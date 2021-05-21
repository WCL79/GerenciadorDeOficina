package br.com.gerenciadorDeOficina.dtos.entrada;

import br.com.gerenciadorDeOficina.models.Servico;;

import java.time.LocalDate;

public class CadastrarServicoDTO {


    private String ordemDeServico;

    private LocalDate dataCriacao;

    private String tipoDeServico;

    private String mecanica;

    private Double valor;

    public CadastrarServicoDTO() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public Servico converterCadastrarServicoDTOParaServico() {

        Servico servico = new Servico();
        servico.setDataCriacao(this.dataCriacao);
        servico.setOrdemDeServico(this.ordemDeServico);
        servico.setTipoDeServico(this.tipoDeServico);
        servico.setMecanica(this.mecanica);
        servico.setValor(this.valor);

        return servico;
    }
}