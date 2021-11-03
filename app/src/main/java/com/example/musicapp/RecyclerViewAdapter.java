package com.example.musicapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.APP.list;
import com.example.musicapp.APP.musica;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<musica> array_incidencies;
    private list context;

    public RecyclerViewAdapter(list con, ArrayList<musica> arrI){
        array_incidencies = arrI;
        context = con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_incidencies.get(position).gettitulo());
        holder.prioritat.setText(array_incidencies.get(position).getartista());
    }

    @Override
    public int getItemCount() {
        return array_incidencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom,prioritat;
        ConstraintLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.itemListTitulo);
            layout = itemView.findViewById(R.id.layout);
            prioritat = itemView.findViewById(R.id.itemListArtista);
        }
    }
}