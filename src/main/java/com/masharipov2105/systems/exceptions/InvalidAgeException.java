package com.masharipov2105.systems.exceptions;

public class InvalidAgeException extends StudentException{

	public InvalidAgeException(){

		super("Age in incorrect format");
	}
}