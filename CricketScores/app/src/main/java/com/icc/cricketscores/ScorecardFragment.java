package com.icc.cricketscores;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.icc.cricketscores.ClassDefinition.BatsmanStats;
import com.icc.cricketscores.ClassDefinition.BowlerStats;
import com.icc.cricketscores.ClassDefinition.InningsStats;
import com.icc.cricketscores.ClassDefinition.MatchDetails;


import static android.support.v4.content.ContextCompat.getDrawable;

public class ScorecardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scorecard_fragment,null);

        BatsmanStats[] batsmanStats = (BatsmanStats[]) getArguments().getSerializable("batsmanStats");
        BowlerStats[] bowlerStats = (BowlerStats[]) getArguments().getSerializable("bowlerStats");
        InningsStats inningsStats = (InningsStats) getArguments().getSerializable("inningsStats");
        MatchDetails matchDetails = (MatchDetails) getArguments().getSerializable("matchDetails");

        ImageView imageView = view.findViewById(R.id.battingFlag);
        Drawable flag_team1 = getDrawable(getContext(),inningsStats.getFlagId());
        imageView.setImageDrawable(flag_team1);

        TextView batting_team_name = view.findViewById(R.id.BattingName);
        batting_team_name.setText(inningsStats.getSide_name()+"Batting");

        LinearLayout temp = view.findViewById(R.id.battingSide);
        Drawable team1_background = getDrawable(getContext(),inningsStats.getBackgroundImage());
        temp.setBackground(team1_background);

        imageView = view.findViewById(R.id.bowlingFlag);
        flag_team1 = getDrawable(getContext(),inningsStats.getBowlingFlagId());
        imageView.setImageDrawable(flag_team1);

        TextView bowling_team_name = view.findViewById(R.id.bowlingName);
        bowling_team_name.setText(inningsStats.getBowling_side()+" Bowling");

        temp = view.findViewById(R.id.bowlingSide);
        team1_background = getDrawable(getContext(),inningsStats.getBowlingBackgroundImage());
        temp.setBackground(team1_background);

        TableLayout batsman = view.findViewById(R.id.BattingTable);

        for(int i=1;i<12;i++){
            TableRow row = (TableRow) batsman.getChildAt(i);
            TextView name = (TextView) row.getChildAt(0);
            TextView runs = (TextView) row.getChildAt(1);
            TextView balls = (TextView) row.getChildAt(2);
            TextView fours = (TextView) row.getChildAt(3);
            TextView sixes = (TextView) row.getChildAt(4);
            TextView strikeRate = (TextView) row.getChildAt(5);

            if(batsmanStats[i-1]!=null){
                name.setText(batsmanStats[i-1].getName() + "\n" + batsmanStats[i-1].getHowOut());
                runs.setText(batsmanStats[i-1].getRuns());
                balls.setText(batsmanStats[i-1].getBalls());
                fours.setText(batsmanStats[i-1].getFours());
                sixes.setText(batsmanStats[i-1].getSixes());
                strikeRate.setText(batsmanStats[i-1].getStrikeRate());
            }
        }
        float d = getContext().getResources().getDisplayMetrics().density;
        int mar = (int)(2*d);
        TableLayout bowler = view.findViewById(R.id.BowlingTable);
        LinearLayout.LayoutParams param = new TableRow.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TabLayout.LayoutParams.WRAP_CONTENT,
                5.0f
        );
        param.setMargins(mar,0,mar,0);

        LinearLayout.LayoutParams param1 = new TableRow.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TabLayout.LayoutParams.WRAP_CONTENT,
                1.0f
        );

        for(int i = 0; i<11; i++){
            if(bowlerStats[i]!=null) {
                TableRow row = new TableRow(getContext());
                TextView name = new TextView(getContext());
                TextView overs = new TextView(getContext());
                TextView maiden = new TextView(getContext());
                TextView runs = new TextView(getContext());
                TextView wickets = new TextView(getContext());
                TextView economy = new TextView(getContext());
                row.setBackgroundColor(Color.parseColor("#f1f1f1"));

                name.setGravity(Gravity.CENTER);
                overs.setGravity(Gravity.CENTER);
                maiden.setGravity(Gravity.CENTER);
                runs.setGravity(Gravity.CENTER);
                wickets.setGravity(Gravity.CENTER);
                economy.setGravity(Gravity.CENTER);

                name.setLayoutParams(param);
                overs.setLayoutParams(param1);
                maiden.setLayoutParams(param1);
                runs.setLayoutParams(param1);
                wickets.setLayoutParams(param1);
                economy.setLayoutParams(param1);


                int val = (int) (20*d);

                name.setPadding(0,val,0,val);
                overs.setPadding(0,val,0,val);
                maiden.setPadding(0,val,0,val);
                runs.setPadding(0,val,0,val);
                wickets.setPadding(0,val,0,val);
                economy.setPadding(0,val,0,val);

                name.setTypeface(null, Typeface.BOLD);
                overs.setTypeface(null, Typeface.BOLD);
                maiden.setTypeface(null, Typeface.BOLD);
                runs.setTypeface(null, Typeface.BOLD);
                wickets.setTypeface(null, Typeface.BOLD);
                economy.setTypeface(null, Typeface.BOLD);

                if(i%2==0) {
                    name.setBackgroundColor(Color.parseColor("#ffffff"));
                    overs.setBackgroundColor(Color.parseColor("#ffffff"));
                    maiden.setBackgroundColor(Color.parseColor("#ffffff"));
                    runs.setBackgroundColor(Color.parseColor("#ffffff"));
                    wickets.setBackgroundColor(Color.parseColor("#ffffff"));
                    economy.setBackgroundColor(Color.parseColor("#ffffff"));

                }



                name.setText(bowlerStats[i].getName());
                overs.setText(bowlerStats[i].getOvers());
                maiden.setText(bowlerStats[i].getMaidens());
                runs.setText(bowlerStats[i].getRuns());
                wickets.setText(bowlerStats[i].getWickets());
                economy.setText(bowlerStats[i].getEconomy());

                row.addView(name);
                row.addView(overs);
                row.addView(maiden);
                row.addView(runs);
                row.addView(wickets);
                row.addView(economy);

                bowler.addView(row);
            }
        }

        TextView extras = view.findViewById(R.id.extras);
        TextView totalExtras = view.findViewById(R.id.totalExtras);

        TextView total = view.findViewById(R.id.total);
        TextView totalScore = view.findViewById(R.id.totalScore);

        String ex = "";
        if(!inningsStats.getByes().equals("0")){
            ex+=inningsStats.getByes()+"b ";
        }
        if(!inningsStats.getLegByes().equals("0")){
            ex+=inningsStats.getLegByes()+"lb ";
        }
        if(!inningsStats.getWide().equals("0")){
            ex+=inningsStats.getWide()+"w ";
        }
        if(!inningsStats.getNoBall().equals("0")){
            ex+=inningsStats.getNoBall()+"nb ";
        }

        extras.setText("Extras\n"+ex);
        totalExtras.setText(inningsStats.getExtras());

        total.setText("Total\n"+inningsStats.getOvers());
        totalScore.setText(inningsStats.getRuns()+"-"+inningsStats.getWickets());

        return view;
    }
}
