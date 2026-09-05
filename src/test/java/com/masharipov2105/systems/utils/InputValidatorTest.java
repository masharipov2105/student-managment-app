package com.masharipov2105.systems.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.masharipov2105.systems.exceptions.*;

public class InputValidatorTest{

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
}