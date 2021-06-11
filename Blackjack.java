import java.util.Random;
import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        P1Random randGen = new P1Random();
        Scanner scan = new Scanner(System.in);

        int menu = 1;                 //declared all the variables here
        int card;
        int hand = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;
        int totGames = playerWins + dealerWins + ties;
        int gameNum = 1;

        System.out.println("START GAME #" + gameNum);    //first game beginning line

        while (menu != 4)
        {                       //divided into 4 main sections based on menu selection
            if (menu == 1)
            {
                card = randGen.nextInt(13) + 1;

                if (hand < 21)
                {
                    System.out.println("");

                    if (card == 1)
                    {
                        System.out.println("Your card is a ACE!");
                        hand = hand + 1;
                    }
                    else if (card == 11)
                    {
                        System.out.println("Your card is a JACK!");
                        hand = hand + 10;
                    }
                    else if (card == 12)
                    {
                        System.out.println("Your card is a QUEEN!");
                        hand = hand + 10;
                    }
                    else if (card == 13)
                    {
                        System.out.println("Your card is a KING!");
                        hand = hand + 10;
                    }
                    else  //used one statement for all number cards
                    {
                        System.out.println("Your card is a " + card + "!");
                        hand = hand + card;
                    }

                    System.out.println("Your hand is: " + hand);
                    System.out.println("");
                }
                if (hand == 21) //blackjack condition
                {
                    System.out.println("BLACKJACK! You win!");
                    hand = 0;
                    playerWins ++;
                    gameNum ++;
                    totGames ++;
                    System.out.println("");
                    System.out.println("START GAME #" + gameNum);
                    System.out.println("");
                    continue;  //used continue statement to go to top of the loop
                }
                if (hand > 21)  //exceeding condition
                {
                    System.out.println("You exceeded 21! You lose.");
                    hand = 0;
                    dealerWins ++;
                    gameNum ++;
                    totGames ++;
                    System.out.println("");
                    System.out.println("START GAME #" + gameNum);
                    System.out.println("");
                    continue;
                }
                                    //menu goes for all conditions
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                menu = scan.nextInt();
            }

            if (menu == 2)
            {
                int dealersHand = randGen.nextInt(11) + 16;
                System.out.println("");
                System.out.println("Dealer's hand: " + dealersHand);
                System.out.println("Your hand is: " + hand);
                System.out.println("");
                                        //divided into 3 sections based on result
                if (dealersHand > 21 || dealersHand < hand)
                {
                    System.out.println("You win!");
                    playerWins ++;
                }
                if (dealersHand == hand)
                {
                    System.out.println("It's a tie! No one wins!");
                    ties ++;
                }
                if (dealersHand <= 21 && dealersHand > hand)
                {
                    System.out.println("Dealer wins!");
                    dealerWins ++;
                }

                hand = 0;
                gameNum ++;         //keeping score
                totGames ++;
                menu = 1;
                System.out.println("");
                System.out.println("START GAME #" + gameNum);
            }
            if (menu == 3)
            {                               //printing stats
                System.out.println("");
                System.out.println("Number of Player wins: " + playerWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + ties);
                System.out.println("Total # of games played is: " + totGames);
                System.out.println("Percentage of Player wins: " + playerWins * 100.0 / (totGames) + "%");
                System.out.println("");
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                menu = scan.nextInt();
            }
            if (menu != 1 && menu != 2 && menu != 3 && menu != 4)
            {                               //invalid input condition
                System.out.println("");
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("");
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                menu = scan.nextInt();
            }
        }
    }
}
