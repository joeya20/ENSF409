package edu.ucalgary.ensf409;
import java.io.IOException;

public class DayMemory {
  /* main()
   * Accept a command-line argument which specifies a translation file.
   * The argument should be in the form of a two-letter language code,
   * followed by a dash and a two-letter region code, e.g., en-US
   * which corresponds with files en-US.txt and en-US.ser
   * If no argument is specified, it throws a custom exception,
   * CommandArgumentNotProvidedException. Additional arguments are
   * ignored.
  */
  public static void main(String[] args)
  throws CommandArgumentNotProvidedException, IOException, 
  ClassNotFoundException, ArgFileNotFoundException {
    if(args.length == 0) {
      throw new CommandArgumentNotProvidedException();
    }
    else {
      String translationFile = args[0];
      var translation = new Translator(translationFile);
    }
  }
}