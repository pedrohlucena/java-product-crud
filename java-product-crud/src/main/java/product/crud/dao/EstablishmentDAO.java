package product.crud.dao;

import jakarta.persistence.EntityManager;
import product.crud.entity.Establishment;

public class EstablishmentDAO extends GenericDAO<Establishment, Integer> {
	public EstablishmentDAO(EntityManager em) {
		super(em);
	}
}
