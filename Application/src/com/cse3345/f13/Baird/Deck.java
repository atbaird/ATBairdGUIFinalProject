package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

//Deck Class
public class Deck {
	public int totalNumOfCards;
	public ArrayList<Card> cards;
	public Context myContext;
	
	public Deck(Context b) {
		myContext = b;
		totalNumOfCards = 52;
		cards = new ArrayList<Card>();
		for(int i = 0; i < 13; i++)
		{ //num = i, suit = j;
			for(int j = 0; j < 4; j++) {
				Card temp = new Card(j, i, myContext);
				cards.add(temp);
			}
		}
		shuffle();
	}
	
	public void shuffle() {
		//shuffle should swap each card once, randomly taking another card ahead of current position.
		//this method is repeatable as well, so no worries on if you want to start a new game or instantly reshuffle.
		for(int i = 0; i < totalNumOfCards; i++) {
			cards.get(i).setSwapped(false);
		}
		for(int k = 0; k < totalNumOfCards; k++) {
			Card temp = cards.get(k);
			if(temp.getSwapped() == false) {
				boolean swappedOnce = false;
				while(swappedOnce == false)
				{
					int ran = (int)(Math.random()*(totalNumOfCards-k));
					int rand = ran + k;
					if(rand < 52 && cards.get(rand).getSwapped() == false ) {
						swappedOnce = true;
						Card temp1 = cards.get(k);
						temp1.setSwapped(true);
						Card temp2 = cards.get(rand);
						temp2.setSwapped(true);
						cards.set(k, temp2);
						cards.set(rand, temp1);
						
					}
				}
			}
		}
		for(int i = 0; i < totalNumOfCards; i++) {
			//the swapped feature will work for both shuffling and determining score.
			cards.get(i).setSwapped(false);
		}
	}

	public void restoreDeck(ArrayList<Card> a) {
		cards = a;
	}
	
	public ArrayList<Card> getDeck() {
		return cards;
	}
	public Card getCardAt(int i) {
		return cards.get(i);
	}
}