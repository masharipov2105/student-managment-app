package com.masharipov2105.systems.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentRequestModelTest{

	@Test
	void testStudentRequestModelSuccess(){

		StudentRequestModel model = new StudentRequestModel("Ali","Valiev",20,"male","sha-256qoeiqpewiqpeiqpweipqoeqpw12");
		assertEquals("Ali", model.getFirstName());
		assertEquals("Valiev", model.getLastName());
		assertEquals(20, model.getAge());
		assertEquals("male", model.getGender());
		assertEquals("sha-256qoeiqpewiqpeiqpweipqoeqpw12", model.getPassword());	
	}

	@Test
	void testStudentRequestModelUpdateData(){

		StudentRequestModel model = new StudentRequestModel("Ali","Valiev",20,"male", "sha-256qoeiqpewiqpeiqpweipqoeqpw12");
		model.setFirstName("Ali2");
		model.setLastName("Valiev2");
		model.setAge(21);
		model.setGender("female");
		model.setPassword("sha-256qoeiqpewiqpeiqpweipqoeqpw122");

		assertEquals("Ali2", model.getFirstName());
		assertEquals("Valiev2", model.getLastName());
		assertEquals(21, model.getAge());
		assertEquals("female", model.getGender());
		assertEquals("sha-256qoeiqpewiqpeiqpweipqoeqpw122", model.getPassword());
	}
}