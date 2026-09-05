package com.masharipov2105.systems.exceptions;

public class InvalidNameException extends StudentException{

	public InvalidNameException(){

		super("Invalid name; please use only letters.");
	}
}