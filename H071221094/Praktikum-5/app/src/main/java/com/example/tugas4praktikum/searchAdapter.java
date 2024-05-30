package com.example.tugas4praktikum;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder> {
    private final ArrayList<User>searchs;

    public searchAdapter(ArrayList<User> searchs) {
        this.searchs = searchs;
    }

    @NonNull
    @Override
    public searchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_searching,parent,false);
        return new searchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull searchAdapter.ViewHolder holder, int position) {
        User user2 = searchs.get(position);

        holder.fotoProfilSearchAkun.setImageResource(user2.getProfil());
        holder.namaAkunSearchAkun.setText(user2.getNamaAkun());
        holder.userNameSearchAkun.setText(user2.getNamaUser());
        holder.searh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, AkunPostinganActivity.class);
                intent.putExtra(AkunPostinganActivity.FRAGCOUNT, user2);
                holder.itemView.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return searchs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoProfilSearchAkun;
        TextView namaAkunSearchAkun, userNameSearchAkun;
        CardView searh_card;

        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoProfilSearchAkun = itemView.findViewById(R.id.fotoProfilSearch);
            namaAkunSearchAkun = itemView.findViewById(R.id.namaAkunSearch);
            userNameSearchAkun = itemView.findViewById(R.id.usernameSearch);
            searh_card = itemView.findViewById(R.id.card_search);
            context = itemView.getContext();

        }
    }
}
