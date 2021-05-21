package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_veiculo")
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

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

    @ManyToMany
    @JoinTable (name = "tb_veiculo_servico",
            joinColumns = @JoinColumn(name = "veiculo_id"),
            inverseJoinColumns = @JoinColumn (name = "servico_id"))
    private List<Servico> servicoList;


    public Veiculo() {
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
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

}

