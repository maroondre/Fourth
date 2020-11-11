package com.example.fourth.Connections;

import com.example.fourth.ListModels.ListBansa;
import com.example.fourth.ListModels.ListLiga;
import com.example.fourth.ListModels.ListScore;
import com.example.fourth.ListModels.ListStandings;
import com.example.fourth.ListModels.ListTeams;
import com.example.fourth.ListModels.ListVideo;

import java.util.List;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    String Soccer = "https:///apiv2.apifootball.com/";
    String BASE_URLPOD = "https://www.scorebat.com/video-api/";

    @GET("?")
    Call<List<ListScore>> getScore (@Query("action") String action, @Query("from") String from, @Query("to") String to,@Query("league_id") String league, @Query("APIkey") String api);

    @GET("?")
    Call<List<ListTeams>> getTeam (@Query("action") String action, @Query("league_id") String league, @Query("APIkey") String api);

    @GET("?")
    Call<List<ListStandings>> getStandings (@Query("action") String action, @Query("league_id") String league, @Query("APIkey") String api);

    @GET("v1")
    Call<List<ListVideo>> getVideo();

    @GET("?")
    Call<List<ListBansa>> getBansa (@Query("action") String action, @Query("APIkey") String api);

    @GET("?")
    Call<List<ListLiga>> getLeague (@Query("action") String action, @Query("country_id") String countryid, @Query("APIkey") String api);
}
