import java.util.Scanner;

class Main {
  private static final double COST = 0.25;
  private static final int TRADECOST = 3;
  
  public static double getMoney() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Each candy costs $" + COST + "\nAnd you may trade " + TRADECOST + " wrappers for a candy.");
    System.out.print("How much money do you want to spend? $");
    double money = scan.nextDouble();
    return money;
  }

  public static int tradeWrappers(int candies) {
    System.out.println("You eat " + candies + " candies.");
    int wrappers = candies - (candies % TRADECOST);
    if(wrappers/TRADECOST < 1)
      return 0;
    candies = wrappers/TRADECOST;
    System.out.println("You trade your wrappers for " + candies + " more candies.");
    return candies + tradeWrappers(candies);
  }

  public static int maxCandies(double money) {
    int candies = (int)(money / COST);
    return candies + tradeWrappers(candies);
  }


  public static void main(String[] args) {
    double money = getMoney();
    int totalCandies = maxCandies(money);
    System.out.println("In total, you ate " + totalCandies + " candies! ¡Que ganga!");
  }
}