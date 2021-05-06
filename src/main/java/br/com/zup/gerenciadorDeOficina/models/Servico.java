package br.com.zup.gerenciadorDeOficina.models;

import br.com.zup.gerenciadorDeOficina.models.enums.Andamento;

import java.time.LocalDate;

public class Servico {

    private Integer ordemDeServico;
    private Veiculo veiculo;
    private LocalDate dataDeEntrada;
    private LocalDate dataDeSaida;
    private String tipoDeServico;
    private Andamento andamento;
    private Funcionario funcionario;
    private String responsavelPeloServico;

    public Servico() {
    }

    public Integer getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(Integer ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getResponsavelPeloServico() {
        return responsavelPeloServico;
    }

    public void setResponsavelPeloServico(String responsavelPeloServico) {
        this.responsavelPeloServico = responsavelPeloServico;
    }

}