package com.masharipov2105.systems.exceptions;

public class InvalidCommandException extends StudentException{

	public InvalidCommandException(){

		super("Command does not exist; please enter 'help'.");
	}

	//overloading
	public InvalidCommandException(String message){

		super(message);
	}
}