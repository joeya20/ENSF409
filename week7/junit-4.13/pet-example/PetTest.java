import org.junit.*;
import static org.junit.Assert.*;

public class PetTest {
    public PetTest(){
    }
    @Test
    public void testCalculateAge_BirthdayPast() {
        //create pet object
        int[] birthDate = new int[]{2011, 1, 1};
        Pet myPet = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
        //set expected result and obtained result
        int expResult = 10;
        int result = myPet.calculateAge();
        //compare obtained result w/ expected result
        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAge_BirthdayFuture() {
        //create pet object
        int[] birthDate = new int[]{2011, 1, 1};
        Pet myPet = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
        //set expected result and obtained result
        int expResult = 9;
        int result = myPet.calculateAge();
        //compare obtained result w/ expected result
        assertEquals("Calculated age was incorrect: ", expResult, result);
    }
    @Test
    public void testCalculateAge_BirthdayToday() {
        //create pet object
        int[] birthDate = new int[]{2011, 1, 1};
        Pet myPet = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
        //set expected result and obtained result
        int expResult = 10;
        int result = myPet.calculateAge();
        //compare obtained result w/ expected result
        assertEquals("Calculated age was incorrect: ", expResult, result);
    }
}