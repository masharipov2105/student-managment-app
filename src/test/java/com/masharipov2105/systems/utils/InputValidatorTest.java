package com.masharipov2105.systems.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.masharipov2105.systems.exceptions.*;

public class InputValidatorTest{


    //=============================== parseName ====================================
	@Test
	void testInputValidatorSuccess() throws InvalidNameException{

		assertEquals("Alisher", InputValidator.parseName("Alisher"));
	}

	@Test
	void testInputValidatorNullAndEmptyValue() throws InvalidNameException{

		Exception exp = assertThrows(InvalidNameException.class, ()->{InputValidator.parseName(null);});
		assertEquals("The field cannot be null or empty", exp.getMessage());

		Exception exp2 = assertThrows(InvalidNameException.class, ()->{InputValidator.parseName("");});
		assertEquals("The field cannot be null or empty", exp2.getMessage());
	}

	@Test
	void testInputValidatorInvalidLengthValue() throws InvalidNameException{

		Exception exp = assertThrows(InvalidNameException.class, ()->{InputValidator.parseName("A");});
		assertEquals("The field length must be between a min of 2 and a max of 50 characters", exp.getMessage());

		Exception exp2 = assertThrows(InvalidNameException.class, ()->{InputValidator.parseName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");});
		assertEquals("The field length must be between a min of 2 and a max of 50 characters", exp.getMessage());
	}

	@Test
	void testInputValidatorInvalidValue() throws InvalidNameException{

		Exception exp = assertThrows(InvalidNameException.class, ()->{InputValidator.parseName("Alisher77!");});
		assertEquals("Invalid name; please use only letters.", exp.getMessage());
	}


	//================================== parseAge ================================================
	@Test
	void testParseAgeSuccess() throws InvalidAgeException{

		assertEquals(23, InputValidator.parseAge("23"));
	} 

	@Test
	void testparseAgeNullAndEmptyValue() throws InvalidAgeException{

		Exception exp = assertThrows(InvalidAgeException.class, ()->{InputValidator.parseAge(null);});
		assertEquals("The field cannot be empty.", exp.getMessage());

		Exception exp2 = assertThrows(InvalidAgeException.class, ()->{InputValidator.parseAge("");});
		assertEquals("The field cannot be empty.", exp2.getMessage());

	}

	@Test
	void testParseAgeInvalidValue() throws InvalidAgeException{

		Exception exp = assertThrows(InvalidAgeException.class, ()->{InputValidator.parseAge("24r");});
		assertEquals("Age in incorrect format", exp.getMessage());
	}

	@Test
	void testparseAgeInvalidValue2() throws InvalidAgeException{

		Exception exp = assertThrows(InvalidAgeException.class, ()->{InputValidator.parseAge("15");});
		assertEquals("The age range cannot be under 18. Max 150.", exp.getMessage());

		Exception exp2 = assertThrows(InvalidAgeException.class, ()->{InputValidator.parseAge("155");});
		assertEquals("The age range cannot be under 18. Max 150.", exp2.getMessage());
	}



	//==================================== parseGender =========================================
	@Test
	void testParseGenderMaleSuccess() throws InvalidGenderException{

		assertEquals("male", InputValidator.parseGender("MALE"));
		assertEquals("male", InputValidator.parseGender("Male"));
		assertEquals("male", InputValidator.parseGender("male"));
		assertEquals("male", InputValidator.parseGender("M"));
		assertEquals("male", InputValidator.parseGender("m"));

	}

	@Test
	void testParseGenderFemaleSuccess() throws InvalidGenderException{

		assertEquals("female", InputValidator.parseGender("FEMALE"));
		assertEquals("female", InputValidator.parseGender("Female"));
		assertEquals("female", InputValidator.parseGender("female"));
		assertEquals("female", InputValidator.parseGender("F"));
		assertEquals("female", InputValidator.parseGender("f"));

	}

	@Test
	void testParseGenderNullAndEmptyValue() throws InvalidGenderException{

		Exception exp = assertThrows(InvalidGenderException.class, ()->{InputValidator.parseGender(null);});
		assertEquals("The field cannot be empty.", exp.getMessage());

		Exception exp2 = assertThrows(InvalidGenderException.class, ()->{InputValidator.parseGender("");});
		assertEquals("The field cannot be empty.", exp2.getMessage());
	}

	@Test
	void testParseGenderInvalidValue() throws InvalidGenderException{

		Exception exp = assertThrows(InvalidGenderException.class, ()->{InputValidator.parseGender("JDskdk");});
		assertEquals("Invalid gender; please select one (male/female)", exp.getMessage());
	}
}