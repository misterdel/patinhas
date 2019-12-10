package pt.javeiros.patinhas.dao.config;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class JPAUtil {
	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("patinhas");
 
	@PersistenceUnit(name = "patinhas")
	private EntityManagerFactory emf;

	
	@RequestScoped
    @Produces
	public EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}

	/**public void fecharEntityManager(@Disposes EntityManager em) {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}*/
}
