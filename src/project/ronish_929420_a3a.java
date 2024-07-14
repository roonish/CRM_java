package project;

public class ronish_929420_a3a {

	public static void main(String[] args) {
		// Initialize a,b as int with default value 0 and initialize c as char without a value
		int a = 0; 
        int b = 0;
        char c;

        // a. Adds 2 to a and stores the result in b
        b = a + 2;

        // b. Multiplies b times 4 and stores the result in a
        a = b * 4;

        // c. Divides a by 3.14 and stores the result in b
        b = (int) (a / 3.14);

        // d. Subtracts 8 from b and stores the result in a
        a = b - 8;

        // e. Stores the character ‘K’ in c
        c = 'K';

        // f. Stores the Unicode code for ‘B’(66) in c 
        c = (char) 66;

        // Print the final values of a, b, and c
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
		
	}

}
