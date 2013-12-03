package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	//Card Class
	//individual values for cards and so on.
	public class Card {
		private int suit;
		private int num;
		public boolean swapped;
		//clas = {0, 1, 2, 3} = {spades, clubs, diamonds, hearts}
		//num = {0,1,2,3,4,5,6,7,8,9,10,11,12} = {A, 2,3,4,5,6,7,8,9,10,J,Q,K}
		public Card(int a, int b) {
			suit = a;
			num = b;
			swapped = false;
		}
		public void setSwapped(boolean a) {
			swapped = a;
		}
		public boolean getSwapped() {
			return swapped;
		}
		public int getSuit() {
			return suit;
		}
		public int getNumber() {
			return num;
		}
		public Drawable determineDrawable() {
			//This method will return a drawable with the correct card to show.
			Drawable draw = getResources().getDrawable(R.drawable.no_card);
			switch(suit) {
			case 0:
				//spades
				switch(num) {
				case 0:
					draw = getResources().getDrawable(R.drawable.ace_spades);
					break;
				case 1:
					draw = getResources().getDrawable(R.drawable.two_spades);
					break;
				case 2:
					draw = getResources().getDrawable(R.drawable.three_spades);
					break;
				case 3:
					draw = getResources().getDrawable(R.drawable.four_spades);
					break;
				case 4:
					draw = getResources().getDrawable(R.drawable.five_spades);
					break;
				case 5:
					draw = getResources().getDrawable(R.drawable.six_spades);
					break;
				case 6:
					draw = getResources().getDrawable(R.drawable.seven_spades);
					break;
				case 7:
					draw = getResources().getDrawable(R.drawable.eight_spades);
					break;
				case 8:
					draw = getResources().getDrawable(R.drawable.nine_spades);
					break;
				case 9:
					draw = getResources().getDrawable(R.drawable.ten_spades);
					break;
				case 10:
					draw = getResources().getDrawable(R.drawable.jack_spades);
					break;
				case 11:
					draw = getResources().getDrawable(R.drawable.queen_spades);
					break;
				case 12:
					draw = getResources().getDrawable(R.drawable.king_spades);
					break;
				}
				break;
			case 1:
				//Clubs
				switch(num) {
				case 0:
					draw = getResources().getDrawable(R.drawable.ace_clubs);
					break;
				case 1:
					draw = getResources().getDrawable(R.drawable.two_clubs);
					break;
				case 2:
					draw = getResources().getDrawable(R.drawable.three_clubs);
					break;
				case 3:
					draw = getResources().getDrawable(R.drawable.four_clubs);
					break;
				case 4:
					draw = getResources().getDrawable(R.drawable.five_clubs);
					break;
				case 5:
					draw = getResources().getDrawable(R.drawable.six_clubs);
					break;
				case 6:
					draw = getResources().getDrawable(R.drawable.seven_clubs);
					break;
				case 7:
					draw = getResources().getDrawable(R.drawable.eight_clubs);
					break;
				case 8:
					draw = getResources().getDrawable(R.drawable.nine_clubs);
					break;
				case 9:
					draw = getResources().getDrawable(R.drawable.ten_clubs);
					break;
				case 10:
					draw = getResources().getDrawable(R.drawable.jack_clubs);
					break;
				case 11:
					draw = getResources().getDrawable(R.drawable.queen_clubs);
					break;
				case 12:
					draw = getResources().getDrawable(R.drawable.king_clubs);
					break;
				}
				break;
			case 2:
				//Diamonds
				switch(num) {
				case 0:
					draw = getResources().getDrawable(R.drawable.ace_diamonds);
					break;
				case 1:
					draw = getResources().getDrawable(R.drawable.two_diamonds);
					break;
				case 2:
					draw = getResources().getDrawable(R.drawable.three_diamonds);
					break;
				case 3:
					draw = getResources().getDrawable(R.drawable.four_diamonds);
					break;
				case 4:
					draw = getResources().getDrawable(R.drawable.five_diamonds);
					break;
				case 5:
					draw = getResources().getDrawable(R.drawable.six_diamonds);
					break;
				case 6:
					draw = getResources().getDrawable(R.drawable.seven_diamonds);
					break;
				case 7:
					draw = getResources().getDrawable(R.drawable.eight_diamonds);
					break;
				case 8:
					draw = getResources().getDrawable(R.drawable.nine_diamonds);
					break;
				case 9:
					draw = getResources().getDrawable(R.drawable.ten_diamonds);
					break;
				case 10:
					draw = getResources().getDrawable(R.drawable.jack_diamonds);
					break;
				case 11:
					draw = getResources().getDrawable(R.drawable.queen_diamonds);
					break;
				case 12:
					draw = getResources().getDrawable(R.drawable.king_diamonds);
					break;
				}
				break;
			case 3:
				//Hearts
				switch(num) {
				case 0:
					draw = getResources().getDrawable(R.drawable.ace_hearts);
					break;
				case 1:
					draw = getResources().getDrawable(R.drawable.two_hearts);
					break;
				case 2:
					draw = getResources().getDrawable(R.drawable.three_hearts);
					break;
				case 3:
					draw = getResources().getDrawable(R.drawable.four_hearts);
					break;
				case 4:
					draw = getResources().getDrawable(R.drawable.five_hearts);
					break;
				case 5:
					draw = getResources().getDrawable(R.drawable.six_hearts);
					break;
				case 6:
					draw = getResources().getDrawable(R.drawable.seven_hearts);
					break;
				case 7:
					draw = getResources().getDrawable(R.drawable.eight_hearts);
					break;
				case 8:
					draw = getResources().getDrawable(R.drawable.nine_hearts);
					break;
				case 9:
					draw = getResources().getDrawable(R.drawable.ten_hearts);
					break;
				case 10:
					draw = getResources().getDrawable(R.drawable.jack_hearts);
					break;
				case 11:
					draw = getResources().getDrawable(R.drawable.queen_hearts);
					break;
				case 12:
					draw = getResources().getDrawable(R.drawable.king_hearts);
					break;
				}
				break;
			}
		return draw;
	}
	
	
	//Deck Class
	public class Deck {
		public int totalNumOfCards;
		public Card[] cards;
		
		public Deck() {
			totalNumOfCards = 52;
			cards = new Card[totalNumOfCards];
			for(int i = 0; i < 13; i++)
			{ //num = i, suit = j;
				for(int j = 0; j < 4; j++) {
					Card temp = new Card(j, i);
					cards[i+ j] = temp;
				}
			}
			shuffle();
		}
		
		public void shuffle() {
			//shuffle should swap each card once, randomly taking another card ahead of current position.
			//this method is repeatable as well, so no worries on if you want to start a new game or instantly reshuffle.
			for(int i = 0; i < totalNumOfCards; i++) {
				cards[i].setSwapped(false);
			}
			for(int k = 0; k < totalNumOfCards; k++) {
				Card temp = cards[k];
				if(temp.getSwapped() == false) {
					boolean swappedOnce = false;
					while(swappedOnce == false)
					{
						int ran = (int)Math.random()*(totalNumOfCards - k);
						int rand = ran + k;
						if(cards[rand].getSwapped() == false ) {
							swappedOnce = true;
							cards[k].setSwapped(true);
							cards[rand].setSwapped(true);
							cards[k] = cards[rand];
							cards[rand] = temp;
							
						}
					}
				}
			}
		}
		
		public Card[] getDeck() {
			return cards;
		}
	}
	
	
	//Stack Class
	//should be used for the regular place holder spots.
	public class Stack {
		public ArrayList<Card> cardStack;
		ImageView stack;
		boolean isSuitStack;
		public Stack(Card[] a, ImageView b, boolean c) {
			for(int i = 0; i < a.length; i++) {
				cardStack.add(a[i]);
			}
			stack = b;
			isSuitStack = c;
		}
		public void addCard(Card b) {
			cardStack.add(b);
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
		}
		public Card removeTopCard() {
			Card b = cardStack.get(cardStack.size() - 1);
			cardStack.remove(cardStack.size()-1);
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
			return b;
		}
		public Card getTopCard() {
			return cardStack.get(cardStack.size() - 1);
		}
	}
	
	//for the extra cards you can pull from.
	public class drawDeck {
		public ArrayList<Card> popMe; //face down cards
		public ArrayList<Card> holder; //face up cards
		ImageView backCards;
		ImageView frontCards;
		public drawDeck(Card[] a, ImageView b, ImageView c) {
			for(int i = 0; i < a.length; i++) {
				popMe.add(a[i]);
			}
			backCards = b;
			backCards.setImageResource(R.drawable.card_back);
			frontCards = c;
			c.setImageResource(R.drawable.no_card);
		}
		public void drawThree() {
			if(popMe.size() == 0) {
				moveBackToDeck();
			} else {
				int size = 3;
				if(popMe.size() < 3) {
					size = popMe.size();
				}
				int a = 0;
				int b = 0;
				for(int i = popMe.size() - 1-size; i < popMe.size(); i++) {
					if(a == 0) {
						b = i;
					}
					holder.add(popMe.get(i));
					popMe.remove(b);
					a++;
				}
				if(popMe.size() == 0) {
					backCards.setImageResource(R.drawable.no_card);
				}
				
			}
		}
		public void moveBackToDeck() {
			for(int j = 0; j < holder.size(); j++) {
				popMe.add(holder.get(0));
				holder.remove(0);
			}
			
		}
	}
	}
}
