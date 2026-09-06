package com.masharipov2105.systems.repository;

import com.masharipov2105.systems.models.StudentModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StudentRepositoryImpl implements StudentRepository{

	private Map<Long, StudentModel> data;

	public StudentRepositoryImpl(){

		this.data = new HashMap<>();
	}

	@Override
	public void save(long id, StudentModel model){

		this.data.put(id, model);
	}

	@Override
	public ArrayList<StudentModel> getAll(){

		ArrayList<StudentModel> list = new ArrayList<>(this.data.values()); 
		return list;
	}

	@Override
	public StudentModel getId(long id){

		return this.data.get(id);
	}

	@Override
	public void removeId(long id){

		this.data.remove(id);
	}

	@Override
	public void updateId(long id, StudentModel model){

		this.data.put(id, model);
	}

	@Override
	public void removeAll(){

		this.data.clear();
	}
}