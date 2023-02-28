package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import product.crud.entity.Client;

public class UpdateTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		Client client = new Client(1, "Banana");
		em.merge(client);
		
//		Client client = em.find(Client.class, 1);
//		client.setName("Thiago");
		
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