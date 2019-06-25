package com.icc.cricketscores;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.icc.cricketscores.ClassDefinition.BatsmanStats;
import com.icc.cricketscores.ClassDefinition.BowlerStats;
import com.icc.cricketscores.ClassDefinition.InningsStats;
import com.icc.cricketscores.ClassDefinition.MatchDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Scorecard extends AppCompatActivity {

    BatsmanStats[] batsmanStats;
    BowlerStats[] bowlerStats;
    InningsStats inningsStats;
    ProgressBar progressBar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);
        MatchDetails matchDetails = (MatchDetails) getIntent().getSerializableExtra("MatchDetails");
        TabLayout tabLayout = findViewById(R.id.teamTab);
        TabLayout.Tab t1 = tabLayout.getTabAt(0);
        TabLayout.Tab t2 = tabLayout.getTabAt(1);
        t1.setText(matchDetails.getTeam1());
        t2.setText(matchDetails.getTeam2());
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.INVISIBLE);
        frameLayout = findViewById(R.id.scoreCard);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                frameLayout.removeAllViews();
                progressBar.setVisibility(View.VISIBLE);
                int pos = tab.getPosition();
                Log.v("TAG",Integer.toString(pos));
                if(pos==0){
                    batsmanStats = new BatsmanStats[11];
                    bowlerStats = new BowlerStats[11];
                    inningsStats = new InningsStats();
                    for(int i=0;i<11;i++){
                        batsmanStats[i]=null;
                        bowlerStats[i]=null;
                    }
                    inningsStats.setBowling_side(matchDetails.getTeam2());
                    getData(matchDetails.getTeam1_shortname(),matchDetails.getMatch_id());
                }
                else{
                    batsmanStats = new BatsmanStats[11];
                    bowlerStats = new BowlerStats[11];
                    inningsStats = new InningsStats();
                    for(int i=0;i<11;i++){
                        batsmanStats[i]=null;
                        bowlerStats[i]=null;
                    }
                    inningsStats.setBowling_side(matchDetails.getTeam1());
                    getData(matchDetails.getTeam2_shortname(),matchDetails.getMatch_id());

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                frameLayout.removeAllViews();
                progressBar.setVisibility(View.VISIBLE);
                int pos = tab.getPosition();
                Log.v("TAG",Integer.toString(pos));
                if(pos==0){
                    batsmanStats = new BatsmanStats[11];
                    bowlerStats = new BowlerStats[11];
                    inningsStats = new InningsStats();
                    for(int i=0;i<11;i++){
                        batsmanStats[i]=null;
                        bowlerStats[i]=null;
                    }
                    inningsStats.setBowling_side(matchDetails.getTeam2());
                    getData(matchDetails.getTeam1_shortname(),matchDetails.getMatch_id());
                }
                else{
                    batsmanStats = new BatsmanStats[11];
                    bowlerStats = new BowlerStats[11];
                    inningsStats = new InningsStats();
                    for(int i=0;i<11;i++){
                        batsmanStats[i]=null;
                        bowlerStats[i]=null;
                    }
                    inningsStats.setBowling_side(matchDetails.getTeam1());
                    getData(matchDetails.getTeam2_shortname(),matchDetails.getMatch_id());

                }
            }
        });
    }

    private void getData(String Tname, long match_id) {

        String StandingsURL = "https://dev132-cricket-live-scores-v1.p.rapidapi.com/scorecards.php?seriesid=2181&matchid="+Long.toString(match_id);

        if(isNetworkAvailable()){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(StandingsURL)
                    .header("X-RapidAPI-Host", "dev132-cricket-live-scores-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "f624852d01msh1c6aed1b8c6bcbap1771f3jsn029bd3334c64")
                    .build();

            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String jsonData = response.body().string();
//                    Log.v("Testing",jsonData);
                    try {
                        boolean isValid = getStats(jsonData,Tname);
//                        frameLayout.removeAllViews();
                        progressBar.setVisibility(View.INVISIBLE);
                        if(isValid) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("bowlerStats", bowlerStats);
                            bundle.putSerializable("batsmanStats", batsmanStats);
                            bundle.putSerializable("inningsStats", inningsStats);
                            ScorecardFragment fragment = new ScorecardFragment();
                            fragment.setArguments(bundle);

                            FragmentManager fragmentManager = getSupportFragmentManager();
//                            progressBar.setVisibility(View.GONE);
                            fragmentManager.beginTransaction().replace(R.id.scoreCard, fragment).commit();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private boolean getStats(String jsonData,String Tname) throws JSONException {
        JSONObject raw_data = new JSONObject(jsonData);

        JSONArray innings = raw_data.getJSONObject("fullScorecard").getJSONArray("innings");

        for(int i=0;i<innings.length();i++){
            JSONObject inning = innings.getJSONObject(i);
            String name = inning.getString("shortName").split(" ")[1];
            if(name.equals(Tname)){
                setData(inning);
                return true;
            }
        }
        return false;
    }

    private void setData(JSONObject inning) throws JSONException {

        inningsStats.setWickets(inning.getString("wicket"));
        inningsStats.setRuns(inning.getString("run"));
        inningsStats.setOvers(inning.getString("over"));
        inningsStats.setExtras(inning.getString("extra"));
        inningsStats.setByes(inning.getString("bye"));
        inningsStats.setLegByes(inning.getString("legBye"));
        inningsStats.setWide(inning.getString("wide"));
        inningsStats.setNoBall(inning.getString("noBall"));
        inningsStats.setRunRate(inning.getString("runRate"));
        String[] side_name = inning.getString("name").split(" ");
        int l=side_name.length;
        String team_name="";
        for(int i=2;i<l;i++){
            team_name+=side_name[i];
            team_name+=" ";
        }
        inningsStats.setSide_name(team_name);

        JSONArray batsman = inning.getJSONArray("batsmen");
        JSONArray bowlers = inning.getJSONArray("bowlers");

        for(int i=0;i<batsman.length();i++){
            JSONObject batter = batsman.getJSONObject(i);
            BatsmanStats b = new BatsmanStats();
            b.setName(batter.getString("name"));
            b.setRuns(batter.getString("runs"));
            b.setBalls(batter.getString("balls"));
            b.setFours(batter.getString("fours"));
            b.setSixes(batter.getString("sixes"));
            b.setStrikeRate(batter.getString("strikeRate"));
            b.setHowOut(batter.getString("howOut"));
            batsmanStats[i] = b;
        }

        for(int i=0;i<bowlers.length();i++){
            JSONObject bowler = bowlers.getJSONObject(i);
            BowlerStats b = new BowlerStats();
            b.setName(bowler.getString("name"));
            b.setRuns(bowler.getString("runsConceded"));
            b.setMaidens(bowler.getString("maidens"));
            b.setOvers(bowler.getString("overs"));
            b.setWickets(bowler.getString("wickets"));
            b.setEconomy(bowler.getString("economy"));
            bowlerStats[i] = b;
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        else {
            Toast.makeText(this , "No Internet Connection",
                    Toast.LENGTH_LONG).show();
        }
        return isAvailable;
    }
}
