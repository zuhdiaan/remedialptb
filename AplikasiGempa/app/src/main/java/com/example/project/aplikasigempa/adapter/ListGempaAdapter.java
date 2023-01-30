package com.example.project.aplikasigempa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.aplikasigempa.R;
import com.example.project.aplikasigempa.model.FeatureModel;

import java.util.ArrayList;

public class ListGempaAdapter extends RecyclerView.Adapter<ListGempaAdapter.ListGempaViewHolder> {
    private ArrayList<FeatureModel> listFeature;

    public ListGempaAdapter(ArrayList<FeatureModel> listFeature){
        this.listFeature = listFeature;
    }

    @NonNull
    @Override
    public ListGempaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_list_gempa, parent,false);
        return new ListGempaAdapter.ListGempaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListGempaViewHolder holder, int position) {
        FeatureModel feature = listFeature.get(position);
        System.out.println("data : " + listFeature.get(position).getId());


        holder.tvLokasi.setText(feature.getProperties().getPlace());
        holder.tvTanggal.setText(feature.getProperties().getTime().toString());
        holder.tvSkala.setText(feature.getProperties().getMag().toString());
    }

    @Override
    public int getItemCount() {
        return listFeature.size() > 0 ? listFeature.size() : 0;
    }

    public class ListGempaViewHolder extends RecyclerView.ViewHolder{
        TextView tvLokasi, tvTanggal, tvSkala;

        public ListGempaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLokasi = itemView.findViewById(R.id.tv_lokasi);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvSkala = itemView.findViewById(R.id.tv_skala);
        }
    }
}
