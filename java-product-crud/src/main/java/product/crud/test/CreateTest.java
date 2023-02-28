package java.product.crud.test;

import java.product.crud.entity.Client;
import java.product.crud.entity.Establishment;
import java.product.crud.entity.EstablishmentType;
import java.product.crud.entity.RentContract;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CreateTest {
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			
			EstablishmentType establishmentType = new EstablishmentType("Petshop", null);
			
			Client client1 = new Client("Pedro");
			Client client2 = new Client("Leandro");
			
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
			
			em.persist(establishment1);
			em.persist(establishment2);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			em.close();
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
