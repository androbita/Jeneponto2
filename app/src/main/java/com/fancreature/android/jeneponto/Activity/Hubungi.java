package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Hubungi extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_contact, container, false);
    }
}

