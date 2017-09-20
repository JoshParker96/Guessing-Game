import java.util.Scanner;

public class Prompter {
  
  Scanner scanner = new Scanner(System.in);
  
  public Jar jar;
  
  public String askForItemName() {
   System.out.print("\n=====================\n"); 
   System.out.print("ADMINISTRAtOR SET UP\n");
   System.out.print("=====================\n");
   System.out.print("\nWhat item do you want to fill the jar with? ");
   return scanner.nextLine();
  }
  
  public int askForNumberOfItems(String type) {
   int amount = 0;
   System.out.printf("How many %s(s) do you want in the jar? ", type);
   amount = scanner.nextInt();
   return amount;
  }
  
  public void playerRules(String type, int maxAmount) {
   System.out.print("\n=====================\n"); 
   System.out.print("       PLAYER\n");
   System.out.print("=====================\n");
   System.out.printf("How many %s are in the jar? Pick a number between 1 and %d\n", type, maxAmount);
   System.out.println(" ");
  }
  
  public int promptForGuess() {
   int guess = 0;
    
    do {
      System.out.print("Guess: ");
      guess = checkGuess(guess);
  } while(guess <= 0);
    
    return guess;
  }
  
  public void warning(int guess, int numberOfItems) {
    try {
      if(guess > numberOfItems) {
        throw new IllegalArgumentException("Player's guess must be less than the number Of items in the jar\n");
      }
  } catch (IllegalArgumentException iae) {
      System.out.printf("Your guess must be less than %d\n", numberOfItems);
    }
  
  }
  
  public int checkGuess(int guess) {
    try {
      guess = scanner.nextInt();
      if (guess <= 0) {
        throw new IllegalArgumentException("player's guess must be greater than 0\n");
      }
    }catch (IllegalArgumentException iae) {
      System.out.println("Guess must be greater than 0");
    }
    scanner.nextLine();
    return guess;
  }
  
  public void clue(int compareGuess) {
    if(compareGuess < 0) {
     System.out.println("Your guess is too high\n");
    } else {
     System.out.println("Your guess is too low\n"); 
    }
  }
  
  public void printResult(int attempts) {
    System.out.printf("You got it in %d attempt(s).\n", attempts);
  }
}