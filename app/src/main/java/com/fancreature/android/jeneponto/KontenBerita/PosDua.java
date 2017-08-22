package com.fancreature.android.jeneponto.KontenBerita;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import com.fancreature.android.jeneponto.HttpHandler;
import com.fancreature.android.jeneponto.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Irfan Assidiq on 8/12/2017.
 */

public class PosDua extends Fragment{
    @Nullable

    @Bind(R.id.img)
    ImageView img;
    @Bind(R.id.list)
    ListView lv;
    private ProgressDialog pDialog;
    TextView x;
    private static String url = "http://visitjeneponto.id/connection/getisiberitaapps1.php";
    ArrayList<HashMap<String, String>> contactList;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.httpsample, container, false);

        ButterKnife.bind(this, rootview);
        return rootview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
        new PosDua.GetContacts().execute();

    }


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(PosDua.super.getContext());
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
                    JSONArray contacts = jsonObj.getJSONArray("berita");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String id = c.getString("id");
                        String kode = c.getString("kode");
                        String image = "http://visitjeneponto.id" + c.getString("image");
                        String judul = c.getString("judul");
                        String isikonten = String.valueOf(Html.fromHtml(c.getString("isi_konten")));
                        String tanggal = c.getString("tanggal_rilis");
                        String by = c.getString("created_by");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();


                        // adding each child node to HashMap key => value
//                        contact.put("kode", id);
                        contact.put("judul", judul);
                        contact.put("image", image);
                        contact.put("isi_konten", isikonten);
                        contact.put("tanggal", tanggal);
//                        contact.put("created_by", by);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(pDialog.isShowing());
            pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    PosDua.super.getContext(), contactList,
                    R.layout.isiberita, new String[]{"judul", "tanggal", "isi_konten"}, new int[]{R.id.judul, R.id.tanggal, R.id.konten});
            lv.setAdapter(adapter);
        }
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        String[] image = new String[]{"image"};
//        Picasso.with(this.getContext())
//                .load("http://visitjeneponto.id/webimage/BE1C43A96AB448A6BA7D882CEEB09D98.jpg")
//                .placeholder(R.drawable.jeneponto)
//                .error(R.drawable.jeneponto)
//                .into(img);
    }

}
