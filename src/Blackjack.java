import java.util.Scanner; //importing Scanner

public class Blackjack {
    public static void main(String[] args) {
        P1Random rng = new P1Random(); //random number generator
        Scanner scanner = new Scanner(System.in);
        //naming variables
        int input = 1;
        int wins = 0;
        int dealerWins = 0;
        int ties = 0;
        int numGames = 0;
        double percent;
        boolean game=false;

        while (!game) { //a new game is started when this loops
            int card;
            int hand = 0;
            int dealerHand;
            boolean play=false;
            System.out.println("\nSTART GAME #" + (numGames + 1));
            card = rng.nextInt(13) + 1;
            //prints out the card dealt
            if (card == 1) {
                System.out.println("\nYour card is a ACE!");
                hand += 1;
            } else if (card == 11) {
                System.out.println("\nYour card is a JACK!");
                hand += 10;
            } else if (card == 12) {
                System.out.println("\nYour card is a QUEEN!");
                hand += 10;
            } else if (card == 13) {
                System.out.println("\nYour card is a KING!");
                hand += 10;
            } else {
                System.out.println("\nYour card is a " + card + "!");
                hand += card;
            }
            System.out.println("Your hand is: " + hand);

            while (!play) { //printing out the menu
                System.out.println("\n1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.print("\nChoose an option: ");
                input = scanner.nextInt();

                switch (input) { //prints out the card dealt
                    case 1:
                        card = rng.nextInt(13) + 1;
                        if (card == 1) {
                            System.out.println("\nYour card is a ACE!");
                            hand += 1;
                        } else if (card == 11) {
                            System.out.println("\nYour card is a JACK!");
                            hand += 10;
                        } else if (card == 12) {
                            System.out.println("\nYour card is a QUEEN!");
                            hand += 10;
                        } else if (card == 13) {
                            System.out.println("\nYour card is a KING!");
                            hand += 10;
                        } else {
                            System.out.println("\nYour card is a " + card + "!");
                            hand += card;
                        }
                        System.out.println("Your hand is: " + hand);
                        if (hand > 21) {
                            System.out.println("You exceeded 21! You lose.");
                            dealerWins += 1;
                            play=true;
                        }
                        else if (hand == 21) {
                            System.out.println("BLACKJACK! You win!");
                            wins += 1;
                            play=true;
                        }
                        break;
                    case 2: //holds hand and prints results
                        dealerHand = rng.nextInt(11) + 16;
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        if (dealerHand > 21) {
                            System.out.println("You win!");
                            wins += 1; }
                        else if (dealerHand == hand) {
                            System.out.println("It's a tie! No one wins!");
                            ties += 1; }
                        else if (dealerHand > hand) {
                            System.out.println("Dealer wins!");
                            dealerWins += 1; }
                        else if (hand > dealerHand) {
                            System.out.println("You win!");
                            wins += 1;
                        }
                        play=true;
                        break;
                    case 3: //prints statistics for the game
                        percent = ((double) (wins) / (double) (numGames));
                        percent = Math.round(percent * 100);
                        System.out.println("Number of Player wins: " + wins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + ties);
                        System.out.println("Total # of games played is: " + numGames);
                        System.out.println("Percentage of Player wins: " + percent + "%");
                        break;
                    case 4: //ends the program
                        play=true;
                        game=true;
                        break;
                    default:
                        System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                }
            }
            if (game) {
                break;
            }

            numGames++;
        }
    }
}
