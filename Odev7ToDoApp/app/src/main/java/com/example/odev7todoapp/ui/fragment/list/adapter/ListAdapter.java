package com.example.odev7todoapp.ui.fragment.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev7todoapp.R;
import com.example.odev7todoapp.data.entity.ToDo;
import com.example.odev7todoapp.databinding.RowLayoutBinding;
import com.example.odev7todoapp.ui.fragment.list.ListFragmentDirections;
import com.example.odev7todoapp.ui.viewModel.ListViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private List<ToDo> toDoList;
    private ListViewModel viewModel;

    public ListAdapter(List<ToDo> toDoList, Context context, ListViewModel viewModel) {
        this.toDoList = toDoList;
        this.viewModel = viewModel;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RowLayoutBinding binding;

        public MyHolder(RowLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.cardView.setOnClickListener(this);
            binding.ivDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                ToDo toDo = toDoList.get(position);
                handleItemClick(v, toDo);
            }
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutBinding binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ToDo toDo = toDoList.get(position);
        RowLayoutBinding binding = holder.binding;
        binding.tvToDo.setText(toDo.getName());
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    private void handleItemClick(View v, ToDo toDo) {
        if (v.getId() == R.id.cardView) {
            navigateToUpdateFragment(v, toDo);
        } else if (v.getId() == R.id.ivDelete) {
            showDeleteConfirmationSnackbar(v, toDo);
        }
    }

    private void navigateToUpdateFragment(View v, ToDo toDo) {
        ListFragmentDirections.ActionListFragmentToUpdateFragment action =
                ListFragmentDirections.actionListFragmentToUpdateFragment(toDo);
        Navigation.findNavController(v).navigate(action);
    }

    private void showDeleteConfirmationSnackbar(View v, ToDo toDo) {
        Snackbar.make(v, toDo.getName() + " silinsin mi", Snackbar.LENGTH_SHORT)
                .setAction("evet", v1 -> viewModel.deleteItem(toDo.getId()))
                .show();
    }
}

