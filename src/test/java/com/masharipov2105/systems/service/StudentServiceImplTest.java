package com.masharipov2105.systems.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.masharipov2105.systems.exceptions.*;
import com.masharipov2105.systems.models.*;
import com.masharipov2105.systems.repository.*;
import com.masharipov2105.systems.utils.*;

import java.util.ArrayList;
import java.time.LocalDate;

public class StudentServiceImplTest{

	@Test
	void testShowAll() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model2 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model3 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		assertEquals("[]", service.showAll().toString());
		assertEquals(true, service.create(model));
		assertEquals(true, service.create(model2));
		assertEquals(true, service.create(model3));

		assertEquals(3, service.showAll().size());
		assertEquals(1l, service.showAll().get(0).getId());
		assertEquals(2l, service.showAll().get(1).getId());
		assertEquals(3l, service.showAll().get(2).getId());

	}



	@Test
	void testShow() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model = new StudentRequestModel(

			"Ali",
			"Valiev",
			25,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model2 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model3 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		assertEquals("[]", service.showAll().toString());
		assertEquals(true, service.create(model));
		assertEquals(true, service.create(model2));
		assertEquals(true, service.create(model3));

		assertEquals(25, service.show(1l).getAge());
	}




	@Test
	void testCreateSuccess() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		assertEquals("[]", service.showAll().toString());
		assertEquals(true, service.create(model));
	}



	@Test
	void testCreateErrors() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model2 = new StudentRequestModel(

			"A",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		Exception exp = assertThrows(InvalidNameException.class, ()->{service.create(model2);});
		assertEquals("first name is minimum length: 3 letters", exp.getMessage());

		IdGenerator.reset();

		StudentRequestModel model3 = new StudentRequestModel(

			"Ali",
			"V",
			18,
			"male",
			"Qweasd123"
		);

		Exception exp2 = assertThrows(InvalidNameException.class, ()->{service.create(model3);});
		assertEquals("last name is minimum length: 3 letters", exp2.getMessage());


		IdGenerator.reset();

		StudentRequestModel model4 = new StudentRequestModel(

			"Ali",
			"Valiev",
			15,
			"male",
			"Qweasd123"
		);

		Exception exp3 = assertThrows(InvalidAgeException.class, ()->{service.create(model4);});
		assertEquals("Age cannot be under 18.", exp3.getMessage());


		IdGenerator.reset();

		StudentRequestModel model5 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"mal",
			"Qweasd123"
		);

		Exception exp4 = assertThrows(InvalidGenderException.class, ()->{service.create(model5);});
		assertEquals("Invalid gender; please select one (male/female)", exp4.getMessage());


		IdGenerator.reset();

		StudentRequestModel model6 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Q"
		);

		Exception exp5 = assertThrows(StudentException.class, ()->{service.create(model6);});
		assertEquals("The password length cannot be less than 4 characters or greater than 50 characters.", exp5.getMessage());

	}



	@Test
	void testUpdate() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model2 = new StudentRequestModel(

			"A",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		Exception exp = assertThrows(InvalidNameException.class, ()->{service.update(1l, model2);});
		assertEquals("first name is minimum length: 3 letters", exp.getMessage());

		IdGenerator.reset();

		StudentRequestModel model3 = new StudentRequestModel(

			"Ali",
			"V",
			18,
			"male",
			"Qweasd123"
		);

		Exception exp2 = assertThrows(InvalidNameException.class, ()->{service.update(1l, model3);});
		assertEquals("last name is minimum length: 3 letters", exp2.getMessage());


		IdGenerator.reset();

		StudentRequestModel model4 = new StudentRequestModel(

			"Ali",
			"Valiev",
			15,
			"male",
			"Qweasd123"
		);

		Exception exp3 = assertThrows(InvalidAgeException.class, ()->{service.update(1l, model4);});
		assertEquals("Age cannot be under 18.", exp3.getMessage());


		IdGenerator.reset();

		StudentRequestModel model5 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"mal",
			"Qweasd123"
		);

		Exception exp4 = assertThrows(InvalidGenderException.class, ()->{service.update(1l, model5);});
		assertEquals("Invalid gender; please select one (male/female)", exp4.getMessage());


		IdGenerator.reset();

		StudentRequestModel model6 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Q"
		);

		Exception exp5 = assertThrows(StudentException.class, ()->{service.update(1l, model6);});
		assertEquals("The password length cannot be less than 4 characters or greater than 50 characters.", exp5.getMessage());

	}



	@Test
	void testDrop() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		assertEquals("[]", service.showAll().toString());
		assertEquals(true, service.create(model));
		assertEquals(true, service.drop(1l));
		assertEquals("[]", service.showAll().toString());
		assertEquals(false, service.drop(1l));
	}

	@Test
	void testDropAll() throws StudentException{

		IdGenerator.reset();

		StudentService service = new StudentServiceImpl();

		StudentRequestModel model = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model2 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		StudentRequestModel model3 = new StudentRequestModel(

			"Ali",
			"Valiev",
			18,
			"male",
			"Qweasd123"
		);

		assertEquals("[]", service.showAll().toString());
		assertEquals(true, service.create(model));
		assertEquals(true, service.create(model2));
		assertEquals(true, service.create(model3));

		assertEquals(3, service.showAll().size());
		assertEquals(1l, service.showAll().get(0).getId());
		assertEquals(2l, service.showAll().get(1).getId());
		assertEquals(3l, service.showAll().get(2).getId());

		service.dropAll();
		assertEquals(0, service.showAll().size());
	}

}