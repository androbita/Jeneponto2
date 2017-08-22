package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.R;

import butterknife.Bind;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Something extends Fragment {
    @Bind (R.id.imageView3)
    ImageView imview3;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newenergi, container, false);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        new DownloadImageTask(imview3).execute("http://visitjeneponto.id/webimage/bangun-pltu-large_final.jpg");
//        try {
//            URL url = new URL("http://visitjeneponto.id/webimage/bangun-pltu-large_final.jpg");
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            imview3.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


}
