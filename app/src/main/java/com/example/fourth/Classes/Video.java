package com.example.fourth.Classes;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.fourth.Adapter.LigaAdapter;
import com.example.fourth.Adapter.ScoreAdapter;
import com.example.fourth.Adapter.VideoAdapter;
import com.example.fourth.Connections.ApiCall;
import com.example.fourth.Connections.Calls;
import com.example.fourth.Connections.Retrocall;
import com.example.fourth.ListModels.ListLiga;
import com.example.fourth.ListModels.ListVideo;
import com.football.match.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Video extends Fragment {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private ProgressDialog pdLoading;
    private List<ListVideo> llp;
    private View view;
    Calls calls;
    CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_video, container, false);
        getActivity().setTitle("Live Football Matches");

            declare();
            video();
        return view;

    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(calls.loadListVideo() == null){
                    loop();
                }else{
                    getVideo();
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
        calls = new Calls(getActivity());
        calls.loadVideo();
        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = (RecyclerView) view.findViewById(R.id.vView);
//      rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
    }

    private void getVideo()
    {
        List<ListVideo> vidModel = calls.loadListVideo();
        rvAdapter = new VideoAdapter(getActivity(), vidModel);
        rView.setAdapter(rvAdapter);
    }

    public void video()
    {
        Retrocall rfit = new Retrocall();
        rfit.retrofitBuilder();

        Call<List<ListVideo>> call = rfit.retrofitVideo().getVideo();
        call.enqueue(new Callback<List<ListVideo>>() {
            @Override
            public void onResponse(Call<List<ListVideo>> call, Response<List<ListVideo>> response) {
                List<ListVideo> video = response.body();

                llp =  new ArrayList<>();

                //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                rvAdapter = new VideoAdapter(getActivity(), video);
                rView.setAdapter(rvAdapter);
                pdLoading.dismiss();

            }
            @Override
            public void onFailure(Call<List<ListVideo>> call, Throwable t) {

            }
        });
    }

}