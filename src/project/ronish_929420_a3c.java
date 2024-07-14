package project;
import javax.swing.JOptionPane;

public class ronish_929420_a3c {
    public static void main(String[] args) {
        // Declare variables
        String name;
        int age;
        double annualPay;

        // Take input from the user using JOptionPane
        name = JOptionPane.showInputDialog("Enter your name:");
        age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
        annualPay = Double.parseDouble(JOptionPane.showInputDialog("Enter your desired annual pay:"));

        // Create the message to display
        String message = "My name is " + name + ", my age is " + age + " and\n" +
                         "I hope to earn $" + annualPay + " per year.";

        // Display the message using JOptionPane
        JOptionPane.showMessageDialog(null, message);

        // Exit the program
        System.exit(0);
    }
}

