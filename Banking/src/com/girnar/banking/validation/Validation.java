package com.girnar.banking.validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public int validationForIntegerValues() {
		String regex = "^[0-9]{1,6}";
		Pattern pattern;
		Matcher match;
		String value;
		// System.out.println("please Enter value");
		/**
		 * Hear the validation operation is going to be done .check the given length
		 * which we enter is valid or not.
		 */
		Scanner scanner = new Scanner(System.in);
		while (true) {
			value = scanner.nextLine();
			pattern = Pattern.compile(regex);
			match = pattern.matcher(value);
			// System.out.println(match);
			if (match.matches()) {
				// scanner.close();
				return Integer.parseInt(value);
				// converting string input to long and returning in value variable
			} else {
				// if the entered is not valid value this part will executed
				System.out.println("please Enter valid input");
				continue;
			}
		}
	}

	public String validationForStringValues() {
		String regex = "[a-zA-Z]+";
		Pattern pattern;
		Matcher match;
		String value;
		// System.out.println("please Enter value");
		/**
		 * Hear the validation operation is going to be done .check the given length
		 * which we enter is valid or not.
		 */
		Scanner scanner = new Scanner(System.in);
		while (true) {
			value = scanner.nextLine();
			pattern = Pattern.compile(regex);
			match = pattern.matcher(value);
			// System.out.println(match);
			if (match.matches()) {
				if (value.length() > 500) {
					System.out.println("Please enter valid input having characters less than 50");
					continue;
				} else {
					// scanner.close();
					return value;
				}
				// converting string input to long and returning in value variable
			} else {
				// if the entered is not valid value this part will executed

				System.out.println("please Enter valid input");
				continue;
			}
		}
	}
}
