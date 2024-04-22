# Description of Blackjack:
Blackjack is a card game played against a casino dealer. The game's object is to collect cards in your hand whose total is as high as possible without going over 21. If the cards you hold beat the dealer's, you win!
How Blackjack is played:
The player and the dealer receive two cards. The player then counts the total points in their hand and decides to hit (take another card) or stand (accept no more cards). If you go over 21, you "bust" (lose).
The player wins if they do not "bust" and their total points are higher than the dealer's.
Blackjack card values:
•
Face cards count as 10.
•
Aces count as either 1 or 11 - i.e., count as 11 as long the value does not exceed 21.
•
All other cards count as their numeric value.
# Player Actions:
•
Hit Deals another card to the player's hand.
•
Stand Indicates that the player does not want more cards and ends her turn.
# Instructions:
•
a Deck class that stores all cards in a deck in an ArrayList. This class also includes a shuffle and drawCard method.
•
a Card class that will store and return the rank and suit of the cards.
•
a Hand class to add the cards to the player's or dealer's hand. This class will include a method that calculates the points of the hand and a method to display the cards.
•
a BlackjackGame class that simulates the game by creating methods to deal the cards to the player and the dealer, allowing players to hit or stand and determine and output the winner.
