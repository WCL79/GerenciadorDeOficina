package br.com.gerenciadorDeOficina.dtos;

import br.com.gerenciadorDeOficina.models.Servico;;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastrarServicoDTO {

    @NotNull(message = "o campo ordemDeServico não foi informado")
    private Integer ordemDeServico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;

    @NotNull(message = "o campo tipoDeServico não foi informado")
    @NotEmpty(message = "o campo tipoDeServico está vazio")
    private String tipoDeServico;


    @NotNull(message = "o campo responsavelPeloServico não foi informado")
    @NotEmpty(message = "o campo responsavelPeloServico está vazio")
    private String mecanica;

    public CadastrarServicoDTO() {
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(Integer ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }
    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public Servico converterCadastrarServicoDTOParaServico() {
        Servico servico = new Servico();
        servico.setOrdemDeServico(this.ordemDeServico);
        servico.setTipoDeServico(this.tipoDeServico);
        servico.setMecanica(mecanica);

        return servico;
    }
}