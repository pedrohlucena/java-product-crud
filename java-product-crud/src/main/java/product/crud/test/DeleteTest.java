package product.crud.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import product.crud.dao.ClientDAO;

public class DeleteTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
		
		ClientDAO clientDao = new ClientDAO(em);
		
		try {	
			clientDao.remove(1);
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
