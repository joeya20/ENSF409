/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.0
 */

public class Permutations {

    public int permutations(int arrayLength,
        int numOfElements) 
    {
        if(arrayLength >= 0 && 
            numOfElements >= 0 &&
            numOfElements <= arrayLength)
            {
                if(numOfElements == 0 ||
                    arrayLength == 0)
                {
                    return 1;
                }
                else
                {
                    return arrayLength * 
                        permutations(arrayLength - 1, numOfElements - 1);
                }
            }
        else
        {
            throw new IllegalArgumentException("Illegal argument(S) provided to method permutations()");
        }
    }

    // public static void main(String[] args)
    // {
    //     System.out.println(new Permutations().permutations(3, 2));
    // }
}