
/**
 * @author  Joey Ah-kiow
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @version 1.5
 * @since 1.0
 */

public class Hello {
    /**
     * This initializes a variable for all primitive types and prints their contents to the terminal
     * An explicit and automatic type cast are also completed and the results are printed to the terminal
     * 
     * @param args Optional command line arguments
     */
    public static void main(String[] args) {
        
        // Declaring a variable for all primitive types
        boolean exampleBool = true;
        char exampleChar = 'a';
        byte exampleByte = 0;
        short exampleShort = 10;
        int exampleInt = 15;
        long exampleLong = 30;
        float exampleFloat = 1.1f;
        double exampleDouble = 20.2;

        //using all primitive types declared above
        System.out.println("Example boolean: " + exampleBool);
        System.out.println("Example char: " + exampleChar);
        System.out.println("Example byte: " + exampleByte);
        System.out.println("Example short: " + exampleShort);
        System.out.println("Example int: " + exampleInt);
        System.out.println("Example long: " + exampleLong);
        System.out.println("Example float: " + exampleFloat);
        System.out.println("Example double: " + exampleDouble);

        //explicit type cast
        exampleInt = (int)exampleDouble;
        System.out.println("new int: " + exampleInt);

        //automatic type cast
        exampleDouble = exampleInt;
        System.out.println("new double " + exampleDouble);

    }
}   // end of class declaration