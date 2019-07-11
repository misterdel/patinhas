/**
 * 
 */
package pt.javeiros.patinhas.interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;



/**
 * Created by cahangoa on 14/06/2019.
 */

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 /** @PersistenceContext(name="patinhas")
	  private EntityManager manager;*/

	

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();

		Object result = null;

		try {
			if (!trx.isActive()) {
				trx.begin();
				result = context.proceed();
				if (!trx.getRollbackOnly()) {
					trx.commit();
				} else {
					trx.rollback();
				}
			}
		} catch (Exception e) {
			if (trx.isActive()) {
				trx.rollback();
			}
		}

		return result;

	}
}