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

		if (data.trim().equals("male")){

			return "male";
		} else if (data.trim().equals("female")){

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

		// help command
		if (command.trim().equals("help")){

			return "help";
		}

		//list command
		else if(command.trim().equals("list")){

			return "list";
		}

		// show command
		else if(command.trim().equals("show")){

			return "show";
		}

		//create command
		else if (command.trim().equals("create")){

			return "create";
		}

		// edit command
		else if(command.trim().equals("edit")){

			return "edit";
		}

		// delete command
		else if(command.trim().equals("delete")){

			return "delete";
		}

		//clear command
		else if(command.trim().equals("clear")){

			return "clear";
		}

		// exit command
		else if (command.trim().equals("quit")){

			return "quit";
		} 

		// command not found
		else{

			throw new InvalidCommandException();
		}
	} 
}