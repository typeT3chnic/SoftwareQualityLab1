package com.ontariotechu.sofe3980U;

import java.util.Scanner;

import org.joda.time.LocalTime;

/**
 * Interactive Binary Calculator Application
 *
 */
public class App 
{
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	* Main program: Entry point of the interactive binary calculator application.
	* Displays current time and provides a menu-driven interface to perform
	* binary operations (ADD, OR, AND, MULTIPLY).
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		LocalTime currentTime = new LocalTime();
		System.out.println("========================================");
		System.out.println("   BINARY CALCULATOR APPLICATION");
		System.out.println("========================================");
		System.out.println("The current local time is: " + currentTime);
		System.out.println();
		
		boolean running = true;
		while (running) {
			displayMenu();
			int choice = getUserChoice();
			
			switch(choice) {
				case 1:
					performAddition();
					break;
				case 2:
					performOr();
					break;
				case 3:
					performAnd();
					break;
				case 4:
					performMultiply();
					break;
				case 5:
					running = false;
					System.out.println("Thank you for using Binary Calculator! Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.\n");
			}
		}
		
		scanner.close();
    }
	
	/**
	 * Display the main menu options
	 */
	private static void displayMenu() {
		System.out.println("========================================");
		System.out.println("          SELECT OPERATION");
		System.out.println("========================================");
		System.out.println("1. ADD two binary numbers");
		System.out.println("2. OR two binary numbers");
		System.out.println("3. AND two binary numbers");
		System.out.println("4. MULTIPLY two binary numbers");
		System.out.println("5. EXIT");
		System.out.println("========================================");
	}
	
	/**
	 * Get user's menu choice
	 * @return the user's choice as an integer
	 */
	private static int getUserChoice() {
		System.out.print("Enter your choice (1-5): ");
		try {
			int choice = Integer.parseInt(scanner.nextLine());
			return choice;
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	/**
	 * Get a binary number from the user with validation
	 * @param promptMessage the message to display to the user
	 * @return a Binary object with user-provided value
	 */
	private static Binary getBinaryInput(String promptMessage) {
		while (true) {
			System.out.print(promptMessage);
			String input = scanner.nextLine().trim();
			
			// Validate input
			boolean isValid = true;
			if (input.isEmpty()) {
				isValid = false;
			} else {
				for (char c : input.toCharArray()) {
					if (c != '0' && c != '1') {
						isValid = false;
						break;
					}
				}
			}
			
			if (isValid) {
				return new Binary(input);
			} else {
				System.out.println("Invalid input! Please enter only binary digits (0 and 1).\n");
			}
		}
	}
	
	/**
	 * Perform addition operation
	 */
	private static void performAddition() {
		System.out.println("\n--- ADDITION OPERATION ---");
		Binary num1 = getBinaryInput("Enter first binary number: ");
		Binary num2 = getBinaryInput("Enter second binary number: ");
		
		Binary result = Binary.add(num1, num2);
		
		System.out.println("\n  " + num1.getValue() + " (binary)");
		System.out.println("+ " + num2.getValue() + " (binary)");
		System.out.println("--------------------");
		System.out.println("  " + result.getValue() + " (binary)\n");
	}
	
	/**
	 * Perform OR operation
	 */
	private static void performOr() {
		System.out.println("\n--- BITWISE OR OPERATION ---");
		Binary num1 = getBinaryInput("Enter first binary number: ");
		Binary num2 = getBinaryInput("Enter second binary number: ");
		
		Binary result = Binary.or(num1, num2);
		
		System.out.println("\n  " + num1.getValue() + " (binary)");
		System.out.println("| " + num2.getValue() + " (binary)");
		System.out.println("--------------------");
		System.out.println("  " + result.getValue() + " (binary)\n");
	}
	
	/**
	 * Perform AND operation
	 */
	private static void performAnd() {
		System.out.println("\n--- BITWISE AND OPERATION ---");
		Binary num1 = getBinaryInput("Enter first binary number: ");
		Binary num2 = getBinaryInput("Enter second binary number: ");
		
		Binary result = Binary.and(num1, num2);
		
		System.out.println("\n  " + num1.getValue() + " (binary)");
		System.out.println("& " + num2.getValue() + " (binary)");
		System.out.println("--------------------");
		System.out.println("  " + result.getValue() + " (binary)\n");
	}
	
	/**
	 * Perform multiplication operation
	 */
	private static void performMultiply() {
		System.out.println("\n--- MULTIPLICATION OPERATION ---");
		Binary num1 = getBinaryInput("Enter first binary number: ");
		Binary num2 = getBinaryInput("Enter second binary number: ");
		
		Binary result = Binary.multiply(num1, num2);
		
		System.out.println("\n  " + num1.getValue() + " (binary)");
		System.out.println("* " + num2.getValue() + " (binary)");
		System.out.println("--------------------");
		System.out.println("  " + result.getValue() + " (binary)\n");
	}
}
