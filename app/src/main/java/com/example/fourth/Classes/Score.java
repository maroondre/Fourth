package com.example.fourth.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fourth.Adapter.ScoreAdapter;
import com.example.fourth.Connections.Calls;
import com.example.fourth.Connections.Retrocall;
import com.example.fourth.ListModels.ListScore;
import com.football.match.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Score extends Fragment {
    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListScore> lsm;
    private ProgressDialog pdLoading;
    View view;
    Calls call;
    CountDownTimer countDownTimer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_score, container, false);
        getActivity().setTitle("Match Score");

        declare();
        loop();
        return view;
    }

        public void startTimer(){
            countDownTimer = new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    if(call.loadListScore() == null){
                        loop();
                    }else{
                        getData();
                        pdLoading.dismiss();
                    }
                }
            }.start();
        }
        public void loop(){
            startTimer();
        }

    private void declare()
    {
        call = new Calls(getActivity());

        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = (RecyclerView) view.findViewById(R.id.scoreView);
        // rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);

    }


    private void getData()
    {
        List<ListScore> newsModel = call.loadListScore();
        rvAdapter = new ScoreAdapter(getActivity(), newsModel);
        rView.setAdapter(rvAdapter);

    }
    
    private void getScore()
    {

        Retrocall rfit = new Retrocall();
        rfit.retrofitBuilder();

        Call<List<ListScore>> call = rfit.retrofitBuilder().getScore("get_events","2020-10-01","2020-10-03","148",Retrocall.APIKEY);
        call.enqueue(new Callback<List<ListScore>>() {
            @Override
            public void onResponse(Call<List<ListScore>> call, Response<List<ListScore>> response) {
                List<ListScore> teamList = response.body();

                //  String[] team = new String[teamList.size()];
                lsm =  new ArrayList<>();

                for(int i=0; i<teamList.size(); i++){
                    // team[i] = teamList.get(i).getName();
                    lsm.add(new ListScore(teamList.get(i).getCountryName()
                            ,teamList.get(i).getLeagueId()
                            ,teamList.get(i).getLeagueName()
                            ,teamList.get(i).getMatchDate()
                            ,teamList.get(i).getMatchStatus()
                            ,teamList.get(i).getMatchTime()
                            ,teamList.get(i).getMatchHometeamId()
                            ,teamList.get(i).getMatchHometeamName()
                            ,teamList.get(i).getMatchHometeamScore()
                            ,teamList.get(i).getMatchAwayteamName()
                            ,teamList.get(i).getMatchAwayteamId()
                            ,teamList.get(i).getMatchAwayteamScore()
                            ,teamList.get(i).getTeamHomeBadge()
                            ,teamList.get(i).getTeamAwayBadge()
                            ,teamList.get(i).getLeagueLogo()
                            ,teamList.get(i).getCountryLogo()));
                    //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                    rvAdapter = new ScoreAdapter(getActivity(), lsm);
                    rView.setAdapter(rvAdapter);
                    pdLoading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<ListScore>> call, Throwable t) {

            }
        });
    }


}