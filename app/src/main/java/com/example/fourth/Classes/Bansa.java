package com.example.fourth.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fourth.Adapter.BansaAdapter;
import com.example.fourth.Adapter.StandingAdapter;
import com.example.fourth.Connections.Calls;
import com.example.fourth.ListModels.ListBansa;
import com.example.fourth.ListModels.ListScore;
import com.example.fourth.ListModels.ListStandings;
import com.football.match.R;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bansa extends Fragment {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private GridLayoutManager rvLayout;
    private List<ListScore> lsm;
    private ProgressDialog pdLoading;
    public ArrayList<String> llvpics = new ArrayList<>();

    View view;
    Calls call;
    CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_bansa, container, false);
        getActivity().setTitle("Country League");

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
                if(call.loadListBansa() == null){
                    loop();
                }else{
                    getBansa();
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
        rView = (RecyclerView) view.findViewById(R.id.bansaView);
        // rView.setHasFixedSize(true);
        rvLayout = new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL,false);
        rView.setLayoutManager(rvLayout);

    }

    private void getBansa()
    {
        List<ListBansa> bansaModel = call.loadListBansa();
        rvAdapter = new BansaAdapter(getActivity(), bansaModel);
        rView.setAdapter(rvAdapter);

    }


}