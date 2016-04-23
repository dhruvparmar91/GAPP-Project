package gapp.model.dao;

import java.util.List;

import gapp.model.Degree;

public interface DegreeDao {
	
	public Degree saveDegree(Degree degree);
	
	public Degree getDegree(Integer id);
	
	public void removeDegree(Degree degree);
	
	public List<Degree> getDegreesByApplicationId(Integer id);

}
