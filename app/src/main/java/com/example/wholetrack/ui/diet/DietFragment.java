package com.example.wholetrack.ui.diet;

import android.content.pm.Signature;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.Arrays;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wholetrack.databinding.FragmentDietBinding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

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

        // Daily summary items:


        // food form elements
        TextView error = binding.formError;
        TextView selectLabal = binding.foodListLabel;
        error.setVisibility(View.GONE);
        Spinner foodList = binding.foodList;
        EditText foodName, foodCalorie, foodFat, foodCarb, foodProtein;
        foodName = binding.foodName;
        foodCalorie = binding.foodCalorie;
        foodFat = binding.foodFat;
        foodCarb = binding.foodCarb;
        foodProtein = binding.foodProtein;
        Switch save = binding.saveForLater;
        Button submitFood = binding.submitFoodForm;
        LinearLayout manualEnter = binding.manualEnter;
        Button buttonManual = binding.buttonManual;
        foodForm.setVisibility(View.GONE);
        String[] foods = { "Slice of Pizza", "Banana",
                "Can of Beans", "The Golub Special",
                "Oatmilk Latte", "Taco Bell Crunch Wrap Supreme" };

        ArrayAdapter ad
                = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                foods);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        foodList.setAdapter(ad);
        buttonFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if (buttonFood.getText().equals("Close Data Entry")){
                    foodForm.setVisibility(View.GONE);
                    buttonFood.setText("Enter New Data");
                    buttonManual.setText("Or Enter Data Manually");
                    foodName.setText("");
                    foodCalorie.setText("");
                    foodCarb.setText("");
                    foodProtein.setText("");
                    foodFat.setText("");
                    error.setVisibility(View.GONE);



                } else{
                    foodForm.setVisibility(View.VISIBLE);
                    buttonFood.setText("Close Data Entry");
                    manualEnter.setVisibility(View.GONE);
                    foodList.setVisibility(View.VISIBLE);
                    selectLabal.setVisibility(View.VISIBLE);
                    buttonManual.setVisibility(View.VISIBLE);
                   // manualEnter.setVisibility(View.INVISIBLE);
                }

            }
        });

        buttonManual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if (buttonManual.getText().equals("Or Enter Data Manually")){

                    buttonManual.setText("Select From List Instead");
                    foodForm.setVisibility(View.VISIBLE);
                    selectLabal.setVisibility(View.GONE);
                    foodList.setVisibility(View.GONE);
                    manualEnter.setVisibility(View.VISIBLE);


                } else{
                    buttonManual.setText("Or Enter Data Manually");

                    //buttonManual.setVisibility(View.GONE);
                    //foodForm.setVisibility(View.GONE);
                    selectLabal.setVisibility(View.VISIBLE);
                    foodList.setVisibility(View.VISIBLE);
                    manualEnter.setVisibility(View.GONE);
                    foodName.setText("");
                    foodCalorie.setText("");
                    foodCarb.setText("");
                    foodProtein.setText("");
                    foodFat.setText("");
                    error.setVisibility(View.GONE);

                }

            }
        });
        // test laoding a file

        submitFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (manualEnter.getVisibility() == View.VISIBLE){
                    boolean name, cal, fat, carb, prot;
                    name = !foodName.getText().toString().equals("");
                    cal = !(foodCalorie.getText().toString()).equals("");
                    fat = !(foodFat.getText().toString()).equals("");
                    carb = !(foodCarb.getText().toString()).equals("");
                    prot = !(foodProtein.getText().toString()).equals("");

                    // valid? submission
                    if (name && cal && fat && carb && prot){
                        error.setVisibility(View.GONE);
                        foodForm.setVisibility(View.GONE);

                        if (save.isChecked()){
                            // save to food list
                        }
                        foodForm.setVisibility(View.GONE);
                        buttonFood.setText("Enter New Data");
                        buttonManual.setText("Or Enter Data Manually");
                        foodName.setText("");
                        foodCalorie.setText("");
                        foodCarb.setText("");
                        foodProtein.setText("");
                        foodFat.setText("");
                        Toast toast = Toast.makeText(getContext(), "Submit not yet implemented", Toast.LENGTH_SHORT);
                        // to show the toast
                        toast.show();
                    }else{
                        error.setVisibility(View.VISIBLE);
                    }
                }
                else {
                    foodForm.setVisibility(View.GONE);
                    buttonFood.setText("Enter New Data");
                    buttonManual.setText("Or Enter Data Manually");
                    error.setVisibility(View.GONE);
                    Toast toast = Toast.makeText(getContext(), "Submit not yet implemented", Toast.LENGTH_SHORT);
                    // to show the toast
                    toast.show();
                    foodName.setText("");
                    foodCalorie.setText("");
                    foodCarb.setText("");
                    foodProtein.setText("");
                    foodFat.setText("");
                }
                // make sure all items are filled in before continuing

                // 2 things, send numbers to daily summary, save food to food list if checked





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