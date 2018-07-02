package com.example.kenedi.nicolsrestaruant.presentacion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.kenedi.nicolsrestaruant.R;
import com.example.kenedi.nicolsrestaruant.aplicacion.Plato;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import static com.example.kenedi.nicolsrestaruant.basededatos.Instancias.DATABASE;

public class CardContentFragment extends Fragment {

    RecyclerView rv;
    List<Plato> platos;
    Adapter adapter1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rv = container.findViewById(R.id.my_recycler_view);


        platos = new ArrayList<>();
        adapter1 = (Adapter) new Adaptador(platos);
        rv.setAdapter((RecyclerView.Adapter) adapter1);
        DATABASE.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                platos.removeAll(platos);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Plato plato = snapshot.getValue(Plato.class);
                    platos.add(plato);
                }
                ((RecyclerView.Adapter) adapter1).notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return rv;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity2.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            // Adding Snackbar to Action Button inside card
            Button button = (Button)itemView.findViewById(R.id.action_button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Action is pressed",
                            Snackbar.LENGTH_LONG).show();
                }
            });

            ImageButton favoriteImageButton =
                    (ImageButton) itemView.findViewById(R.id.favorite_button);
            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Added to Favorite",
                            Snackbar.LENGTH_LONG).show();
                }
            });

            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
            shareImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Share article",
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }

}
