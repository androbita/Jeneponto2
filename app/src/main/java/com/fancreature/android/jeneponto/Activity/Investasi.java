package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.FragmentPeluang.FragmentAsal;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentAwal;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentDua;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentEmpat;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentLima;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentTiga;
import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class Investasi extends Fragment {

    @Bind(R.id.vpager)
     ViewPager vpager;

    FragmentPagerAdapter adapterViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.potensi, container, false);
//        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.vpager);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 6;

    public MyPagerAdapter (FragmentManager fragmentManager){
        super(fragmentManager);
    }
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    return FragmentAsal.newInstance(1,"Aset Daerah");
                case 1 :
                    return FragmentAwal.newInstance(2,"Perikanan dan Kelautan");
                case 2 :
                    return FragmentTiga.newInstance(3,"Perkebunan");
                case 3 :
                    return FragmentAsal.newInstance(4,"Pertanian Holtikultura");
                case 4 :
                    return FragmentEmpat.newInstance(5,"Pertanian Tanaman Pangan");
                case 5 :
                    return FragmentLima.newInstance(6,"Peternakan");
                default:
                    return FragmentAsal.newInstance(1,"Aset Daerah");
            }
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            position ;
            return "Page " + position;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapterViewPager = new MyPagerAdapter(getFragmentManager());
        vpager.setAdapter(adapterViewPager);
    }
}
