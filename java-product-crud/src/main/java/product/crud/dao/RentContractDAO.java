package product.crud.dao;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.EntityManager;
import product.crud.entity.RentContract;

public class RentContractDAO extends GenericDAO<RentContract, Integer> {
	public RentContractDAO(EntityManager em) {
		super(em);
	}
}
