/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.1
 */

import java.util.Arrays;

public class SimpleArrays {

    private String[] stringArray;

    /**
     * Default constructor to instantiate stringArray and fill with "Hello, ENSF 409"
     */
    public SimpleArrays() 
    {
        this("Hello, ENSF 409");
    }

    /**
     * Constructor to instantiate and fill stringArray with desired String
     * @param stringToFill String with which to populate field stringArray
     */
    public SimpleArrays(String stringToFill) 
    {
		stringArray = new String[4];
        Arrays.fill(stringArray, stringToFill);
    }

    /**
     * overloaded arrayConcat method which uses 0 as the startIndex when none is provided
     * @return string containing all contents of stringArray,
     *           concatenated and seperated by '#'
     */
    public String arrayConcat() 
    {
        return arrayConcat(0);
    }

    /**
     * @param startIndex index of stringArray to begin concatenating
     * @return  string containing contents of stringArray from startIndex to end,
     *           concatenated and seperated by '#'
     * @throws IndexOutOfBoundsException If startIndex >= stringArray.length
     */
    public String arrayConcat(int startIndex)
    {
        String stringToReturn = arrayCrop(startIndex, //calls array crop from startIndex to end of array
            stringArray.length - 1);

        if(stringToReturn.equals("Fail")) //throws exception if startIndex >= stringArray.length or startIndex < 0
        {
            throw new IndexOutOfBoundsException();
        }
        else if(stringToReturn.equals("Match")) //if startIndex == stringArray.length - 1
        {
            return stringArray[stringArray.length - 1];
        }
        else
        {
            return stringToReturn;
        }
    }

    /**
     * @param startIndex index of stringArray to begin concatenating, inclusive
     * @param endIndex index of stringArray to end concatenating, inclusive
     * @return  string containing contents of stringArray from startIndex to endIndex(inclusive),
     *      concatenated and seperated by '#' or "Match" if (startIndex == endIndex) or
     *      "Fail" if (startIndex >= stringArray.length || if endIndex >= stringArray.length)
     */
    public String arrayCrop(int startIndex, int endIndex) 
    {
        if(startIndex == endIndex)
        {
            return "Match";
        }
        else if(startIndex > endIndex)
        {
            return arrayCrop(endIndex, startIndex); //swap startIndex and endIndex if startIndex > endIndex
        }
        else
        {
            if(startIndex > stringArray.length - 1 ||
                endIndex > stringArray.length - 1 ||
                startIndex < 0 ||
                endIndex < 0)
            {
                return "Fail";
            }
            else
            {
                StringBuilder stringToReturn = 
                    new StringBuilder();
                int i;

                for (i = startIndex; i < endIndex; i++) 
                {
                    stringToReturn.append(stringArray[i] + '#');
                }
                stringToReturn.append(stringArray[i]);

                return stringToReturn.toString();
            }
        }
    }
}
    