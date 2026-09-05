package com.masharipov2105.systems.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InvalidNameExceptionTest{

	void helper() throws InvalidNameException{

		throw new InvalidNameException();
	}

	@Test
	void testInvalidNameException() throws InvalidNameException{

		Exception exp = assertThrows(InvalidNameException.class, ()->{helper();});
		assertEquals("Invalid name; please use only letters.", exp.getMessage());
	}
}