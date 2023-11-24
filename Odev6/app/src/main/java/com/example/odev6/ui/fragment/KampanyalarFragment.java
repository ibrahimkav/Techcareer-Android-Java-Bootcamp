package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.databinding.FragmentKampanyalarBinding;


public class KampanyalarFragment extends Fragment {
    private FragmentKampanyalarBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentKampanyalarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}