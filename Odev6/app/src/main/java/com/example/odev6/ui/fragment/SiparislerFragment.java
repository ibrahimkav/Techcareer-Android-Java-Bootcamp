package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.databinding.FragmentSiparislerBinding;


public class SiparislerFragment extends Fragment {

   private FragmentSiparislerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSiparislerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}