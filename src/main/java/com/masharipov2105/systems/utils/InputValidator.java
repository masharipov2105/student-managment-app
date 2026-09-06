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

		if (data.equals("male") || data.equals("Male") || data.equals("m") || data.equals("M") || data.equals("MALE")){

			return "male";
		} else if (data.equals("female") || data.equals("Female") || data.equals("f") || data.equals("F") || data.equals("FEMALE")){

			return "female";
		} else{

			throw new InvalidGenderException();
		}
	}
}