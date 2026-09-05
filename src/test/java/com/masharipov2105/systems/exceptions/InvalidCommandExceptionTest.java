package com.masharipov2105.systems.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InvalidCommandExceptionTest{

	void helper() throws InvalidCommandException{

		throw new InvalidCommandException();
	}

	@Test
	void testInvalidCommandException() throws InvalidCommandException{

		Exception exp = assertThrows(InvalidCommandException.class, ()->{helper();});
		assertEquals("Command does not exist; please enter 'help'.", exp.getMessage());
	}
}