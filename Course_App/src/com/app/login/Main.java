package com.app.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.usecases.RegisterStudent;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Automated Student Registration System\n");
		
		
		
		System.out.println("\r\n"
				+ "                  _                            _             _      \r\n"
				+ "     /\\          | |                          | |           | |     \r\n"
				+ "    /  \\   _   _ | |_  ___   _ __ ___    __ _ | |_  ___   __| |     \r\n"
				+ "   / /\\ \\ | | | || __|/ _ \\ | '_ ` _ \\  / _` || __|/ _ \\ / _` |     \r\n"
				+ "  / ____ \\| |_| || |_| (_) || | | | | || (_| || |_|  __/| (_| |     \r\n"
				+ " /_/    \\_\\\\__,_| \\__|\\___/ |_| |_| |_| \\__,_| \\__|\\___| \\__,_|     \r\n"
				+ "   _____  _               _               _                         \r\n"
				+ "  / ____|| |             | |             | |                        \r\n"
				+ " | (___  | |_  _   _   __| |  ___  _ __  | |_                       \r\n"
				+ "  \\___ \\ | __|| | | | / _` | / _ \\| '_ \\ | __|                      \r\n"
				+ "  ____) || |_ | |_| || (_| ||  __/| | | || |_                       \r\n"
				+ " |_____/  \\__| \\__,_| \\__,_| \\___||_| |_| \\__|                      \r\n"
				+ "  _____               _       _                _    _               \r\n"
				+ " |  __ \\             (_)     | |              | |  (_)              \r\n"
				+ " | |__) | ___   __ _  _  ___ | |_  _ __  __ _ | |_  _   ___   _ __  \r\n"
				+ " |  _  / / _ \\ / _` || |/ __|| __|| '__|/ _` || __|| | / _ \\ | '_ \\ \r\n"
				+ " | | \\ \\|  __/| (_| || |\\__ \\| |_ | |  | (_| || |_ | || (_) || | | |\r\n"
				+ " |_|  \\_\\\\___| \\__, ||_||___/ \\__||_|   \\__,_| \\__||_| \\___/ |_| |_|\r\n"
				+ "   _____        __/ | _                                             \r\n"
				+ "  / ____|      |___/ | |                                            \r\n"
				+ " | (___   _   _  ___ | |_  ___  _ __ ___                            \r\n"
				+ "  \\___ \\ | | | |/ __|| __|/ _ \\| '_ ` _ \\                           \r\n"
				+ "  ____) || |_| |\\__ \\| |_|  __/| | | | | |                          \r\n"
				+ " |_____/  \\__, ||___/ \\__|\\___||_| |_| |_|                          \r\n"
				+ "           __/ |                                                    \r\n"
				+ "          |___/                                                     \r\n"
				+ "");
		
		System.out.println("Choose any option: \n"
							+ "Select 1 - for Register new Student\n"
							+ "Select 2 - for Admin Login\n"
							+ "Select 3 - for Student Login\n"
							+ "Select 4 - for Exit\n");
		
		
		
		try {
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			if(choice == 1) {
				RegisterStudent.main(args);
				main(args);
			}else if(choice == 2) {
				AdminLogin.main(args);
			}else if(choice == 3) {
				StudentLogin.main(args);
			}else if(choice == 4) {
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter correct Input");
			main(args);
		}
		
		
		
		
	}
	
}
