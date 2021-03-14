package edu.ucalgary.ensf409;
import java.io.*;

public class Translator {
  private String languageCode;
  private TranslationText translation;

  /* getTranslation()
  * getter method
  */
  public TranslationText getTranslation() {
    return translation;
  }

  /* translate()
   * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
   * the 31st), and a year. Throws an IllegalArgumentException if monthNum or dayNum is 
   * not valid. Returns the formatted sentence as a String. Notice that the String
   * containing formatting uses numbered arguments - this is because some languages
   * will put the words in the sentence in a different order, but the translate()
   * method must be able to work without knowledge of the language structure.
   * Note: You do not have to check if a day is valid for a particular month/year;
   * February 31 or February 29, 2021 can both be accepted, but out of range values
   * e.g., month 15 day 40, are not valid and should be handled with an 
   * IllegalArgumentException. 
  */
  public String translate(int monthNum, int dayNum, int year) {
    if(dayNum < 0 || dayNum > 31 || monthNum < 0 || monthNum > 12){
      throw new IllegalArgumentException();
    }
    return String.format(translation.getSentence(), translation.getDay(dayNum-1), translation.getMonth(monthNum-1), year);
  }

  /* Constructor
   * Accepts a String of a two-letter language code, dash, and two-letter region
   * code, e.g., te-IN and throws an IllegalArgumentException if the language and
   * region code are not in the correct format. Language codes are ISO 639-1 and
   * region codes are ISO 3166, but this method only checks the format of the String, 
   * not the validity of the codes. It calls importTranslation().
  */
  public Translator(String fileName) throws ClassNotFoundException, IOException, ArgFileNotFoundException{
    if(fileName.replaceFirst("[a-z]{2}-[A-Z]{2}", "").equals("")){
      this.languageCode = fileName;
      importTranslation();
    }
    else{
      throw new IllegalArgumentException("Invalid filename provided!");
    }
  }

  /* importTranslation()
   * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
   * No arguments. Returns void.
  */
  public void importTranslation() throws ClassNotFoundException, IOException, ArgFileNotFoundException{
    File serFile = new File(languageCode + ".ser");
    if(serFile.exists()){
      deserialize();
    }
    else{
      importFromText();
    }
  }

  /* importFromText()
   * Reads in from a the two-letter language code, dash, two-letter region code text 
   * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
   * the data. It can throw I/O exceptions, as well as a custom ArgFileNotFoundException. 
   * We expect the .txt file to be in a valid format. The file is expected to be in the same 
   * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
   * always consist of the month names, one per line, followed by the day names, one per line, 
   * followed by the sentence containing formatting strings. This is the last line in the file. You
   * cannot make any assumptions about what will appear on each line, only that each line
   * will contain only one data element, and that it will not contain an empty line.
   * No arguments. Returns void.
  */
  public void importFromText() throws IOException, ArgFileNotFoundException{
    String[] months = new String[12];
    String[] days = new String[31];
    String sentence = null;

    File textFile = new File(languageCode + ".txt");
    if(!textFile.exists()){
      throw new ArgFileNotFoundException();
    }
    BufferedReader reader = new BufferedReader(new FileReader(textFile));

    for (int i = 0; i < 12; i++) {
      months[i] = reader.readLine();
    }
    for (int i = 0; i < 31; i++) {
      days[i] = reader.readLine();
    }
    sentence = reader.readLine();

    if(reader != null){
      reader.close();
    }
    this.translation = new TranslationText(months, days, sentence);
  }

  /* serialize()
  * Creates a serialized object file of the TranslationText object, with the
  * name format la-CO.ser, where la is the two-letter language code and CO is
  * the two-letter region code. An example of a serialized object file can be
  * found in the exercise directory as es-BO.ser
  * I/O exceptions can be thrown.
   * No arguments. Returns void.
  */
  public void serialize() throws IOException{
    File serFile = new File(languageCode + ".ser");
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(serFile, false));
    serFile.createNewFile();
    outputStream.writeObject(this.translation);
    outputStream.close();
  }

  /* deserialize()
   * Creates a TranslationText object from a .ser file. The files are named
   * xx-YY.ser, where xx is the two-letter language code and YY is the two-
   * letter region code. es-bo.ser is an example. It can throw I/O exceptions.
   * No arguments. Returns void.
  */
  public void deserialize() throws IOException, ClassNotFoundException{
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(languageCode + ".ser"));
    TranslationText fileContents = (TranslationText) inputStream.readObject();
    inputStream.close();
    this.translation = fileContents;
  }
}

