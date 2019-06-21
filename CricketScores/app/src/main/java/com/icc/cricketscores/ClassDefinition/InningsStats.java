package com.icc.cricketscores.ClassDefinition;

import java.io.Serializable;

public class InningsStats implements Serializable {
    String wickets,runs,overs,extras,byes,legByes,wide,noBall,runRate;

    public InningsStats() {
    }

    public InningsStats(String wickets, String runs, String overs, String extras, String byes, String legByes, String wide, String noBall, String runRate) {
        this.wickets = wickets;
        this.runs = runs;
        this.overs = overs;
        this.extras = extras;
        this.byes = byes;
        this.legByes = legByes;
        this.wide = wide;
        this.noBall = noBall;
        this.runRate = runRate;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getByes() {
        return byes;
    }

    public void setByes(String byes) {
        this.byes = byes;
    }

    public String getLegByes() {
        return legByes;
    }

    public void setLegByes(String legByes) {
        this.legByes = legByes;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getNoBall() {
        return noBall;
    }

    public void setNoBall(String noBall) {
        this.noBall = noBall;
    }

    public String getRunRate() {
        return runRate;
    }

    public void setRunRate(String runRate) {
        this.runRate = runRate;
    }
}
