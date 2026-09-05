package com.masharipov2105.systems.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentExceptionTest{

	void helper() throws StudentException{

		throw new StudentException("student error");
	}

	@Test
	void testStudentException() throws Exception{

		Exception exp = assertThrows(Exception.class, ()->{helper();});
		assertEquals("student error", exp.getMessage());
	}
}