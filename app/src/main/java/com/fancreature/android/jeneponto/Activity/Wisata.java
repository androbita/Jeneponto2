package com.fancreature.android.jeneponto.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.fancreature.android.jeneponto.FragmentPerizinan.IzinDaerah;
import com.fancreature.android.jeneponto.FragmentPerizinan.IzinNasional;
import com.fancreature.android.jeneponto.HttpHandler;
import com.fancreature.android.jeneponto.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class Wisata extends Fragment {

    private String TAG = Wisata.class.getSimpleName();

    private ProgressDialog pDialog;
    @Bind(R.id.lw)
    ListView lv;

    //
//    @Bind(R.id.llay)
//    LinearLayout llay;
    // URL to get contacts JSON
    private static String url = "http://visitjeneponto.id/connection/getWisata.php/";
//    private Uri urix = Uri.parse("http://www.visitjeneponto.id"); // missing 'http://' will cause crashed

    ArrayList<HashMap<String, String>> contactList;


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.httpsample, container, false);
//
////        getActivity();
//
//        return rootView;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wisata, container, false);

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
//        setContentView(R.layout.httpsample);
//        lv.findViewById(R.id.list);
        new Wisata.GetContacts().execute();


//        setContentView(R.layout.httpsample);
//        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
//        getLayoutInflater().inflate(R.layout.httpsample, contentFrameLayout);
    }



    /**
     * Async task class to get json by making HTTP call
     */


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Wisata.super.getContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("wisata");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String namaizin = c.getString("nama_izin");
//                        String persyaratan = String.valueOf(Html.fromHtml(c.getString("persyaratan")));
//                        String lamaProses = c.getString("lama_proses");
//                        String biaya = String.valueOf(Html.fromHtml(c.getString("biaya")));
//                        String jangkaWaktu = c.getString("jangka_waktu");

                        String id = c.getString("id");
                        String judul = c.getString("judul_wisata");
                        String link = c.getString("link_gambar");
                        String keterangan = c.getString("keterangan");

                        HashMap<String, String> contact = new HashMap<>();

//                        contact.put("nama_izin", namaizin);
//                        contact.put("persyaratan", persyaratan);
//                        contact.put("lama_proses", lamaProses);
//                        contact.put("biaya", biaya);
//                        contact.put("jangka_waktu", jangkaWaktu);

                        contact.put("id", id);
                        contact.put("judul_wisata", judul);
                        contact.put("link_gambar", link);
                        contact.put("keterangan", keterangan);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });

            }

            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            String urlGambar = new String("link_gambar");
//
            ListAdapter adapter = new SimpleAdapter(
                    Wisata.super.getContext(), contactList,
                    R.layout.list_wisata, new String[]{urlGambar}, new int[]{R.id.img_wisata});

            lv.setAdapter(adapter);

            ImageView imgWisata = (ImageView) getView().findViewById(R.id.img_wisata);

            Picasso.with(getContext())
                    .load(urlGambar)
                    .into(imgWisata);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}

