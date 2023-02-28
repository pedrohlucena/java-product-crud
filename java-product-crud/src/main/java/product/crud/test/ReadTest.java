package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import product.crud.entity.Client;

public class ReadTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		Client client = em.find(Client.class, 1);
		
		System.out.println("CLIENT " + client.getId() + ": " + client.getName());
		
		em.close();
	}
}
