package com.icc.cricketscores.ClassDefinition;

import java.io.Serializable;

public class TeamDetails implements Serializable {
    String teamName;
    int played,won,lost,noResult;
    double netRunRate;
    int points;

    public TeamDetails() {
    }

    public TeamDetails(String teamName, int played, int won, int lost, int noResult, double netRunRate, int points) {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.noResult = noResult;
        this.netRunRate = netRunRate;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getNoResult() {
        return noResult;
    }

    public void setNoResult(int noResult) {
        this.noResult = noResult;
    }

    public double getNetRunRate() {
        return netRunRate;
    }

    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
