package com.example.fourth.ListModels;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListTeams {

        @SerializedName("team_key")
        private String teamKey;

        @SerializedName("team_name")
        private String teamName;

        @SerializedName("team_badge")
        private String teamBadge;

        public ListTeams(String teamKey, String teamName, String teamBadge)
        {
            this.teamKey = teamKey;
            this.teamName = teamName;
            this.teamBadge = teamBadge;
        }

        public String getTeamKey() {
                return teamKey;
            }

        public String getTeamName() {
                return teamName;
            }

        public String getTeamBadge() {
                return teamBadge;
            }
}

