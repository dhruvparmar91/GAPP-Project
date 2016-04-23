package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AppStatus;
import gapp.model.dao.AppStatusDao;

@Repository
public class AppStatusDaoImpl implements AppStatusDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public AppStatus saveStatus(AppStatus status) {
		return entityManager.merge(status);
	}

	@Override
	public AppStatus getStatus(Integer id) {
		return entityManager.find(AppStatus.class, id);
	}

}
