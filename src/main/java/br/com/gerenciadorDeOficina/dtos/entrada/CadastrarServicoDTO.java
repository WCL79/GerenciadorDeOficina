package br.com.gerenciadorDeOficina.dtos.entrada;

import br.com.gerenciadorDeOficina.models.Servico;;

import java.time.LocalDate;

public class CadastrarServicoDTO {


    private String os;

    private String mecanica;

    private Double valor;

    private String item;

    private String dataCriacao;

    private Long idVeiculo;

    public CadastrarServicoDTO() {
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

    public Servico converterCadastrarServicoDTOParaServico() {

        Servico servico = new Servico();
        servico.setDataCriacao(this.dataCriacao);
        servico.setOs(this.os);
        servico.setItem(this.item);
        servico.setMecanica(this.mecanica);
        servico.setValor(this.valor);
        servico.setIdVeiculo(this.idVeiculo);

        return servico;
    }
}