package com.fancreature.android.jeneponto.FragmentPeluang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 8/21/2017.
 */

public class FragmentTiga extends Fragment {
    private String taitel;
    private int page;
    String[] listArray={"siwalan", "jambu mete", "kelapa", "kopi arabica"};

    public static FragmentTiga newInstance(int page, String taitel){

        FragmentTiga fragmentAwal = new FragmentTiga();
        Bundle args = new Bundle();
        args.putInt("someInt",page);
        args.putString("someTitle",taitel);
        fragmentAwal.setArguments(args);
        return fragmentAwal;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 1);
        taitel = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.httpsample, container, false);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.fragmentawal, listArray );
        ListView lv = (ListView) view.findViewById(R.id.list);
        lv.setAdapter(adapter);
        return view;
    }
}
