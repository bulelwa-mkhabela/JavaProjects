import java.util.Scanner;
/**
 * DietTrackerInputValidator is a simple program that validates a single-character input
 * from the user. The input must be either a letter (for a food item name) or a digit
 * (for a calorie value). Any other type of input is considered invalid.
**/
public class DietTrackerInputValidator {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a character (letter for food item, digit for calories): ");
        String input = scanner.nextLine();

        // Check if the input is exactly one character long
        if (input.length() != 1) {
            System.out.println("Invalid input: Please enter exactly one character.");
        } else {
            char ch = input.charAt(0);

            // Use Character class methods to validate
            if (Character.isLetter(ch)) {
                System.out.println("Valid input: It's a letter (for food item name).");
            } else if (Character.isDigit(ch)) {
                System.out.println("Valid input: It's a digit (for calorie value).");
            } else {
                System.out.println("Invalid input: The character is neither a letter nor a digit.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}

