package project;
import java.util.Scanner;

public class ronish_929420_a3b {

	public static void main(String[] args) {
		 // Scanner for taking input
        Scanner sc = new Scanner(System.in);
        
        // Declare variables for force, area, and pressure
        double force;
        double area;
        double pressure;
        
        // Store a number in the force variable by taking input from the user
        System.out.print("Enter the force: ");
        force = sc.nextDouble();
        
        // Store a number in the area variable by taking input from the user
        System.out.print("Enter the area: ");
        area = sc.nextDouble();
        
        // Divide area by force and store the result in the pressure variable
        pressure = area / force;
        
        // Check the pressure and print the corresponding color
        if (pressure >= 20 && pressure <= 40) {
            System.out.println("Pressure is Green.");
        } else if (pressure >= 41 && pressure <= 65) {
            System.out.println("Pressure is Yellow.");
        } else if (pressure >= 66 && pressure <= 75) {
            System.out.println("Pressure is Red.");
        } else {
            System.out.println("Pressure is out of the defined ranges.");
        }
        
        // Close the scanner
        sc.close();
	}

}
