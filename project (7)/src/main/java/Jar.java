import java.util.Scanner;
import java.util.Random;

public class Jar {
  
  public String itemName;
  public int numberOfItems;
  public int actualNumber;
  
  Scanner scanner = new Scanner(System.in);
  
  public Jar(String itemName, int numberOfItems) {
   this.itemName = itemName;
   this.numberOfItems = numberOfItems;
  }
  
  public int fillJar() {
   Random random = new Random();
   actualNumber = random.nextInt(numberOfItems) + 1;
   return actualNumber;
  }
  
  public int hasWon(int guess) {
    return actualNumber - guess;
  }
  
}