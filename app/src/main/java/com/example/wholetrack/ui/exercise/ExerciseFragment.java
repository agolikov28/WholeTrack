package com.example.wholetrack.ui.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.wholetrack.R;
import com.example.wholetrack.databinding.FragmentExerciseBinding;
import com.example.wholetrack.ui.diet.DietFragment;

public class ExerciseFragment extends Fragment {

    private FragmentExerciseBinding binding;

    private Button Arm, legs, chest , cardio;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExerciseViewModel exerciseViewModel =
                new ViewModelProvider(this).get(ExerciseViewModel.class);

        binding = FragmentExerciseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textExercise;
//        exerciseViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        Arm = binding.button;
        legs = binding.leg;
        chest = binding.chest;
        cardio = binding.cardio;

        Arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(getContext(),ArmActivity.class);
//                startActivity(in);
                ArmFragment Am = new ArmFragment();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.nav_host_fragment_activity_main, Am).commit();


            }
        });

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardioFragment Am = new CardioFragment();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.nav_host_fragment_activity_main, Am).commit();


            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LegsFragment Am = new LegsFragment();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.nav_host_fragment_activity_main, Am).commit();


            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChestFragment Am = new ChestFragment();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.nav_host_fragment_activity_main, Am).commit();


            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}