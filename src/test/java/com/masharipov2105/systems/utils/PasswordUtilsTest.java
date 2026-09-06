package com.masharipov2105.systems.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.masharipov2105.systems.exceptions.InvalidNameException;

public final class PasswordUtilsTest{


	@Test
	void testHashPassword() throws InvalidNameException{

		assertEquals(64, PasswordUtils.hashPassword("12345678").length());

		boolean isTrue = ("12345678" == PasswordUtils.hashPassword("12345678"));
		assertEquals(false, isTrue);
	}

	@Test
	void testHashPasswordIsEquals() throws InvalidNameException{

		String p1 = PasswordUtils.hashPassword("88888888");
		String p2 = PasswordUtils.hashPassword("88888888");

		assertEquals(true, p1.equals(p2));

		String p3 = PasswordUtils.hashPassword("12345678");
		assertEquals(false, p1.equals(p3));
	}
}