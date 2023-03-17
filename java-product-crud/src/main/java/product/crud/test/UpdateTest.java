package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import product.crud.dao.ClientDAO;
import product.crud.entity.Client;
import product.crud.entity.PhysicalPersonClient;

public class UpdateTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
		
		ClientDAO clientDao = new ClientDAO(em);
		
		Client client = new PhysicalPersonClient(1, "Banana");
		
		clientDao.update(client);
		
		try {	
			clientDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
		}
	}
}