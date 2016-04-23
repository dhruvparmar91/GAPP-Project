package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AddValue;
import gapp.model.dao.AddValueDao;

@Repository
public class AddValueDaoImpl implements AddValueDao {
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public AddValue getAddValue(Integer id) {
		return entityManager.find(AddValue.class, id);

	}

	@Override
	@Transactional
	public AddValue saveAddValue(AddValue addValue) {
		return entityManager.merge(addValue);
	}

}
