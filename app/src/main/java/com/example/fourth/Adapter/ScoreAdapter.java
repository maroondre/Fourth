package com.example.fourth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth.ListModels.ListScore;
import com.football.match.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    private Context context;
    private List<ListScore> lsm;
    ListScore sm;

    public ScoreAdapter(Context context, List lsm)
    {
        this.context = context;
        this.lsm = lsm;
    }

    @NonNull
    @Override
    public ScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentscore, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lsm.get(position));
        sm = lsm.get(position);

        holder.country.setText(sm.getCountryName());
        holder.league.setText(sm.getLeagueName());
        holder.date.setText(sm.getMatchDate());
        holder.status.setText(sm.getMatchStatus());
       // holder.time.setText(sm.getMatchTime());
        holder.home.setText(sm.getMatchHometeamName());
        holder.away.setText(sm.getMatchAwayteamName());
        holder.homeScore.setText(sm.getMatchHometeamScore());
        holder.awayScore.setText(sm.getMatchAwayteamScore());
        Picasso.get().load(lsm.get(position).getTeamHomeBadge()).into(holder.homeImg);
        Picasso.get().load(lsm.get(position).getTeamAwayBadge()).into(holder.awayImg);
        Picasso.get().load(lsm.get(position).getCountryLogo()).into(holder.countryImg);
        
        
    }

    @Override
    public int getItemCount() {
        return lsm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView country,league,date,status,time, home, away, homeScore, awayScore;
            public ImageView homeImg, awayImg, countryImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            country = itemView.findViewById(R.id.country);
            league = itemView.findViewById(R.id.league);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
            home = itemView.findViewById(R.id.home);
            away = itemView.findViewById(R.id.away);
            homeScore = itemView.findViewById(R.id.homeScore);
            awayScore = itemView.findViewById(R.id.awayScore);
            homeImg = itemView.findViewById(R.id.homeImg);
            awayImg = itemView.findViewById(R.id.awayImg);
            countryImg = itemView.findViewById(R.id.countryImg);

        }
    }
}
