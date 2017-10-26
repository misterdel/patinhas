package pt.javeiros.patinhas.view.tes;

import pt.javeiros.patinhas.service.test.ServiceTeste;

public class ViewTeste {
	public void salvar() {
		ServiceTeste serv = new ServiceTeste();
		serv.salvar();
		System.out.println("Passou no View");
	}
	
	public static void main(String[] args) {
		ViewTeste vie = new ViewTeste();
		vie.salvar();
	}
}
