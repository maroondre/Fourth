package com.example.fourth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth.Classes.Liga;
import com.example.fourth.ListModels.ListBansa;
import com.football.match.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.security.PrivateKey;
import java.util.List;

public class BansaAdapter extends RecyclerView.Adapter<BansaAdapter.ViewHolder> {

    private Context context;
    private List<ListBansa> llb;
    private ListBansa lb;
    public static String countryid;

    public BansaAdapter(Context context, List llb)
    {
        this.context = context;
        this.llb = llb;
    }

    @NonNull
    @Override
    public BansaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentbansa, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(llb.get(position));
        lb = llb.get(position);

        holder.country.setText(lb.getCountryName());
        //countryid = lb.getCountryId().toString();
        // Code ni Ivan at ni Mark
            if(llb.get(position).getCountryLogo().equals(""))
            {
                holder.img.setImageResource(R.drawable.sync_problem);
            }
            else{
                Picasso.get().load(llb.get(position).getCountryLogo()).into(holder.img, new Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(Exception e) {
                    holder.img.setImageResource(R.drawable.sync_problem);
                }
            });
        }
        // Code ni Ivan at ni Mark

    }

    @Override
    public int getItemCount() {
        return llb.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView country;
        ImageView img;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.country);
            img = itemView.findViewById(R.id.imageView);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0 ; i<llb.size();i++ ){
                        if(country.getText() == llb.get(i).getCountryName()){
                            countryid = llb.get(i).getCountryId().toString();
                            break;
                        }

                    }
                    Intent intent = new Intent(v.getContext(), Liga.class);
                    intent.putExtra("id", countryid);
                    context.startActivity(intent);
                }
            });*/
        }
    }
}
