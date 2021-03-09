package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;

public class StringProcessorTest {
    public StringProcessorTest(){
    }

    @Test
    public void testaddTogetherMirror() {
        StringProcessor myStringProcessor = new StringProcessor("c");
        String expResult = "tac";
        String result = myStringProcessor.addTogetherMirror("at");
        assertEquals(expResult, result);
        System.out.println(result);
    }
    @Test
    public void testaddTogetherMirror_lowercase() {
        StringProcessor myStringProcessor = new StringProcessor("c");
        String expResult = "tac";
        String result = myStringProcessor.addTogetherMirror("At");
        assertEquals(expResult, result);
        System.out.println(result);
    }
    @Test
    public void testaddTogetherMirror_strip() {
        StringProcessor myStringProcessor = new StringProcessor("  c  ");
        String expResult = "tac";
        String result = myStringProcessor.addTogetherMirror("  At  ");
        assertEquals(expResult, result);
        System.out.println(result);
    }
}