/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.1
 */

public class Animal {

    //fields
    private int legs = 4;
    private String color;

    //Constructors
    public Animal(
        String color,
        int legs) 
    {
        this.color = color;
        this.legs = legs;
    }

    public Animal(
        String color) 
    {
        this.color = color;
    }

    //getters
    public int getLegs() 
    {
        return this.legs;
    }

    public String getColor() 
    {
        return this.color;
    }

    //setters
    public void setColor(
        String color) 
    {
        this.color = color;
    }

    public void setLegs(
        int legs) 
    {
        this.legs = legs;
    }
}