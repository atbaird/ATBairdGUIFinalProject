package com.cse3345.f13.Baird;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class highscores_view extends Activity{
	public String highScoreName1;
	public String highScoreName2;
	public String highScoreName3;
	public String highScoreName4;
	public String highScoreName5;
	public int highScore1;
	public int highScore2;
	public int highScore3;
	public int highScore4;
	public int highScore5;
	boolean stay;
	boolean add;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		highScore1 = intent.getIntExtra("highscore1", 0);
		highScore2 = intent.getIntExtra("highscore2", 0);
		highScore3 = intent.getIntExtra("highscore3", 0);
		highScore4 = intent.getIntExtra("highscore4", 0);
		highScore5 = intent.getIntExtra("highscore5", 0);
		highScoreName1 = intent.getStringExtra("highscorename1");
		highScoreName2 = intent.getStringExtra("highscorename2");
		highScoreName3 = intent.getStringExtra("highscorename3");
		highScoreName4 = intent.getStringExtra("highscorename4");
		highScoreName5 = intent.getStringExtra("highscorename5");
		add = intent.getBooleanExtra("boolAdd", false);
		stay = intent.getBooleanExtra("boolStay", true);
		
		if(add == true) {
			int yourScore = intent.getIntExtra("yourscore", 0);
			String yourName = intent.getStringExtra("yourName");
			if(yourScore > highScore1) {
				highScore5 = highScore4;
				highScore4 = highScore3;
				highScore3 = highScore2;
				highScore2 = highScore1;
				highScoreName5 = highScoreName4;
				highScoreName4 = highScoreName3;
				highScoreName3 = highScoreName2;
				highScoreName2 = highScoreName1;
				
				highScore1 = yourScore;
				highScoreName1 = yourName;
			} else if(yourScore >highScore2) {
				highScore5 = highScore4;
				highScore4 = highScore3;
				highScore3 = highScore2;
				highScoreName5 = highScoreName4;
				highScoreName4 = highScoreName3;
				highScoreName3 = highScoreName2;
				highScore2 = yourScore;
				highScoreName2 = yourName;
			} else if(yourScore >highScore3) {
				highScore5 = highScore4;
				highScore4 = highScore3;
				highScoreName5 = highScoreName4;
				highScoreName4 = highScoreName3;
				highScoreName3 = yourName;
				highScore3 = yourScore;
			} else if(yourScore >highScore4) {
				highScore5 = highScore4;
				highScoreName5 = highScoreName4;
				highScore4 = yourScore;
				highScoreName4 = yourName;
			} else {
				highScore5 = yourScore;
				highScoreName5 = yourName;
			}
		}
		if(stay == false) {
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
			i.putExtra("boolAdd", add);
			i.putExtra("boolStay", stay);
			setResult(RESULT_OK,i);
    		finish();
		} else {
			setContentView(R.layout.highscores_view);
			Button returnMe = (Button)findViewById(R.id.returnMe);
			TextView scores = (TextView)findViewById(R.id.scores);
			TextView scoreNames = (TextView)findViewById(R.id.scoreNames);
			scoreNames.setText("Name\n1. "+highScoreName1+"\n2. "+highScoreName2+"\n3."+highScoreName3+"\n4. "+highScoreName4+"\n5. "+highScoreName5);
			scores.setText("Score\n"+highScore1+"\n"+highScore2+"\n"+highScore3+"\n"+highScore4+"\n"+highScore5);
			returnMe.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
					i.putExtra("boolAdd", add);
					i.putExtra("boolStay", stay);
					setResult(RESULT_OK,i);
					setContentView(R.layout.activity_main);
		    		finish();
				}
				
			});
		}
	}
}
