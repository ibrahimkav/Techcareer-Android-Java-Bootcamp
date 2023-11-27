package com.example.odev7todoapp.ui.fragment.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.example.odev7todoapp.R;
import com.example.odev7todoapp.databinding.FragmentListBinding;
import com.example.odev7todoapp.ui.fragment.list.adapter.ListAdapter;
import com.example.odev7todoapp.ui.viewModel.ListViewModel;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentListBinding binding;
    private ListViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        initRecyclerView();
        initObservers();
        initFab();
        setupToolbarMenu();
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void initRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private void initObservers() {
        viewModel.toDoList.observe(getViewLifecycleOwner(), toDos -> {
            ListAdapter listAdapter = new ListAdapter(toDos, requireContext(), viewModel);
            binding.recyclerView.setAdapter(listAdapter);
        });
    }

    private void initFab() {
        binding.floatingActionButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_listFragment_to_addFragment)
        );
    }

    private void setupToolbarMenu() {
        binding.toolbar.inflateMenu(R.menu.list_fragment_menu);
        MenuItem searchMenuItem = binding.toolbar.getMenu().findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.search(newText);
        return true;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menuDeleteAll) {
            viewModel.deleteAll();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ListViewModel.class);
    }
}
