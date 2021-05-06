package br.com.zup.gerenciadorDeOficina.models;

/**
 * Classe para definir os atributos do Funcionário.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Funcionario {


    @NotNull(message = "Nome incompleto ou digitado erroneamente")
    private String nomecompleto;
    @NotNull(message = "cpf não encontrado")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;


    public Funcionario() {
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}