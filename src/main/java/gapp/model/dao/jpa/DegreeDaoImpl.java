package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Degree;
import gapp.model.dao.DegreeDao;

@Repository
public class DegreeDaoImpl implements DegreeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Degree saveDegree(Degree degree) {
		return entityManager.merge(degree);
	}

	@Override
	public Degree getDegree(Integer id) {
		return entityManager.find(Degree.class, id);
	}

	@Override
	@Transactional
	public void removeDegree(Degree degree) {
		entityManager.remove(degree);
	}

	@Override
	public List<Degree> getDegreesByApplicationId(Integer id) {
		String query = "from Degree where application.id=" + id;
		return entityManager.createQuery(query, Degree.class).getResultList();
	}

}
