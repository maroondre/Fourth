package com.example.fourth.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fourth.Adapter.ScoreAdapter;
import com.example.fourth.Adapter.StandingAdapter;
import com.example.fourth.Connections.Calls;
import com.example.fourth.ListModels.ListScore;
import com.example.fourth.ListModels.ListStandings;
import com.example.fourth.ListModels.ListTeams;
import com.example.fourth.ListModels.ListVideo;
import com.football.match.R;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Standings extends Fragment {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListScore> lsm;
    private ProgressDialog pdLoading;
    public List<String> llvpics = new ArrayList<>();
    private CarouselView carouselView;

    View view;
    Calls call;
    HashMap<String,String> llt;
    CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_standings, container, false);
        getActivity().setTitle("Standings");
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
                if(call.loadListStandings() == null || call.loadListVideo() == null){
                    loop();
                }else{
                    cardView();
                    showPics();
                    getStandings();
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
        call.loadStandings();
        call.loadVideo();
        llt = new HashMap<>();
        carouselView = view.findViewById(R.id.carousel);
        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = (RecyclerView) view.findViewById(R.id.standView);
        // rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);

    }

    public HashMap<String, String> getLlt(){return llt;}

    public void setLlt(String teamId, String logo){this.llt.put(teamId,logo);}

    public void Logo()
    {
        List<ListTeams> teamModel = call.loadListTeams();
        for(int i=0; i<teamModel.size(); i++){
            // team[i] = teamList.get(i).getName();
            setLlt(teamModel.get(i).getTeamKey()
                    ,teamModel.get(i).getTeamBadge());
        }
        getStandings();
    }

    private void getStandings()
    {
        List<ListStandings> newsModel = call.loadListStandings();
        rvAdapter = new StandingAdapter(getActivity(), newsModel);
        rView.setAdapter(rvAdapter);

    }

    private void cardView()
    {
        List<ListVideo> pics = call.loadListVideo();
        for(int i = 0; i<pics.size(); i++){
            addItem(pics.get(i).getThumbnail());
        }
        rvAdapter = new StandingAdapter(getActivity(), pics);
        rView.setAdapter(rvAdapter);
    }

    public void showPics()
    {
        System.out.println(llvpics.toString());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + llvpics.size());

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<String> imageListTitle = new ArrayList<String>();
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
                //imageView.setImageResource(imagelist[position]);
                Picasso.get().load(imageListTitle.get(position)).into(imageView);
            }
        });
        carouselView.setPageCount(llvpics.size());
    }

    public void addItem(String pics)
    {
        llvpics.add(pics);
    }
}