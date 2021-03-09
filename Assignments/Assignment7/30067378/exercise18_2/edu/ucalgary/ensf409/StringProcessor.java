package edu.ucalgary.ensf409;
import java.util.regex.*;

public class StringProcessor{
    private final String storedString;

    public StringProcessor(String input){
        this.storedString = new String(input);
    }
    
    public String addTogetherMirror(String inputString) {
        String combined = storedString.strip() + inputString.strip();
        return new StringBuilder(combined).reverse().toString().toLowerCase();
    }

    public static String idProcessing(String firstName, String lastName, String petName, int year) {
        String nameFormat = "^[A-Z]{1}([-a-zA-Z\\s\\.']*)[a-z]{1}";
        String puncCheck = "[-\\s\\.']{2,}";
        Pattern namePattern = Pattern.compile(nameFormat);
        Pattern puncPattern = Pattern.compile(puncCheck);
        //check year
        if(year > 2021 || String.valueOf(year).length() < 4){
            throw new IllegalArgumentException();
        }
        //check first name
        Matcher nameMatcher = namePattern.matcher(firstName);
        Matcher puncMatcher = puncPattern.matcher(firstName);
        if((firstName.length() > 26) || !nameMatcher.matches() || puncMatcher.find()){
            throw new IllegalArgumentException();
        }
        //check last name
        nameMatcher = namePattern.matcher(lastName);
        puncMatcher = puncPattern.matcher(lastName);
        if((lastName.length() > 26) || !nameMatcher.matches() || puncMatcher.find()){
            throw new IllegalArgumentException();
        }
        //check pet name
        nameMatcher = namePattern.matcher(petName);
        puncMatcher = puncPattern.matcher(petName);
        if((petName.length() > 26) || !nameMatcher.matches() || puncMatcher.find()){
            throw new IllegalArgumentException();
        }
        String petID = new String(String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + String.valueOf(petName.charAt(0)) + String.valueOf(year));
        return petID;
    }

    public String secretCode(int offset) {
        String encodedString = new String();
        
        for (int i = 0; i < storedString.length(); i++){

            char newUnicode = storedString.charAt(i);

            if(Character.isLetter(storedString.charAt(i))){
                newUnicode += offset;
                if(!Character.isLetter(newUnicode)){
                    newUnicode -= 26;
                }
            }
            encodedString = encodedString.concat(String.valueOf(newUnicode));
        }
        
        return encodedString;
    }
    
    public String getStoredString(){
        return this.storedString;
    }

}

