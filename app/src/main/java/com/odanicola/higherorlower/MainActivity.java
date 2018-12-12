package com.odanicola.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rightNumber;

    public void makeToast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public int makeRandomNumber(){
        Random rand = new Random();
        rightNumber = rand.nextInt(20)+1;
        return rightNumber;
    }

    public void doGuess(View view){
        EditText guessNumber = (EditText) findViewById(R.id.guessText);

        if(guessNumber.getText().toString().matches("")){
            makeToast("Please put a number on the field");
        }else{
            int number = Integer.parseInt(guessNumber.getText().toString());

            String result = "";

            if(number > rightNumber) {
                result = "Oops, your number is greater than mine. Try another number!.";
                guessNumber.setText("");
            }else if(number < rightNumber){
                result = "Oops, your number is lower than mine. Try another number!.";
                guessNumber.setText("");
            }else{
                result = "Yeaaayy. You're right! The number is " + rightNumber;
                guessNumber.setText("");
                makeRandomNumber();
            }

            makeToast(result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeRandomNumber();
    }
}
