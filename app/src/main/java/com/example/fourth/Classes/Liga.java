package com.example.fourth.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fourth.Adapter.BansaAdapter;
import com.example.fourth.Adapter.LigaAdapter;
import com.example.fourth.Connections.Calls;
import com.example.fourth.Connections.Retrocall;
import com.example.fourth.ListModels.ListBansa;
import com.example.fourth.ListModels.ListLiga;
import com.example.fourth.ListModels.ListScore;
import com.football.match.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.fourth.Connections.Calls.liga;

public class Liga extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private List<ListLiga> liga;
    private ProgressDialog pdLoading;
    String countryid;
    View view;
    Calls call;
    CountDownTimer countDownTimer;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liga);
        getSupportActionBar().setTitle("Team Website");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        declare();
        loadLigas();
        pdLoading.dismiss();
    }

    private void declare()
    {
        countryid = getIntent().getStringExtra("id");
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        rView = (RecyclerView) findViewById(R.id.ligaView);
        // rView.setHasFixedSize(true);
        rvLayout = new LinearLayoutManager(this);
        rView.setLayoutManager(rvLayout);

    }

    public void loadLigas()
    {
        Retrocall rfit = new Retrocall();
        rfit.retrofitBuilder();

        Call<List<ListLiga>> call = rfit.retrofitBuilder().getLeague("get_leagues",String.valueOf(countryid),Retrocall.APIKEY);
        call.enqueue(new Callback<List<ListLiga>>() {
            @Override
            public void onResponse(Call<List<ListLiga>> call, Response<List<ListLiga>> response) {
                List<ListLiga> ligaList = response.body();

                liga =  new ArrayList<>();

                //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                rvAdapter = new LigaAdapter(Liga.this, ligaList);
                rView.setAdapter(rvAdapter);


            }
            @Override
            public void onFailure(Call<List<ListLiga>> call, Throwable t) {

            }
        });
    }
}