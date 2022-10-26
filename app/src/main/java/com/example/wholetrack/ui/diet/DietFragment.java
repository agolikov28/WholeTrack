package com.example.wholetrack.ui.diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wholetrack.databinding.FragmentDietBinding;

public class DietFragment extends Fragment {

    private FragmentDietBinding binding;
    public int test = 1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DietViewModel dietViewModel =
                new ViewModelProvider(this).get(DietViewModel.class);

        binding = FragmentDietBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button buttonFood = binding.enterFood;
        final LinearLayout foodForm = binding.foodForm;
        buttonFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if (foodForm.getVisibility() == View.VISIBLE){
                    foodForm.setVisibility(View.GONE);
                    buttonFood.setText("Enter New Data");
                } else{
                    foodForm.setVisibility(View.VISIBLE);
                    buttonFood.setText("Close Food Menu");
                }

            }
        });

       // dietViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}