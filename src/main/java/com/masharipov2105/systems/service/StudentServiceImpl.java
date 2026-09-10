package com.masharipov2105.systems.service;

import com.masharipov2105.systems.exceptions.*;
import com.masharipov2105.systems.models.*;
import com.masharipov2105.systems.repository.*;
import com.masharipov2105.systems.utils.*;

import java.util.ArrayList;
import java.time.LocalDate;

public class StudentServiceImpl implements StudentService{

	//fields
	private ArrayList<StudentResponseModel> response;
	private StudentRepository repo;

	//constructor
	public StudentServiceImpl(){

		this.response = new ArrayList<>();
		this.repo = new StudentRepositoryImpl();
	}

	//methods
	@Override
	public ArrayList<StudentResponseModel> showAll(){

		ArrayList<StudentModel> model = this.repo.getAll();

		for (StudentModel mod : model){

			StudentResponseModel newModel = new StudentResponseModel(

				mod.getId(),
				mod.getFirstName(),
				mod.getLastName(),
				mod.getAge(),
				mod.getGender(),
				mod.getCreateAt()
			);

			this.response.add(newModel);
		}

		return this.response;
	}

	@Override
	public StudentResponseModel show(long id){

		StudentModel mod = this.repo.getId(id);
		StudentResponseModel newModel = new StudentResponseModel(

			mod.getId(),
			mod.getFirstName(),
			mod.getLastName(),
			mod.getAge(),
			mod.getGender(),
			mod.getCreateAt()
		);

		return newModel;
	}

	@Override
	public boolean create(StudentRequestModel model) throws StudentException{

		try{

			StudentModel newModel = new StudentModel(

				IdGenerator.generateId(),
				model.getFirstName(),
				model.getLastName(),
				model.getAge(),
				model.getGender(),
				LocalDate.now(),
				PasswordUtils.hashPassword(model.getPassword()),
				LocalDate.now()
			);

			return this.repo.save(newModel.getId(), newModel);
		} catch (Exception e){

			throw new StudentException(e.getMessage());
		}
	}

	@Override
	public boolean update(long id, StudentRequestModel updateModel) throws StudentException{

		try{

			StudentModel mod = this.repo.getId(id);

			StudentModel newModel = new StudentModel(

				mod.getId(),
				updateModel.getFirstName(),
				updateModel.getLastName(),
				updateModel.getAge(),
				updateModel.getGender(),
				mod.getCreateAt(),
				PasswordUtils.hashPassword(updateModel.getPassword()),
				LocalDate.now()
			);

			return this.repo.updateId(id, newModel);
		} catch(Exception e){

			throw new StudentException(e.getMessage());
		}
	}

	@Override
	public boolean drop(long id) throws StudentException{

		try{

			return this.repo.removeId(id);
		} catch(Exception e){

			throw new StudentException(e.getMessage());
		}
	}

	@Override
	public void dropAll(){

		this.repo.removeAll();
	}
}