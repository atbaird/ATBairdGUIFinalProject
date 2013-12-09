package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//for the extra cards you can pull from.
public class DrawDeck {
	public ArrayList<Card> popMe; //face down cards
	public ArrayList<Card> holder; //face up cards
	ImageView backCards;
	ImageView frontCards;
	Context myContext;
	ImageView dragger;
	public DrawDeck(ArrayList<Card> a, ImageView b, ImageView c, Context d, ImageView e) {
		popMe = a;
		holder = new ArrayList<Card>();
		myContext = d;
		backCards = b;
		backCards.setImageResource(R.drawable.card_back);
		frontCards = c;
		frontCards.setImageResource(R.drawable.no_card);
		dragger = e;
	}
	public void drawThree() {
		int sizePop = popMe.size();
		//
		if(sizePop == 0) {
			moveBackToDeck();
		} else if(sizePop == 1) {
			holder.add(popMe.get(0));
			popMe.remove(0);
		}else if(sizePop == 2) {
			for(int i = popMe.size() -1; i > sizePop-3; i--) {
				holder.add(popMe.get(i));
				popMe.remove(i);
			}
		} else{
			for(int i = popMe.size() -1; i > sizePop- 4; i--) {
				holder.add(popMe.get(i));
				popMe.remove(i);
			}
		}
		
		if(popMe.size() == 0) {
			backCards.setImageResource(R.drawable.no_card);
		} else {
			backCards.setImageResource(R.drawable.card_back);
		}
		if(holder.size() == 0) {
			frontCards.setImageResource(R.drawable.no_card);
		} else {
			frontCards.setImageDrawable(holder.get(holder.size()-1).determineDrawable());
		}
	}
	public void moveBackToDeck() {
		if(holder.size() > 0) {
			while(holder.size() > 0) {
				popMe.add(holder.get(holder.size() -1));
				holder.remove(holder.size() -1);
			}
		}
	}
	public int getCurrentSizeOne() {
		return popMe.size();
	}
	public int getCurrentSizeTwo() {
		return holder.size();
	}
	public void returnCardToDeck(Card a) {
		holder.add(a);
		frontCards.setImageDrawable(holder.get(holder.size() -1).determineDrawable());
	}
	public Card getTopCard() {
		if(holder.size() > 0) {
			Card temp = holder.get(holder.size() -1);
			return temp;
		}
		return null;
	}
	public Card removeTopCard() {
		if(holder.size() > 0) {
			Card temp = holder.get(holder.size() -1);
			holder.remove(holder.size() -1);
			if(holder.size() > 0) {
				frontCards.setImageDrawable(holder.get(holder.size()-1).determineDrawable());
			} else {
				frontCards.setImageResource(R.drawable.no_card);
			}
			return temp;
		}
		return null;
	}
	
	public ArrayList<Card> getPopMe() {
		return popMe;
	}
	public ArrayList<Card> getHolder() {
		return holder;
	}
}