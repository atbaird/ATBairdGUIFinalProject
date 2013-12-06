package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	public Stack stackOne, stackTwo, stackThree, stackFour, stackFive, stackSix, stackSeven;
	public Stack stackHearts, stackDiamonds, stackClubs, stackSpades;
	public DrawDeck clickDeck;
	public Deck deck;
	public int index = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Context me = getApplicationContext();
		deck = new Deck(me);
		ArrayList<Card> cards = deck.getDeck();
		ArrayList<Card> cardsOne = new ArrayList<Card>();
		ArrayList<Card> cardsTwo = new ArrayList<Card>();
		ArrayList<Card> cardsThree = new ArrayList<Card>();
		ArrayList<Card> cardsFour = new ArrayList<Card>();
		ArrayList<Card> cardsFive = new ArrayList<Card>();
		ArrayList<Card> cardsSix = new ArrayList<Card>();
		ArrayList<Card> cardsSeven = new ArrayList<Card>();
		ArrayList<Card> cardsRest = new ArrayList<Card>();
		for(int i = 0; i < cards.size(); i++) {
			Card temp = cards.get(i);
			if(cardsOne.size() < 1) {
				cardsOne.add(temp);
			} else if(cardsTwo.size() < 2) {
				cardsTwo.add(temp);
			} else if(cardsThree.size() < 3) {
				cardsThree.add(temp);
			} else if(cardsFour.size() < 4) {
				cardsFour.add(temp);
			} else if(cardsFive.size() < 5) {
				cardsFive.add(temp);
			} else if(cardsSix.size() < 6) {
				cardsSix.add(temp);
			} else if(cardsSeven.size() < 7) {
				cardsSeven.add(temp);
			} else {
				cardsRest.add(temp);
			}
		}
		ImageView imageStackOne = (ImageView)findViewById(R.id.stackOne);
		ImageView imageStackTwo = (ImageView)findViewById(R.id.stackTwo);
		ImageView imageStackThree = (ImageView)findViewById(R.id.stackThree);
		ImageView imageStackFour = (ImageView)findViewById(R.id.stackFour);
		ImageView imageStackFive = (ImageView)findViewById(R.id.stackFive);
		ImageView imageStackSix = (ImageView)findViewById(R.id.stackSix);
		ImageView imageStackSeven = (ImageView)findViewById(R.id.stackSeven);
		
		stackOne = new Stack(cardsOne, imageStackOne, false);
		stackTwo = new Stack(cardsTwo, imageStackTwo, false);
		stackThree = new Stack(cardsThree, imageStackThree, false);
		stackFour = new Stack(cardsFour, imageStackFour, false);
		stackFive = new Stack(cardsFive, imageStackFive, false);
		stackSix = new Stack(cardsSix, imageStackSix, false);
		stackSeven = new Stack(cardsSeven, imageStackSeven, false);
		
		ImageView imageDrawDeck = (ImageView)findViewById(R.id.leftOverDeck);
		ImageView imageDrawDeckTwo = (ImageView)findViewById(R.id.showOverDeck);
		clickDeck = new DrawDeck(cardsRest, imageDrawDeck, imageDrawDeckTwo, me);
		
		imageDrawDeck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int one = clickDeck.getCurrentSizeOne();
				int two = clickDeck.getCurrentSizeTwo();
				if(one != 0 || two != 0) {
					clickDeck.drawThree();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
