package gapp.model.dao;

import gapp.model.AddField;

public interface AddFieldDao {
	
	AddField saveAdditional(AddField addField);
	
	AddField getAddField(Integer id);
	
	void removeField(AddField addField);

}
