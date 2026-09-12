package com.masharipov2105.systems.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class StudentResponseModelTest{

	@Test
	void testStudentResponseModelCreateSuccess(){

		StudentResponseModel model = new StudentResponseModel(1l,"Ali","Valiev",20,"male",LocalDate.now());
		assertEquals(1l, model.getId());
		assertEquals("Ali", model.getFirstName());
		assertEquals("Valiev", model.getLastName());
		assertEquals(20, model.getAge());
		assertEquals("male", model.getGender());
		assertEquals(LocalDate.now(), model.getCreateAt());
	}

	@Test
	void testStudentResponseModelUpdateData(){

		StudentResponseModel model = new StudentResponseModel(1l,"Ali","Valiev",20,"male",LocalDate.now());
		model.setId(2l);
		model.setFirstName("Ali2");
		model.setLastName("Valiev2");
		model.setAge(21);
		model.setGender("female");
		model.setCreateAt(LocalDate.now());

		assertEquals(2l, model.getId());
		assertEquals("Ali2", model.getFirstName());
		assertEquals("Valiev2", model.getLastName());
		assertEquals(21, model.getAge());
		assertEquals("female", model.getGender());
		assertEquals(LocalDate.now(), model.getCreateAt());
	}

	@Test
	void testToString(){

		StudentResponseModel model = new StudentResponseModel(1l,"Ali","Valiev",20,"male",LocalDate.now());

		assertEquals(String.format("1; Ali; Valiev; 20; male; %s", String.valueOf(LocalDate.now())), model.toString());
	}
}