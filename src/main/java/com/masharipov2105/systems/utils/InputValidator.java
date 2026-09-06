package com.masharipov2105.systems.utils;

import com.masharipov2105.systems.exceptions.*;

public class InputValidator{

	private InputValidator(){

		throw new UnsupportedOperationException("Utility class cannot be instantiated!");
	}


	public static String parseName(String data) throws InvalidNameException{

		final String bannedCharacters = "0123456789!@#$%^&*()_+-=<|>?,./';:}{][";

		if (data == null || data.trim().isEmpty()){

			throw new InvalidNameException("The field cannot be null or empty");
		}

		if (data.trim().length() < 2 || data.trim().length() > 50){

			throw new InvalidNameException("The field length must be between a min of 2 and a max of 50 characters");
		}

		boolean flag = true;
		for (int i = 0; i < data.length(); i ++){

			if (flag){

				for (int j = 0; j < bannedCharacters.length(); j ++){

					if (data.charAt(i) == bannedCharacters.charAt(j)){

						flag = false;
						throw new InvalidNameException();
					}
				}
			} else{

				break;
			}
		}

		return (data.substring(0, 1).toUpperCase() + data.substring(1));
	}


	public static int parseAge(String ageData) throws InvalidAgeException{

		if (ageData == null || ageData.trim().isEmpty()){

			throw new InvalidAgeException("The field cannot be empty.");
		}

		try{

			int age = Integer.parseInt(ageData);

			if (age < 18 || age > 150){

				throw new InvalidAgeException("The age range cannot be under 18. Max 150.");
			}

			return age;
		} catch(NumberFormatException e){

			throw new InvalidAgeException();
		}
	}


	public static String parseGender(String data) throws InvalidGenderException{

		if (data == null || data.trim().isEmpty()){

			throw new InvalidGenderException("The field cannot be empty.");
		}

		if (data.trim().equals("male") || data.trim().equals("Male") || data.trim().equals("m") || data.trim().equals("M") || data.trim().equals("MALE")){

			return "male";
		} else if (data.trim().equals("female") || data.trim().equals("Female") || data.trim().equals("f") || data.trim().equals("F") || data.trim().equals("FEMALE")){

			return "female";
		} else{

			throw new InvalidGenderException();
		}
	}


	public static String parsePassword(String passwd) throws InvalidNameException{

		if (passwd == null || passwd.trim().isEmpty()){

			throw new InvalidNameException("The field cannot be empty.");
		}

		if (passwd.trim().length() < 4 || passwd.trim().length() > 50){

			throw new InvalidNameException("The password length cannot be less than 4 characters or greater than 50 characters.");
		}

		return passwd.trim();
	}


	public static String parseCommand(String command) throws InvalidCommandException{

		if (command == null || command.trim().isEmpty()){

			throw new InvalidCommandException("empty command, continue");
		}

		// exit command
		if (command.trim().equals("quit") || command.trim().equals("exit") || command.trim().equals("q")){

			return "quit";
		} 

		// show command
		else if(command.trim().equals("show") || command.trim().equals("Show") || command.trim().equals("SHOW")){

			return "show";
		}

		// edit command
		else if(command.trim().equals("edit") || command.trim().equals("Edit") || command.trim().equals("EDIT")){

			return "edit";
		}

		// delete command
		else if(command.trim().equals("delete") || command.trim().equals("del") || command.trim().equals("Del") || command.trim().equals("DEL") || command.trim().equals("Delete") || command.trim().equals("DELETE")){

			return "delete";
		}
		// command not found
		else{

			throw new InvalidCommandException();
		}
	} 
}