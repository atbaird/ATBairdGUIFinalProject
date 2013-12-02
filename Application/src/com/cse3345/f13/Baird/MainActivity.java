package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

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
		private int clas;
		private int num;
		public boolean swapped;
		//clas = {0, 1, 2, 3} = {spades, clubs, diamonds, hearts}
		//num = {0,1,2,3,4,5,6,7,8,9,10,11,12} = {A, 2,3,4,5,6,7,8,9,10,J,Q,K}
		public Card(int a, int b) {
			clas = a;
			num = b;
			swapped = false;
		}
		public void setSwapped(boolean a) {
			swapped = a;
		}
		public boolean getSwapped() {
			return swapped;
		}
		public int getClas() {
			return clas;
		}
		public int getNumber() {
			return num;
		}
		
	}
	
	
	//Deck Class
	public class Deck {
		public int totalNumOfCards;
		public Card[] cards;
		
		public Deck() {
			totalNumOfCards = 52;
			cards = new Card[totalNumOfCards];
			for(int i = 0; i < 13; i++)
			{ //num = i, clas = j;
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
		public Card[] cardStack;
		public Stack() {
			
		}
	}
	
	//for the extra cards you can pull from.
	public class drawDeck {
		public ArrayList<Card> popMe; //face down cards
		public ArrayList<Card> holder; //face up cards
		public drawDeck() {
			
		}
	}
}