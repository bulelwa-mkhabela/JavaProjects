public class FitnessStoreApp {
    public static void main(String[] args) {
        // Declare two strings representing the shake names
        String shake1 = "VanillaShake";
        String shake2 = "VANILLAshake";

        // Compare the two strings ignoring case sensitivity
        if (shake1.equalsIgnoreCase(shake2)) {
            System.out.println("The shakes are considered the same product.");
        } else {
            System.out.println("The shakes are considered different products.");
        }

        // Output is shown in a clean, readable format that is easy for users to interpret.
    }
}
