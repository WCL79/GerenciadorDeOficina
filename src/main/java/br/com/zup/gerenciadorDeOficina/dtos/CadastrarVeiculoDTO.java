package br.com.zup.gerenciadorDeOficina.dtos;

import br.com.zup.gerenciadorDeOficina.models.Cliente;
import br.com.zup.gerenciadorDeOficina.models.Veiculo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastrarVeiculoDTO {
    @NotBlank(message = "Campo do tipo de Veículo não pode ser vazio!")
    @NotNull(message = "O campo do tipo de Veículo  não foi informada")
    private String tipoDeVeiculo;

    @NotBlank(message = "Campo do marca de Veículo não pode ser vazio!")
    @NotNull(message = "O campo do marca de Veículo  não foi informada")
    private String marcaDoVeiculo;

    @NotBlank(message = "Campo do modelo de Veículo não pode ser vazio!")
    @NotNull(message = "O campo do modelo de Veículo  não foi informada")
    private String modeloDoVeiculo;

    @NotNull(message = "O campo do ano de Veículo  não foi informada")
    private Integer anoDoVeiculo;

    @NotBlank(message = "Campo do  placa do Veículo não pode ser vazio!")
    @NotNull(message = "O campo do placa  do Veículo  não foi informada")
    private String placaDoVeiculo;

    @NotBlank(message = "Campo do chassi de Veículo não pode ser vazio!")
    @NotNull(message = "O campo do chassi de Veículo  não foi informada")
    private String chassi;

    @NotBlank(message = "Campo do CPF não pode ser vazio!")
    @NotNull(message = "O campo do CPF não foi informada")
    @CPF(message = "Campo do CPF está inválido!")
    private String cpf;

    public CadastrarVeiculoDTO() {
    }

    public String getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public void setTipoDeVeiculo(String tipoDeVeiculo) {
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public String getMarcaDoVeiculo() {
        return marcaDoVeiculo;
    }

    public void setMarcaDoVeiculo(String marcaDoVeiculo) {
        this.marcaDoVeiculo = marcaDoVeiculo;
    }

    public String getModeloDoVeiculo() {
        return modeloDoVeiculo;
    }

    public void setModeloDoVeiculo(String modeloDoVeiculo) {
        this.modeloDoVeiculo = modeloDoVeiculo;
    }

    public Integer getAnoDoVeiculo() {
        return anoDoVeiculo;
    }

    public void setAnoDoVeiculo(Integer anoDoVeiculo) {
        this.anoDoVeiculo = anoDoVeiculo;
    }

    public String getPlacaDoVeiculo() {
        return placaDoVeiculo;
    }

    public void setPlacaDoVeiculo(String placaDoVeiculo) {
        this.placaDoVeiculo = placaDoVeiculo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Veiculo converterCadastrarVeiculoDTOparaVeiculo(Cliente donoDoVeiculo) {
        Veiculo veiculo = new Veiculo();
        veiculo.setTipoDeVeiculo(this.tipoDeVeiculo);
        veiculo.setMarcaDoVeiculo(this.marcaDoVeiculo);
        veiculo.setAnoDoVeiculo(this.anoDoVeiculo);
        veiculo.setModeloDoVeiculo(this.modeloDoVeiculo);
        veiculo.setPlacaDoVeiculo(this.placaDoVeiculo);
        veiculo.setChassi(this.chassi);
        veiculo.setDonoDoVeiculo(donoDoVeiculo);

        return veiculo;
    }

}