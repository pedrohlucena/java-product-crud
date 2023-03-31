package product.crud.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import product.crud.entity.Client;

public class ClientDAO extends GenericDAO<Client, Integer> {
	public ClientDAO(EntityManager em) {
		super(em);
	}
	
	public List<Client> fetchByName(String name) {
		return em.createQuery("FROM Client c WHERE c.name like %" + name + "%", Client.class)
			.getResultList();
	}
	
	public Client fetchByEmail(String email) {
		return em.createQuery("FROM Client c WHERE c.email = :email", Client.class)
				.setParameter("email", email)
				.getSingleResult();
	}
	
	public long count() {
		return em.createQuery("SELECT count(c) FROM Client c", Long.class)
				.getSingleResult();
	}
	
	public List<Client> fetchSortedByName() {
		return em.createQuery("FROM Client c ORDER BY c.name", Client.class)
			.setMaxResults(1)
			.getResultList();
	}
}
