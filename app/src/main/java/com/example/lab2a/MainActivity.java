package com.example.lab2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Weapon playerWeapon, botWeapon;
    private int playerScore, botScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1 = (TextView) findViewById(R.id.titleText);
        t1.setText("Welcome to Rock Paper Scissors!\nPlease choose your weapon:");

        TextView t2 = (TextView) findViewById(R.id.textOutput);
        t2.setText("Player: 0, Computer: 0");
    }

    public void botChoose() {
        List<Weapon> list = new ArrayList<Weapon>();
        list.add(Weapon.ROCK);
        list.add(Weapon.PAPER);
        list.add(Weapon.SCISSORS);
        botWeapon = list.get(new Random().nextInt(list.size()));
    }

    public void onClickInputButtonRock(View v) {
        playerWeapon = Weapon.ROCK;
        gameOutput();
    }
    public void onClickInputButtonPaper(View v) {
        playerWeapon = Weapon.PAPER;
        gameOutput();
    }
    public void onClickInputButtonScissors(View v) {
        playerWeapon = Weapon.SCISSORS;
        gameOutput();
    }

    public void gameOutput() {
        String s = "";
        botChoose();

        s += "Player's Weapon: " + playerWeapon + "\n";
        s += "Computer's Weapon: " + botWeapon + "\n";

        switch (playerWeapon) {
            case ROCK:
                switch (botWeapon) {
                    case ROCK:
                        s += "Draw!";
                        break;
                    case PAPER:
                        s += "Computer wins! Paper covers rock!";
                        botScore++;
                        break;
                    case SCISSORS:
                        s += "Player wins! Rock blunts scissors!";
                        playerScore++;
                        break;
                }
                break;
            case PAPER:
                switch (botWeapon) {
                    case ROCK:
                        s += "Player wins! Paper covers rock!";
                        playerScore++;
                        break;
                    case PAPER:
                        s += "Draw!";
                        break;
                    case SCISSORS:
                        s += "Computer wins! Scissors cut paper!";
                        botScore++;
                        break;
                }
                break;
            case SCISSORS:
                switch (botWeapon) {
                    case ROCK:
                        s += "Computer wins! Rock blunts scissors!";
                        botScore++;
                        break;
                    case PAPER:
                        s += "Player wins! Scissors cut paper!";
                        playerScore++;
                        break;
                    case SCISSORS:
                        s += "Draw!";
                        break;
                }
                break;
        }

        TextView t = (TextView) findViewById(R.id.textOutput);
        t.setText("Player: " + playerScore + ", Computer: " + botScore + "\n" + s);
    }


}