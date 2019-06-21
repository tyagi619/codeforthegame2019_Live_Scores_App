package com.icc.cricketscores.ClassDefinition;

import java.io.Serializable;

public class BowlerStats implements Serializable {
    String name;
    String runs,maidens,wickets,overs,economy;

    public BowlerStats() {
    }

    public BowlerStats(String name, String runs, String maidens, String wickets, String overs, String economy) {
        this.name = name;
        this.runs = runs;
        this.maidens = maidens;
        this.wickets = wickets;
        this.overs = overs;
        this.economy = economy;
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

    public String getMaidens() {
        return maidens;
    }

    public void setMaidens(String maidens) {
        this.maidens = maidens;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }
}
