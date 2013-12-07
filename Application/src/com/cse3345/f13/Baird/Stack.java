package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

//Stack Class
//should be used for the regular place holder spots.
public class Stack {
	public ArrayList<Card> cardStack;
	ImageView stack;
	boolean isSuitStack;
	ImageView dragger;
	public Stack(ArrayList<Card> a, ImageView b, boolean c, ImageView d) {
		cardStack = a;
		stack = b;
		isSuitStack = c;
		dragger = d;
		if(cardStack.size() > 0) {
			stack.setImageDrawable(cardStack.get(cardStack.size()-1).determineDrawable());
		} else if(cardStack.size() == 0 && isSuitStack == false){
			stack.setImageResource(R.drawable.no_card);
		}
		
		/*stack.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View view, MotionEvent motionEvent) {
				if(dragger.getId() == ((ImageView)view).getId()) {
					if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
						if(cardStack.size() > 1) {
							dragger.setImageDrawable(stack.getDrawable());
							ClipData data = ClipData.newPlainText("", "");
							DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(dragger);
							Card temp = cardStack.get(cardStack.size() -1);
							((ImageView)view).setImageDrawable(cardStack.get(cardStack.size()-2).determineDrawable());
							view.startDrag(data, shadowBuilder, dragger, 0);
						
							return true;
						} else if(cardStack.size() == 1) {
							dragger.setImageDrawable(stack.getDrawable());
							Card temp = cardStack.get(cardStack.size() -1);
							((ImageView)view).setImageResource(R.drawable.no_card);
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		});*/
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