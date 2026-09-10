package com.masharipov2105.systems.repository;

import com.masharipov2105.systems.models.StudentModel;
import com.masharipov2105.systems.exceptions.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StudentRepositoryImpl implements StudentRepository{

	private Map<Long, StudentModel> data;

	public StudentRepositoryImpl(){

		this.data = new HashMap<>();
	}

	@Override
	public boolean save(long id, StudentModel model){

		try{

			this.data.put(id, model);
			return true;
		} catch(Exception e){

			return false;
		}
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
	public boolean removeId(long id){

		return this.data.remove(id) != null;
	}

	@Override
	public boolean updateId(long id, StudentModel model){

		try{

			this.data.put(id, model);
			return true;
		} catch(Exception e){

			return false;
		}
	}

	@Override
	public void removeAll(){

		this.data.clear();
	}
}