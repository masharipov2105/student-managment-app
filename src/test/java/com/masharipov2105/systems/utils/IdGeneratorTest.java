package com.masharipov2105.systems.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IdGeneratorTest{

	@Test
	void testGenerateId(){

		assertEquals(1L, IdGenerator.generateId());
		assertEquals(2L, IdGenerator.generateId());
		assertEquals(3L, IdGenerator.generateId());
		assertEquals(4L, IdGenerator.generateId());
		assertEquals(5L, IdGenerator.generateId());
		assertEquals(6L, IdGenerator.generateId());
		assertEquals(7L, IdGenerator.generateId());
		assertEquals(8L, IdGenerator.generateId());
		assertEquals(9L, IdGenerator.generateId());

		IdGenerator.reset();

		assertEquals(1L, IdGenerator.generateId());
	}
}