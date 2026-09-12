package com.masharipov2105.systems.service;

import com.masharipov2105.systems.exceptions.*;
import com.masharipov2105.systems.models.*;

import java.util.ArrayList;

public interface StudentService{

	ArrayList<StudentResponseModel> showAll();
	StudentResponseModel show(long id) throws StudentException;
	boolean create(StudentRequestModel model) throws StudentException;
	boolean update(long id, StudentRequestModel updateModel) throws StudentException;
	boolean drop(long id) throws StudentException;
	void dropAll();
}