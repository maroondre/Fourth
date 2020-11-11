package com.example.fourth.Connections;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.fourth.Classes.Score;
import com.example.fourth.ListModels.ListBansa;
import com.example.fourth.ListModels.ListLiga;
import com.example.fourth.ListModels.ListScore;
import com.example.fourth.ListModels.ListStandings;
import com.example.fourth.ListModels.ListTeams;
import com.example.fourth.ListModels.ListVideo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Calls {

    public static final String pref = "sharedPreference";
    public static final String score = "Score";
    public static final String standing = "Standing";
    public static final String teams = "Teams";
    public static final String video = "Video";
    public static final String bansa = "Country";
    public static final String liga = "Leagues";
    String countryid;
    SharedPreferences spref;
    SharedPreferences.Editor spEditor;
    Context context;
    Activity activity;
    Retrocall rfit;
    int flag = 0;

    public Calls(Context context){
        this.context = context;
        spref = context.getSharedPreferences(pref, Context.MODE_PRIVATE);
        spEditor= spref.edit();
        this.activity = (Activity) this.context;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private SharedPreferences.Editor Editor() {
        return spEditor;
    }

    private SharedPreferences Shared(){
        return spref;
    }

    public <T> void saveData(String call, List<T> model)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        Editor().putString(call,jsonString);
        Editor().apply();
    }

    public List<ListScore> loadListScore(){
        Gson gson = new Gson();
        String json = Shared().getString(score,"");
        Type type = new TypeToken<List<ListScore>>(){}.getType();
        List<ListScore> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListStandings> loadListStandings(){
        Gson gson = new Gson();
        String json = Shared().getString(standing,"");
        Type type = new TypeToken<List<ListStandings>>(){}.getType();
        List<ListStandings> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListVideo> loadListVideo(){
        Gson gson = new Gson();
        String json = Shared().getString(video,"");
        Type type = new TypeToken<List<ListVideo>>(){}.getType();
        List<ListVideo> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListTeams> loadListTeams(){
        Gson gson = new Gson();
        String json = Shared().getString(teams,"");
        Type type = new TypeToken<List<ListTeams>>(){}.getType();
        List<ListTeams> model = gson.fromJson(json,type);
        return model;
    }

    public List<ListBansa> loadListBansa(){
        Gson gson = new Gson();
        String json = Shared().getString(bansa,"");
        Type type = new TypeToken<List<ListBansa>>(){}.getType();
        List<ListBansa> model = gson.fromJson(json,type);
        return model;
    }

    /*public List<ListLiga> loadListLiga(){
        Gson gson = new Gson();
        String json = Shared().getString(liga,"");
        Type type = new TypeToken<List<ListLiga>>(){}.getType();
        List<ListLiga> model = gson.fromJson(json,type);
        return model;
    }*/

    public void clearData()
    {
        spref.edit().clear().apply();
        spref.edit().apply();
    }
    
        public void loadScore()
        {
            rfit =  new Retrocall();
            Call<List<ListScore>> call = rfit.retrofitBuilder().getScore("get_events","2020-10-01","2020-10-03","148",Retrocall.APIKEY);
            call.enqueue(new Callback<List<ListScore>>() {
                @Override
                public void onResponse(Call<List<ListScore>> call, Response<List<ListScore>> response) {
                    List<ListScore> scorelist = response.body();
                    saveData(score,scorelist);
                    System.out.println("BONGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    //      Toast.makeText(activity,score,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListScore>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadTeams()
        {
            rfit =  new Retrocall();
            Call<List<ListTeams>> call = rfit.retrofitBuilder().getTeam("get_teams","148",Retrocall.APIKEY);
            call.enqueue(new Callback<List<ListTeams>>() {
                @Override
                public void onResponse(Call<List<ListTeams>> call, Response<List<ListTeams>> response) {
                    List<ListTeams> teamlist = response.body();
                    saveData(teams,teamlist);
                    System.out.println("BONGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                     //      Toast.makeText(activity,teams,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListTeams>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadStandings()
        {
            rfit =  new Retrocall();
            Call<List<ListStandings>> call = rfit.retrofitBuilder().getStandings("get_standings","148",Retrocall.APIKEY);
            call.enqueue(new Callback<List<ListStandings>>() {
                @Override
                public void onResponse(Call<List<ListStandings>> call, Response<List<ListStandings>> response) {
                    List<ListStandings> stands = response.body();
                    saveData(standing,stands);
                    System.out.println("BONGIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
                     //      Toast.makeText(activity,standing,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListStandings>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadVideo()
        {
            rfit =  new Retrocall();
            Call<List<ListVideo>> call = rfit.retrofitVideo().getVideo();
            call.enqueue(new Callback<List<ListVideo>>() {
                @Override
                public void onResponse(Call<List<ListVideo>> call, Response<List<ListVideo>> response) {
                    List<ListVideo> vid = response.body();
                    saveData(video,vid);
                    System.out.println("BONG000000000000000000000000000000000000000000000000000000000000");
                       //    Toast.makeText(activity,video,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListVideo>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadBansa()
        {
            rfit =  new Retrocall();
            Call<List<ListBansa>> call = rfit.retrofitBuilder().getBansa("get_countries",Retrocall.APIKEY);
            call.enqueue(new Callback<List<ListBansa>>() {
                @Override
                public void onResponse(Call<List<ListBansa>> call, Response<List<ListBansa>> response) {
                    List<ListBansa> ban = response.body();
                    saveData(bansa,ban);
                    System.out.println("BONGUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
                       //    Toast.makeText(activity,bansa,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListBansa>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

       /* public void loadLiga()
        {

            rfit =  new Retrocall();
            Call<List<ListLiga>> call = rfit.retrofitBuilder().getLeague("get_leagues","",Retrocall.APIKEY);
            call.enqueue(new Callback<List<ListLiga>>() {
                @Override
                public void onResponse(Call<List<ListLiga>> call, Response<List<ListLiga>> response) {
                    List<ListLiga> league = response.body();
                    saveData(liga,league);
                    System.out.println("BONGAAAAAAAAAAAAAAAAAAAAAAAAAAOOOOOOOOUUUUUUUUUUUUUUUUUUUUUU");
                    //       Toast.makeText(activity,teams,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<ListLiga>> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }*/
}
