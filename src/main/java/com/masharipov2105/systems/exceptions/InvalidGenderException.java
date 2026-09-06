package com.masharipov2105.systems.exceptions;

public class InvalidGenderException extends StudentException{

	public InvalidGenderException(){

		super("Invalid gender; please select one (male/female)");
	}

	//overloading
	public InvalidGenderException(String message){

		super(message);
	}
}