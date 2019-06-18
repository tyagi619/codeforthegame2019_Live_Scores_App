package com.icc.cricketscores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icc.cricketscores.ClassDefinition.MatchDetails;

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
        fixtureViewHolder.team1.setText(matchDetails.getTeam1());
        fixtureViewHolder.team2.setText(matchDetails.getTeam2());
        fixtureViewHolder.match.setText(matchDetails.getMatch_No());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class fixtureViewHolder extends RecyclerView.ViewHolder{
        TextView team1,team2,score1,score2,overs1,overs2,summary,match;
        ImageView flag1,flag2;
        public fixtureViewHolder(View itemView){
            super(itemView);
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
