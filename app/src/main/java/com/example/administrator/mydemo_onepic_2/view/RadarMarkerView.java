package com.example.administrator.mydemo_onepic_2.view;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.administrator.mydemo_onepic_2.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public class RadarMarkerView extends MarkerView {

    private TextView tvContent;
    private DecimalFormat format = new DecimalFormat("##0");

    public RadarMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = (TextView) findViewById(R.id.tvContent);
        tvContent.setTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf"));
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvContent.setText(format.format(e.getY()) + " %");

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight() - 10);
    }
}
