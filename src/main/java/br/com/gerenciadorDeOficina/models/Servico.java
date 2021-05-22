package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;


@Table(name = "servicos")
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String ordemDeServico;

    @Column(length = 20, nullable = false)
    private String mecanica;

    @Column
    private String dataCriacao;

    @Column(length = 50, nullable = false)
    private String tipoDeServico;

    @Column
    private Double valor;


    public Servico() {

    }

    public Servico(Integer id, String ordemDeServico, String mecanica, String dataCriacao, String tipoDeServico, Double valor, List<Veiculo> veiculoList) {
        this.id = id;
        this.ordemDeServico = ordemDeServico;
        this.mecanica = mecanica;
        this.dataCriacao = dataCriacao;
        this.tipoDeServico = tipoDeServico;
        this.valor = valor;

    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
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