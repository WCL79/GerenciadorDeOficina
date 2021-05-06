package br.com.zup.gerenciadorDeOficina.exceptions;

public class ListaDeServicoDoClienteVaziaExcecao extends RuntimeException {
    private int status = 200;
    private String campo = "";
    private String razao = "OK";
    private String tipoErro = "Nenhum serviço cadastrado!";

    public ListaDeServicoDoClienteVaziaExcecao(String message) {
        super(message);
    }

    public ListaDeServicoDoClienteVaziaExcecao() {
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
