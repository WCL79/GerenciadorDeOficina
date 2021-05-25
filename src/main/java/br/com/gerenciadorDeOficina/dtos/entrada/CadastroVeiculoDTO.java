package br.com.gerenciadorDeOficina.dtos.entrada;

import br.com.gerenciadorDeOficina.models.Veiculo;

import javax.validation.constraints.NotNull;

public class CadastroVeiculoDTO {

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String placa;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String marca;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String cor;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String ano;

    @NotNull(message = "{validacao.campo_obrigatorio}")
    private String modelo;


    public CadastroVeiculoDTO() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public Veiculo converterCadastrarVeiculoDTOParaVeiculo(){

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(this.placa);
        veiculo.setMarca(this.marca);
        veiculo.setCor(this.cor);
        veiculo.setAno(this.ano);
        veiculo.setModelo(this.modelo);

        return veiculo;
    }
}
