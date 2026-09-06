package com.masharipov2105.systems.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.masharipov2105.systems.models.StudentModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class StudentRepositoryImplTest{


	@Test
	void testSave(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentRepository studentRepo = new StudentRepositoryImpl();

		assertEquals("[]", studentRepo.getAll().toString());

		studentRepo.save(1L, model);

		assertEquals(false, "[]".equals(studentRepo.getAll().toString()));
	}

	@Test
	void testGetAll(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentRepository studentRepo = new StudentRepositoryImpl();

		studentRepo.save(1l, model);

		assertEquals(1l, studentRepo.getAll().get(0).getId());
		assertEquals("Ali", studentRepo.getAll().get(0).getFirstName());
		assertEquals("Valiev", studentRepo.getAll().get(0).getLastName());
		assertEquals(20, studentRepo.getAll().get(0).getAge());
		assertEquals("male", studentRepo.getAll().get(0).getGender());
		assertEquals(LocalDate.now(), studentRepo.getAll().get(0).getCreateAt());
		assertEquals("sha-256qoeiqpewiqpeiqpweipqoeqpw12", studentRepo.getAll().get(0).getPassword());
		assertEquals(LocalDate.now(), studentRepo.getAll().get(0).getUpdateAt());

	}

	@Test
	void testGetInById(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentRepository studentRepo = new StudentRepositoryImpl();

		studentRepo.save(1l, model);

		assertEquals(1l,studentRepo.getId(1l).getId());
		assertEquals("Ali", studentRepo.getId(1l).getFirstName());
		assertEquals("Valiev", studentRepo.getId(1l).getLastName());
		assertEquals(20, studentRepo.getId(1l).getAge());
		assertEquals("male", studentRepo.getId(1l).getGender());
		assertEquals(LocalDate.now(), studentRepo.getId(1l).getCreateAt());
		assertEquals("sha-256qoeiqpewiqpeiqpweipqoeqpw12", studentRepo.getId(1l).getPassword());
		assertEquals(LocalDate.now(), studentRepo.getId(1l).getUpdateAt());
	}

	@Test
	void testRemoveById(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentRepository studentRepo = new StudentRepositoryImpl();

		studentRepo.save(1l, model);
		assertEquals(false, "[]".equals(studentRepo.getAll().toString()));

		studentRepo.removeId(1l);

		assertEquals(true, "[]".equals(studentRepo.getAll().toString()));
	}

	@Test
	void testUpdateById(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentRepository studentRepo = new StudentRepositoryImpl();

		studentRepo.save(1l, model);

		StudentModel model2 = new StudentModel(1l,"Olivia","Alderson",25,"female",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		studentRepo.updateId(1l, model2);

		assertEquals(1l,studentRepo.getId(1l).getId());
		assertEquals("Olivia", studentRepo.getId(1l).getFirstName());
		assertEquals("Alderson", studentRepo.getId(1l).getLastName());
		assertEquals(25, studentRepo.getId(1l).getAge());
		assertEquals("female", studentRepo.getId(1l).getGender());
		assertEquals(LocalDate.now(), studentRepo.getId(1l).getCreateAt());
		assertEquals("sha-256qoeiqpewiqpeiqpweipqoeqpw12", studentRepo.getId(1l).getPassword());
		assertEquals(LocalDate.now(), studentRepo.getId(1l).getUpdateAt());
	}

	@Test
	void testRemoveAll(){

		StudentModel model = new StudentModel(1l,"Ali","Valiev",20,"male",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		StudentModel model2 = new StudentModel(1l,"Olivia","Alderson",25,"female",LocalDate.now(),"sha-256qoeiqpewiqpeiqpweipqoeqpw12",LocalDate.now());
		
		StudentRepository studentRepo = new StudentRepositoryImpl();
		assertEquals(true, "[]".equals(studentRepo.getAll().toString()));

		studentRepo.save(1l, model);
		studentRepo.save(2l, model2);

		assertEquals(false, "[]".equals(studentRepo.getAll().toString()));

		studentRepo.removeAll();

		assertEquals(true, "[]".equals(studentRepo.getAll().toString()));
	}
}