package br.com.gerenciadorDeOficina.models;

import javax.persistence.*;
import java.util.List;


@Table(name = "tb_veiculo")
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private String cor;

    @Column
    private String placa;

    @Column
    private String ano;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @OneToMany
    @JoinColumn(name = "id_veiculo")
    private List<Servico> servicoList;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, String cor, String placa, String ano, Long idUsuario, List<Servico> servicoList) {
        Id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.ano = ano;
        this.idUsuario = idUsuario;
        this.servicoList = servicoList;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }
}
