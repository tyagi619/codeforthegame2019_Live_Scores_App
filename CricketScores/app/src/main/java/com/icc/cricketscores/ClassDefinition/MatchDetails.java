package com.icc.cricketscores.ClassDefinition;

public class MatchDetails {
    String match_No;
    String team1,team2;
    String team1_shortname,team2_shortname;
    String matchStatus,matchResult;
    String score_team1,score_team2;
    String venue;
    int current_Innings;
    String toss_message;
    String start_date,start_time;
    int match_id;

    public MatchDetails() {
    }

    public MatchDetails(String match_No, String team1, String team2, String team1_shortname, String team2_shortname, String matchStatus, String matchResult, String score_team1, String score_team2, String venue, int current_Innings, String toss_message, String start_date, String start_time, int match_id) {
        this.match_No = match_No;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_shortname = team1_shortname;
        this.team2_shortname = team2_shortname;
        this.matchStatus = matchStatus;
        this.matchResult = matchResult;
        this.score_team1 = score_team1;
        this.score_team2 = score_team2;
        this.venue = venue;
        this.current_Innings = current_Innings;
        this.toss_message = toss_message;
        this.start_date = start_date;
        this.start_time = start_time;
        this.match_id = match_id;
    }

    public String getMatch_No() {
        return match_No;
    }

    public void setMatch_No(String match_No) {
        this.match_No = match_No;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1_shortname() {
        return team1_shortname;
    }

    public void setTeam1_shortname(String team1_shortname) {
        this.team1_shortname = team1_shortname;
    }

    public String getTeam2_shortname() {
        return team2_shortname;
    }

    public void setTeam2_shortname(String team2_shortname) {
        this.team2_shortname = team2_shortname;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getScore_team1() {
        return score_team1;
    }

    public void setScore_team1(String score_team1) {
        this.score_team1 = score_team1;
    }

    public String getScore_team2() {
        return score_team2;
    }

    public void setScore_team2(String score_team2) {
        this.score_team2 = score_team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getCurrent_Innings() {
        return current_Innings;
    }

    public void setCurrent_Innings(int current_Innings) {
        this.current_Innings = current_Innings;
    }

    public String getToss_message() {
        return toss_message;
    }

    public void setToss_message(String toss_message) {
        this.toss_message = toss_message;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
}
