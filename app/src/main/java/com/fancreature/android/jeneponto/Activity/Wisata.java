package com.fancreature.android.jeneponto.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class Wisata extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wisata, container, false);
        return rootView;
    }
}

