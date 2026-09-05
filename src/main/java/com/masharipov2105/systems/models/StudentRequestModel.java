package com.masharipov2105.systems.models;

public class StudentRequestModel{

	//fields
	private String firstName; // public
	private String lastName; // public
	private int age; // public
	private String gender; //public
	private String password; //secret e.g sha-256ueioqweu8912eu19eu1928eu1928eu12eu19eu9

	//constructor
	public StudentRequestModel(
		String firstName_, 
		String lastName_, 
		int age_, 
		String gender_, 
		String password_
	){
		//initialize
		this.firstName = firstName_;
		this.lastName = lastName_;
		this.age = age_;
		this.gender = gender_;
		this.password = password_;
	}

	//getter
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

	public String getPassword(){

		return this.password;
	}



	// setters
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

	public void setPassword(String newPassword){

		this.password = newPassword;
	}
}