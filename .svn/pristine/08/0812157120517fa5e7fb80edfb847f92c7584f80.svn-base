package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AddField;
import gapp.model.dao.AddFieldDao;

@Repository
public class AddFieldDaoImpl implements AddFieldDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public AddField saveAdditional(AddField addField) {
		return entityManager.merge(addField);
	}

	@Override
	public AddField getAddField(Integer id) {
		return entityManager.find(AddField.class, id);
	}

	@Override
	@Transactional
	public void removeField(AddField addField) {
		entityManager.remove(addField);
		return;
		
	}

}
