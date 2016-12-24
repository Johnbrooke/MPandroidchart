package com.example.administrator.mydemo_onepic_2.view;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyAxisValueFormatter implements IAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value) + " ￥";
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}
