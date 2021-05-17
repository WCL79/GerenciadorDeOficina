package br.com.gerenciadorDeOficina.dtos;

import br.com.gerenciadorDeOficina.models.enums.Andamento;
import br.com.gerenciadorDeOficina.models.Funcionario;
import br.com.gerenciadorDeOficina.models.Servico;
import br.com.gerenciadorDeOficina.models.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastrarServicoDTO {

    @NotNull(message = "o campo ordemDeServico não foi informado")
    private Integer ordemDeServico;

    @NotNull(message = "o campo chassi não foi informado")
    @NotEmpty(message = "o campo chassi está vazio")
    private String chassi;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeEntrada;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeSaida;

    @NotNull(message = "o campo tipoDeServico não foi informado")
    @NotEmpty(message = "o campo tipoDeServico está vazio")
    private String tipoDeServico;


    private Andamento andamento;

    @NotNull(message = "o campo cpfFuncionario não foi informado")
    @NotEmpty(message = "o campo cpfFuncionario está vazio")
    @CPF(message = "CPF inválido!")
    private String cpfFuncionario;

    @NotNull(message = "o campo responsavelPeloServico não foi informado")
    @NotEmpty(message = "o campo responsavelPeloServico está vazio")
    private String responsavelPeloServico;

    public CadastrarServicoDTO() {
    }

    public Integer getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(Integer ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public LocalDate getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(LocalDate dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public Andamento getAndamento() {
        return andamento;
    }

    public void setAndamento(Andamento andamento) {
        this.andamento = andamento;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getResponsavelPeloServico() {
        return responsavelPeloServico;
    }

    public void setResponsavelPeloServico(String responsavelPeloServico) {
        this.responsavelPeloServico = responsavelPeloServico;
    }

    public Servico converterCadastrarServicoDTOParaServico(Veiculo veiculo, Funcionario funcionario) {
        Servico servico = new Servico();
        servico.setOrdemDeServico(this.ordemDeServico);
        servico.setVeiculo(veiculo);
        servico.setDataDeEntrada(this.dataDeEntrada);
        servico.setDataDeSaida(this.dataDeSaida);
        servico.setTipoDeServico(this.tipoDeServico);
        servico.setAndamento(this.andamento);
        servico.setFuncionario(funcionario);
        servico.setResponsavelPeloServico(responsavelPeloServico);

        return servico;
    }

}