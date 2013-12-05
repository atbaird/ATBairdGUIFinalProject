package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.widget.ImageView;

//Stack Class
//should be used for the regular place holder spots.
public class Stack {
	public ArrayList<Card> cardStack;
	ImageView stack;
	boolean isSuitStack;
	public Stack(ArrayList<Card> a, ImageView b, boolean c) {
		cardStack = a;
		stack = b;
		isSuitStack = c;
		if(cardStack.size() > 0) {
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
		} else if(cardStack.size() == 0 && isSuitStack == false){
			stack.setImageResource(R.drawable.no_card);
		}
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
		if(cardStack.size() > 1) {
			return cardStack.get(cardStack.size() - 1);
		}
		return null;
	}
	public void verifyCardCanAdd(Card c) {
		//this method will verify that you can add the card, and then if can, will perform the correct operations to do so.
		Card ourTopCard = getTopCard();
		if(isSuitStack == true) {
			if(ourTopCard == null) {
				if(c.getNumber() == 0) {
					
				}
			}
			else if(ourTopCard.getSuit() == c.getSuit()) {
				if(ourTopCard.getNumber() == c.getNumber()-1) {
					
				}
			}
		} else {
			
		}
	}
}