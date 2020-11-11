package com.example.fourth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth.ListModels.ListLiga;
import com.football.match.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LigaAdapter extends RecyclerView.Adapter<LigaAdapter.ViewHolder> {

    private Context context;
    private List<ListLiga> lliga;
    private ListLiga liga;

    public LigaAdapter(Context context, List lliga)
    {
        this.context = context;
        this.lliga = lliga;
    }

    @NonNull
    @Override
    public LigaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentliga, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LigaAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lliga.get(position));
        liga = lliga.get(position);

        holder.countryname.setText(liga.getCountryName());
        holder.leaguename.setText(liga.getLeagueName());
        holder.season.setText(liga.getLeagueSeason());
        if(!lliga.get(position).getLeagueLogo().equals(""))
        {
            Picasso.get().load(liga.getLeagueLogo()).into(holder.leagueImg);
        }

    }

    @Override
    public int getItemCount() {
        return lliga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView countryname, leaguename, season;
        ImageView leagueImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryname = itemView.findViewById(R.id.countryname);
            leaguename = itemView.findViewById(R.id.leagueName);
            season = itemView.findViewById(R.id.season);
            leagueImg = itemView.findViewById(R.id.leagueId);

        }
    }
}
