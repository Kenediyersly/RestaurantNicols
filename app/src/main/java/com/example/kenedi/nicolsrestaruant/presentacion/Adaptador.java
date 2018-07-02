package com.example.kenedi.nicolsrestaruant.presentacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kenedi.nicolsrestaruant.R;
import com.example.kenedi.nicolsrestaruant.aplicacion.Plato;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.platosHolder>{

    List<Plato> platos;
    public Context context;
    public Adaptador(List<Plato> platos) {
    }
    public Adaptador (Context context){

    }

    @NonNull
    @Override
    public platosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        platosHolder holder =new platosHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull platosHolder holder, int position) {
        Plato plato = platos.get(position);
        String presio2 = String.valueOf(plato.getPresio());
        String url = plato.getImagen();

        Picasso.with(context)
                .load(url)
                .error(R.drawable.ic_favorite)
                .fit()
                .centerInside()
                .into(holder.imagen);
        holder.nombre.setText(plato.getNombre());
        holder.presio.setText(presio2);
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public static class platosHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre, presio;


        public platosHolder(View itemView) {
            super(itemView);
            imagen =(ImageView) itemView.findViewById(R.id.card_image);
            nombre= itemView.findViewById(R.id.card_title);
            presio= itemView.findViewById(R.id.card_text);
        }
    }
}
