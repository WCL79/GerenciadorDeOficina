package br.com.zup.gerenciadorDeOficina.exceptions;

public class VeiculoDuplicadoExcecao extends RuntimeException {
    private int status = 422;
    private String campo = "chassi";
    private String razao = "UNPROCESSABLE ENTITY";
    private String tipoErro = "Veículo já cadastrado!";

    public VeiculoDuplicadoExcecao(String message) {
        super(message);
    }

    public VeiculoDuplicadoExcecao() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTipoErro() {
        return tipoErro;
    }

    public void setTipoErro(String tipoErro) {
        this.tipoErro = tipoErro;
    }
}
