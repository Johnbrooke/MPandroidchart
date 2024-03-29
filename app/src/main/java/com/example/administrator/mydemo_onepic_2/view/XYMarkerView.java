package com.example.administrator.mydemo_onepic_2.view;

import android.content.Context;
import android.widget.TextView;

import com.example.administrator.mydemo_onepic_2.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class XYMarkerView extends MarkerView {

    private TextView tvContent;
    private IAxisValueFormatter xAxisValueFormatter;

    private DecimalFormat format;

    public XYMarkerView(Context context, IAxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = (TextView) findViewById(R.id.tvContent);
        format = new DecimalFormat("###.0");
    }

    //回调函数每次MarkerView重绘,可以用来更新内容(用户界面)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvContent.setText("x: " + xAxisValueFormatter.getFormattedValue(e.getX(),null) + ", y: " + format.format(e.getY())+"万");
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth()/2), -getHeight());
    }
}
