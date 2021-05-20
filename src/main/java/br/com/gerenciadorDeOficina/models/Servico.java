package br.com.gerenciadorDeOficina.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "servicos")
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ordemDeServico;
    private String mecanica;
    private LocalDate dataCriacao;
    private String tipoDeServico;
    private Double valor;


    public Servico() {
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(String ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
    }
}