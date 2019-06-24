package com.icc.cricketscores;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icc.cricketscores.ClassDefinition.MatchDetails;


public class FixturesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures,null);
        MatchDetails[] data = (MatchDetails[]) getArguments().getSerializable("fixtures");
        int index = getArguments().getInt("index");

        RecyclerView matches = view.findViewById(R.id.RecycleViewFixtures);

        fixtureAdapter adapter = new fixtureAdapter(data);
        matches.setAdapter(adapter);
        matches.setLayoutManager(new LinearLayoutManager(getActivity()));
        matches.getLayoutManager().scrollToPosition(index);
        return view;
    }
}
