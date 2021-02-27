/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.2
 */

public class Creature {
    /**
     * This prints out "This is a placeholder for Creature " and the contents of string animalType of class Animal
     * @param args Handles command-line arguments
     */
    public static void main(String[] args) {

        //instantiate new object of type Animal and get content of String animalType
        Animal myAnimal = new Animal();     
        String myType = myAnimal.animalType();
        //print output to console
        System.out.println("This is a placeholder for Creature " + 
            myType);
    }
}   //end of class Creature declaration


class Animal{
    private String animalType = "dog";

    public String animalType() {    //returns content of animalType
        return animalType;
    }
}   //end of class Animal declaration