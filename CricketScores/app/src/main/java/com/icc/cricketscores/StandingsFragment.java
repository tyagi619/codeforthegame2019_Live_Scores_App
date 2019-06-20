package com.icc.cricketscores;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.icc.cricketscores.ClassDefinition.TeamDetails;

public class StandingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.standings,null);

        TeamDetails[] data = (TeamDetails[]) getArguments().getSerializable("tableList");
        TableLayout pointsTable = view.findViewById(R.id.TableStandings);
        for(int i=1;i<11;i++){
            TableRow row = (TableRow) pointsTable.getChildAt(i);
            TextView team_name = (TextView) row.getChildAt(0);
            TextView played = (TextView) row.getChildAt(1);
            TextView won = (TextView) row.getChildAt(2);
            TextView lost = (TextView) row.getChildAt(3);
            TextView noResult = (TextView) row.getChildAt(4);
            TextView netRunRate = (TextView) row.getChildAt(5);
            TextView points = (TextView) row.getChildAt(6);

            team_name.setText(data[i-1].getTeamName());
            played.setText(Integer.toString(data[i-1].getPlayed()));
            won.setText(Integer.toString(data[i-1].getWon()));
            lost.setText(Integer.toString(data[i-1].getLost()));
            noResult.setText(Integer.toString(data[i-1].getNoResult()));
            points.setText(Integer.toString(data[i-1].getPoints()));
            netRunRate.setText(Double.toString(data[i-1].getNetRunRate()));
        }
        return view;
    }
}
