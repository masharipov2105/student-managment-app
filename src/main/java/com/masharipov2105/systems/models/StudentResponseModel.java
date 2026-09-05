package com.masharipov2105.systems.models;

import java.time.LocalDate;

public class StudentResponseModel{

	//fields
	private long id; // public
	private String firstName; // public
	private String lastName; // public
	private int age; // public
	private String gender; //public
	private LocalDate createAt; //public 
	
	//constructor
	public StudentResponseModel(
		long id_, 
		String firstName_, 
		String lastName_, 
		int age_, 
		String gender_, 
		LocalDate createAt_
	){
		//initialize
		this.id = id_;
		this.firstName = firstName_;
		this.lastName = lastName_;
		this.age = age_;
		this.gender = gender_;
		this.createAt = createAt_;
	}

	//getter
	public long getId(){

		return this.id;
	}

	public String getFirstName(){

		return this.firstName;
	}

	public String getLastName(){

		return this.lastName;
	}

	public int getAge(){

		return this.age;
	}

	public String getGender(){

		return this.gender;
	}

	public LocalDate getCreateAt(){

		return this.createAt;
	}




	// setters
	public void setId(long newId){

		this.id = newId;
	}

	public void setFirstName(String newName){

		this.firstName = newName;
	}

	public void setLastName(String newName){

		this.lastName = newName;
	}

	public void setAge(int newAge){

		this.age = newAge;
	}

	public void setGender(String newGender){

		this.gender = newGender;
	}

	public void setCreateAt(LocalDate newDate){

		this.createAt = newDate;
	}
}