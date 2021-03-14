package edu.ucalgary.ensf409;
import java.io.Serializable;

/* TranslationText
* Serializable representation of the data file. Has the serialVersionUID of 19.
* No method in this class throws an exception.
*/
public class TranslationText implements Serializable{
  
  private static final long serialVersionUID = 19L;
  private String[] months;
  private String[] days;
  private String sentence;

  /* getSentence()
  * Getter method, returns String
  */
  public String getSentence() {
    return sentence;
  }
  /* getMonths()
  * Getter method, returns String[]
  */
  public String[] getMonths() {
    return months;
  }
  /* getDays()
  * Getter method, returns String[]
  */
  public String[] getDays() {
    return days;
  }
  /* getMonth()
  * Accepts an integer 0-11 corresponding to an index in the months array,
  * and returns the value at that index.
  */
  public String getMonth(int index) {
    return months[index];
  }
  /* getDay()
  * Accepts an integer 0-30 corresponding to an index in the day array,
  * and returns the value at that index.
  */
  public String getDay(int index) {
    return days[index];
  }
  /* Constructor
  * Accepts a String array of months, a String array of days, and a String 
  * containing a sentence with formatting.
  */
  public TranslationText(String[] months, String[] days, String sentence){
    this.months = months;
    this.days = days;
    this.sentence = sentence;
  }
}

