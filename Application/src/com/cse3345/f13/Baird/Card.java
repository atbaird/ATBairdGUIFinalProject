package com.cse3345.f13.Baird;

import android.content.Context;
import android.graphics.drawable.Drawable;

//Card Class
//individual values for cards and so on.
public class Card {
	private int suit;
	private int num;
	public boolean swapped;
	public Context myContext;
	//clas = {0, 1, 2, 3} = {spades, clubs, diamonds, hearts}
	//num = {0,1,2,3,4,5,6,7,8,9,10,11,12} = {A, 2,3,4,5,6,7,8,9,10,J,Q,K}
	public Card(int a, int b, Context c) {
		suit = a;
		num = b;
		swapped = false;
		myContext = c;
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
		Drawable draw = myContext.getResources().getDrawable(R.drawable.no_card);
		switch(suit) {
		case 0:
			//spades
			switch(num) {
			case 0:
				draw = myContext.getResources().getDrawable(R.drawable.ace_spades);
				break;
			case 1:
				draw = myContext.getResources().getDrawable(R.drawable.two_spades);
				break;
			case 2:
				draw = myContext.getResources().getDrawable(R.drawable.three_spades);
				break;
			case 3:
				draw = myContext.getResources().getDrawable(R.drawable.four_spades);
				break;
			case 4:
				draw = myContext.getResources().getDrawable(R.drawable.five_spades);
				break;
			case 5:
				draw = myContext.getResources().getDrawable(R.drawable.six_spades);
				break;
			case 6:
				draw = myContext.getResources().getDrawable(R.drawable.seven_spades);
				break;
			case 7:
				draw = myContext.getResources().getDrawable(R.drawable.eight_spades);
				break;
			case 8:
				draw = myContext.getResources().getDrawable(R.drawable.nine_spades);
				break;
			case 9:
				draw = myContext.getResources().getDrawable(R.drawable.ten_spades);
				break;
			case 10:
				draw = myContext.getResources().getDrawable(R.drawable.jack_spades);
				break;
			case 11:
				draw = myContext.getResources().getDrawable(R.drawable.queen_spades);
				break;
			case 12:
				draw = myContext.getResources().getDrawable(R.drawable.king_spades);
				break;
			}
			break;
		case 1:
			//Clubs
			switch(num) {
			case 0:
				draw = myContext.getResources().getDrawable(R.drawable.ace_clubs);
				break;
			case 1:
				draw = myContext.getResources().getDrawable(R.drawable.two_clubs);
				break;
			case 2:
				draw = myContext.getResources().getDrawable(R.drawable.three_clubs);
				break;
			case 3:
				draw = myContext.getResources().getDrawable(R.drawable.four_clubs);
				break;
			case 4:
				draw = myContext.getResources().getDrawable(R.drawable.five_clubs);
				break;
			case 5:
				draw = myContext.getResources().getDrawable(R.drawable.six_clubs);
				break;
			case 6:
				draw = myContext.getResources().getDrawable(R.drawable.seven_clubs);
				break;
			case 7:
				draw = myContext.getResources().getDrawable(R.drawable.eight_clubs);
				break;
			case 8:
				draw = myContext.getResources().getDrawable(R.drawable.nine_clubs);
				break;
			case 9:
				draw = myContext.getResources().getDrawable(R.drawable.ten_clubs);
				break;
			case 10:
				draw = myContext.getResources().getDrawable(R.drawable.jack_clubs);
				break;
			case 11:
				draw = myContext.getResources().getDrawable(R.drawable.queen_clubs);
				break;
			case 12:
				draw = myContext.getResources().getDrawable(R.drawable.king_clubs);
				break;
			}
			break;
		case 2:
			//Diamonds
			switch(num) {
			case 0:
				draw = myContext.getResources().getDrawable(R.drawable.ace_diamonds);
				break;
			case 1:
				draw = myContext.getResources().getDrawable(R.drawable.two_diamonds);
				break;
			case 2:
				draw = myContext.getResources().getDrawable(R.drawable.three_diamonds);
				break;
			case 3:
				draw = myContext.getResources().getDrawable(R.drawable.four_diamonds);
				break;
			case 4:
				draw = myContext.getResources().getDrawable(R.drawable.five_diamonds);
				break;
			case 5:
				draw = myContext.getResources().getDrawable(R.drawable.six_diamonds);
				break;
			case 6:
				draw = myContext.getResources().getDrawable(R.drawable.seven_diamonds);
				break;
			case 7:
				draw = myContext.getResources().getDrawable(R.drawable.eight_diamonds);
				break;
			case 8:
				draw = myContext.getResources().getDrawable(R.drawable.nine_diamonds);
				break;
			case 9:
				draw = myContext.getResources().getDrawable(R.drawable.ten_diamonds);
				break;
			case 10:
				draw = myContext.getResources().getDrawable(R.drawable.jack_diamonds);
				break;
			case 11:
				draw = myContext.getResources().getDrawable(R.drawable.queen_diamonds);
				break;
			case 12:
				draw = myContext.getResources().getDrawable(R.drawable.king_diamonds);
				break;
			}
			break;
		case 3:
			//Hearts
			switch(num) {
			case 0:
				draw = myContext.getResources().getDrawable(R.drawable.ace_hearts);
				break;
			case 1:
				draw = myContext.getResources().getDrawable(R.drawable.two_hearts);
				break;
			case 2:
				draw = myContext.getResources().getDrawable(R.drawable.three_hearts);
				break;
			case 3:
				draw = myContext.getResources().getDrawable(R.drawable.four_hearts);
				break;
			case 4:
				draw = myContext.getResources().getDrawable(R.drawable.five_hearts);
				break;
			case 5:
				draw = myContext.getResources().getDrawable(R.drawable.six_hearts);
				break;
			case 6:
				draw = myContext.getResources().getDrawable(R.drawable.seven_hearts);
				break;
			case 7:
				draw = myContext.getResources().getDrawable(R.drawable.eight_hearts);
				break;
			case 8:
				draw = myContext.getResources().getDrawable(R.drawable.nine_hearts);
				break;
			case 9:
				draw = myContext.getResources().getDrawable(R.drawable.ten_hearts);
				break;
			case 10:
				draw = myContext.getResources().getDrawable(R.drawable.jack_hearts);
				break;
			case 11:
				draw = myContext.getResources().getDrawable(R.drawable.queen_hearts);
				break;
			case 12:
				draw = myContext.getResources().getDrawable(R.drawable.king_hearts);
				break;
			}
			break;
		}
	return draw;
	}
}