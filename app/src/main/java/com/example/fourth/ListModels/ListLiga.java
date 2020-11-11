package com.example.fourth.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListLiga {

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("league_id")
    private String leagueId;

    @SerializedName("league_name")
    private String leagueName;

    @SerializedName("league_season")
    private String leagueSeason;

    @SerializedName("league_logo")
    private String leagueLogo;

    @SerializedName("country_logo")
    private String countryLogo;
    
        public ListLiga(String countryId, String countryName, String leagueId, String leagueName, String leagueSeason, String leagueLogo, String countryLogo) {
            super();
            this.countryId = countryId;
            this.countryName = countryName;
            this.leagueId = leagueId;
            this.leagueName = leagueName;
            this.leagueSeason = leagueSeason;
            this.leagueLogo = leagueLogo;
            this.countryLogo = countryLogo;
        }

        public String getCountryId() {
            return countryId;
        }
    
        public void setCountryId(String countryId) {
            this.countryId = countryId;
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
    
        public String getLeagueSeason() {
            return leagueSeason;
        }
    
        public void setLeagueSeason(String leagueSeason) {
            this.leagueSeason = leagueSeason;
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
