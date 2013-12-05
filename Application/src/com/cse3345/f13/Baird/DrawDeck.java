package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ImageView;

//for the extra cards you can pull from.
public class DrawDeck {
	public ArrayList<Card> popMe; //face down cards
	public ArrayList<Card> holder; //face up cards
	ImageView backCards;
	ImageView frontCards;
	Context myContext;
	public DrawDeck(ArrayList<Card> a, ImageView b, ImageView c, Context d) {
		popMe = a;
		holder = new ArrayList<Card>();
		myContext = d;
		backCards = b;
		backCards.setImageResource(R.drawable.card_back);
		frontCards = c;
		frontCards.setImageResource(R.drawable.no_card);
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
			frontCards.setImageDrawable(holder.get(holder.size()-1).determineDrawable());
		}
	}
	public void moveBackToDeck() {
		for(int j = 0; j < holder.size(); j++) {
			popMe.add(holder.get(0));
			holder.remove(0);
		}
		backCards.setImageResource(R.drawable.card_back);
		frontCards.setImageResource(R.drawable.no_card);
	}
	public int getCurrentSizeOne() {
		return popMe.size();
	}
	public int getCurrentSizeTwo() {
		return holder.size();
	}
}