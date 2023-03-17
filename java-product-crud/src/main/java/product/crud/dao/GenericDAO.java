package product.crud.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;

public abstract class GenericDAO<T,K> {

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAO(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void create(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void remove(K code) throws Exception {
		T entity = fetch(code);
		if (entity == null){
			throw new Exception("Invalid Code");
		}
		em.remove(entity);
	}
	
	public List<T> list(){
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	public T fetch(K code) {
		return em.find(clazz,code);
	}

	public void commit() throws Exception {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Commit error");
		}
	}
}
