package com.example.odev6.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6.databinding.CardTasarimKampanyaBinding;
import com.example.odev6.entity.Service;

import java.util.List;

public class KampanyaAdapter extends RecyclerView.Adapter<KampanyaAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Service> serviceList;

    public KampanyaAdapter(Context mContext, List<Service> serviceList) {
        this.mContext = mContext;
        this.serviceList = serviceList;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        public CardTasarimKampanyaBinding cardTasarimKampanyaBinding;

        public CardTasarimTutucu( CardTasarimKampanyaBinding cardTasarimKampanyaBinding) {
            super(cardTasarimKampanyaBinding.getRoot());
            this.cardTasarimKampanyaBinding = cardTasarimKampanyaBinding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimKampanyaBinding binding = CardTasarimKampanyaBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Service service = serviceList.get(position);
        CardTasarimKampanyaBinding t = holder.cardTasarimKampanyaBinding;

        t.ivKampanyaServiceImage.setImageResource(mContext.getResources().getIdentifier(service.getResim_ad(),"drawable",mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }


}
