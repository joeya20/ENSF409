
/**
 * @author  Joey Ah-kiow
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * 
 * @version 1.5
 * 
 * @since 1.0
 * 
 */

public class Hello {
    /**
     * This prints "Hello" and the contents of a variable to the terminal window
     * Also initializes a variable for all primitive types and uses both explicit and automatic type casting
     * 
     * @param args Optional command line arguments
     */
    public static void main(String[] args) {
        
        // Declaring a variable for all primitive types
        boolean exampleBool = true;
        char exampleChar = 'a';
        short exampleShort = 10;
        int exampleInt = 20;
        long exampleLong = 30;
        float exampleFloat = 1.1f;
        double exampleDouble = 20.2;

        //explicit type cast
        exampleInt = (int)exampleDouble;

        //automatic type cast
        exampleDouble = exampleInt;

        System.out.println("Hello " + exampleDouble);

    }
}   // end of class declaration