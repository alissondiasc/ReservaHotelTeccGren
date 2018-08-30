package com.tecgreen.loiola.entities;

import com.tecgreen.loiola.dtos.QuartoDTO;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="quartosDisponiveis",
        classes={
                @ConstructorResult(
                        targetClass=QuartoDTO.class,
                        columns={
                                @ColumnResult(name="id", type = Long.class),
                                @ColumnResult(name="descricao", type = String.class),
                                @ColumnResult(name="valor", type = Double.class),
                                @ColumnResult(name="quantidade", type = Integer.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name="Quarto.findAllDisponiveis",
        query="SELECT q.id AS id, q.descricao AS descricao, q.valor AS valor, q.quantidade - case when sub.qtd_reservados is not null then sub.qtd_reservados else 0 end AS quantidade FROM Quarto q LEFT JOIN (SELECT rq.id_quarto as id_quarto , sum(rq.quantidade) as qtd_reservados FROM Reserva r INNER JOIN Reserva_Quarto rq on r.id = rq.id_reserva where (r.data_checkin between :checkin and :checkout) or (r.data_checkout between :checkin and :checkout) group BY id_quarto) sub on q.id = sub.id_quarto WHERE q.quantidade - case when sub.qtd_reservados is not null then sub.qtd_reservados else 0 end > 0",
        resultSetMapping="quartosDisponiveis")
@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private Integer quantidade;

    public Quarto() {
    }

    public Quarto(String descricao, Double valor, Integer quantidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
