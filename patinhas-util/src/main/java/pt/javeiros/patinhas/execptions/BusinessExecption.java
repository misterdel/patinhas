package pt.javeiros.patinhas.execptions;

public class BusinessExecption extends Exception {

    private String mensagem;

    public BusinessExecption(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
