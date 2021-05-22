package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "tb_veiculo")
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 15, nullable = false)
    private String placa;

    @Column(length = 20, nullable = false)
    private String marca;

    @Column(length = 12, nullable = false)
    private String cor;

    @Column(length = 10, nullable = false)
    private String ano;

    @Column(length = 50, nullable = false)
    private String modelo;

    @OneToMany
    private List<Servico> servicoList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }
}

