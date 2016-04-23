package gapp.model.dao;

import java.util.List;

import gapp.model.Department;

public interface DepartmentDao {

	List<Department> getDepartments();

	Department getDepartment(Integer id);
	
	Department saveDepartment(Department department);
	
	void removeDepartment(Department department);
	
	

}
