import java.util.ArrayList;
import java.util.Collections;
// Represents a playing card
class Card {
private final String rank;
private final String suit;
public Card(String rank, String suit) {
this.rank = rank;
this.suit = suit;
}
public String getRank() {
return rank;
}
public String getSuit() {
return suit;
}
}
// Represents a deck of cards
class Deck {
private final ArrayList<Card> cards;
public Deck() {
cards = new ArrayList<>();
initializeDeck();
}
private void initializeDeck() {
String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
for (String suit : suits) {
for (String rank : ranks) {
cards.add(new Card(rank, suit));
}
}
}
public void shuffle() {
Collections.shuffle(cards);
}
public Card drawCard() {
if (cards.isEmpty()) {
throw new IllegalStateException("Deck is empty");
}
return cards.remove(0);
}
}
// Represents a hand of cards
class Hand {
private final ArrayList<Card> cards;
public Hand() {
cards = new ArrayList<>();
}
public void addCard(Card card) {
cards.add(card);
}
public int calculatePoints() {
int points = 0;
int aceCount = 0;
for (Card card : cards) {
String rank = card.getRank();
if (rank.equals("A")) {
aceCount++;
points += 11;
} else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
points += 10;
} else {
points += Integer.parseInt(rank);
}
}
// Adjust points if there are aces
while (points > 21 && aceCount > 0) {
points -= 10;
aceCount--;
}
return points;
}
public void displayCards() {
for (Card card : cards) {
System.out.println(card.getRank() + " of " + card.getSuit());
}
}
}
// Represents a Blackjack game
class BlackjackGame {
private final Deck deck;
private final Hand playerHand;
private final Hand dealerHand;
public BlackjackGame() {
deck = new Deck();
deck.shuffle();
playerHand = new Hand();
dealerHand = new Hand();
}
public void dealInitialCards() {
playerHand.addCard(deck.drawCard());
dealerHand.addCard(deck.drawCard());

playerHand.addCard(deck.drawCard());
dealerHand.addCard(deck.drawCard());
}
public void playerHit() {
playerHand.addCard(deck.drawCard());
}
public int getPlayerPoints() {
return playerHand.calculatePoints();
}
public int getDealerPoints() {
return dealerHand.calculatePoints();
}
public void displayPlayerCards() {
System.out.println("Player's cards:");
playerHand.displayCards();
}
public void displayDealerCards() {
System.out.println("Dealer's cards:");
dealerHand.displayCards();
}
public void displayWinner() {
int playerPoints = getPlayerPoints();
int dealerPoints = getDealerPoints();

if (playerPoints > 21) {
System.out.println("Player busts! Dealer wins.");
} else if (dealerPoints > 21 || playerPoints > dealerPoints) {
System.out.println("Player wins!");
} else if (playerPoints == dealerPoints) {
System.out.println("It's a tie!");
} else {
System.out.println("Dealer wins!");
}
}
}
// Main class to start the game
public class JAVACards {
public static void main(String[] args) {
BlackjackGame game = new BlackjackGame();
game.dealInitialCards();
System.out.println("Player's hand:");
game.displayPlayerCards();
System.out.println("Player's points: " + game.getPlayerPoints());
System.out.println("\nDealer's hand:");
game.displayDealerCards();
System.out.println("Dealer's points: " + game.getDealerPoints());
// Game logic can be implemented here based on player's decision to hit or stand
game.displayWinner();
}
}