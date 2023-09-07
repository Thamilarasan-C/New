package BlackJack;

import java.util.*;

interface BlackJackInterface {
    public void start();

    public ArrayList<Integer> buildDeck();

    public void shuffle();

    public int draw();

    public boolean playerTurn();

    public boolean dealerTurn();

    public boolean isBust(int sum);
}

public class BlackJack implements BlackJackInterface {
    ArrayList<Integer> deck = buildDeck();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> playerCards = new ArrayList<Integer>();
    ArrayList<Integer> dealerCards = new ArrayList<Integer>();
    int playerSum = 0;
    int dealerSum = 0;
    boolean isPlayerBust = false;
    boolean isDealerBust = false;

    public void start() {
        System.out.println("The game is Started");
        System.out.println(deck);
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
                "\nThe dealer has a " + dealerCards.get(0) + " and a hidden card.\nHis total is hidden");
        boolean playerturn = true;
        boolean dealerturn = true;
        boolean gameOn = true;
        boolean firstTurn = true;
        while (playerturn) {
            playerturn = playerTurn();
        }
        if (isPlayerBust) {
            System.out.println("You Bust");
            System.out.println("DEALER WINS!");
            gameOn = false;
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
        if (isDealerBust) {
            System.out.println("Dealer Bust");
            System.out.println("YOU WIN");
            gameOn = false;
        }
        if (gameOn) {
            if (playerSum > dealerSum) {
                System.out.println("You have more points");
                System.out.println("YOU WIN!!");

            } else {
                System.out.println("Dealer has more points");

                System.out.println("DEALER WINS!!");
            }
        }
        System.out.println("Game Over");
    }

    public ArrayList<Integer> buildDeck() {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 11; j++)
                deck.add(j);
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
        System.out.println(deck);
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
            hit();
            if (isBust(playerSum)) {
                isPlayerBust = true;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isBust(int sum) {
        if (sum >= 21) {
            return true;
        }
        return false;
    }

    public void hit() {
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
        System.out.println("Welcome to blackjack game");
        System.out.println("Enter 'Enter' to Start");
        String str = sc.nextLine();
        game1.start();
    }
}
