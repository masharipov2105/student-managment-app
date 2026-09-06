package com.masharipov2105.systems.repository;

import com.masharipov2105.systems.models.StudentModel;
import java.util.ArrayList;

public interface StudentRepository{

	void save(long id, StudentModel model);
	ArrayList<StudentModel> getAll();
	StudentModel getId(long id);
	void removeId(long id);
	void updateId(long id, StudentModel model);
	void removeAll();
}