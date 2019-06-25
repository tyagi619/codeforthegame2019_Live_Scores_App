package com.icc.cricketscores;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Game extends AppCompatActivity {

    String correct;
    private CountDownTimer countDownTimer,nextFragmentTimer;
    private static final long START_TIME_IN_MILIS=10000;
    private long timeLeft = START_TIME_IN_MILIS;
    private TextView q,o1,o2,o3,o4,timer;
    int q_number=5;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        q_number = intent.getIntExtra("number",5);
        score = intent.getIntExtra("score",0);

        q = findViewById(R.id.question);
        o1 = findViewById(R.id.option1);
        o2 = findViewById(R.id.option2);
        o3 = findViewById(R.id.option3);
        o4 = findViewById(R.id.option4);
        timer = findViewById(R.id.timer);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = (String) dataSnapshot.child("Q").getValue();
                String option1 = (String) dataSnapshot.child("A").child("1").getValue();
                String option2 = (String) dataSnapshot.child("A").child("2").getValue();
                String option3 = (String) dataSnapshot.child("A").child("3").getValue();
                String option4 = (String) dataSnapshot.child("A").child("4").getValue();
                correct = (String) dataSnapshot.child("Correct").getValue();
                q.setText(question);
                o1.setText(option1);
                o2.setText(option2);
                o3.setText(option3);
                o4.setText(option4);
                startTimer();
                o1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!option1.equals(correct)){
                            o1.setBackgroundColor(Color.parseColor("#ff0000"));
                        }
                        else{
                            o1.setBackgroundColor(Color.parseColor("#008000"));
                            score++;
                        }
                        o2.setEnabled(false);
                        o3.setEnabled(false);
                        o4.setEnabled(false);
                        countDownTimer.cancel();
                        LoadNextFragment();

                    }
                });

                o2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!option2.equals(correct)){
                            o2.setBackgroundColor(Color.parseColor("#ff0000"));
                        }
                        else{
                            o2.setBackgroundColor(Color.parseColor("#008000"));
                            score++;
                        }
                        o1.setEnabled(false);
                        o3.setEnabled(false);
                        o4.setEnabled(false);
                        countDownTimer.cancel();
                        LoadNextFragment();
                    }
                });

                o3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!option3.equals(correct)){
                            o3.setBackgroundColor(Color.parseColor("#ff0000"));
                        }
                        else{
                            o3.setBackgroundColor(Color.parseColor("#008000"));
                            score++;
                        }
                        o2.setEnabled(false);
                        o1.setEnabled(false);
                        o4.setEnabled(false);
                        countDownTimer.cancel();
                        LoadNextFragment();
                    }
                });

                o4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!option4.equals(correct)){
                            o4.setBackgroundColor(Color.parseColor("#ff0000"));
                        }
                        else{
                            o4.setBackgroundColor(Color.parseColor("#008000"));
                            score++;
                        }
                        o2.setEnabled(false);
                        o3.setEnabled(false);
                        o1.setEnabled(false);
                        countDownTimer.cancel();
                        LoadNextFragment();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    @Override
    public void onBackPressed() {

    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTime();
            }

            @Override
            public void onFinish() {
                o1.setEnabled(false);
                o2.setEnabled(false);
                o3.setEnabled(false);
                o4.setEnabled(false);
                LoadNextFragment();
            }
        }.start();
    }

    private void LoadNextFragment() {
        nextFragmentTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(o1.getText().equals(correct)){
                    o1.setBackgroundColor(Color.parseColor("#008000"));
                }
                else if(o2.getText().equals(correct)){
                    o2.setBackgroundColor(Color.parseColor("#008000"));
                }
                else if(o3.getText().equals(correct)){
                    o3.setBackgroundColor(Color.parseColor("#008000"));
                }
                else{
                    o4.setBackgroundColor(Color.parseColor("#008000"));
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Game.this,Game.class);
                if(q_number==5){
                    intent = new Intent(Game.this,Result.class);
                }
                intent.putExtra("number",q_number+1);
                intent.putExtra("score",score);
                Game.this.startActivity(intent);
                Game.this.finish();
            }
        }.start();
    }

    private void updateTime() {
        int secs = (int) timeLeft/1000;
        timer.setText(secs+"s");
    }
}
