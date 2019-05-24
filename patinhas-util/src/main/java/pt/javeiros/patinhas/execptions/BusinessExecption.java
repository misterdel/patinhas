package pt.javeiros.patinhas.execptions;

public class BusinessExecption extends Exception {

	private static final long serialVersionUID = 1L;
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
