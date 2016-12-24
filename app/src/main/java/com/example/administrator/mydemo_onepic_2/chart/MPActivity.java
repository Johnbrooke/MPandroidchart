package com.example.administrator.mydemo_onepic_2.chart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mydemo_onepic_2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public class MPActivity extends Activity {

    @InjectView(R.id.btn_linechart)
    Button btnLinechart;
    @InjectView(R.id.btn_barchart)
    Button btnBarchart;
    @InjectView(R.id.btn_horizontalchart)
    Button btnHorizontalchart;
    @InjectView(R.id.btn_combinedchart)
    Button btnCombinedchart;
    @InjectView(R.id.btn_piechart)
    Button btnPiechart;
    @InjectView(R.id.btn_scatterchart)
    Button btnScatterchart;
    @InjectView(R.id.btn_candlechart)
    Button btnCandlechart;
    @InjectView(R.id.btn_radarchart)
    Button btnRadarchart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_item);
        ButterKnife.inject(this);


    }

    @OnClick({R.id.btn_linechart, R.id.btn_barchart, R.id.btn_horizontalchart, R.id.btn_combinedchart, R.id.btn_piechart, R.id.btn_scatterchart, R.id.btn_candlechart, R.id.btn_radarchart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_linechart:
                break;
            case R.id.btn_barchart:
                startActivity(new Intent(MPActivity.this,BarChartActivity.class));
                break;
            case R.id.btn_horizontalchart:
                startActivity(new Intent(MPActivity.this,RadarChartActivity.class));
                break;
            case R.id.btn_combinedchart:
                break;
            case R.id.btn_piechart:
                startActivity(new Intent(MPActivity.this,PieCharActivity.class));
                break;
            case R.id.btn_scatterchart:
                break;
            case R.id.btn_candlechart:
                break;
            case R.id.btn_radarchart:
                break;
        }
    }
}
