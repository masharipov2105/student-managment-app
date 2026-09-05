package com.masharipov2105.systems.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InvalidAgeExceptionTest{

	void helper() throws InvalidAgeException{

		throw new InvalidAgeException();
	}

	@Test
	void testInvalidAgeException() throws StudentException{

		Exception exp = assertThrows(InvalidAgeException.class, ()->{helper();});
		assertEquals("Age in incorrect format", exp.getMessage());
	}
}