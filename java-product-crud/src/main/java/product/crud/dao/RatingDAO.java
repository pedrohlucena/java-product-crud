package product.crud.dao;

import jakarta.persistence.EntityManager;
import product.crud.entity.Rating;
import product.crud.entity.RatingId;

public class RatingDAO extends GenericDAO<Rating, RatingId> {
	public RatingDAO(EntityManager em) {
		super(em);
	}
}