package com.example.wholetrack.ui.sleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wholetrack.R;
import com.example.wholetrack.databinding.FragmentHomeBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class SleepFragment extends Fragment {

    private FragmentHomeBinding binding;
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SleepViewModel sleepViewModel =
                new ViewModelProvider(this).get(SleepViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        sleepViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }*/

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, 4));
        barEntriesArrayList.add(new BarEntry(2f, 6));
        barEntriesArrayList.add(new BarEntry(3f, 8));
        barEntriesArrayList.add(new BarEntry(4f, 2));
        barEntriesArrayList.add(new BarEntry(5f, 4));
        barEntriesArrayList.add(new BarEntry(6f, 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}