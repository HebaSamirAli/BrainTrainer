package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score =0,total=0;
    TextView result,timerTextView,scoreTextView;
    Button button0,button1,button2,button3;
    TextView sumTextView;

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view){

        total=total+1;

        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()) ){
            Log.i("Correct","you got it");
            score = score+1;
        }else {
            Log.i("Wrong","try again");
            score = score-1;
        }
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(total));
        newQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        sumTextView = findViewById(R.id.sumTextView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        result = findViewById(R.id.resultTextView);
        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        newQuestion();
    }
    public void newQuestion (){

        Random rand = new Random();
        if (answers.size()>0){
            for(int i=answers.size()-1;i>=0;i--){
                answers.remove(i);
            }


        }

        int a= rand.nextInt(21);
        int b= rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        for (int i=0;i<4;i++){
            if (i==locationOfCorrectAnswer) {
                answers.add(a+b);
            }else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a+b){
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }
}