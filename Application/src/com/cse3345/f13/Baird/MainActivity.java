package com.cse3345.f13.Baird;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final int HIGHSCORES = 120;
	
	private static final String IMAGEVIEW_TAG = "icon bitmap";

	
	static final String value1 = "hScore1";
	static final String value2 = "hScore2";
	static final String value3 = "hScore3";
	static final String value4 = "hScore4";
	static final String value5 = "hScore5";
	static final String value6 = "hScoreName1";
	static final String value7 = "hScoreName2";
	static final String value8 ="hScoreName3";
	static final String value9 = "hScoreName4";
	static final String value10 = "hScoreName5";
	
	public Stack stackOne, stackTwo, stackThree, stackFour, stackFive, stackSix, stackSeven;
	public Stack stackHearts, stackDiamonds, stackClubs, stackSpades;
	public DrawDeck clickDeck;
	public Deck deck;
	public Card temp;

	public Context myContext;
	
	public RelativeLayout victory;

	public Drawable draw1;
	
	public ImageView imageStackOne, imageStackTwo, imageStackThree, imageStackFour, imageStackFive, imageStackSix, imageStackSeven;
	public ImageView imageSpade, imageClub, imageHeart, imageDiamond;
	public ImageView imageDrawDeckTwo, imageDrawDeck;
	public ImageView imageView;

	public TextView tempHolder;
	public TextView scor;
	public TextView vicText;
	public TextView timerText;

	public EditText getName;
	
	public Button newGameButton;
	public Button closeVic;
	public Button openHighScores;
	public Button highScores;

	public Timer time;
	
	public int index;
	public int score;
	public int returnTo; // 0-6 = stacks one through seven; 7 = clickDeck; 8-11 Suit stacks (spade, club, diamond, heart)
	public int timeSeconds;
	public int highScore1;
	public int highScore2;
	public int highScore3;
	public int highScore4;
	public int highScore5;
	
	public boolean checkClick;
	public boolean isPaused;
	
	public String highScoreName1;
	public String highScoreName2;
	public String highScoreName3;
	public String highScoreName4;
	public String highScoreName5;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		isPaused = false;
		
		closeVic = (Button)findViewById(R.id.closeVictory);
		openHighScores = (Button)findViewById(R.id.openHighScores);
		
		victory = (RelativeLayout)findViewById(R.id.Victory);
		victory.setVisibility(victory.INVISIBLE);
		vicText = (TextView)findViewById(R.id.VictoryText);
		
		getName = (EditText)findViewById(R.id.yourName);
		
		myContext = getBaseContext();
		draw1 = myContext.getResources().getDrawable(R.drawable.no_card);
		temp = null;
		checkClick = false;
		returnTo = 0;
		score = 0;
		scor = (TextView)findViewById(R.id.score);
		scor.setText("Score: " + score);
		
		highScore1 = 100;
		highScore2 = 300;
		highScore3 = 420;
		highScore4 = 500;
		highScore5 = 590;
		highScoreName1 = "Freddy";
		highScoreName2 = "Bill";
		highScoreName3 = "Grace";
		highScoreName4 = "Greg";
		highScoreName5 = "Alex";
		
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
		
		imageStackOne = (ImageView)findViewById(R.id.stackOne);
		imageStackTwo = (ImageView)findViewById(R.id.stackTwo);
		imageStackThree = (ImageView)findViewById(R.id.stackThree);
		imageStackFour = (ImageView)findViewById(R.id.stackFour);
		imageStackFive = (ImageView)findViewById(R.id.stackFive);
		imageStackSix = (ImageView)findViewById(R.id.stackSix);
		imageStackSeven = (ImageView)findViewById(R.id.stackSeven);
		
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
		
		imageSpade = (ImageView)findViewById(R.id.stackSpades);
		imageClub = (ImageView)findViewById(R.id.stackClubs);
		imageDiamond = (ImageView)findViewById(R.id.stackDiamonds);
		imageHeart = (ImageView)findViewById(R.id.stackHearts);
		
		stackSpades = new Stack(spades, imageSpade, true, 0);
		stackClubs = new Stack(clubs, imageClub, true, 1);
		stackDiamonds = new Stack(diamonds, imageDiamond, true, 2);
		stackHearts = new Stack(hearts, imageHeart, true, 3);
		
		imageDrawDeck = (ImageView)findViewById(R.id.leftOverDeck);
		imageDrawDeckTwo = (ImageView)findViewById(R.id.showOverDeck);
		clickDeck = new DrawDeck(cardsRest, imageDrawDeck, imageDrawDeckTwo, me, tempImage);
		
		tempHolder = (TextView)findViewById(R.id.tempHolder);
		
		
		
		//Normal Click Listeners
		OnClickListener NormalOnClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Stack myStack = stackOne;
				ImageView myImage =(ImageView)v;
				if(imageStackOne == myImage) {
					myStack = stackOne;
					index = 0;
				} else if(imageStackTwo == myImage) {
					myStack = stackTwo;
					index = 1;
				} else if(imageStackThree == myImage) {
					myStack = stackThree;
					index = 2;
				} else if(imageStackFour == myImage) {
					myStack = stackFour;
					index = 3;
				} else if (imageStackFive == myImage) {
					myStack = stackFive;
					index = 4;
				} else if(imageStackSix == myImage) {
					myStack = stackSix;
					index = 5;
				} else if(imageStackSeven == myImage){
					myStack = stackSeven;
					index = 6;
				}
					
				
				if(checkClick == false) {
					temp = myStack.getTopCard();
					if(temp != null) {
						temp = myStack.removeTopCard();
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null, null, null, temp.determineDrawable());
						checkClick = true;
						returnTo = index;
						myImage.setBackgroundColor(myContext.getResources().getColor(R.color.yellow));
						imageView = myImage;
					}
				} else {
					if(returnTo == index) {
						myStack.addCard(temp);
						temp = null;
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null, draw1);
						myImage.setBackgroundColor(myContext.getResources().getColor(R.color.white));
						checkClick = false;
					} else {
						Card temp2 = myStack.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null) {
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit2 == 0 || suit2 == 1) {
								if(suit1 == 2 || suit1 ==3) {
									if(num2 == num1 + 1) {
										myStack.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
										checkClick = false;
										imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
										
									}
								}
							} else {
								if(suit1 == 0 || suit1 == 1) {
									if(num2 == num1 + 1) {
										myStack.addCard(temp);
										temp = null;
										tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
										checkClick = false;
										imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
									}
								}
							}
						} else {
							if(num1 == 12) {
								myStack.addCard(temp);
								temp = null;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								checkClick = false;
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
							}
						}
					}
				}
			}
			
		};
		
		//Regular Spaces
		imageStackOne.setOnClickListener(NormalOnClickListener);
		imageStackTwo.setOnClickListener(NormalOnClickListener);
		imageStackThree.setOnClickListener(NormalOnClickListener);
		imageStackFour.setOnClickListener(NormalOnClickListener);
		imageStackFive.setOnClickListener(NormalOnClickListener);
		imageStackSix.setOnClickListener(NormalOnClickListener);
		imageStackSeven.setOnClickListener(NormalOnClickListener);
		
		//Deck
		imageDrawDeckTwo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(checkClick == false) {
					temp = clickDeck.removeTopCard();
					if(temp != null) {
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null, null, null, temp.determineDrawable());
						returnTo = 7;
						imageView = imageDrawDeckTwo;
						checkClick = true;
						imageDrawDeckTwo.setBackgroundColor(myContext.getResources().getColor(R.color.yellow));
					}
				} else {
					if(returnTo == 7) {
						clickDeck.returnCardToDeck(temp);
						temp = null;
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null, null, null, draw1);
						imageDrawDeckTwo.setBackgroundColor(myContext.getResources().getColor(R.color.white));
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
		
		OnClickListener SuitClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Stack myStack = stackSpades;
				ImageView myImage = (ImageView)v;
				if(myImage == imageSpade) {
					myStack = stackSpades;
					index = 8;
				} else if(myImage == imageClub) {
					myStack = stackClubs;
					index = 9;
				} else if(myImage == imageDiamond) {
					myStack = stackDiamonds;
					index = 10;
				} else if(myImage == imageHeart){
					myStack = stackHearts;
					index = 11;
				}
				
				if(checkClick == false) {
					temp = myStack.getTopCard();
					if(temp != null) {
						temp = myStack.removeTopCard();
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null, null, null, temp.determineDrawable());
						returnTo = index;
						checkClick = true;
						myImage.setBackgroundColor(myContext.getResources().getColor(R.color.yellow));
						imageView = myImage;
					}
				} else {
					if(returnTo == index) {
						myStack.addCard(temp);
						tempHolder.setCompoundDrawablesWithIntrinsicBounds(null, null, null, draw1);
						checkClick = false;
						temp = null;
						myImage.setBackgroundColor(myContext.getResources().getColor(R.color.white));
					} else {
						Card temp2 = myStack.getTopCard();
						int suit1 = temp.getSuit();
						int num1 = temp.getNumber();
						if(temp2 != null)
						{
							int suit2 = temp2.getSuit();
							int num2 = temp2.getNumber();
							if(suit1 == suit2 && num1 == num2 +1) {
								myStack.addCard(temp);
								checkClick = false;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								if(temp.getSwapped() == false) {
									temp.setSwapped(true);
									if(num2 == 12) {
										score = score + 100;
									} else {
										score = score + 10;
									}
									scor.setText("Score: "+score);
								}
								temp = null;
								
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
								
							}
							if(temp == null && stackOne.getTopCard() == null && stackTwo.getTopCard() == null && stackThree.getTopCard() == null
									&& stackFour.getTopCard()==null && stackFive.getTopCard() == null && stackSix.getTopCard() == null 
									&& stackSeven.getTopCard() == null && clickDeck.getCurrentSizeOne() == 0 && clickDeck.getCurrentSizeTwo() == 0) {
								endGame(score);
							}
						} else {
							if(myStack == stackSpades && suit1 == 0 && num1 == 0) {
								myStack.addCard(temp);
								checkClick = false;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								if(temp.getSwapped() == false) {
									temp.setSwapped(true);
									score = score + 10;
									scor.setText("Score: "+score);
								}
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
								temp = null;
							} else if(myStack == stackClubs && suit1 == 1 && num1 == 0) {
								myStack.addCard(temp);
								checkClick = false;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								if(temp.getSwapped() == false) {
									temp.setSwapped(true);
									score = score + 10;
									scor.setText("Score: "+score);
								}
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
							} else if(myStack == stackDiamonds && suit1 == 2 && num1 == 0) {
								myStack.addCard(temp);
								checkClick = false;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								if(temp.getSwapped() == false) {
									temp.setSwapped(true);
									score = score + 10;
									scor.setText("Score: "+score);
								}
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
							} else if(myStack == stackHearts && suit1 == 3 && num1 == 0) {
								myStack.addCard(temp);
								checkClick = false;
								tempHolder.setCompoundDrawablesWithIntrinsicBounds(null,null,null,draw1);
								if(temp.getSwapped() == false) {
									temp.setSwapped(true);
									score = score + 10;
									scor.setText("Score: "+score);
								}
								imageView.setBackgroundColor(myContext.getResources().getColor(R.color.white));
							}
						}
					}
				}
			}
		};
		
		imageSpade.setOnClickListener(SuitClickListener);
		imageClub.setOnClickListener(SuitClickListener);
		imageDiamond.setOnClickListener(SuitClickListener);
		imageHeart.setOnClickListener(SuitClickListener);
		
		timerText = (TextView)findViewById(R.id.timerShow);
		Timer T=new Timer();
		T.scheduleAtFixedRate(new TimerTask() {         
		        @Override
		        public void run() {
		            runOnUiThread(new Runnable()
		            {
		                @Override
		                public void run()
		                {
		                	if(isPaused == false) {
		                		timeSeconds++;
			                    timerText.setText("Time: " + timeSeconds +"s");
			                    int a = timeSeconds % 10;
			                    if(a==0 && score > 0) {
			                    	score--;
			                    	scor.setText("Score: " + score);
			                    }
		                	}
		                }
		            });
		        }
		    }, 1000, 1000);
		
		//highscore button
		highScores = (Button)findViewById(R.id.highScoreButton);
		highScores.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isPaused = true;
				Intent i = new Intent(getApplicationContext(), highscores_view.class);
				i.putExtra("highscore1", highScore1);
				i.putExtra("highscore2", highScore2);
				i.putExtra("highscore3", highScore3);
				i.putExtra("highscore4", highScore4);
				i.putExtra("highscore5", highScore5);
				i.putExtra("highscorename1", highScoreName1);
				i.putExtra("highscorename2", highScoreName2);
				i.putExtra("highscorename3", highScoreName3);
				i.putExtra("highscorename4", highScoreName4);
				i.putExtra("highscorename5", highScoreName5);
				i.putExtra("boolAdd", false);
				i.putExtra("boolStay", true);
				startActivityForResult(i, HIGHSCORES);
			}
			
		});
		
		newGameButton = (Button)findViewById(R.id.new_game);
		newGameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				newGame();
			}
		});
		
		/*
		//Drag Clicking for the imageViews
		//I used this in order to create my click and drag capabilities: http://mobile.tutsplus.com/tutorials/android/android-sdk-implementing-drag-and-drop-functionality/
		OnTouchListener cardDraggerTouch = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent m) {
				// TODO Auto-generated method stub
				if (m.getAction() == MotionEvent.ACTION_DOWN) {
					int b = ((Integer)v.getTag());
					ClipData data = ClipData.newPlainText("", "" + b);
					DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
					v.startDrag(data, shadowBuilder, v, 0);
					return true;
				}
				return false;
			}
		};
		
		imageStackOne.setOnTouchListener(cardDraggerTouch);
		imageStackTwo.setOnTouchListener(cardDraggerTouch);
		imageStackThree.setOnTouchListener(cardDraggerTouch);
		imageStackFour.setOnTouchListener(cardDraggerTouch);
		imageStackFive.setOnTouchListener(cardDraggerTouch);
		imageStackSix.setOnTouchListener(cardDraggerTouch);
		imageStackSeven.setOnTouchListener(cardDraggerTouch);
		imageDrawDeckTwo.setOnTouchListener(cardDraggerTouch);
		imageHeart.setOnTouchListener(cardDraggerTouch);
		imageDiamond.setOnTouchListener(cardDraggerTouch);
		imageClub.setOnTouchListener(cardDraggerTouch);
		imageSpade.setOnTouchListener(cardDraggerTouch);
		
		
		OnDragListener cardDragListener = new OnDragListener() {

			@Override
			public boolean onDrag(View v, DragEvent event) {
				DrawDeck clicky = null;
				Stack myStack = null;
					// TODO Auto-generated method stub
					switch (event.getAction()) {
				    case DragEvent.ACTION_DRAG_STARTED:
				        //no action necessary
				    	return true;
					case DragEvent.ACTION_DRAG_ENTERED:
				        //no action necessary
						Log.d("Drag", "I have entered; v = " + v);
				        break;
				    case DragEvent.ACTION_DRAG_EXITED:
				        //no action necessary
				        break;
				    case DragEvent.ACTION_DROP:
				    	View view = (View) event.getLocalState();
				    	view.setVisibility(View.INVISIBLE);
				    	ImageView dropTarget = (ImageView) view;
				    	ImageView dropped = (ImageView) v;
				    	returnTo = isWhatStack(dropped);
				    	int returnTo2 = isWhatStack(dropTarget);
				    	if(returnTo == 0) {
				    		myStack = stackOne;
				    	} else if(returnTo == 1) {
				    		myStack = stackTwo;
				    	} else if(returnTo == 2) {
				    		myStack = stackThree;
				    	} else if(returnTo == 3) {
				    		myStack = stackFour;
				    	} else if(returnTo == 4) {
				    		myStack = stackFive;
				    	} else if(returnTo == 5) {
				    		myStack = stackSix;
				    	} else if(returnTo == 6) {
				    		myStack = stackSeven;
				    	} else if(returnTo == 7) {
				    		clicky = clickDeck;
				    	} else if(returnTo == 8) {
				    		myStack = stackSpades;
				    	} else if(returnTo == 9) {
				    		myStack = stackClubs;
				    	} else if(returnTo == 10) {
				    		myStack = stackDiamonds;
				    	} else if(returnTo == 11) {
				    		myStack = stackHearts;
				    	}
				    	Stack myStackTwo = null;
				    	if(returnTo2 == 0) {
				    		myStackTwo = stackOne;
				    	} else if(returnTo2 == 1) {
				    		myStackTwo = stackTwo;
				    	} else if(returnTo2 == 2) {
				    		myStackTwo = stackThree;
				    	} else if(returnTo2 == 3) {
				    		myStackTwo = stackFour;
				    	} else if(returnTo2 == 4) {
				    		myStackTwo = stackFive;
				    	} else if(returnTo2 == 5) {
				    		myStackTwo = stackSix;
				    	} else if(returnTo2 == 6) {
				    		myStackTwo = stackSeven;
				    	} else if(returnTo2 == 8) {
				    		myStackTwo = stackSpades;
				    	} else if(returnTo2 == 9) {
				    		myStackTwo = stackClubs;
				    	} else if(returnTo2 == 10) {
				    		myStackTwo = stackDiamonds;
				    	} else if(returnTo2 == 11) {
				    		myStackTwo = stackHearts;
				    	}
				    	if(myStack != null && myStackTwo != null) {
				    		
				    		Card card1 = null;
				    		if(returnTo == 7) {
				    			card1 = clicky.getTopCard();
				    		} else {
				    			card1 = myStack.getTopCard();
				    		}
				    		if(returnTo2 != 7 && card1 != null) {
				    			Card card2 = myStackTwo.getTopCard();
				    		
				    			if(returnTo < 8 && returnTo2 < 7) {
				    				if(card2 == null && card1.getNumber() == 12) {
				    					myStackTwo.addCard(card1);
				    					myStack.removeTopCard();
				    				}
				    				else if((card1.getSuit() == 0|| card1.getSuit() == 1) && (card2.getSuit() == 2 || card2.getSuit() == 3)){
				    					if(card1.getNumber() == card2.getNumber() - 1) {
				    						myStack.removeTopCard();
				    						myStackTwo.addCard(card1);
				    					} else {
				    					}
				    				} else {
				    				}
				    			} else if(returnTo < 7 && returnTo2 >= 8) {
				    				if(card2 == null) {
				    					if(card1.getNumber() == 0 && myStackTwo.getStackSuit() == card1.getSuit()) {
				    						myStackTwo.addCard(card1);
				    						myStack.removeTopCard();
				    					}
				    				} else if(card2.getSuit() == card1.getSuit()) {
				    					if(card2.getNumber() + 1 == card1.getNumber()) {
				    						myStack.removeTopCard();
				    						myStackTwo.addCard(card1);
				    					} else {
				    					}
				    				} else {
				    				}
				    			} else if(returnTo >= 8 && returnTo2 >= 8) {
				    				return true;
				    			} else if(returnTo == 7 && returnTo2 >= 8) {
				    				if(card2 == null) {
				    					if(card1.getNumber() == 0 && myStackTwo.getStackSuit() == card1.getSuit()) {
				    						myStackTwo.addCard(card1);
				    						clicky.removeTopCard();
				    					}
				    				} else if(card2.getSuit() == card1.getSuit()) {
				    					if(card2.getNumber() + 1 == card1.getNumber()) {
				    						clicky.removeTopCard();
				    						myStackTwo.addCard(card1);
				    					} else {
				    					}
				    				} else {
				    				}
				    			} else if(returnTo == 7 && returnTo2 < 7) {
				    				if(card2 == null && card1.getNumber() == 12) {
				    					myStackTwo.addCard(card1);
				    					clicky.removeTopCard();
				    				}
				    				else if((card1.getSuit() == 0|| card1.getSuit() == 1) && (card2.getSuit() == 2 || card2.getSuit() == 3)){
				    					if(card1.getNumber() == card2.getNumber() - 1) {
				    						clicky.removeTopCard();
				    						myStackTwo.addCard(card1);
				    					} else {
				    					}
				    				} else {
				    				}
				    			}
				    		} else {
				    		}
				    	}
				    	return true;
				        //handle the dragged view being dropped over a drop view
				    case DragEvent.ACTION_DRAG_ENDED:
				        //no action necessary
				        break;
				    default:
				        break;
					}
				return false;
			}
			
			public int isWhatStack(ImageView k) {
				if(k == imageStackOne) {
					return 0;
				} else if(k == imageStackTwo) {
					return 1;
				} else if(k == imageStackThree) {
					return 2;
				} else if(k == imageStackFour) {
					return 3;
				} else if(k == imageStackFive) {
					return 4;
				} else if(k == imageStackSix) {
					return 5;
				} else if(k == imageStackSeven) {
					return 6;
				} else if(k == imageDrawDeckTwo) {
					return 7;
				} else if(k == imageSpade) {
					return 8;
				} else if(k == imageClub) {
					return 9;
				} else if(k == imageDiamond) {
					return 10;
				} else {//imageHeart
					return 11;
				}
			}
		};
		imageStackOne.setOnDragListener(cardDragListener);
		imageStackTwo.setOnDragListener(cardDragListener);
		imageStackThree.setOnDragListener(cardDragListener);
		imageStackFour.setOnDragListener(cardDragListener);
		imageStackFive.setOnDragListener(cardDragListener);
		imageStackSix.setOnDragListener(cardDragListener);
		imageStackSeven.setOnDragListener(cardDragListener);
		imageDrawDeckTwo.setOnDragListener(cardDragListener);
		imageHeart.setOnDragListener(cardDragListener);
		imageDiamond.setOnDragListener(cardDragListener);
		imageClub.setOnDragListener(cardDragListener);
		imageSpade.setOnDragListener(cardDragListener);
		*/
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		highScore1 = savedInstanceState.getInt(value1,0);
		highScore2 = savedInstanceState.getInt(value2, 0);
		highScore3 = savedInstanceState.getInt(value3, 0);
		highScore4 = savedInstanceState.getInt(value4, 0);
		highScore5 = savedInstanceState.getInt(value5, 0);
		highScoreName1 = savedInstanceState.getString(value6);
		highScoreName2 = savedInstanceState.getString(value7);
		highScoreName3 = savedInstanceState.getString(value8);
		highScoreName4 = savedInstanceState.getString(value9);
		highScoreName5 = savedInstanceState.getString(value10);
		
		
		//val1 deckPopMe, val2 deckHolder, val3 HeartsStack, val4
	}

	
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Bundle savedInstance = new Bundle();
		savedInstance.putInt(value1, highScore1);
		savedInstance.putInt(value2, highScore2);
		savedInstance.putInt(value3, highScore3);
		savedInstance.putInt(value4, highScore4);
		savedInstance.putInt(value5, highScore5);
		savedInstance.putString(value6, highScoreName1);
		savedInstance.putString(value7, highScoreName2);
		savedInstance.putString(value8, highScoreName3);
		savedInstance.putString(value9, highScoreName4);
		savedInstance.putString(value10, highScoreName5);
		savedInstanceState = savedInstance;
		super.onSaveInstanceState(savedInstanceState);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onPause() {
		super.onPause();
		isPaused = true;
	}
	@Override
	public void onResume() {
		super.onResume();
		isPaused = false;
	}
	
	public void endGame(int b) {
		String text = "Congratulations; you won!";
		int place = 6;
		if(b > highScore1) {
			place = 1;
		} else if(b > highScore2) {
			place = 2;
		} else if(b > highScore3) {
			place = 3;
		} else if(b > highScore4) {
			place = 4;
		} else if(b > highScore5) {
			place = 5;
		}
		if(place >=5) {
			text+= "\nYou made it onto the highscores board!\nYou are number" + place + "!";
		}
		
		
		vicText.setText(text);
		victory.setVisibility(victory.VISIBLE);
		closeVic.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isPaused = true;
				victory.setVisibility(victory.INVISIBLE);
				Intent i = new Intent(getApplicationContext(), highscores_view.class);
				i.putExtra("highscore1", highScore1);
				i.putExtra("highscore1", highScore1);
				i.putExtra("highscore2", highScore2);
				i.putExtra("highscore3", highScore3);
				i.putExtra("highscore4", highScore4);
				i.putExtra("highscore5", highScore5);
				i.putExtra("highscorename1", highScoreName1);
				i.putExtra("highscorename2", highScoreName2);
				i.putExtra("highscorename3", highScoreName3);
				i.putExtra("highscorename4", highScoreName4);
				i.putExtra("highscorename5", highScoreName5);
				i.putExtra("boolAdd", true);
				i.putExtra("boolStay", false);
				i.putExtra("yourscore", score);
				String name = getName.getText().toString();
				i.putExtra("yourname", name);
				startActivityForResult(i, HIGHSCORES);
			}
		});
		openHighScores.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					// TODO Auto-generated method stub
				isPaused = true;
					Intent i = new Intent(getApplicationContext(), highscores_view.class);
					i.putExtra("highscore1", highScore1);
					i.putExtra("highscore2", highScore2);
					i.putExtra("highscore3", highScore3);
					i.putExtra("highscore4", highScore4);
					i.putExtra("highscore5", highScore5);
					i.putExtra("highscorename1", highScoreName1);
					i.putExtra("highscorename2", highScoreName2);
					i.putExtra("highscorename3", highScoreName3);
					i.putExtra("highscorename4", highScoreName4);
					i.putExtra("highscorename5", highScoreName5);
					i.putExtra("boolAdd", true);
					i.putExtra("boolStay", true);
					i.putExtra("yourscore", score);
					String name = getName.getText().toString();
					i.putExtra("yourname", name);
					startActivityForResult(i, HIGHSCORES);
			}
		});
		
		
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		isPaused = false;
		if(requestCode == HIGHSCORES) {
			if(resultCode == RESULT_OK) {
				boolean checker = data.getBooleanExtra("boolAdd", false);
				if(checker == true) {
					highScore1 = data.getIntExtra("highscore1", 0);
					highScore2 = data.getIntExtra("highscore2", 0);
					highScore3 = data.getIntExtra("highscore3", 0);
					highScore4 = data.getIntExtra("highscore4", 0);
					highScore5 = data.getIntExtra("highscore5", 0);
					highScoreName1 = data.getStringExtra("highscorename1");
					highScoreName2 = data.getStringExtra("highscorename2");
					highScoreName3 = data.getStringExtra("highscorename3");
					highScoreName4 = data.getStringExtra("highscorename4");
					highScoreName5 = data.getStringExtra("highscorenmae5");
				}
			}
		}
	}
	
	public void newGame() {
		deck.shuffle();
		ArrayList<Card> newDeck = deck.getDeck();
		
		score = 0;
		scor.setText("Score: " + score);
		
		ArrayList<Card> newStackOne = new ArrayList<Card>(),
				newStackTwo = new ArrayList<Card>(),
				newStackThree = new ArrayList<Card>(),
				newStackFour = new ArrayList<Card>(),
				newStackFive = new ArrayList<Card>(),
				newStackSix = new ArrayList<Card>(),
				newStackSeven = new ArrayList<Card>();
		ArrayList<Card> newStackHearts = new ArrayList<Card>(),
				newStackDiamonds = new ArrayList<Card>(),
				newStackClubs = new ArrayList<Card>(),
				newStackSpades = new ArrayList<Card>();
		ArrayList<Card> newBackCards = new ArrayList<Card>(), newFrontCards = new ArrayList<Card>();
		
		for(int i = 0; i < newDeck.size(); i++) {
				Card temp = newDeck.get(i);
				if(newStackOne.size() < 1) {
					newStackOne.add(temp);
				} else if(newStackTwo.size() < 2) {
					newStackTwo.add(temp);
				} else if(newStackThree.size() < 3) {
					newStackThree.add(temp);
				} else if(newStackFour.size() < 4) {
					newStackFour.add(temp);
				} else if(newStackFive.size() < 5) {
					newStackFive.add(temp);
				} else if(newStackSix.size() < 6) {
					newStackSix.add(temp);
				} else if(newStackSeven.size() < 7) {
					newStackSeven.add(temp);
				} else {
					newBackCards.add(temp);
				}
			}
		stackOne.restoreStack(newStackOne);
		stackTwo.restoreStack(newStackTwo);
		stackThree.restoreStack(newStackThree);
		stackFour.restoreStack(newStackFour);
		stackFive.restoreStack(newStackFive);
		stackSix.restoreStack(newStackSix);
		stackSeven.restoreStack(newStackSeven);
		clickDeck.restoreDeck(newBackCards, newFrontCards);
		stackHearts.restoreStack(newStackHearts);
		stackDiamonds.restoreStack(newStackDiamonds);
		stackClubs.restoreStack(newStackClubs);
		stackSpades.restoreStack(newStackSpades);
		timeSeconds = 0;
		timerText.setText("Time: "+ timeSeconds + "s");
		
		//stackOne, stackTwo,stackThree,stackFour,stackFive,stackSix,stackSeven
		//stackHearts,stackDiamonds,stackClubs,stackSpades
		//clickDeck
	}
}
