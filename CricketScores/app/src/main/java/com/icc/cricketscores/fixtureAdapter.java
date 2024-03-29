package com.icc.cricketscores;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icc.cricketscores.ClassDefinition.MatchDetails;

import static android.support.v4.content.ContextCompat.getDrawable;
import static android.support.v4.content.ContextCompat.startActivity;

public class fixtureAdapter extends RecyclerView.Adapter<fixtureAdapter.fixtureViewHolder> {

    MatchDetails[] data;
    public fixtureAdapter(MatchDetails[] data){
        this.data=data;
    }

    @NonNull
    @Override
    public fixtureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_match_item, viewGroup, false);
        return new fixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fixtureViewHolder fixtureViewHolder, int i) {
        MatchDetails matchDetails = data[i];
        Drawable flag_team1 = getDrawable(fixtureViewHolder.context,matchDetails.getFlag1Id());
        Drawable flag_team2 = getDrawable(fixtureViewHolder.context,matchDetails.getFlag2Id());
        fixtureViewHolder.flag1.setImageDrawable(flag_team1);
        fixtureViewHolder.flag2.setImageDrawable(flag_team2);
        fixtureViewHolder.team1.setText(matchDetails.getTeam1_shortname());
        fixtureViewHolder.team2.setText(matchDetails.getTeam2_shortname());
        fixtureViewHolder.match.setText(matchDetails.getMatch_No());
        fixtureViewHolder.score1.setText(matchDetails.getScore_team1());
        fixtureViewHolder.score2.setText(matchDetails.getScore_team2());
        fixtureViewHolder.overs1.setText(matchDetails.getOvers_team1());
        fixtureViewHolder.overs2.setText(matchDetails.getOvers_team2());
        if(matchDetails.getMatchStatus().equals("UPCOMING")){
            fixtureViewHolder.summary.setText(matchDetails.getStart_date()+ "   " + matchDetails.getStart_time());
        }
        else{
            fixtureViewHolder.summary.setText(matchDetails.getMatchResult());
        }
        fixtureViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(matchDetails.getMatchStatus().equals("UPCOMING")){
                    Log.v("TAG","not started");
                }
                else {
                    Log.v("TAG", "working");
                    Intent intent = new Intent(fixtureViewHolder.context, Scorecard.class);
                    intent.putExtra("MatchDetails", matchDetails);
                    startActivity(fixtureViewHolder.context, intent, null);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class fixtureViewHolder extends RecyclerView.ViewHolder{
        TextView team1,team2,score1,score2,overs1,overs2,summary,match;
        ImageView flag1,flag2;
        ConstraintLayout card;
        Context context;
        public fixtureViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            card = itemView.findViewById(R.id.cardViewFixtures);
            flag1 = itemView.findViewById(R.id.team1_flag);
            flag2 = itemView.findViewById(R.id.team2_flag);
            team1 = itemView.findViewById(R.id.team1_name);
            team2 = itemView.findViewById(R.id.team2_name);
            score1 =itemView.findViewById(R.id.team1_score);
            score2 =itemView.findViewById(R.id.team2_score);
            overs1 =itemView.findViewById(R.id.team1_overs);
            overs2 =itemView.findViewById(R.id.team2_overs);
            summary =itemView.findViewById(R.id.match_summary);
            match =itemView.findViewById(R.id.match_no);
        }
    }
}
