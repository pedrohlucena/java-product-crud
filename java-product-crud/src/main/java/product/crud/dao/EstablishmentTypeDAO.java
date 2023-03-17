package product.crud.dao;

import jakarta.persistence.EntityManager;
import product.crud.entity.EstablishmentType;

public class EstablishmentTypeDAO extends GenericDAO<EstablishmentType, Integer> {
	public EstablishmentTypeDAO(EntityManager em) {
		super(em);
	}
}