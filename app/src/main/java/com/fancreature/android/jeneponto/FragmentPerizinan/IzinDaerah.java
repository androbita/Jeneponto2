package com.fancreature.android.jeneponto.FragmentPerizinan;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.fancreature.android.jeneponto.Activity.Perizinan;
import com.fancreature.android.jeneponto.HttpHandler;
import com.fancreature.android.jeneponto.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pranadana on 8/15/2017.
 */

public class IzinDaerah extends Fragment {
    private String TAG = Perizinan.class.getSimpleName();

    private ProgressDialog pDialog;
    @Bind(R.id.list)
    ListView lv;
    //
//    @Bind(R.id.llay)
//    LinearLayout llay;
    // URL to get contacts JSON
    private static String url = "http://visitjeneponto.id/connection/getIzinApps.php/";
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
        View rootView = inflater.inflate(R.layout.list_perizinan_daerah, container, false);

//    rootView.findViewById(R.id.l)
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
//        setContentView(R.layout.httpsample);
//        lv.findViewById(R.id.list);
        new GetContacts().execute();


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
            pDialog = new ProgressDialog(IzinDaerah.super.getContext());
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
                    JSONArray contacts = jsonObj.getJSONArray("prosedur_perizinan");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String id = c.getString("id");
//                        String kode = c.getString("kode");
//                        String image = c.getString("image");
//                        String judul = c.getString("judul");
//                        String isikonten = c.getString("isi_konten");
//                        String tanggal = c.getString("tanggal_rilis");
//                        String by = c.getString("created_by");
//                        String id = c.getString("id");
//                        String kode = c.getString("kode");
                        String namaizin = c.getString("nama_izin");
                        String persyaratan = String.valueOf(Html.fromHtml(c.getString("persyaratan")));
                        String lamaProses = c.getString("lama_proses");
                        String biaya = String.valueOf(Html.fromHtml(c.getString("biaya")));
                        String jangkaWaktu = c.getString("jangka_waktu");

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
//                        contact.put("kode", id);
//                        contact.put("kode", kode);
//                        contact.put("isi_konten", isikonten);
//                        contact.put("created_by", by);
                        contact.put("nama_izin", namaizin);
                        contact.put("persyaratan", persyaratan);
                        contact.put("lama_proses", lamaProses);
                        contact.put("biaya", biaya);
                        contact.put("jangka_waktu", jangkaWaktu);

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
            ListAdapter adapter = new SimpleAdapter(
                    IzinDaerah.super.getContext(), contactList,
                    R.layout.list_izin_daerah, new String[]{"nama_izin", "persyaratan", "lama_proses", "biaya", "jangka_waktu"}, new int[]{R.id.nama_izin, R.id.persyaratan, R.id.lama_proses, R.id.biaya, R.id.jangka_waktu});

            lv.setAdapter(adapter);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
////        llay ;
//        lv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String jenepon = "http://visitjeneponto.id";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(jenepon));
//                startActivity(intent);
//            }
//        });
    }
}
