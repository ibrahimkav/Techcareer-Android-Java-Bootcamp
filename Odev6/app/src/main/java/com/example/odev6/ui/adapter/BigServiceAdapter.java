package com.example.odev6.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6.databinding.CardTasarimBigServisBinding;
import com.example.odev6.databinding.CardTasarimServisBinding;
import com.example.odev6.entity.Service;

import java.util.List;

public class BigServiceAdapter extends RecyclerView.Adapter<BigServiceAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Service> serviceList;

    public BigServiceAdapter(Context mContext, List<Service> serviceList) {
        this.mContext = mContext;
        this.serviceList = serviceList;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBigServisBinding bigServisBinding;

        public CardTasarimTutucu( CardTasarimBigServisBinding bigServisBinding) {
            super(bigServisBinding.getRoot());
            this.bigServisBinding = bigServisBinding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBigServisBinding binding = CardTasarimBigServisBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Service service = serviceList.get(position);
        CardTasarimBigServisBinding t = holder.bigServisBinding;

        t.ivBigServiceImage.setImageResource(mContext.getResources().getIdentifier(service.getResim_ad(),"drawable",mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }


}
