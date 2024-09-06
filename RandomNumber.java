import java.util.Scanner;

public class RandomNumber
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int roundsPalyed = 0;
        int score = 0;
        int maxAttempts = 5;
        while(true)
        {
            roundsPalyed++;
            System.out.println("\nRound :-"+roundsPalyed);
            int targertNumber = (int)(Math.random()*100)+1;
            int attempts =0;
            while(attempts<maxAttempts)
            {
                System.out.println("Enter your guess number (1-100)");
                int guess = sc.nextInt();
                attempts++;
                if(guess==targertNumber)
                {
                    System.out.println("You Guessed Correctd Number Congralatuions !!");
                    score++;
                    break;
                }
                else if(guess<targertNumber)
                {
                    System.out.println("Too low Try Again");
                }

                else
                {
                    System.out.println("Too high try Again ");
                }
            }
            if(attempts==maxAttempts)
            {
                System.out.println("Sorry you ran out of attempts");
            }
            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = sc.next();
            if(!playAgain.equalsIgnoreCase("yes"))
            {
                break;
            }
        }
        System.out.println("\n Game Over your final Score is  "+score);
    }
}