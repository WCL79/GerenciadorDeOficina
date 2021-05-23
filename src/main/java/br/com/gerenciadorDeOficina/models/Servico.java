package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;


@Table(name = "servicos")
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String os;

    @Column(length = 50, nullable = false)
    private String mecanica;

    @Column
    private Double valor;

    @Column(length = 50)
    private String item;

    @Column(length = 50, nullable = false)
    private String dataCriacao;

    @Column
    private Long idVeiculo;

    public Servico() {
    }

    public Servico(Long id, String os, String mecanica, Double valor, String item, String dataCriacao, Long idVeiculo) {
        this.id = id;
        this.os = os;
        this.mecanica = mecanica;
        this.valor = valor;
        this.item = item;
        this.dataCriacao = dataCriacao;
        this.idVeiculo = idVeiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}