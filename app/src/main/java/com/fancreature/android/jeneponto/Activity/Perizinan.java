package com.fancreature.android.jeneponto.Activity;

        import android.support.v4.app.Fragment;
        import android.app.ProgressDialog;
        import android.os.AsyncTask;
        import android.os.Build;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.annotation.RequiresApi;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;

        import com.fancreature.android.jeneponto.FragmentPerizinan.IzinDaerah;
        import com.fancreature.android.jeneponto.FragmentPerizinan.IzinNasional;
        import com.fancreature.android.jeneponto.HttpHandler;
        import com.fancreature.android.jeneponto.MainActivity;
        import com.fancreature.android.jeneponto.R;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.zip.Inflater;

        import butterknife.Bind;
        import butterknife.ButterKnife;

/**
 * Created by pranadana on 8/9/2017.
 */

public class Perizinan extends Fragment {

    @Bind(R.id.btn_daerah)
    Button btnDaerah;

    @Bind(R.id.btn_nasional)
    Button btnNasional;

    public Perizinan(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.layout_perizinan, container, false);
//        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Prosedur Perizinan");
        //((MainActivity) getActivity()).getSupportActionBar().setSubtitle("(list_perizinan_daerah.xml)");
//        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        btnNasional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IzinNasional izinNasional = new IzinNasional();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fIzin, izinNasional)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        btnDaerah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                IzinDaerah izinDaerah = new IzinDaerah();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fIzin, izinDaerah)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });
    }
}