package br.com.zup.gerenciadorDeOficina.exceptions;

public class ClienteNaoLocalizadoExcecao extends RuntimeException {
    private int Status = 400;
    private String campo = "";
    private String razao = "BAD REQUEST";
    private String tipoErro = "Cliente não encontrado!";

    public ClienteNaoLocalizadoExcecao(String message) {
        super(message);
    }

    public ClienteNaoLocalizadoExcecao() {
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
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
