package com.example.administrator.mydemo_onepic_2.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mydemo_onepic_2.R;
import com.example.administrator.mydemo_onepic_2.utils.DayAxisValueFormatter;
import com.example.administrator.mydemo_onepic_2.view.MyAxisValueFormatter;
import com.example.administrator.mydemo_onepic_2.view.XYMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public class BarChartActivity extends Activity implements OnChartValueSelectedListener {


    @InjectView(R.id.barchar_item)
    BarChart mChart;
    @InjectView(R.id.bt_item)
    Button btItem;
    BarDataSet dataSet;
    BarData data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barchart_item);
        ButterKnife.inject(this);

        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawBarShadow(false);
//        mChart.setDrawValueAboveBar(true);

        mChart.getDescription().setText("公司签半年财务报表（单位：万元）");
        mChart.getDescription().setPosition(750,40);

//        mChart.setMaxVisibleValueCount(60);

        mChart.setPinchZoom(false);

//        mChart.setDrawValueAboveBar(true);

        //设置是否可以触摸
//        mChart.setTouchEnabled(true);
        mChart.setDrawGridBackground(false);


//        //X轴字体颜色
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTextSize(10f);
//        xAxis.setTextColor(Color.BLUE);
//        xAxis.setDrawAxisLine(true);
//        xAxis.setDrawGridLines(false);

//        mChart.setDrawLabels




        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        IAxisValueFormatter custom = new MyAxisValueFormatter();

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)



        XYMarkerView mv = new XYMarkerView(this, xAxisFormatter);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart



        // 隐藏右边的坐标轴
        mChart.getAxisRight().setEnabled(false);
        setData();

        mChart.setDoubleTapToZoomEnabled(false);//设置双击不进行缩放
        mChart.animateY(3000);

    }
    private void setData() {


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        //new BarEntry(X,Y);
        yVals1.add(new BarEntry(1f, 12f));
        yVals1.add(new BarEntry(2f, 11f));
        yVals1.add(new BarEntry(3f, 10f));
        yVals1.add(new BarEntry(4f, 9f));
        yVals1.add(new BarEntry(5f, 8f));
        yVals1.add(new BarEntry(6f, 7f));
        yVals1.add(new BarEntry(7f, 6f));
        yVals1.add(new BarEntry(8f, 5f));
        yVals1.add(new BarEntry(9f, 4f));
        yVals1.add(new BarEntry(10f, 3f));
        yVals1.add(new BarEntry(11f, 2f));
        yVals1.add(new BarEntry(12f, 1f));

        BarDataSet set1;
        set1 = new BarDataSet(yVals1, "2017");
        set1.setColors(ColorTemplate.VORDIPLOM_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);
        mChart.setData(data);

        }

    protected RectF mOnValueSelectedRectF = new RectF();

    @SuppressLint("NewApi")
    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("TAG","==============================||=====" + e);
        if (e == null)
            return;

        RectF bounds = mOnValueSelectedRectF;
        mChart.getBarBounds((BarEntry) e, bounds);
        MPPointF position = mChart.getPosition(e, YAxis.AxisDependency.LEFT);

        Log.i("bounds", bounds.toString());
        Log.i("position", position.toString());

        Log.i("x-index",
                "low: " + mChart.getLowestVisibleX() + ", high: "
                        + mChart.getHighestVisibleX());

        MPPointF.recycleInstance(position);

    }

    @Override
    public void onNothingSelected() {

    }


}


