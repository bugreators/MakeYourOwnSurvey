package com.bugcreators.makeyourownsurvey.Controller.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleStackMode;
import com.anychart.scales.Linear;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportsFragment extends Fragment {


    public ReportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);

        Cartesian cartesian = AnyChart.cartesian();

        cartesian.animation(true);

        cartesian.title("Stacked Column Report");

        cartesian.yScale().stackMode(ScaleStackMode.PERCENT);

        Linear scalesLinear = Linear.instantiate();
        scalesLinear.minimum(0d);
        scalesLinear.maximum(100d);
        scalesLinear.ticks("{ interval: 20 }");

        com.anychart.core.axes.Linear extraYAxis = cartesian.yAxis(1d);
        extraYAxis.orientation(Orientation.RIGHT)
                .scale(scalesLinear);
        extraYAxis.labels()
                .padding(0d, 0d, 0d, 5d)
                .format("{%Value}%");

        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomDataEntry("P1", 96.5, 2040, 1200, 1600));
        data.add(new CustomDataEntry("P2", 77.1, 1794, 1124, 1724));
        data.add(new CustomDataEntry("P3", 73.2, 2026, 1006, 1806));
        data.add(new CustomDataEntry("P4", 61.1, 2341, 921, 1621));
        data.add(new CustomDataEntry("P5", 70.0, 1800, 1500, 1700));
        data.add(new CustomDataEntry("P6", 60.7, 1507, 1007, 1907));
        data.add(new CustomDataEntry("P7", 62.1, 2701, 921, 1821));
        data.add(new CustomDataEntry("P8", 75.1, 1671, 971, 1671));
        data.add(new CustomDataEntry("P9", 80.0, 1980, 1080, 1880));
        data.add(new CustomDataEntry("P10", 54.1, 1041, 1041, 1641));
        data.add(new CustomDataEntry("P11", 51.3, 813, 1113, 1913));
        data.add(new CustomDataEntry("P12", 59.1, 691, 1091, 1691));

        Set set = Set.instantiate();
        set.data(data);
        Mapping column1Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping column2Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping column3Data = set.mapAs("{ x: 'x', value: 'value4' }");

        cartesian.column(column1Data);
        cartesian.crosshair(true);

        cartesian.column(column2Data);

        cartesian.column(column3Data);

        anyChartView.setChart(cartesian);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
        }
    }


}