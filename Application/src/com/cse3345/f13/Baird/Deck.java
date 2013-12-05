package com.cse3345.f13.Baird;

import android.content.Context;

//Deck Class
public class Deck {
	public int totalNumOfCards;
	public Card[] cards;
	public Context myContext;
	
	public Deck(int a, Context b) {
		myContext = b;
		totalNumOfCards = a;
		cards = new Card[totalNumOfCards];
		for(int i = 0; i < 13; i++)
		{ //num = i, suit = j;
			for(int j = 0; j < 4; j++) {
				Card temp = new Card(j, i, b);
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