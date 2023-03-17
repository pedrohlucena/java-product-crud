package product.crud.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import product.crud.dao.EstablishmentDAO;
import product.crud.entity.Client;
import product.crud.entity.Establishment;
import product.crud.entity.EstablishmentType;
import product.crud.entity.PhysicalPersonClient;
import product.crud.entity.RentContract;

public class CreateTest {
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
			
			EstablishmentDAO establishmentDao = new EstablishmentDAO(em);
			
			EstablishmentType establishmentType = new EstablishmentType("Petshop", null);
			
			Client client1 = new PhysicalPersonClient("Pedro");
			Client client2 = new PhysicalPersonClient("Leandro");
			
			RentContract contract = new RentContract(
					1,
					2000,
					new GregorianCalendar(2015, Calendar.JANUARY, 10),
					null
			);
			
			List<Client> clientList = new ArrayList<>();
			clientList.add(client1);
			clientList.add(client2);
			
			Establishment establishment1 = new Establishment("FIAP Pets", clientList, null, establishmentType);
			Establishment establishment2 = new Establishment("Pedro dogs", clientList, contract, establishmentType);
			
			contract.setEstablishment(establishment2);
			
			establishmentDao.create(establishment1);
			establishmentDao.create(establishment2);
			
			establishmentDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
		}
	}
}
