package com.icc.cricketscores.ClassDefinition;

import com.icc.cricketscores.R;

import java.io.Serializable;

public class InningsStats implements Serializable {
    String wickets,runs,overs,extras,byes,legByes,wide,noBall,runRate;
    String side_name;
    String bowling_side;

    public InningsStats() {
    }

    public InningsStats(String wickets, String runs, String overs, String extras, String byes, String legByes, String wide, String noBall, String runRate, String side_name, String bowling_side) {
        this.wickets = wickets;
        this.runs = runs;
        this.overs = overs;
        this.extras = extras;
        this.byes = byes;
        this.legByes = legByes;
        this.wide = wide;
        this.noBall = noBall;
        this.runRate = runRate;
        this.side_name = side_name;
        this.bowling_side = bowling_side;
    }

    public String getBowling_side() {
        return bowling_side;
    }

    public void setBowling_side(String bowling_side) {
        this.bowling_side = bowling_side;
    }

    public String getSide_name() {
        return side_name;
    }

    public void setSide_name(String side_name) {
        this.side_name = side_name;
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

    public int getFlagId(){
        int flagID = R.drawable.ind;

        switch (side_name.toLowerCase()){
            case "australia ":
                flagID = R.drawable.aus;
                break;
            case "india ":
                flagID = R.drawable.ind;
                break;
            case "new zealand ":
                flagID = R.drawable.nz;
                break;
            case "england ":
                flagID = R.drawable.eng;
                break;
            case  "sri lanka ":
                flagID = R.drawable.sl;
                break;
            case "pakistan ":
                flagID = R.drawable.pak;
                break;
            case "south africa ":
                flagID = R.drawable.sa;
                break;
            case "west indies ":
                flagID = R.drawable.wi;
                break;
            case "bangladesh ":
                flagID = R.drawable.ban;
                break;
            case "afghanistan ":
                flagID = R.drawable.afg;
                break;
        }
        return flagID;
    }

    public int getBowlingFlagId(){
        int flagID = R.drawable.ind;

        switch (bowling_side.toLowerCase()){
            case "australia":
                flagID = R.drawable.aus;
                break;
            case "india ":
                flagID = R.drawable.ind;
                break;
            case "new zealand":
                flagID = R.drawable.nz;
                break;
            case "england":
                flagID = R.drawable.eng;
                break;
            case  "sri lanka":
                flagID = R.drawable.sl;
                break;
            case "pakistan":
                flagID = R.drawable.pak;
                break;
            case "south africa":
                flagID = R.drawable.sa;
                break;
            case "west indies ":
                flagID = R.drawable.wi;
                break;
            case "bangladesh":
                flagID = R.drawable.ban;
                break;
            case "afghanistan":
                flagID = R.drawable.afg;
                break;
        }
        return flagID;
    }

    public int getBackgroundImage(){
        int flagID = R.drawable.ind_background;

        switch (side_name.toLowerCase()){
            case "australia ":
                flagID = R.drawable.aus_background;
                break;
            case "india ":
                flagID = R.drawable.ind_background;
                break;
            case "new zealand ":
                flagID = R.drawable.nz_background;
                break;
            case "england ":
                flagID = R.drawable.eng_background;
                break;
            case  "sri lanka ":
                flagID = R.drawable.sl_background;
                break;
            case "pakistan ":
                flagID = R.drawable.pak_background;
                break;
            case "south africa ":
                flagID = R.drawable.sa_backgroung;
                break;
            case "west indies ":
                flagID = R.drawable.wi_background;
                break;
            case "bangladesh ":
                flagID = R.drawable.ban_background;
                break;
            case "afghanistan ":
                flagID = R.drawable.afg_background;
                break;
        }
        return flagID;
    }

    public int getBowlingBackgroundImage(){
        int flagID = R.drawable.ind_background;

        switch (bowling_side.toLowerCase()){
            case "australia":
                flagID = R.drawable.aus_background;
                break;
            case "india ":
                flagID = R.drawable.ind_background;
                break;
            case "new zealand":
                flagID = R.drawable.nz_background;
                break;
            case "england":
                flagID = R.drawable.eng_background;
                break;
            case  "sri lanka":
                flagID = R.drawable.sl_background;
                break;
            case "pakistan":
                flagID = R.drawable.pak_background;
                break;
            case "south africa":
                flagID = R.drawable.sa_backgroung;
                break;
            case "west indies":
                flagID = R.drawable.wi_background;
                break;
            case "bangladesh":
                flagID = R.drawable.ban_background;
                break;
            case "afghanistan":
                flagID = R.drawable.afg_background;
                break;
        }
        return flagID;
    }
}
