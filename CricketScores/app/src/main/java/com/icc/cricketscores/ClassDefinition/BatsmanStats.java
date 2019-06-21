package com.icc.cricketscores.ClassDefinition;

import java.io.Serializable;

public class BatsmanStats implements Serializable {
    String name;
    String runs,balls,fours,sixes,strikeRate;
    String howOut;

    public BatsmanStats() {
    }

    public BatsmanStats(String name, String runs, String balls, String fours, String sixes, String strikeRate, String howOut) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.fours = fours;
        this.sixes = sixes;
        this.strikeRate = strikeRate;
        this.howOut = howOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public String getFours() {
        return fours;
    }

    public void setFours(String fours) {
        this.fours = fours;
    }

    public String getSixes() {
        return sixes;
    }

    public void setSixes(String sixes) {
        this.sixes = sixes;
    }

    public String getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(String strikeRate) {
        this.strikeRate = strikeRate;
    }

    public String getHowOut() {
        return howOut;
    }

    public void setHowOut(String howOut) {
        this.howOut = howOut;
    }
}
