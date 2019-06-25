package com.icc.cricketscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);

        TextView result_score = findViewById(R.id.score);
        TextView message = findViewById(R.id.message);
        result_score.setText(score+"");
        message.setText(getMessage(score));

        Button restart = findViewById(R.id.restart);
        Button back_to_home = findViewById(R.id.backToHome);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this,Game.class);
                intent.putExtra("number",1);
                intent.putExtra("score",0);
                Result.this.startActivity(intent);
                Result.this.finish();
            }
        });

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this,MainActivity.class);
                Result.this.startActivity(intent);
                Result.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    private String getMessage(int score){
        switch ((score)){
            case 0:
                return "You don't seem to be a true cricket fan";
            case 1:
                return "Seems like you need to widen your knowledge";
            case 2:
                return "Well tried!! But there is always scope of improvement";
            case 3:
                return "That was a average performance";
            case 4:
                return "You just hit a four!! Maybe try for a six next time";
            case 5:
                return "Well Played!!! That was a wonderful innings";
            default:
                return "";
        }
    }
}
