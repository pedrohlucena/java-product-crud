package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import product.crud.entity.Client;

public class DeleteTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		Client client = em.find(Client.class, 2);
		
		em.remove(client);
		
		try {	
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			transaction.commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}
}
