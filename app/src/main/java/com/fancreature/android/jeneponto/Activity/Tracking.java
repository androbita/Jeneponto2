package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Tracking extends Fragment {

    @Bind(R.id.iniIsi)
    TextView isiin;

    @Bind(R.id.iniTombol)
    ImageView tombolin;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.tracking, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tombolin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isiin.setText(R.string.isiin);
                isiin.setTextColor(getResources().getColor(R.color.greenHard));



            }
        });

        }

}
