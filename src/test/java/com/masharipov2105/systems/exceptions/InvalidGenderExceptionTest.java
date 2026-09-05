package com.masharipov2105.systems.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InvalidGenderExceptionTest{

	void helper() throws InvalidGenderException{

		throw new InvalidGenderException();
	}

	@Test
	void testInvalidGenderException() throws InvalidGenderException{

		Exception exp = assertThrows(InvalidGenderException.class, ()->{helper();});
		assertEquals("Invalid gender; please select one (male/female)", exp.getMessage());
	}
}