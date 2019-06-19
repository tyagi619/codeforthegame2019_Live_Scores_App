package com.icc.cricketscores;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    MatchDetails[] data = new MatchDetails[48];

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getData();
    }

    public void getData(){
        String MatchUrl = "https://dev132-cricket-live-scores-v1.p.rapidapi.com/matchseries.php?seriesid=2181";

        if(isNetworkAvailable()){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(MatchUrl)
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
                    Log.v("Testing",jsonData);
                    try {
                        getMatches(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    private void getMatches (String jsonData) throws JSONException {
        JSONObject raw_data= new JSONObject(jsonData);

        JSONObject fixtureList = raw_data.getJSONObject("matchList");
        JSONArray fixtures = fixtureList.getJSONArray("matches");
        for(int i=0;i<48;i++){
            JSONObject matchData = fixtures.getJSONObject(i);
            setData(matchData);
        }
    }

    private void setData(JSONObject matchData) throws JSONException {
        String name = matchData.getString("name");
        int index;
        if(name.equals("Semi Final 1")){
            index=45;
        }
        else if(name.equals("Semi Final 2")){
            index=46;
        }
        else if(name.equals("Final")){
            index=47;
        }
        else{
            String[] match_number = name.split(" ");
            index = Integer.valueOf(match_number[1]);
//            Log.v("Match NUmber",Integer.toString(index));
            index=index-1;
        }

        data[index].setCurrent_Innings(Integer.parseInt(matchData.getString("currentInningId")));
        data[index].setTeam1(matchData.getJSONObject("homeTeam").getString("name"));
        data[index].setTeam2(matchData.getJSONObject("awayTeam").getString("name"));
        data[index].setTeam1_shortname(matchData.getJSONObject("homeTeam").getString("shortName"));
        data[index].setTeam2_shortname(matchData.getJSONObject("awayTeam").getString("shortName"));
        data[index].setMatch_No(matchData.getString("name"));
        data[index].setMatch_id(matchData.getInt("id"));
        data[index].setMatchStatus(matchData.getString("status"));
        data[index].setMatchResult(matchData.getString("matchSummaryText"));
        data[index].setScore_team1(matchData.getJSONObject("scores").getString("homeScore"));
        data[index].setScore_team2(matchData.getJSONObject("scores").getString("awayScore"));
        data[index].setVenue(matchData.getJSONObject("venue").getString("name"));
        data[index].setToss_message("");

        String[] start_date = matchData.getString("startDateTime").split("T");
        String[] date = start_date[0].split("-");

        data[index].setStart_date(date[0]+"-"+date[1]+"-"+date[2]);

        String start_time = start_date[0].split("Z")[0];
        String[] time = start_time.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        min = min+30;
        if(min>60){
            min = min%60;
            hour=hour+1;
        }
        hour = hour+5;
        time[0] = Integer.toString(hour);
        if(time[0].length()==1){
            time[0] = "0"+time[0];
        }
        time[1] = Integer.toString(min);
        if(time[1].length()==1){
            time[1] = "0"+time[1];
        }

        data[index].setStart_time(time[0]+":"+time[1]+":"+time[2]);

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
