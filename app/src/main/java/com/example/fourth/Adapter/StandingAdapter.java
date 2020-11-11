package com.example.fourth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth.ListModels.ListStandings;
import com.football.match.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingAdapter extends RecyclerView.Adapter<StandingAdapter.ViewHolder> {

    private Context context;
    public static List<ListStandings> lls;
    private ListStandings ls;

    public StandingAdapter(Context context, List lls)
    {
        this.context =  context;
        this.lls = lls;
    }

    @NonNull
    @Override
    public StandingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentstandings, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StandingAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lls.get(position));
        ls=lls.get(position);

        holder.name.setText(ls.getTeamName());
        holder.rank.setText(ls.getOverallLeaguePosition());
        holder.games.setText(ls.getOverallLeaguePayed());
        holder.win.setText(ls.getOverallLeagueW());
        holder.draw.setText(ls.getOverallLeagueD());
        holder.loss.setText(ls.getOverallLeagueL());
        holder.pts.setText(ls.getOverallLeaguePTS());
        Picasso.get().load(lls.get(position).getTeam_badge()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return lls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,rank,games,win,draw,loss,pts;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.team_name);
            rank = itemView.findViewById(R.id.position);
            games = itemView.findViewById(R.id.game);
            win = itemView.findViewById(R.id.wins);
            draw = itemView.findViewById(R.id.draw);
            loss = itemView.findViewById(R.id.loss);
            pts = itemView.findViewById(R.id.pts);
            img = itemView.findViewById(R.id.idlogo);

        }
    }
}
