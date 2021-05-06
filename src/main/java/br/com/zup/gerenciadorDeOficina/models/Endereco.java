package br.com.zup.gerenciadorDeOficina.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Endereco {

    @NotBlank(message = "Campo rua não pode ser vazio!")
    @NotNull(message = "O campo rua não foi informada")
    private String rua;

    @NotBlank(message = "Campo número não pode ser vazio!")
    @NotNull(message = "O campo número não foi informada")
    private int    numero;

    @NotBlank(message = "Campo cidade não pode ser vazio!")
    @NotNull(message = "O campo cidade não foi informada")
    private String cidade;

    @NotBlank(message = "Campo estado não pode ser vazio!")
    @NotNull(message = "O campo estado não foi informada")
    private String estado;
    private int    cep;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String cidade, String estado, int cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

}