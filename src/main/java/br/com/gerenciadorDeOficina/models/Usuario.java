package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nomeCompleto;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ManyToMany
    private List<Veiculo> veiculoList;

    public Usuario() {
    }

    public Usuario(Long id, String nomeCompleto, String email, String senha, List<Veiculo> veiculoList) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.veiculoList = veiculoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }

}
