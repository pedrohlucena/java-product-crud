package product.crud.dao;

import jakarta.persistence.EntityManager;
import product.crud.entity.Client;

public class ClientDAO extends GenericDAO<Client, Integer> {
	public ClientDAO(EntityManager em) {
		super(em);
	}
}
