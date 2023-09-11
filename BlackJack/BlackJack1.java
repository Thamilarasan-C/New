package BlackJack;

import java.util.*;

interface BlackJackInterface1 {

    public void start();

    public void buildDeck(int n);

    public void shuffle();

    public int draw();

    public boolean playerTurn(ArrayList<Boolean> gameOn);

    public boolean dealerTurn(ArrayList<Boolean> gameOn);

    public void playerhits();

    public boolean isBust(int sum);

}

public class BlackJack1 implements BlackJackInterface1 {
    Player p1;
    Dealer d;
    int winningPoint;
    int numberOfDecks;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    Deck d1;

    public BlackJack1() {
        System.out.println("Welcome to blackjack game");
        getInputs();
    }

    public class Dealer {
        Dealer() {
        }

        int dealerId;
        int dealerSum = 0;
        ArrayList<Integer> dealerCards = new ArrayList<Integer>();

        public boolean dealerTurn(ArrayList<Boolean> gameOn) {
            if (dealerSum >= winningPoint - 5) {
                System.out.println("Dealer stays");
                return false;
            }
            System.out.println("Dealer chooses to hit");
            int card = d1.draw();
            dealerCards.add(card);
            dealerSum += card;
            System.out.println("He draws a " + card + "\nHis total is " + dealerSum);
            if (isBust(dealerSum)) {
                System.out.println("Dealer Bust");
                System.out.println("YOU WIN");
                gameOn.set(0, false);
                return false;
            }
            if (isWin(dealerSum)) {
                System.out.println("Dealer Scored a winning point");
                System.out.println("DEALER WINS!");
                gameOn.set(0, false);
                return false;
            }
            return true;
        }
    }

    public class Player {
        Player() {
        }

        int playerId;
        int playerSum = 0;
        ArrayList<Integer> playerCards = new ArrayList<Integer>();

        public void playerhits() {
            int card = d1.draw();
            playerCards.add(card);
            playerSum += card;
            System.out.println("You drew a " + card);
            System.out.println("Your total is " + playerSum);
        }

        public boolean playerTurn(ArrayList<Boolean> gameOn) {
            System.out.println("Would you like to \"hit\" or \"stay\"");
            System.out.println("Enter h for hit or s for stay");
            char c = sc.next().charAt(0);
            if (c == 'h') {
                playerhits();
                if (isBust(playerSum)) {
                    System.out.println("You Bust");
                    System.out.println("DEALER WINS!");
                    gameOn.set(0, false);
                    return false;
                }
                if (isWin(playerSum)) {
                    System.out.println("You Scored a winning point");
                    System.out.println("YOU WIN!");
                    gameOn.set(0, false);
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    public class Deck {
        int numberOfDecks;
        Random random = new Random();
        ArrayList<Integer> deck = new ArrayList<>();

        Deck(int n) {
            numberOfDecks = n;
            buildDeck();
        }

        public void buildDeck() {
            for (int n = 1; n <= numberOfDecks; n++) {
                for (int i = 1; i <= 4; i++) {
                    for (int j = 2; j <= 11; j++)
                        deck.add(j);
                }
            }
        }

        public void shuffle() {
            for (int currentIndex = 0; currentIndex < deck.size(); currentIndex++) {
                int currentcard = deck.get(currentIndex);
                int randomIndex = random.nextInt(deck.size());
                int randomCard = deck.get(randomIndex);
                deck.set(currentIndex, randomCard);
                deck.set(randomIndex, currentcard);
            }
        }

        public int draw() {
            int randomIndex = random.nextInt(deck.size());
            int randomCard = deck.get(randomIndex);
            deck.remove(randomIndex);
            return randomCard;
        }

    }

    public void getInputs() {
        System.out.println("Enter number of decks needed");
        numberOfDecks = sc.nextInt();
        System.out.println("Enter the winning points");
        winningPoint = sc.nextInt();
        System.out.println(
                "Enter 'Enter' to Start a game with " + numberOfDecks + "decks and winning point " + winningPoint);
        sc.nextLine();
        sc.nextLine();
        start();
    }

    public void start() {

        d1 = new Deck(numberOfDecks);
        System.out.println("The game is Started");

        System.out.println(d1.deck);
        d1.shuffle();

        p1 = new Player();
        d = new Dealer();

        for (int i = 0; i < 2; i++) {

            int cardForPlayer = d1.draw();
            p1.playerCards.add(cardForPlayer);
            p1.playerSum += cardForPlayer;

            int cardForDealer = d1.draw();
            d.dealerCards.add(cardForDealer);
            d.dealerSum += cardForDealer;

        }
        System.out.println("You get a " + p1.playerCards.get(0) + " and " + p1.playerCards.get(1) +
                "\nYour total is " + p1.playerSum +
                "\n\nThe dealer has a " + d.dealerCards.get(0) + " and a hidden card.\nHis total is hidden\n");

        boolean playerturn = true;
        boolean dealerturn = true;
        ArrayList<Boolean> gameOn = new ArrayList<>();
        gameOn.add(true);
        boolean firstTurn = true;

        while (playerturn) {
            playerturn = p1.playerTurn(gameOn);
        }

        while (gameOn.get(0) && dealerturn) {

            if (firstTurn) {
                firstTurn = false;
                System.out.println("Okay Dealers turn.");
                System.out.println("His hidden card was " + d.dealerCards.get(1) +
                        "\nHis total is " + d.dealerSum);
            }
            dealerturn = d.dealerTurn(gameOn);
        }

        if (gameOn.get(0))
            checkWinner(p1, d);
        System.out.println("Game Over");
    }

    public void checkWinner(Player p1, Dealer d1) {

        if (p1.playerSum > d1.dealerSum) {
            System.out.println("You have more points");
            System.out.println("YOU WIN!!");

        } else if (p1.playerSum < d1.dealerSum) {
            System.out.println("Dealer has more points");
            System.out.println("DEALER WINS!!");
        } else
            System.out.println("Both of your points are equal.  TIE!  ");
    }

    public boolean isBust(int sum) {
        if (sum > winningPoint) {
            return true;
        }
        return false;
    }

    public boolean isWin(int sum) {
        if (sum == winningPoint) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BlackJackInterface1 game1 = new BlackJack1();
    }
}
