package BlackJack;

import java.util.*;

interface BlackJackInterface {

    public void start();

    public ArrayList<Integer> buildDeck(int n);

    public void shuffle();

    public int draw();

    public boolean playerTurn();

    public boolean dealerTurn();

    public void playerhits();

    public boolean isBust(int sum);

    public void checkWinner();

}

public class BlackJack implements BlackJackInterface {
    int numberOfDecks;
    int winningPoint;
    ArrayList<Integer> deck = new ArrayList<>();
    ArrayList<Integer> playerCards = new ArrayList<Integer>();
    ArrayList<Integer> dealerCards = new ArrayList<Integer>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    int playerSum = 0;
    int dealerSum = 0;

    boolean gameOn=true;

    boolean isPlayerBust = false;
    boolean isDealerBust = false;

    public BlackJack() {
        System.out.println("Welcome to blackjack game");
        getInputs();
    }

    public void getInputs() {
        System.out.println("Enter number of decks needed");
        numberOfDecks = sc.nextInt();
        deck = buildDeck(numberOfDecks);
        System.out.println("Enter the winning points");
        winningPoint = sc.nextInt();
        System.out.println(
                "Enter 'Enter' to Start a game with " + numberOfDecks + "decks and winning point " + winningPoint);
        sc.nextLine();
        start();
    }

    public void start() {

        System.out.println("The game is Started");
        shuffle();
        for (int i = 0; i < 2; i++) {

            int cardForPlayer = draw();
            playerCards.add(cardForPlayer);
            playerSum += cardForPlayer;

            int cardForDealer = draw();
            dealerCards.add(cardForDealer);
            dealerSum += cardForDealer;

        }
        System.out.println("You get a " + playerCards.get(0) + " and " + playerCards.get(1) +
                "\nYour total is " + playerSum +
                "\n\nThe dealer has a " + dealerCards.get(0) + " and a hidden card.\nHis total is hidden\n");
        boolean playerturn = true;
        boolean dealerturn = true;
        boolean gameOn = true;
        boolean firstTurn = true;
        while (playerturn) {
            playerturn = playerTurn();
        }
        //checkForWin();
        if (isPlayerBust) {
            // System.out.println("You Bust");
            // System.out.println("DEALER WINS!");
            // gameOn = false;
        }
        else if()
        {
            // System.out.println("You have a winning point \nYOU WIN!");
            gameOn= false;
        }
        while (gameOn && dealerturn) {

            if (firstTurn) {
                firstTurn = false;
                System.out.println("Okay Dealers turn.");
                System.out.println("His hidden card was " + dealerCards.get(1) +
                        "\nHis total is " + dealerSum);
            }
            dealerturn = dealerTurn();
        }

        // gameOn=isGameOn();
        if (isDealerBust) {
            System.out.println("Dealer Bust");
            System.out.println("YOU WIN");
            gameOn = false;
        }
        if (gameOn)
        checkWinner();
        System.out.println("Game Over");
    }

    public void checkForWin(){

    }
    
    public void checkWinner() {
        
        if (playerSum > dealerSum) {
            System.out.println("You have more points");
            System.out.println("YOU WIN!!");
            
        } else {
            System.out.println("Dealer has more points");
            System.out.println("DEALER WINS!!");
        }
    }
    
    public ArrayList<Integer> buildDeck(int numberOfDecks) {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int n = 1; n <= numberOfDecks; n++) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 2; j <= 11; j++)
                deck.add(j);
            }
        }
        return deck;
        
    }
    
    public void shuffle() {
        for (int currentIndex = 0; currentIndex < deck.size(); currentIndex++) {
            int currentcard = deck.get(currentIndex);
            int randomIndex = random.nextInt(deck.size());
            int randomCard = deck.get(randomIndex);
            deck.set(currentIndex, randomCard);
            deck.set(randomIndex, currentcard);
        }
        // System.out.println(deck);
    }
    
    public int draw() {
        int randomIndex = random.nextInt(deck.size());
        int randomCard = deck.get(randomIndex);
        deck.remove(randomIndex);
        return randomCard;
    }

    public boolean playerTurn() {
        System.out.println("Would you like to \"hit\" or \"stay\"");
        System.out.println("Enter h for hit or s for stay");
        char c = sc.next().charAt(0);
        if (c == 'h') {
            playerhits();
            if (isBust(playerSum)) {   
                System.out.println("You Bust");
                System.out.println("DEALER WINS!");
                gameOn = false;
                return false;
            }

            if(isWin(playerSum)){
                System.out.println("You have a winning point \nYOU WIN!");
                gameOn = false;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isBust(int sum) {
        if (sum > winningPoint) {
            return true;
        }
        return false;
    }

    public boolean isWin(int sum){
        if(sum==winningPoint){
            return true;
        }
        return false;
    }
    public void playerhits() {
        int card = draw();
        playerCards.add(card);
        playerSum += card;
        System.out.println("You drew a " + card);
        System.out.println("Your total is " + playerSum);
    }

    public boolean dealerTurn() {
        if (dealerSum >= 16) {
            System.out.println("Dealer stays");
            return false;
        }
        System.out.println("Dealer chooses to hit");
        int card = draw();
        dealerCards.add(card);
        dealerSum += card;
        System.out.println("He draws a " + card + "\nHis total is " + dealerSum);
        if (isBust(dealerSum)) {
            isDealerBust = true;
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BlackJackInterface game1 = new BlackJack();
    }
}
