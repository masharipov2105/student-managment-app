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

			System.out.print("StudentManagement > ");
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
						CreateOrUpdateStudent("create");
						break;

					case "edit":
						CreateOrUpdateStudent("update");
						break;

					case "delete":
						RemoveStudentById();
						break;

					case "clear":
						ClearAllData();
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

		String finalString = "\n";
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

				System.out.println("\n" + this.service.show(Long.parseLong(id)).toString() + "\n");
			} catch(NumberFormatException e){

				System.out.println("The ID must be an integer.");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		}
	}











	//The method is create new or update Studnet item
	private void CreateOrUpdateStudent(String regime) throws StudentException{

		long id = 1l;
		String parametr = "the";
		boolean isContinue = true;
		String firstName = null;
		String lastName = null;
		int age = 0;
		String gender = "male";
		String password = null;

		if (regime.equals("update")){

			parametr = "new";

			// id acquisition mechanism
			while (isContinue){

				System.out.print("enter id: ");
				String data = this.scanner.nextLine();

				if (data == null || data.trim().isEmpty()){

					continue;
				} else if(data.trim().equals("quit")){

					System.out.println("Cancel");
					isContinue = false;
					break;
				} else{

					try{

						this.service.show(Long.parseLong(data));
						break;
					} catch(NumberFormatException e){

						System.out.println("The ID must be an integer.");
					} catch(StudentException e){

						System.out.println(e.getMessage());
						isContinue = false;
						break;
					}
				}
			}
		}

		// firstName acquisition mechanism
		while (isContinue){

			System.out.print(String.format("enter %s firstName: ", parametr));
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

			System.out.print(String.format("enter %s lastName: ", parametr));
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

			System.out.print(String.format("enter %s age: ", parametr));
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

			System.out.print(String.format("enter %s gender(male/female): ", parametr));
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

			System.out.print(String.format("enter %s password: ", parametr));
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

		if (isContinue && regime.equals("create")){

			StudentRequestModel student = new StudentRequestModel(

				firstName,
				lastName,
				age,
				gender,
				password
			);

			try{

				this.service.create(student);
				System.out.println("Successfully created!");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		} else if (isContinue && regime.equals("update")){

			StudentRequestModel updateStudent = new StudentRequestModel(

				firstName,
				lastName,
				age,
				gender,
				password
			);

			try{

				this.service.update(id, updateStudent);
				System.out.println("Successfully updated!");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		}
	}
















	//The metod is remove data by ID
	private void RemoveStudentById() throws StudentException{

		System.out.print("enter ID: ");
		String id = this.scanner.nextLine();

		if (id == null || id.trim().isEmpty()){
			
			RemoveStudentById();
		} else if (id.trim().equals("quit")){

			System.out.println("Cancel");
		} else{

			try{

				if (this.service.drop(Long.parseLong(id))){

					System.out.println("Successfully deleted.");
				} else{

					System.out.println("No information found for the ID.");
				}
			} catch(NumberFormatException e){

				System.out.println("The ID must be an integer.");
			} catch(StudentException e){

				System.out.println(e.getMessage());
			}
		}
	}











	// The method is clearr All data
	private void ClearAllData(){

		System.out.print("Delete all data ? (yes/no): ");

		String result = this.scanner.nextLine();

		if (result == null || result.trim().isEmpty()){

			ClearAllData();
		} else if (result.trim().equals("quit")){

			System.out.println("Cancel");
		}else if(result.equals("yes")){

			this.service.dropAll();
			System.out.println("Clear all data.");
		} else if(result.equals("no")){

			System.out.println("Operation cancelled");
		} else{

			System.out.println("enter 'yes' or 'no'");
			ClearAllData();
		}
	}

}