/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.1
 */

public class JavaStrings {

    /**
     * Concatenates string1 and string2 after removing leading and trailing whitespace
     * and returns the length of the resulting string
     * @param string1 first string to add
     * @param string2 second string to add
     * @return length of string1 + string2 after removing leading and trailing whitespace
     */
    public int addTogether(String string1, String string2) 
    {
        String pointlessString = string1.strip() + string2.strip();
        return pointlessString.length();
    }

    /**
     * Creates an identifier for the pet, using the first character of the owner's first name,
     * owner's last name and name of pet combined with the year of its Date of Birth
     * @param firstName owner's first name
     * @param lastName  owner's last name
     * @param petName   name of pet
     * @param year      year of pet's Date of Birth
     * @return          String identifier for the pet
     * @throws          IllegalArgumentException if firstName, lastName or petName 
     *                  is an empty string or contains only whitespace
     */
    public String idProcessing(String firstName, 
        String lastName, String petName, int year)
    {
        String strippedFirstName = firstName.strip();
        String strippedLastName = lastName.strip();
        String strippedPetName = petName.strip();

        if(strippedFirstName.length() > 0 &&
            strippedLastName.length() > 0 &&
            strippedPetName.length() > 0)
        {
            return new StringBuilder()
                .append(strippedFirstName.charAt(0)) 
                .append(strippedLastName.charAt(0))
                .append(strippedPetName.charAt(0)) 
                .append(String.valueOf(year))
                .toString().toUpperCase();
        }
        else //throw exception is firstName, lastName or petName is empty/whitespace
        {
            throw new IllegalArgumentException(
                "Error: Illegal argument provided to method idProcessing");
        }
    }

    /**
     * creates a secret code for an ingredient name by replacing all vowels with 'z'
     * and cropping only the 3 first characters
     * @param ingredientName name of the ingredient, must be at least 3 characters long
     * @return string containing the secret code of the ingredient
     */
    public String secretCode(String ingredientName) 
    {
        return ingredientName.toLowerCase().replaceAll("[aeiou]", "z")
            .substring(0, 3);
    }
}