package com.example.samsung.reservpark.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsung.reservpark.R;
import com.example.samsung.reservpark.models.Park;


import java.util.List;


public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParksViewHolder> {
    public List<Park> parks;
    public Context context;

    public ParkAdapter(List<Park> parks, Context context) {
        this.parks= parks;this.context = context;
    }

    @Override
    public ParkAdapter.ParksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_parks, parent, false);
        ParksViewHolder parksViewHolder = new ParksViewHolder(cardview);
        return parksViewHolder;
    }

    @Override
    public void onBindViewHolder(ParkAdapter.ParksViewHolder holder, int position) {
        holder.nombre.setText(parks.get(position).getName());
        holder.direccion.setText(parks.get(position).getAddress());
        holder.cupo.setText(String.valueOf(parks.get(position).getQuota()));
        holder.tarifa.setText(String.valueOf(parks.get(position).getTariff()));
        holder.horario.setText(parks.get(position).getHorary());
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    public class ParksViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView direccion;
        TextView cupo;
        TextView tarifa;
        TextView horario;
        CardView parksCard;

        public ParksViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.cvNombre);
            direccion = itemView.findViewById(R.id.cvDireccion);
            cupo = itemView.findViewById(R.id.cvCupo);
            tarifa = itemView.findViewById(R.id.cvTarifa);
            horario = itemView.findViewById(R.id.cvHorario);
            parksCard= itemView.findViewById(R.id.personasCard);
        }
    }
}

