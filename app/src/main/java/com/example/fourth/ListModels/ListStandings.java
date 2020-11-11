package com.example.fourth.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListStandings {

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("league_id")
    private String leagueId;

    @SerializedName("league_name")
    private String leagueName;

    @SerializedName("team_id")
    private String teamId;

    @SerializedName("team_name")
    private String teamName;

    @SerializedName("overall_league_position")
    private String overallLeaguePosition;

    @SerializedName("overall_league_payed")
    private String overallLeaguePayed;

    @SerializedName("overall_league_W")
    private String overallLeagueW;

    @SerializedName("overall_league_D")
    private String overallLeagueD;

    @SerializedName("overall_league_L")
    private String overallLeagueL;

    @SerializedName("overall_league_GF")
    private String overallLeagueGF;

    @SerializedName("overall_league_GA")
    private String overallLeagueGA;

    @SerializedName("overall_league_PTS")
    private String overallLeaguePTS;

    @SerializedName("home_league_position")
    private String homeLeaguePosition;

    @SerializedName("home_league_payed")
    private String homeLeaguePayed;

    @SerializedName("home_league_W")
    private String homeLeagueW;

    @SerializedName("home_league_D")
    private String homeLeagueD;

    @SerializedName("home_league_L")
    private String homeLeagueL;

    @SerializedName("home_league_GF")
    private String homeLeagueGF;

    @SerializedName("home_league_GA")
    private String homeLeagueGA;

    @SerializedName("home_league_PTS")
    private String homeLeaguePTS;

    @SerializedName("away_league_position")
    private String awayLeaguePosition;

    @SerializedName("away_league_payed")
    private String awayLeaguePayed;

    @SerializedName("away_league_W")
    private String awayLeagueW;

    @SerializedName("away_league_D")
    private String awayLeagueD;

    @SerializedName("away_league_L")
    private String awayLeagueL;

    @SerializedName("away_league_GF")
    private String awayLeagueGF;

    @SerializedName("away_league_GA")
    private String awayLeagueGA;

    @SerializedName("away_league_PTS")
    private String awayLeaguePTS;

    @SerializedName("team_badge")
    private String team_badge;

    public ListStandings(String countryName, String leagueId, String leagueName, String teamId, String teamName, String overallLeaguePosition, String overallLeaguePayed, String overallLeagueW, String overallLeagueD, String overallLeagueL, String overallLeagueGF, String overallLeagueGA, String overallLeaguePTS, String homeLeaguePosition, String homeLeaguePayed, String homeLeagueW, String homeLeagueD, String homeLeagueL, String homeLeagueGF, String homeLeagueGA, String homeLeaguePTS, String awayLeaguePosition, String awayLeaguePayed, String awayLeagueW, String awayLeagueD, String awayLeagueL, String awayLeagueGF, String awayLeagueGA, String awayLeaguePTS,String team_badge) {
        this.countryName = countryName;
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.teamId = teamId;
        this.teamName = teamName;
        this.overallLeaguePosition = overallLeaguePosition;
        this.overallLeaguePayed = overallLeaguePayed;
        this.overallLeagueW = overallLeagueW;
        this.overallLeagueD = overallLeagueD;
        this.overallLeagueL = overallLeagueL;
        this.overallLeagueGF = overallLeagueGF;
        this.overallLeagueGA = overallLeagueGA;
        this.overallLeaguePTS = overallLeaguePTS;
        this.homeLeaguePosition = homeLeaguePosition;
        this.homeLeaguePayed = homeLeaguePayed;
        this.homeLeagueW = homeLeagueW;
        this.homeLeagueD = homeLeagueD;
        this.homeLeagueL = homeLeagueL;
        this.homeLeagueGF = homeLeagueGF;
        this.homeLeagueGA = homeLeagueGA;
        this.homeLeaguePTS = homeLeaguePTS;
        this.awayLeaguePosition = awayLeaguePosition;
        this.awayLeaguePayed = awayLeaguePayed;
        this.awayLeagueW = awayLeagueW;
        this.awayLeagueD = awayLeagueD;
        this.awayLeagueL = awayLeagueL;
        this.awayLeagueGF = awayLeagueGF;
        this.awayLeagueGA = awayLeagueGA;
        this.awayLeaguePTS = awayLeaguePTS;
        this.team_badge = team_badge;
    }

    public String getTeam_badge() {
        return team_badge;
    }

    public void setTeam_badge(String teamLogo) {
        this.team_badge = teamLogo;
    }

    public ListStandings(String leagueName, String teamId, String teamName, String overallLeaguePosition, String overallLeaguePayed, String overallLeagueW, String overallLeagueD, String overallLeagueL, String overallLeaguePTS, String teamLogo) {

        this.leagueName = leagueName;
        this.teamId = teamId;
        this.teamName = teamName;
        this.overallLeaguePosition = overallLeaguePosition;
        this.overallLeaguePayed = overallLeaguePayed;
        this.overallLeagueW = overallLeagueW;
        this.overallLeagueD = overallLeagueD;
        this.overallLeagueL = overallLeagueL;
        this.overallLeaguePTS = overallLeaguePTS;
        this.team_badge = teamLogo;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getOverallLeaguePosition() {
        return overallLeaguePosition;
    }

    public String getOverallLeaguePayed() {
        return overallLeaguePayed;
    }

    public String getOverallLeagueW() {
        return overallLeagueW;
    }

    public String getOverallLeagueD() {
        return overallLeagueD;
    }

    public String getOverallLeagueL() {
        return overallLeagueL;
    }

    public String getOverallLeagueGF() {
        return overallLeagueGF;
    }

    public String getOverallLeagueGA() {
        return overallLeagueGA;
    }

    public String getOverallLeaguePTS() {
        return overallLeaguePTS;
    }

    public String getHomeLeaguePosition() {
        return homeLeaguePosition;
    }

    public String getHomeLeaguePayed() {
        return homeLeaguePayed;
    }

    public String getHomeLeagueW() {
        return homeLeagueW;
    }

    public String getHomeLeagueD() {
        return homeLeagueD;
    }

    public String getHomeLeagueL() {
        return homeLeagueL;
    }

    public String getHomeLeagueGF() {
        return homeLeagueGF;
    }

    public String getHomeLeagueGA() {
        return homeLeagueGA;
    }

    public String getHomeLeaguePTS() {
        return homeLeaguePTS;
    }

    public String getAwayLeaguePosition() {
        return awayLeaguePosition;
    }

    public String getAwayLeaguePayed() {
        return awayLeaguePayed;
    }

    public String getAwayLeagueW() {
        return awayLeagueW;
    }

    public String getAwayLeagueD() {
        return awayLeagueD;
    }

    public String getAwayLeagueL() {
        return awayLeagueL;
    }

    public String getAwayLeagueGF() {
        return awayLeagueGF;
    }

    public String getAwayLeagueGA() {
        return awayLeagueGA;
    }

    public String getAwayLeaguePTS() {
        return awayLeaguePTS;
    }
}

