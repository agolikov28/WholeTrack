package com.example.wholetrack.ui.exercise;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.wholetrack.R;
import com.example.wholetrack.databinding.FragmentCardioBinding;


public class CardioFragment extends Fragment {
    private FragmentCardioBinding binding;

    private static final long  START_TIME = 1800000;
    private TextView timertext;
    private Button startb, resetb, costumeb, entertb;
    private CountDownTimer mcount;
    private boolean istimerunning, isnewtime;
    private long timeleft = START_TIME;
    private EditText newtime;

    private int timeEnter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCardioBinding.inflate(inflater, container,false);
        View root = binding.getRoot();
        Button back = binding.goingback;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseFragment exer = new ExerciseFragment();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.nav_host_fragment_activity_main, exer).commit();

            }
        });

        timertext = binding.timeview;
        startb = binding.startb;
        resetb = binding.resetb;
        costumeb = binding.customtimer;
        entertb = binding.entercostumetime;
        newtime = binding.timecostumeEdit;

        startb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(istimerunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        resetb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        costumeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                costumeb.setVisibility(View.INVISIBLE);
                entertb.setVisibility(View.VISIBLE);
                newtime.setVisibility(View.VISIBLE);

            }
        });

        entertb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(newtime.getText().toString())){
                    newtime.setError("You must enter a number of minutes");

                }else if (TextUtils.isDigitsOnly(newtime.getText().toString())){
                    int numtime = Integer.parseInt(newtime.getText().toString());
                    timeEnter = numtime * 60000;
                    timeleft = (long) (timeEnter);
                    isnewtime = true;
                    startb.setText("Start");
                    resetb.setVisibility(View.INVISIBLE);
                    costumeb.setVisibility(View.VISIBLE);
                    entertb.setVisibility(View.INVISIBLE);
                    newtime.setVisibility(View.INVISIBLE);
                    updatetime();


                    //Toast.makeText(getContext(),"You must enter a number of minutes", Toast.LENGTH_SHORT).show();
                }else{
                    newtime.setError("You must enter a number of minutes");
                }
            }
        });

        updatetime();

        return root;
    }

    private void startTimer(){
        mcount = new CountDownTimer(timeleft, 1000) {
            @Override
            public void onTick(long l) {
                timeleft = l;
                updatetime();
            }

            @Override
            public void onFinish() {
                istimerunning = false;
                startb.setText("Start");
                startb.setVisibility(View.INVISIBLE);
                resetb.setVisibility(View.VISIBLE);
            }
        }.start();

        istimerunning = true;
        startb.setText("Pause");
        resetb.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer(){
        mcount.cancel();
        istimerunning = false;
        startb.setText("Continue");
        resetb.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
        if(isnewtime){
            timeleft = timeEnter;
        }else{
            timeleft = START_TIME;
        }

        updatetime();
        startb.setText("Start");
        resetb.setVisibility(View.INVISIBLE);
        startb.setVisibility(View.VISIBLE);
    }
    private void updatetime(){
        int minutes = (int) (timeleft /1000) /60;
        int seconds = (int) (timeleft /1000) %60;
        String timeis = String.format("%02d:%02d", minutes, seconds);
        timertext.setText(timeis);

    }
}