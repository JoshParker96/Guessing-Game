public class GuessingGame {
    public static void main(String[] args) {
      final Prompter prompter = new Prompter();
      final String type = prompter.askForItemName();
      final int numberOfItems = prompter.askForNumberOfItems(type);
      
      final Jar jar = new Jar(type, numberOfItems);
      jar.fillJar();
      
      prompter.playerRules(type, numberOfItems);
      startGame(prompter, jar, numberOfItems);
    }
  
  
  private static void startGame(Prompter prompter, Jar jar, int numberOfItems) {
    int attempts = 0;
    int hasWon = 1;
    
    while(hasWon != 0) {
      hasWon = keepGuessing(prompter, jar, numberOfItems);
      attempts++;
    }
    prompter.printResult(attempts);
  }
  
  
  private static int keepGuessing(Prompter prompter, Jar jar, int numberOfItems) {
    int guess;
    int hasWon;
    
    do {
      guess = prompter.promptForGuess();
      if(guess > numberOfItems) {
        prompter.warning(guess, numberOfItems);
      }
    } while(guess > numberOfItems);
    
    hasWon = jar.hasWon(guess);
    if(hasWon != 0) {
      prompter.clue(hasWon);
    }
    return hasWon;
  }
}





