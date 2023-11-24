package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.databinding.FragmentAnasayfaBinding;
import com.example.odev6.databinding.FragmentIcerikBinding;


public class IcerikFragment extends Fragment {
    private FragmentIcerikBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentIcerikBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}