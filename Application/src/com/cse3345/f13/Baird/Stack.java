package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.widget.ImageView;

//Stack Class
//should be used for the regular place holder spots.
public class Stack {
	public ArrayList<Card> cardStack;
	ImageView stack;
	boolean isSuitStack;
	int suit;
	public Stack(ArrayList<Card> a, ImageView b, boolean c, int e) {
		cardStack = a;
		stack = b;
		isSuitStack = c;
		suit = e;
		if(cardStack.size() > 0) {
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
		} else if(cardStack.size() == 0 && isSuitStack == false){
			stack.setImageResource(R.drawable.no_card);
		}
	}
	public int getStackSuit() {
		return suit;
	}
	public void restoreStack(ArrayList<Card> a) {
		cardStack = a;
		if(cardStack.size() > 0) {
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
			
		}else if(isSuitStack == false) {
			stack.setImageResource(R.drawable.no_card);
		} else {
			switch(suit) {
			case 0:
				stack.setImageResource(R.drawable.no_card_spade);
				break;
			case 1:
				stack.setImageResource(R.drawable.no_card_club);
				break;
			case 2:
				stack.setImageResource(R.drawable.no_card_diamond);
				break;
			case 3:
				stack.setImageResource(R.drawable.no_card_heart);
				break;
			}
		}
	}
	public void addCard(Card b) {
		cardStack.add(b);
		stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
	}
	public boolean addCardSorted(Card b, int ret, int ind) {
		if(isSuitStack == false) {
			if(ret == ind) {
				addCard(b);
				return true;
			} else {
				Card myCard = getTopCard();
				int suit1 = b.getSuit();
				int num1 = b.getNumber();
				if(myCard != null) {
					int suit2 = myCard.getSuit();
					int num2 = myCard.getNumber();
					if(suit1 == 0 || suit1 == 1) {
						if(suit2 == 2 || suit2 == 3) {
							if(num2 == num1 + 1) {
								addCard(b);
								return true;
							}
						}
					} else {
						if(suit2 == 0 || suit2 == 1) {
							if(num2 == num1 + 1) {
								addCard(b);
								return true;
							}
						}
					}
				} else {
					if(num1 == 12) {
						addCard(b);
						return true;
					}
				}
			}
		} else {
			if(ret == ind) {
				addCard(b);
				return true;
			} else {
				Card myCard = getTopCard();
				int suit1 = b.getSuit();
				int num1 = b.getNumber();
				if(myCard != null)
				{
					int suit2 = myCard.getSuit();
					int num2 = myCard.getNumber();
					if(suit1 == suit2 && num1 == num2 +1) {
						addCard(b);
						return true;
					}
				} else {
					if(suit1 == suit && num1 == 0) {
						addCard(b);
						return true;
					}
				}
			}
		}
		return false;
	}
	public Card removeTopCard() {
		if(cardStack.size() > 0) {
			Card temp = cardStack.get(cardStack.size() -1);
			cardStack.remove(cardStack.size() -1);
			if(cardStack.size() > 0) {
				stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
			} else if(isSuitStack == false){
				stack.setImageResource(R.drawable.no_card);
			} else {
				switch(suit) {
					case 0:
						stack.setImageResource(R.drawable.no_card_spade);
						break;
					case 1:
						stack.setImageResource(R.drawable.no_card_club);
						break;
					case 2:
						stack.setImageResource(R.drawable.no_card_diamond);
						break;
					case 3:
						stack.setImageResource(R.drawable.no_card_heart);
						break;
				}
			}
			return temp;
		}
		return null;
	}
	
	public Card getTopCard() {
		if(cardStack.size() > 0) {
			Card temp = cardStack.get(cardStack.size() -1);
			return temp;
		}
		return null;
	}
	public ArrayList<Card> getStack() {
		return cardStack;
	}
}