package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import product.crud.dao.ClientDAO;
import product.crud.entity.Client;

public class ReadTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
		
		ClientDAO clientDao = new ClientDAO(em);
		Client client = clientDao.fetch(1);
		
		System.out.println("CLIENT " + client.getId() + ": " + client.getName());
		
		em.close();
	}
}