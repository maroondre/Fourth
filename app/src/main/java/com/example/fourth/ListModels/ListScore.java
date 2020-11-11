package com.example.fourth.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListScore {

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("league_id")
    private String leagueId;

    @SerializedName("league_name")
    private String leagueName;

    @SerializedName("match_date")
    private String matchDate;

    @SerializedName("match_status")
    private String matchStatus;

    @SerializedName("match_time")
    private String matchTime;

    @SerializedName("match_hometeam_id")
    private String matchHometeamId;

    @SerializedName("match_hometeam_name")
    private String matchHometeamName;

    @SerializedName("match_hometeam_score")
    private String matchHometeamScore;

    @SerializedName("match_awayteam_name")
    private String matchAwayteamName;

    @SerializedName("match_awayteam_id")
    private String matchAwayteamId;

    @SerializedName("match_awayteam_score")
    private String matchAwayteamScore;

    @SerializedName("team_home_badge")
    private String teamHomeBadge;

    @SerializedName("team_away_badge")
    private String teamAwayBadge;

    @SerializedName("league_logo")
    private String leagueLogo;

    @SerializedName("country_logo")
    private String countryLogo;
    
    public ListScore( String countryName, String leagueId, String leagueName, String matchDate, String matchStatus, String matchTime, String matchHometeamId, String matchHometeamName, String matchHometeamScore, String matchAwayteamName, String matchAwayteamId, String matchAwayteamScore, String teamHomeBadge, String teamAwayBadge, String leagueLogo, String countryLogo) {
        super();
        this.countryName = countryName;
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.matchTime = matchTime;
        this.matchHometeamId = matchHometeamId;
        this.matchHometeamName = matchHometeamName;
        this.matchHometeamScore = matchHometeamScore;
        this.matchAwayteamName = matchAwayteamName;
        this.matchAwayteamId = matchAwayteamId;
        this.matchAwayteamScore = matchAwayteamScore;
        this.teamHomeBadge = teamHomeBadge;
        this.teamAwayBadge = teamAwayBadge;
        this.leagueLogo = leagueLogo;
        this.countryLogo = countryLogo;
    }

    public ListScore(String countryName, String leagueName, String matchDate, String matchStatus, String matchTime, String matchHometeamName, String matchHometeamScore, String matchAwayteamName, String matchAwayteamScore, String leagueLogo) {
        this.countryName = countryName;
        this.leagueName = leagueName;
        this.matchDate = matchDate;
        this.matchStatus = matchStatus;
        this.matchTime = matchTime;
        this.matchHometeamName = matchHometeamName;
        this.matchHometeamScore = matchHometeamScore;
        this.matchAwayteamName = matchAwayteamName;
        this.matchAwayteamScore = matchAwayteamScore;
        this.leagueLogo = leagueLogo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchHometeamId() {
        return matchHometeamId;
    }

    public void setMatchHometeamId(String matchHometeamId) {
        this.matchHometeamId = matchHometeamId;
    }

    public String getMatchHometeamName() {
        return matchHometeamName;
    }

    public void setMatchHometeamName(String matchHometeamName) {
        this.matchHometeamName = matchHometeamName;
    }

    public String getMatchHometeamScore() {
        return matchHometeamScore;
    }

    public void setMatchHometeamScore(String matchHometeamScore) {
        this.matchHometeamScore = matchHometeamScore;
    }

    public String getMatchAwayteamName() {
        return matchAwayteamName;
    }

    public void setMatchAwayteamName(String matchAwayteamName) {
        this.matchAwayteamName = matchAwayteamName;
    }

    public String getMatchAwayteamId() {
        return matchAwayteamId;
    }

    public void setMatchAwayteamId(String matchAwayteamId) {
        this.matchAwayteamId = matchAwayteamId;
    }

    public String getMatchAwayteamScore() {
        return matchAwayteamScore;
    }

    public void setMatchAwayteamScore(String matchAwayteamScore) {
        this.matchAwayteamScore = matchAwayteamScore;
    }

    public String getTeamHomeBadge() {
        return teamHomeBadge;
    }

    public void setTeamHomeBadge(String teamHomeBadge) {
        this.teamHomeBadge = teamHomeBadge;
    }

    public String getTeamAwayBadge() {
        return teamAwayBadge;
    }

    public void setTeamAwayBadge(String teamAwayBadge) {
        this.teamAwayBadge = teamAwayBadge;
    }

    public String getLeagueLogo() {
        return leagueLogo;
    }

    public void setLeagueLogo(String leagueLogo) {
        this.leagueLogo = leagueLogo;
    }

    public String getCountryLogo() {
        return countryLogo;
    }

    public void setCountryLogo(String countryLogo) {
        this.countryLogo = countryLogo;
    }
    
}
