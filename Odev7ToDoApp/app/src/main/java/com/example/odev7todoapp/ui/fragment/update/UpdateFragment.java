package com.example.odev7todoapp.ui.fragment.update;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.example.odev7todoapp.R;
import com.example.odev7todoapp.data.entity.ToDo;
import com.example.odev7todoapp.databinding.FragmentUpdateBinding;
import com.example.odev7todoapp.ui.viewModel.UpdateViewModel;
import com.google.android.material.snackbar.Snackbar;
import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class UpdateFragment extends Fragment {

    private FragmentUpdateBinding binding;
    private UpdateViewModel viewModel;
    private ToDo toDo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUpdateBinding.inflate(inflater, container, false);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        UpdateFragmentArgs bundle = UpdateFragmentArgs.fromBundle(getArguments());
        toDo = bundle.getToDo();
        binding.etDescriptionUpdate.setText(toDo.getName());

        binding.btnUpdate.setOnClickListener(v -> {
            String toDoName = binding.etDescriptionUpdate.getText().toString();
            viewModel.updateData(toDo.getId(), toDoName);
            navigateToListFragment();
        });

        setupToolbarMenu();
    }

    private void setupToolbarMenu() {
        binding.toolbar.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.update_fragment_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                handleMenuItemSelected(menuItem);
                return true;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }

    private void handleMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menuDelete) {
            showDeleteConfirmationSnackbar();
        }
    }

    private void showDeleteConfirmationSnackbar() {
        Snackbar.make(binding.toolbar, toDo.getName() + " silinsin mi", Snackbar.LENGTH_SHORT)
                .setAction("evet", v1 -> {
                    viewModel.deleteItem(toDo.getId());
                    navigateToListFragment();
                })
                .show();
    }

    private void navigateToListFragment() {
        Navigation.findNavController(requireView()).navigateUp();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(UpdateViewModel.class);
    }
}