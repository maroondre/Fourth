package com.example.fourth.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListBansa {

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("country_logo")
    private String countryLogo;

        public ListBansa(String countryId, String countryName, String countryLogo)
        {
            super();
            this.countryId = countryId;
            this.countryName = countryName;
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

        public String getCountryLogo() {
            return countryLogo;
        }

        public void setCountryLogo(String countryLogo) {
            this.countryLogo = countryLogo;
        }

}
