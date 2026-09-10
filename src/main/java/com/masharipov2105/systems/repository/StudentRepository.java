package com.masharipov2105.systems.repository;

import com.masharipov2105.systems.models.StudentModel;
import java.util.ArrayList;

public interface StudentRepository{

	boolean save(long id, StudentModel model);
	ArrayList<StudentModel> getAll();
	StudentModel getId(long id);
	boolean removeId(long id);
	boolean updateId(long id, StudentModel model);
	void removeAll();
}