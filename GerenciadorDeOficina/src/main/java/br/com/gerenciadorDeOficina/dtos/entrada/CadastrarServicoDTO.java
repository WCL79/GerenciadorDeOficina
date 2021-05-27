package br.com.gerenciadorDeOficina.dtos.entrada;

import br.com.gerenciadorDeOficina.models.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastrarServicoDTO{

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String dataCriacao;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String os;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String mecanica;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String item;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private Double valor;


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

    public Servico converterCadastrarServicoDTOParaServico() {

        Servico servico = new Servico();
        servico.setDataCriacao(this.dataCriacao);
        servico.setOs(this.os);
        servico.setItem(this.item);
        servico.setMecanica(this.mecanica);
        servico.setValor(this.valor);
        return servico;
    }
}