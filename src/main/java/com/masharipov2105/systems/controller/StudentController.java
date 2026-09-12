package com.masharipov2105.systems.controller;

import com.masharipov2105.systems.exceptions.*;
import com.masharipov2105.systems.models.*;
import com.masharipov2105.systems.utils.*;
import com.masharipov2105.systems.service.*;

import java.util.Scanner;

public class StudentController{

	private StudentService service;
	private Scanner scanner;
	private boolean isRun = true;
	private String banner = "\n===================================================\n" +
							"=             Student Managment System            =\n" +
							"===================================================\n";

	private String menu = "1) help - show all commands\n" +
						  "2) list - List of all students\n" + 
						  "3) show - View student by ID\n" + 
						  "4) create - Add new information\n" +
						  "5) edit - Edit information by ID\n" +
						  "6) delete - Delete information by ID\n" +
						  "7) clear - Clear the entire list\n" +
						  "8) quit - Exit the program\n";

	public StudentController(StudentService service_){

		this.service = service_;
		this.scanner = new Scanner(System.in);

	}

	public void start() throws StudentException{

		System.out.println(this.banner);
		System.out.println(this.menu);

		while(this.isRun){

			System.out.print("StudentManagement/ROOT > ");
			String command = this.scanner.nextLine();

			try{

				switch (InputValidator.parseCommand(command)){

					case "help":

						System.out.println("\n" + this.menu);
						break;

					case "list":

						System.out.println(PrintAllStudentList());
						break;

					case "show":
						PrintStudentById();
						break;

					case "create":
						CreateStudent();
						break;

					case "edit":
						System.out.println("Selected in edit command");
						break;

					case "delete":
						System.out.println("Selected in delete command");
						break;

					case "clear":
						System.out.println("Selected in clear command");
						break;

					case "quit":
						System.out.println("Goodbye!");
						this.isRun = false;
						break;
				}

			} catch (InvalidCommandException e){

				if (!e.getMessage().equals("empty command, continue")){

					System.out.println(e.getMessage());
				}
			}
		}
	}

	// The method is show All students or 'The list is empty' message
	private String PrintAllStudentList(){

		String finalString = "";
		if (this.service.showAll().size() == 0){

			finalString = "The list is empty.";
		}

		for (int i = 0; i < this.service.showAll().size(); i ++){

			finalString += (String.format("%d) %s", (i+1), this.service.showAll().get(i)) + "\n");
		}

		return finalString;
	}

	// The metod is show information by ID number
	private void PrintStudentById() throws StudentException{

		System.out.print("enter ID: ");
		String id = this.scanner.nextLine();

		if (id == null || id.trim().isEmpty()){
			
			PrintStudentById();
		} else if (id.trim().equals("quit")){

			System.out.println("Cancel");
		} else{

			try{

				System.out.println(this.service.show(Long.parseLong(id)).toString());
			} catch(NumberFormatException e){

				System.out.println("The ID must be an integer.");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		}
	}

	//The method is created new Studnet item
	private void CreateStudent() throws StudentException{

		boolean isContinue = true;
		String firstName = null;
		String lastName = null;
		int age = 0;
		String gender = "male";
		String password = null;


		// firstName acquisition mechanism
		while (isContinue){

			System.out.print("enter firstName: ");
			String data = this.scanner.nextLine();

			if (data == null || data.trim().isEmpty()){

				continue;
			} else if(data.trim().equals("quit")){

				System.out.println("Cancel");
				isContinue = false;
				break;
			} else{

				try{

					firstName = InputValidator.parseName(data);
					break;
				} catch(InvalidNameException e){

					System.out.println(e.getMessage());
				}
			}
		}

		// lastName acquisition mechanism
		while (isContinue){

			System.out.print("enter lastName: ");
			String data = this.scanner.nextLine();

			if (data == null || data.trim().isEmpty()){

				continue;
			} else if(data.trim().equals("quit")){

				System.out.println("Cancel");
				isContinue = false;
				break;
			} else{

				try{

					lastName = InputValidator.parseName(data);
					break;
				} catch(InvalidNameException e){

					System.out.println(e.getMessage());
				}
			}
		}


		// age acquisition mechanism
		while (isContinue){

			System.out.print("enter age: ");
			String data = this.scanner.nextLine();

			if (data == null || data.trim().isEmpty()){

				continue;
			} else if(data.trim().equals("quit")){

				System.out.println("Cancel");
				isContinue = false;
				break;
			} else{

				try{

					age = InputValidator.parseAge(data);
					break;
				} catch(InvalidAgeException e){

					System.out.println(e.getMessage());
				}
			}
		}


		// gender acquisition mechanism
		while (isContinue){

			System.out.print("enter gender(male/female): ");
			String data = this.scanner.nextLine();

			if (data == null || data.trim().isEmpty()){

				continue;
			} else if(data.trim().equals("quit")){

				System.out.println("Cancel");
				isContinue = false;
				break;
			} else{

				try{

					gender = InputValidator.parseGender(data);
					break;
				} catch(InvalidGenderException e){

					System.out.println(e.getMessage());
				}
			}
		}


		// password acquisition mechanism
		while (isContinue){

			System.out.print("enter password: ");
			String data = this.scanner.nextLine();

			if (data == null || data.trim().isEmpty()){

				continue;
			} else if(data.trim().equals("quit")){

				System.out.println("Cancel");
				isContinue = false;
				break;
			} else{

				try{

					password = InputValidator.parsePassword(data);
					break;
				} catch(InvalidNameException e){

					System.out.println(e.getMessage());
				}
			}
		}

		if (isContinue){

			StudentRequestModel newStudent = new StudentRequestModel(

				firstName,
				lastName,
				age,
				gender,
				password
			);

			try{

				this.service.create(newStudent);
				System.out.println("Successfully created!");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		}
	}
}