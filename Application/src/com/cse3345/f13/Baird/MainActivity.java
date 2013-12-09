package com.cse3345.f13.Baird;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public Stack stackOne, stackTwo, stackThree, stackFour, stackFive, stackSix, stackSeven;
	public Stack stackHearts, stackDiamonds, stackClubs, stackSpades;
	public DrawDeck clickDeck;
	public Deck deck;
	public int index = 0;
	public Card temp;
	public int returnTo; // 0-6 = stacks one through seven; 7 = clickDeck; 8-11 Suit stacks (spade, club, diamond, heart)
	public boolean checkClick;
	public TextView tempHolder;
	public Context myContext;
	public Drawable draw1;
	static final String value1 = "deckPopMe";
	static final String value2 = "deckHolder";
	static final String value3 = "HeartsStack";
	static final String value4 = "DiamondsStack";
	static final String value5 = "ClubsStack";
	static final String value6 = "SpadesStack";
	static final String value7 = "StackOne";
	static final String value8 = "StackTwo";
	static final String value9 = "StackThree";
	static final String value10 = "StackFour";
	static final String value11 = "StackFive";
	static final String value12 = "StackSix";
	static final String value13 = "StackSeven";
	static final String value14 = "CardHeld";
	static final String value15 = "returnTo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myContext = getBaseContext();
		draw1 = myContext.getResources().getDrawable(R.drawable.no_card);
		temp = null;
		checkClick = false;
		returnTo = 0;
		
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
		
		ImageView tempImage = (ImageView)findViewById(R.id.cardImageHold);
		
		ImageView imageStackOne = (ImageView)findViewById(R.id.stackOne);
		ImageView imageStackTwo = (ImageView)findViewById(R.id.stackTwo);
		ImageView imageStackThree = (ImageView)findViewById(R.id.stackThree);
		ImageView imageStackFour = (ImageView)findViewById(R.id.stackFour);
		ImageView imageStackFive = (ImageView)findViewById(R.id.stackFive);
		ImageView imageStackSix = (ImageView)findViewById(R.id.stackSix);
		ImageView imageStackSeven = (ImageView)findViewById(R.id.stackSeven);
		
		stackOne = new Stack(cardsOne, imageStackOne, false, 0);
		stackTwo = new Stack(cardsTwo, imageStackTwo, false, 0);
		stackThree = new Stack(cardsThree, imageStackThree, false, 0);
		stackFour = new Stack(cardsFour, imageStackFour, false, 0);
		stackFive = new Stack(cardsFive, imageStackFive, false, 0);
		stackSix = new Stack(cardsSix, imageStackSix, false, 0);
		stackSeven = new Stack(cardsSeven, imageStackSeven, false, 0);
		
		ArrayList<Card> spades = new ArrayList<Card>();
		ArrayList<Card> hearts = new ArrayList<Card>();
		ArrayList<Card> diamonds = new ArrayList<Card>();
		ArrayList<Card> clubs = new ArrayList<Card>();
		
		ImageView imageSpade = (ImageView)findViewById(R.id.stackSpades);
		ImageView imageClub = (ImageView)findViewById(R.id.stackClubs);
		ImageView imageDiamond = (ImageView)findViewById(R.id.stackDiamonds);
		ImageView imageHeart = (ImageView)findViewById(R.id.stackHearts);
		
		stackSpades = new Stack(spades, imageSpade, true, 0);
		stackClubs = new Stack(clubs, imageClub, true, 1);
		stackDiamonds = new Stack(diamonds, imageDiamond, true, 2);
		stackHearts = new Stack(hearts, imageHeart, true, 3);
		
		ImageView imageDrawDeck = (ImageView)findViewById(R.id.leftOverDeck);
		ImageView imageDrawDeckTwo = (ImageView)findViewById(R.id.showOverDeck);
		clickDeck = new DrawDeck(cardsRest, imageDrawDeck, imageDrawDeckTwo, me, tempImage);
		
		tempHolder = (TextView)findViewById(R.id.tempHolder);
		
		//Normal Click Listeners
		//Regular Spaces
		imageStackOne.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//stackOne
				if(checkClick == false) {
					temp = stackOne.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 0;
						checkClick = true;
					}
				} else {
					if(returnTo == 0) {
						stackOne.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null,null,null, draw1);
						checkClick = false;
					} else {
						Card temp2 = stackSeven.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackOne.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackOne.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackOne.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
			
		});
		imageStackTwo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackTwo
				if(checkClick == false) {
					temp = stackTwo.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 1;
						checkClick = true;
					}
				} else {
					if(returnTo == 1) {
						stackTwo.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null,null,null,draw1);
						checkClick = false;
					} else {
						Card temp2 = stackTwo.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackTwo.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackTwo.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackTwo.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		imageStackThree.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackThree
				if(checkClick == false) {
					temp = stackThree.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 2;
						checkClick = true;
					}
				} else {
					if(returnTo == 2) {
						stackThree.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null,null,null,draw1);
						checkClick = false;
					} else {
						Card temp2 = stackThree.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackThree.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackThree.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackThree.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		imageStackFour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackFour
				if(checkClick == false) {
					temp = stackFour.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 3;
						checkClick = true;
					}
				} else {
					if(returnTo == 3) {
						stackFour.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null,null,null, draw1);
						checkClick = false;
					} else {
						Card temp2 = stackFour.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackFour.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackFour.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackFour.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		imageStackFive.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackFive
				if(checkClick == false) {
					temp = stackFive.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 4;
						checkClick = true;
					}
				} else {
					if(returnTo == 4) {
						stackFive.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null,null,null, draw1);
						checkClick = false;
					} else {
						Card temp2 = stackFive.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackFive.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackFive.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackFive.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		imageStackSix.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackSix
				if(checkClick == false) {
					temp = stackSix.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 5;
						checkClick = true;
					}
				} else {
					if(returnTo == 5) {
						stackSix.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
					} else {
						Card temp2 = stackSix.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackSix.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackSix.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackSix.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		imageStackSeven.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//stackSeven
				if(checkClick == false) {
					temp = stackSeven.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 6;
						checkClick = true;
					}
				} else {
					if(returnTo == 6) {
						stackSeven.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
					} else {
						Card temp2 = stackSeven.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										stackSeven.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										stackSeven.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawables(null,null,null,draw1);
										checkClick = false;
									}
								}
							}
						} else {
							if(num1 == 12) {
								stackSeven.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
								checkClick = false;
							}
						}
					}
				}
			}
		});
		
		//Deck
		imageDrawDeckTwo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(checkClick == false) {
					temp = clickDeck.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 7;
						checkClick = true;
					}
				} else {
					if(returnTo == 7) {
						clickDeck.returnCardToDeck(temp);
						temp = null;
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
					}
				}
			}
		});
		
		
		imageDrawDeck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int one = clickDeck.getCurrentSizeOne();
				int two = clickDeck.getCurrentSizeTwo();
				if(checkClick == false && (one != 0 || two != 0)) {
					clickDeck.drawThree();
				}
			}
		});
		
		
		//Suit spaces
		imageSpade.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(checkClick == false) {
					temp = stackSpades.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 8;
						checkClick = true;
					}
				} else {
					if(returnTo == 8) {
						stackSpades.addCard(temp);
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
						temp = null;
					} else {
						Card temp2 = stackSpades.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null)
						{
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit1 == suit2 && num1 == num2 +1) {
								stackSpades.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						} else {
							if(suit1 == 0 && num1 == 0) {
								stackSpades.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						}
					}
				}
			}
		});
		
		imageClub.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(checkClick == false) {
					temp = stackClubs.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 9;
						checkClick = true;
					}
				} else {
					if(returnTo == 9) {
						stackClubs.addCard(temp);
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
						temp = null;
					} else {
						Card temp2 = stackClubs.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null)
						{
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit1 == suit2 && num1 == num2 +1) {
								stackClubs.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						} else {
							if(suit1 == 1 && num1 == 0) {
								stackClubs.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						}
					}
				}
			}
		});
		
		imageDiamond.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(checkClick == false) {
					temp = stackDiamonds.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 10;
						checkClick = true;
					}
				} else {
					if(returnTo == 10) {
						stackDiamonds.addCard(temp);
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
						temp = null;
					} else {
						Card temp2 = stackDiamonds.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null)
						{
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit1 == suit2 && num1 == num2 +1) {
								stackDiamonds.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						} else {
							if(suit1 == 2 && num1 == 0) {
								stackDiamonds.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						}
					}
				}
			}
		});
		imageHeart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(checkClick == false) {
					temp = stackHearts.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawables(null, null, null, temp.determineDrawable());
						returnTo = 11;
						checkClick = true;
					}
				} else {
					if(returnTo == 11) {
						stackHearts.addCard(temp);
						tempHolder.setCompoundDrawables(null, null, null, draw1);
						checkClick = false;
						temp = null;
					} else {
						Card temp2 = stackHearts.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null)
						{
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit1 == suit2 && num1 == num2 +1) {
								stackHearts.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						} else {
							if(suit1 == 3 && num1 == 0) {
								stackHearts.addCard(temp);
								temp = null;
								checkClick = false;
								tempHolder.setCompoundDrawables(null,null,null,draw1);
							}
						}
					}
				}
			}
		});
		
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		int[] val1 = savedInstanceState.getIntArray(value1);
		int[] val2 = savedInstanceState.getIntArray(value2);
		int[] val3 = savedInstanceState.getIntArray(value3);
		int[] val4 = savedInstanceState.getIntArray(value4);
		int[] val5 = savedInstanceState.getIntArray(value5);
		int[] val6 = savedInstanceState.getIntArray(value6);
		int[] val7 = savedInstanceState.getIntArray(value7);
		int[] val8 = savedInstanceState.getIntArray(value8);
		int[] val9 = savedInstanceState.getIntArray(value9);
		int[] val10 = savedInstanceState.getIntArray(value10);
		int[] val11 = savedInstanceState.getIntArray(value11);
		int[] val12 = savedInstanceState.getIntArray(value12);
		int[] val13 = savedInstanceState.getIntArray(value13);
		int val14 = savedInstanceState.getInt(value14);
		
		ArrayList<Card> restoreDeck = new ArrayList<Card>();
		
		if(val1.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val1.length; i++) {
				Card c = determineCard(val1[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val2.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val2.length; i++) {
				Card c = determineCard(val2[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val3.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val3.length; i++) {
				Card c = determineCard(val3[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val4.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val4.length; i++) {
				Card c = determineCard(val4[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val5.length >0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val5.length; i++) {
				Card c = determineCard(val5[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val6.length >0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val6.length; i++) {
				Card c = determineCard(val6[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val7.length >0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val7.length; i++) {
				Card c = determineCard(val7[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val8.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val8.length; i++) {
				Card c = determineCard(val8[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val9.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val9.length; i++) {
				Card c = determineCard(val9[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val10.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val10.length; i++) {
				Card c = determineCard(val10[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val11.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val11.length; i++) {
				Card c = determineCard(val11[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val12.length >0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val12.length; i++) {
				Card c = determineCard(val12[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val13.length > 0) {
			ArrayList<Card> stack = new ArrayList<Card>();
			for(int i = 0; i < val13.length; i++) {
				Card c = determineCard(val13[i]);
				stack.add(c);
				restoreDeck.add(c);
			}
		}
		if(val14 != 52) {
			temp = determineCard(val14);
			checkClick = true;
			tempHolder.setCompoundDrawables(null,null,null, temp.determineDrawable());
			returnTo = savedInstanceState.getInt(value15);
			restoreDeck.add(temp);
		} else {
			temp = null;
			checkClick = false;
			tempHolder.setCompoundDrawables(null, null, null, draw1);
			returnTo = 0;
		}
	}

	
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Bundle savedInstance = new Bundle();
		ArrayList<Card> popMe = clickDeck.getPopMe();
		int[] val1 = new int[popMe.size()];
		for(int i = 0; i < popMe.size(); i++) {
			Card cardMe = popMe.get(i);
			int suit = cardMe.getSuit();
			int num = cardMe.getNumber();
			int b = (suit*13) + num;
			val1[i] = b;
		}
		savedInstance.putIntArray(value1, val1);
		
		ArrayList<Card> holder = clickDeck.getHolder();
		int[] val2 = new int[holder.size()];
		for(int i = 0; i < holder.size(); i++) {
			Card cardMe = holder.get(i);
			int suit = cardMe.getSuit();
			int num = cardMe.getNumber();
			int b = (suit*13) + num;
			val2[i] = b;
		}
		savedInstance.putIntArray(value2, val2);
		
		ArrayList<Card> hearts = stackHearts.getStack();
		int[] val3 = new int[hearts.size()];
		for(int i = 0; i < hearts.size(); i++) {
			Card cardMe = hearts.get(i);
			int suit = cardMe.getSuit();
			int num = cardMe.getNumber();
			int b = (suit* 13) + num;
			val3[i] = b;
		}
		savedInstance.putIntArray(value3, val3);
		
		ArrayList<Card> diamonds = stackDiamonds.getStack();
		int[] val4 = new int[diamonds.size()];
		for(int i = 0; i < diamonds.size(); i++) {
			Card cardMe = diamonds.get(i);
			int suit = cardMe.getSuit();
			int num = cardMe.getNumber();
			int b = (suit*13) + num;
			val4[i] =b;
		}
		savedInstance.putIntArray(value4, val4);
		
		ArrayList<Card> clubs = stackClubs.getStack();
		int[] val5 = new int[clubs.size()];
		for(int i = 0; i < clubs.size(); i++) {
			Card card = clubs.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val5[i] = b;
		}
		savedInstance.putIntArray(value5, val5);
		
		ArrayList<Card> spades = stackClubs.getStack();
		int[] val6 = new int[spades.size()];
		for(int i = 0; i < spades.size(); i++) {
			Card card = spades.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val6[i] = b;
		}
		savedInstance.putIntArray(value6, val6);
		
		ArrayList<Card> cardStackOne = stackOne.getStack();
		int[] val7 = new int[cardStackOne.size()];
		for(int i = 0; i < cardStackOne.size(); i++) {
			Card card = cardStackOne.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val7[i] = b;
		}
		savedInstance.putIntArray(value7, val7);
		
		ArrayList<Card> cardStackTwo = stackTwo.getStack();
		int[] val8 = new int[cardStackTwo.size()];
		for(int i = 0; i < cardStackTwo.size(); i++) {
			Card card = cardStackTwo.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val8[i] = b;
		}
		savedInstance.putIntArray(value8, val8);
		
		ArrayList<Card> cardStackThree = stackThree.getStack();
		int[] val9 = new int[cardStackThree.size()];
		for(int i = 0; i < cardStackThree.size(); i++) {
			Card card = cardStackThree.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val9[i] = b;
		}
		savedInstance.putIntArray(value9, val9);
		
		ArrayList<Card> cardStackFour = stackFour.getStack();
		int[] val10 = new int[cardStackFour.size()];
		for(int i = 0; i < cardStackFour.size(); i++) {
			Card card = cardStackFour.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val10[i] = b;
		}
		savedInstance.putIntArray(value10, val10);
		
		ArrayList<Card> cardStackFive = stackFive.getStack();
		int[] val11 = new int[cardStackFive.size()];
		for(int i = 0; i < cardStackFive.size(); i++) {
			Card card = cardStackFive.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val11[i] = b;
		}
		savedInstance.putIntArray(value11, val11);
		
		ArrayList<Card> cardStackSix = stackSix.getStack();
		int[] val12 = new int[cardStackSix.size()];
		for(int i = 0; i < cardStackSix.size(); i++) {
			Card card = cardStackSix.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val12[i] = b;
		}
		savedInstance.putIntArray(value12, val12);
		
		ArrayList<Card> cardStackSeven = stackSeven.getStack();
		int[] val13 = new int[cardStackSeven.size()];
		for(int i = 0; i < cardStackSeven.size(); i++) {
			Card card = cardStackSeven.get(i);
			int suit = card.getSuit();
			int num = card.getNumber();
			int b = (suit*13) + num;
			val13[i] = b;
		}
		savedInstance.putIntArray(value13, val13);
		
		if(temp != null) {

			savedInstance.putInt(value14, (temp.getSuit()*13)+temp.getNumber());
			savedInstance.putInt(value15, returnTo);
		} else {
			savedInstance.putInt(value14, 52);
		}
		
		
		super.onSaveInstanceState(savedInstance);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public Card determineCard(int b) {
		switch(b) {
		case 0:
			return new Card(0,0, myContext);
		case 1:
			return new Card(0,1, myContext);
		case 2:
			return new Card(0,2,myContext);
		case 3:
			return new Card(0,3,myContext);
		case 4:
			return new Card(0,4,myContext);
		case 5:
			return new Card(0,5,myContext);
		case 6:
			return new Card(0,6,myContext);
		case 7:
			return new Card(0,7,myContext);
		case 8:
			return new Card(0,8,myContext);
		case 9:
			return new Card(0,9,myContext);
		case 10:
			return new Card(0,10,myContext);
		case 11:
			return new Card(0,11,myContext);
		case 12:
			return new Card(0,12,myContext);
		case 13:
			return new Card(1,0,myContext);
		case 14:
			return new Card(1,1,myContext);
		case 15:
			return new Card(1,2,myContext);
		case 16:
			return new Card(1,3,myContext);
		case 17:
			return new Card(1,4,myContext);
		case 18:
			return new Card(1,5,myContext);
		case 19:
			return new Card(1,6,myContext);
		case 20:
			return new Card(1,7,myContext);
		case 21:
			return new Card(1,8,myContext);
		case 22:
			return new Card(1,9,myContext);
		case 23:
			return new Card(1,10,myContext);
		case 24:
			return new Card(1,11,myContext);
		case 25:
			return new Card(1,12, myContext);
		case 26:
			return new Card(2,0,myContext);
		case 27:
			return new Card(2,1, myContext);
		case 28:
			return new Card(2,2,myContext);
		case 29:
			return new Card(2,3, myContext);
		case 30:
			return new Card(2,4,myContext);
		case 31:
			return new Card(2,5, myContext);
		case 32:
			return new Card(2,6, myContext);
		case 33:
			return new Card(2,7,myContext);
		case 34:
			return new Card(2,8,myContext);
		case 35:
			return new Card(2,9,myContext);
		case 36:
			return new Card(2,10,myContext);
		case 37:
			return new Card(2,11,myContext);
		case 38:
			return new Card(2,12, myContext);
		case 39:
			return new Card(3,0, myContext);
		case 40:
			return new Card(3,1,myContext);
		case 41:
			return new Card(3,2,myContext);
		case 42:
			return new Card(3,3,myContext);
		case 43:
			return new Card(3,4,myContext);
		case 44:
			return new Card(3,5,myContext);
		case 45:
			return new Card(3,6,myContext);
		case 46:
			return new Card(3,7,myContext);
		case 47:
			return new Card(3,8,myContext);
		case 48:
			return new Card(3,9,myContext);
		case 49:
			return new Card(3,10, myContext);
		case 50:
			return new Card(3,11,myContext);
		case 51:
			return new Card(3,12, myContext);
		}
		return null;
	}
}
