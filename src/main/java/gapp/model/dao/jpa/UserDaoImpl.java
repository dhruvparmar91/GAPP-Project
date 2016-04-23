package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.User;
import gapp.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("from User order by id", User.class).getResultList();
	}

	@Override
	@Transactional
	public User saveUser(User user) {

		return entityManager.merge(user);
	}

	@Override
	public Boolean isUserExists(String email) {
		Boolean flag = false;
		List<User> users = entityManager.createQuery("from User", User.class).getResultList();
		if(!users.isEmpty()) {
			for(User user : users ) {
				if(user.getEmail().equalsIgnoreCase(email)) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public User getUser(String email, String password) {
		String query = "from User where email = '" + email + "' " + "and password = '" + password + "' ";
		return entityManager.createQuery(query, User.class).getSingleResult();
	}

	@Override
	public List<User> validateUser(String email, String password) {
		String query = "from User where email = '" + email + "' " + "and password = '" + password + "' ";
		return entityManager.createQuery(query, User.class).getResultList();
	}

}
