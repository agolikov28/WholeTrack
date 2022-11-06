package com.example.wholetrack.ui.sleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wholetrack.databinding.FragmentSleepBinding;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;



public class SleepFragment extends Fragment {

    private FragmentSleepBinding binding;
    private static final int MAX_X_VALUE = 7;
    private static final int MAX_Y_VALUE = 20;
    private static final int MIN_Y_VALUE = 0;
    private static final String SET_LABEL = "Average Sleep";
    private static final String[] DAYS = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    private HorizontalBarChart chart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SleepViewModel sleepViewModel =
                new ViewModelProvider(this).get(SleepViewModel.class);

        binding = FragmentSleepBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        final Button buttonSleep = binding.butto;
        final LinearLayout dataForm = binding.dataForm;
        dataForm.setVisibility(View.GONE);
        TextView ave, sum;
        ave = binding.aveSleep;
        sum = binding.summ;
        EditText sun, mon, tues, wed, thur, fri, sat;
        float average;
        sun = binding.su;
        mon = binding.mo;
        tues = binding.tu;
        wed = binding.we;
        thur = binding.thu;
        fri = binding.fr;
        sat = binding.sa;
        TextView analysis = binding.sleepAnalysis;
        ImageView example = binding.chartImg;
        TextView error = binding.error;
        error.setVisibility(View.GONE);
        buttonSleep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switch between graph page and data page
                boolean a, b, c, d, e, f, g;
                a = !(sun.getText().toString()).equals("");
                b = !(mon.getText().toString()).equals("");
                c = !(tues.getText().toString()).equals("");
                d = !(wed.getText().toString()).equals("");
                e = !(thur.getText().toString()).equals("");
                f = !(fri.getText().toString()).equals("");
                g = !(sat.getText().toString()).equals("");
                if (dataForm.getVisibility() == View.VISIBLE){
                    if (a && b && c && d && e && f && g) {
                        dataForm.setVisibility(View.GONE);
                        sum.setVisibility(View.VISIBLE);
                        analysis.setVisibility(View.VISIBLE);
                        ave.setVisibility(View.VISIBLE);
                        example.setVisibility(View.VISIBLE);
                        buttonSleep.setText("Enter New Sleep Data");
                        error.setVisibility(View.GONE);
                    } else {
                        error.setVisibility(View.VISIBLE);
                    }
                } else{
                    sum.setVisibility(View.GONE);
                    ave.setVisibility(View.GONE);
                    analysis.setVisibility(View.GONE);
                    example.setVisibility(View.GONE);
                    dataForm.setVisibility(View.VISIBLE);
                    buttonSleep.setText("Save Data");
                }

            }
        });



        //BarData data = createChartData();
        //configureChartAppearance();
        //prepareChartData(data);

        //final TextView textView = binding.textHome;
        //sleepViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void prepareChartData(BarData data) {
        data.setValueTextSize(12f);
        chart.setData(data);
        chart.invalidate();
    }

    private BarData createChartData() {
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < MAX_X_VALUE; i++) {
            float x = i;
            float y = 5;
            values.add(new BarEntry(x, y));
        }

        BarDataSet set1 = new BarDataSet(values, SET_LABEL);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        return data;
    }

    private void configureChartAppearance() {
        chart.getDescription().setEnabled(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return DAYS[(int) value];
            }
        });
    }

    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}