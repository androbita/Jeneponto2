package com.fancreature.android.jeneponto.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fancreature.android.jeneponto.HttpHandler;
import com.fancreature.android.jeneponto.KontenBerita.PosDelapan;
import com.fancreature.android.jeneponto.KontenBerita.PosDua;
import com.fancreature.android.jeneponto.KontenBerita.PosEmpat;
import com.fancreature.android.jeneponto.KontenBerita.PosEnam;
import com.fancreature.android.jeneponto.KontenBerita.PosLima;
import com.fancreature.android.jeneponto.KontenBerita.PosSatu;
import com.fancreature.android.jeneponto.KontenBerita.PosSembilan;
import com.fancreature.android.jeneponto.KontenBerita.PosSepuluh;
import com.fancreature.android.jeneponto.KontenBerita.PosTiga;
import com.fancreature.android.jeneponto.KontenBerita.PosTujuh;
import com.fancreature.android.jeneponto.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


import static android.content.ContentValues.TAG;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class Beranda extends Fragment {

private String TAG = Beranda.class.getSimpleName();

    private ProgressDialog pDialog;
    @Bind(R.id.list) ListView lv;
    private Class FragmentClass;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    private static String url = "http://visitjeneponto.id/getdata.php/";
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
    View rootView = inflater.inflate(R.layout.httpsample, container, false);

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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Beranda.super.getContext());
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
                        String image = c.getString("image");
                        String judul = c.getString("judul");
                        String isikonten = c.getString("isi_konten");
                        String tanggal = c.getString("tanggal_rilis");
                        String by = c.getString("created_by");

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
//                        contact.put("kode", id);
                        contact.put("judul", judul);
//                        contact.put("isi_konten", isikonten);
                        contact.put("tanggal", tanggal);
                        contact.put("created_by", by);

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
                    Beranda.super.getContext(), contactList,
                    R.layout.list_item, new String[]{"tanggal", "judul", "created_by"}, new int[]{R.id.tanggal, R.id.judul, R.id.author});

            lv.setAdapter(adapter);
        }

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0 :

                        FragmentClass = PosSatu.class;
                        break;
                    case 1 :
                        FragmentClass = PosDua.class;
                        break;
                    case 2 :
                        FragmentClass = PosTiga.class;
                        break;
                    case 3 :
                        FragmentClass = PosEmpat.class;
                        break;
                    case 4 :
                        FragmentClass = PosLima.class;
                        break;
                    case 5 :
                        FragmentClass = PosEnam.class;
                        break;
                    case 6 :
                        FragmentClass = PosTujuh.class;
                        break;
                    case 7 :
                        FragmentClass = PosDelapan.class;
                        break;
                    case 8 :
                        FragmentClass = PosSembilan.class;
                        break;
                    case 9 :
                        FragmentClass = PosSepuluh.class;
                        break;
                    default:
                        FragmentClass = this.getClass();
                }
                try {
                    fragment = (Fragment) FragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fr = getFragmentManager();
                fr.beginTransaction().replace(R.id.fContent, fragment,"My Tag").commit();

//                String jenepon = "http://visitjeneponto.id";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(jenepon));
//                startActivity(intent);
//                AlertDialog mDialog = new AlertDialog.Builder(getContext())
//                        .setTitle(R.string.app_name)
//                        .setMessage("test onitemclick")
//                        .setPositiveButton("OK",
//                                new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Log.i("MyTag", "Click YES");
//                                    }
//                                })
//                        .create();
//
//                mDialog.show();
            }
        });
////        llay ;
//        lv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
