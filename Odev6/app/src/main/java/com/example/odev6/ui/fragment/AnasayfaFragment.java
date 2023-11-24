package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.databinding.FragmentAnasayfaBinding;
import com.example.odev6.entity.Service;
import com.example.odev6.ui.adapter.BigServiceAdapter;
import com.example.odev6.ui.adapter.KampanyaAdapter;
import com.example.odev6.ui.adapter.ServiceAdapter;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;

    ArrayList<Service> service;
    ArrayList<Service> kampanya;
    ArrayList<Service> bigService;

    BigServiceAdapter bigServiceAdapter;
    KampanyaAdapter kampanyaAdapter;
    ServiceAdapter serviceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);

        binding.kampanyaRv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<Service> serviceKampanyaArrayList = new ArrayList<>();
        Service kampanya3 = new Service(1,"Kampanya Sıra 1","muthis");
        Service kampanya = new Service(2,"Kampanya Sıra 2","kampanya");
        Service kampanya1 = new Service(3,"Kampanya Sıra 3","kampanya1");
        Service kampanya2 = new Service(4,"Kampanya Sıra 4","kampanya2");
        serviceKampanyaArrayList.add(kampanya3);
        serviceKampanyaArrayList.add(kampanya);
        serviceKampanyaArrayList.add(kampanya1);
        serviceKampanyaArrayList.add(kampanya2);

        KampanyaAdapter kampanyaAdapter1 = new KampanyaAdapter(requireContext(),serviceKampanyaArrayList);
        binding.kampanyaRv.setAdapter(kampanyaAdapter1);

        binding.serviceRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ArrayList<Service> serviceArrayList = new ArrayList<>();
        Service sanalMarket = new Service(1,"Service Sıra 1","sanalmarket");
        Service migrosHemen= new Service(2,"Service Sıra 2","hemen");
        Service migrosYemek = new Service(3,"Service Sıra 3","yemek");
        Service tazeDirek = new Service(4,"Service Sıra 4","tazedirekt");
        Service macroOnline = new Service(5,"Service Sıra 5","macroonline");
        Service migrosEkstra = new Service(6,"Service Sıra 6","ekstra");
        serviceArrayList.add(sanalMarket);
        serviceArrayList.add(migrosHemen);
        serviceArrayList.add(migrosYemek);
        serviceArrayList.add(tazeDirek);
        serviceArrayList.add(macroOnline);
        serviceArrayList.add(migrosEkstra);

        ServiceAdapter serviceAdapter1 = new ServiceAdapter(requireContext(),serviceArrayList);
        binding.serviceRv.setAdapter(serviceAdapter1);

        binding.bigServiceRv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        ArrayList<Service> bigServiceArrayList = new ArrayList<>();
        Service mion = new Service(1,"Big Service Sıra 1","mion");
        bigServiceArrayList.add(mion);
        BigServiceAdapter bigServiceAdapter1 = new BigServiceAdapter(requireContext(),bigServiceArrayList);
        binding.bigServiceRv.setAdapter(bigServiceAdapter1);


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return binding.getRoot();


    }
}