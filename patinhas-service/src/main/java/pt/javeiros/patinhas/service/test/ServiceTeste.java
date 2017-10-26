package pt.javeiros.patinhas.service.test;

import pt.javeiros.patinhas.dao.test.DaoTest;

public class ServiceTeste {
	
	public void salvar() {
		DaoTest dao = new DaoTest();
		dao.salvar();
		System.out.println("Passou no service");
	}
}
