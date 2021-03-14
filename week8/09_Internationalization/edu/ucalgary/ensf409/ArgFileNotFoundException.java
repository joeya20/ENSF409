package edu.ucalgary.ensf409;

public class ArgFileNotFoundException extends Exception{
  
  private static final long serialVersionUID = 1L;

  public ArgFileNotFoundException(){
    super();
  }

  public ArgFileNotFoundException(String message){
    super(message);
  }
}