package com.example.odev6.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6.databinding.CardTasarimServisBinding;
import com.example.odev6.entity.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Service> serviceList;

    public ServiceAdapter(Context mContext, List<Service> serviceList) {
        this.mContext = mContext;
        this.serviceList = serviceList;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimServisBinding servisBinding;

        public CardTasarimTutucu( CardTasarimServisBinding servisBinding) {
            super(servisBinding.getRoot());
            this.servisBinding = servisBinding;
        }
    }

    @NonNull
    @Override
    public ServiceAdapter.CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimServisBinding binding = CardTasarimServisBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.CardTasarimTutucu holder, int position) {
        Service service = serviceList.get(position);
        CardTasarimServisBinding t = holder.servisBinding;

        t.ivServiceImage.setImageResource(mContext.getResources().getIdentifier(service.getResim_ad(),"drawable",mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }
}
