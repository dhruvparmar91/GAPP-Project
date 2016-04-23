package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.User;
import gapp.model.dao.ApplicationDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Application> getApplications(String dept, String term) {

		String query = "from Application where department.name = '" + dept + "' and term = '" + term + "' ";

		return entityManager.createQuery(query, Application.class).getResultList();
	}

	@Override
	public List<Application> getAppByUser(String email) {

		String query = "from Application where applicant.email = '" + email + "' ";

		return entityManager.createQuery(query, Application.class).getResultList();
	}
	
//	@Override
//	public List<Application> getAppByApplicantId(Integer id) {
//
//		String query = "from Application where applicant.id = '" + id + "' ";
//
//		return entityManager.createQuery(query, Application.class).getResultList();
//	}

	@Override
	public Application getApplication(Integer id) {
		return entityManager.find(Application.class, id);
		
	}

	@Override
	@Transactional
	public Application saveApplication(Application application) {
		return entityManager.merge(application);
	}

}
