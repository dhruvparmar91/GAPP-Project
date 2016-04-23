package gapp.model.dao;

import gapp.model.AddValue;

public interface AddValueDao {
	
	public AddValue getAddValue(Integer id);
	
	public AddValue saveAddValue(AddValue addValue);

}
