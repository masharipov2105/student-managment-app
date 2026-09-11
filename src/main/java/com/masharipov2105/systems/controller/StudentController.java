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
						System.out.println("Selected in help command");
						break;

					case "list":
						System.out.println("Selected in list command");
						break;

					case "show":
						System.out.println("Selected in show command");
						break;

					case "create":
						System.out.println("Selected in create command");
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
}