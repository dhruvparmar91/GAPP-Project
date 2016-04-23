package gapp.model.dao;

import java.util.List;

import gapp.model.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getUsers();

	User saveUser(User user);

	Boolean isUserExists(String email);

	User getUser(String email, String password);

	List<User> validateUser(String email, String password);

}
