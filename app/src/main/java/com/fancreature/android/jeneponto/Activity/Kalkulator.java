package com.fancreature.android.jeneponto.Activity;

import android.content.Context;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 7/30/2017.
 */

public class Kalkulator extends Fragment {

    public Kalkulator(){

    }

    //    Spinner izinPertama;
//    @Bind(R.id.fContent) FrameLayout fContent;
    @Bind(R.id.izin_pertama) Spinner izinPertama;
    @Bind(R.id.button_hitung) Button tombolHasil;
    @Bind(R.id.hasil_hitung) TextView hasilHitung;
    @Bind(R.id.keterangan) TextView keterangan;

    //deklarasi ketika memilih perpanjangan izin tenaga kerja asing
    @Bind(R.id.linear_asing) LinearLayout llpertama;
    @Bind(R.id.jumlah_tenaga_kerja) EditText tenagaKerja;
    @Bind(R.id.ket_tenaga_kerja) TextView ketTenagaKerja;
    //@Bind(R.id.textUSD) TextView usd;

    //deklarasi ketika memilih izin mendirikan bangunan

    @Bind(R.id.linear_imb) LinearLayout llkedua;
    @Bind(R.id.menu_imb) Spinner menuIMB;
    @Bind(R.id.text_L_V) TextView lv;
    @Bind(R.id.text_It_I) TextView ItI;
    @Bind(R.id.text_index) TextView indeks;
    @Bind(R.id.input_L_V) EditText inputLV;
    @Bind(R.id.input_It_I) EditText inputItI;
    @Bind(R.id.spin_Tk) Spinner spinTk;
    @Bind(R.id.HSbg) Spinner spinHsbg;

    //deklarasi ketika memilih izin usaha perikanan
    @Bind(R.id.linear_ikan) LinearLayout llketiga;
    //khusus spinner

    @Bind(R.id.text_luas) TextView teksLuas;
    @Bind(R.id.input_luas) EditText inputLuas;
    @Bind(R.id.spin_jenis_perikanan) Spinner jenisPerikanan;
    @Bind(R.id.spin_perikanan_tawar) Spinner perikananTawar;
    @Bind(R.id.spin_perikanan_payau) Spinner perikananPayau;
    @Bind(R.id.spin_rumput) Spinner spinRumput;
    @Bind(R.id.spin_kerang_hijau) Spinner spinKerang;

    //deklarasi ketika memilih penangkapan ikan
    @Bind(R.id.spin_penangkapan_ikan) Spinner spinPenangkapanIkan;


    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_kalkulator, container, false);

        ButterKnife.bind(this, rootView);
        return  rootView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        context = getActivity();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        izinPertama.setId(R.id.izin_pertama);
        izinPertama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final String pilihIzin = izinPertama.getSelectedItem().toString();

                if (pilihIzin.equals("Pilih Jenis Izin")){
                    //menutup semua view
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    perikananPayau.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);

                }
                else if (pilihIzin.equals("Perpanjangan Izin Memperkerjakan Tenaga Kerja Asing")){
                    //menutup view yang tidak diperlukan
                    llkedua.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);
                    keterangan.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llpertama.setVisibility(View.VISIBLE);
                    ketTenagaKerja.setVisibility(View.VISIBLE);

//                    usd.setVisibility(View.VISIBLE);


                    tombolHasil.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {

                            String tenagaKerjaNull = tenagaKerja.getText().toString();
                            if(TextUtils.isEmpty(tenagaKerjaNull)) {
                                tenagaKerja.setError("nilai tidak boleh kosong");
                                return;
                            }

                            String hitungAsing = tenagaKerja.getText().toString();
                            int a = Integer.parseInt(hitungAsing);
                            int b = 100;
                            String hasilA = String.valueOf(a * b);
                            hasilHitung.setText(hasilA);
                        }
                    });
                }
                else if (pilihIzin.equals("Izin Mendirikan Bangunan")) {
                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    jenisPerikanan.setVisibility(View.GONE);
                    perikananTawar.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText(null);
                    inputLuas.setVisibility(View.GONE);
                    teksLuas.setVisibility(View.GONE);
                    keterangan.setVisibility(View.GONE);
                    inputLV.setVisibility(View.GONE);
                    inputItI.setVisibility(View.GONE);
                    lv.setVisibility(View.GONE);
                    ItI.setVisibility(View.GONE);
                    indeks.setVisibility(View.GONE);

                    //membuka view yang diperlukan
                    llkedua.setVisibility(View.VISIBLE);
                    menuIMB.setVisibility(View.VISIBLE);
                    menuIMB.setSelection(0);

                    menuIMB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String pilihIMB = menuIMB.getSelectedItem().toString();
                            if (pilihIMB.equals("Pilih Jenis Retribusi")) {
                                //menghilangkan view yang tidak diperlukan
                                lv.setText("");
                                inputLV.setText("");
                                ItI.setText("");
                                inputItI.setText("");
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);
                                keterangan.setVisibility(View.GONE);
                                inputLV.setVisibility(View.GONE);
                                inputItI.setVisibility(View.GONE);

                            } else if (pilihIMB.equals("Retribusi pembangunan gedung baru")) {
                                //menutup view yang tidak diperlukan
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                lv.setVisibility(View.VISIBLE);
                                lv.setText("L");
                                inputLV.setVisibility(View.VISIBLE);
                                inputLV.setHint(R.string.ket_luas);
                                ItI.setVisibility(View.VISIBLE);
                                ItI.setText("It");
                                inputItI.setVisibility(View.VISIBLE);
                                inputItI.setHint(R.string.ket_it);
                                indeks.setVisibility(View.VISIBLE);
                                hasilHitung.setText("");
                                spinHsbg.setVisibility(View.VISIBLE);
                                spinHsbg.setSelection(0);
                                keterangan.setVisibility(View.VISIBLE);
                                keterangan.setText("");

                                spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihHsbg = spinHsbg.getSelectedItem().toString();
                                        if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    hasilHitung.setError("pilih jenis bangunan");
                                                }
                                            });
                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    else if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 6000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 12000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {

                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 18000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_gedung_baru);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else if (pilihIMB.equals("Retribusi rehabilitasi/renovasi bangunan gedung")){
                                //menutup view yang tidak diperlukan
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                lv.setVisibility(View.VISIBLE);
                                lv.setText("L");
                                inputLV.setVisibility(View.VISIBLE);
                                inputLV.setHint(R.string.ket_luas);
                                inputLV.setText("");
                                ItI.setVisibility(View.VISIBLE);
                                ItI.setText("It");
                                inputItI.setVisibility(View.VISIBLE);
                                inputItI.setHint(R.string.ket_it);
                                inputItI.setText("");
                                spinTk.setVisibility(View.VISIBLE);
                                spinTk.setSelection(0);
                                spinHsbg.setVisibility(View.VISIBLE);
                                spinHsbg.setSelection(0);
                                keterangan.setVisibility(View.VISIBLE);
                                keterangan.setText("");

                                spinTk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihTk = spinTk.getSelectedItem().toString();
                                        if (pilihTk.equals("Pilih tingkat kerusakan")){
                                            hasilHitung.setText("");
                                            inputLV.setText("");
                                            inputItI.setText("");
                                            spinHsbg.setSelection(0);

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    hasilHitung.setError("Pilih tingkat kerusakan");
                                                }
                                            });
                                        }
                                        else if (pilihTk.equals("0.45 (untuk tingkat kerusakan sedang)")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);
                                            spinHsbg.setSelection(0);

                                            //membuka view yang diperlukan
                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")){
                                                        hasilHitung.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                hasilHitung.setError("Pilih Jenis Bangunan");
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.45 * 6000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.45 * 12000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.45 * 18000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }else if (pilihTk.equals("0.65 (untuk tingkat kerusakan berat)")){
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);
                                            spinHsbg.setSelection(0);


                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    final String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                                        hasilHitung.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                hasilHitung.setError("Pilih Jenis Bangunan");
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {

                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 6000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 12000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 18000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }
                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }else if (pilihIMB.equals("Retribusi pembangunan bukan gedung baru atau prasarana bangunan gedung")){
                                //menutup view yang tidak diperlukan
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                lv.setVisibility(View.VISIBLE);
                                lv.setText("V");
                                inputLV.setVisibility(View.VISIBLE);
                                inputLV.setHint(R.string.ket_volume);
                                inputLV.setText("");
                                ItI.setVisibility(View.VISIBLE);
                                ItI.setText("I");
                                inputItI.setVisibility(View.VISIBLE);
                                inputItI.setHint(R.string.indeks);
                                inputItI.setText("");
                                indeks.setVisibility(View.VISIBLE);
                                hasilHitung.setText("");
                                spinHsbg.setVisibility(View.VISIBLE);
                                spinHsbg.setSelection(0);
                                keterangan.setVisibility(View.VISIBLE);
                                keterangan.setText("");
                                spinHsbg.setSelection(0);

                                spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihHsbg = spinHsbg.getSelectedItem().toString();
                                        if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    hasilHitung.setError("Pilih Jenis Bangunan");
                                                }
                                            });
                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 6000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_bukan_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 12000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_bukan_gedung_baru);
                                                }
                                            });

                                        } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);

                                            //membuka view yang diperlukan
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    String lvNull = inputLV.getText().toString();
                                                    String ItINull = inputItI.getText().toString();

                                                    if(TextUtils.isEmpty(lvNull)) {
                                                        inputLV.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(ItINull)){
                                                        inputItI.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strlv = inputLV.getText().toString();
                                                    String strItI = inputItI.getText().toString();
                                                    double lv = Double.parseDouble(strlv);
                                                    double ItI = Double.parseDouble(strItI);

                                                    Integer hasil = Integer.valueOf((int) (lv * ItI * 1 * 18000));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_bukan_gedung_baru);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else if(pilihIMB.equals("Retribusi rehabilitasi prasarana bangunan gedung")){
                                //menutup view yang tidak diperlukan
                                indeks.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                lv.setVisibility(View.VISIBLE);
                                lv.setText("V");
                                inputLV.setVisibility(View.VISIBLE);
                                inputLV.setHint(R.string.ket_volume);
                                inputLV.setText("");
                                ItI.setVisibility(View.VISIBLE);
                                ItI.setText("I");
                                inputItI.setVisibility(View.VISIBLE);
                                inputItI.setHint(R.string.indeks);
                                inputItI.setText("");
                                spinTk.setVisibility(View.VISIBLE);
                                spinTk.setSelection(0);
                                spinHsbg.setVisibility(View.VISIBLE);
                                spinHsbg.setSelection(0);
                                keterangan.setVisibility(View.VISIBLE);
                                keterangan.setText("");

                                spinTk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihTk = spinTk.getSelectedItem().toString();
                                        if (pilihTk.equals("Pilih tingkat kerusakan")){
                                            hasilHitung.setText("");
                                            inputLV.setText("");
                                            inputItI.setText("");
                                            spinHsbg.setSelection(0);

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    hasilHitung.setError("Pilih Tingkat Kerusakan");
                                                }
                                            });
                                        }
                                        else if (pilihTk.equals("0.45 (untuk tingkat kerusakan sedang)")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);
                                            spinHsbg.setSelection(0);

                                            //membuka view yang diperlukan
                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")){
                                                        hasilHitung.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                hasilHitung.setError("Pilih Jenis Bangunan");
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.45 * 6000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                String hasil = String.valueOf(lv * It * 0.45 * 12000);
                                                                hasilHitung.setText(hasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    }else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.45 * 6000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }else if (pilihTk.equals("0.65 (untuk tingkat kerusakan berat)")){
                                            hasilHitung.setText("");
                                            hasilHitung.setError(null);
                                            spinHsbg.setSelection(0);
//                                            spinHsbg.getSelectedItem().equals("Pilih Jenis Bangunan");

                                            spinHsbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    final String pilihHsbg = spinHsbg.getSelectedItem().toString();

                                                    if (pilihHsbg.equals("Pilih Jenis Bangunan")) {
                                                        hasilHitung.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                hasilHitung.setError("Pilih Jenis Bangunan");
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat sederhana (Rp. 6000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 6000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    } else if (pilihHsbg.equals("Bangunan gedung tidak bertingkat (Rp. 12.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 12000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });

                                                    } else if (pilihHsbg.equals("Bangunan gedung bertingkat (Rp. 18.000 permeter persegi)")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        hasilHitung.setError(null);

                                                        //membuka view yang diperlukan
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String lvNull = inputLV.getText().toString();
                                                                String ItINull = inputItI.getText().toString();

                                                                if(TextUtils.isEmpty(lvNull)) {
                                                                    inputLV.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }
                                                                if (TextUtils.isEmpty(ItINull)){
                                                                    inputItI.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strlv = inputLV.getText().toString();
                                                                String strIt = inputItI.getText().toString();
                                                                double lv = Double.parseDouble(strlv);
                                                                double It = Double.parseDouble(strIt);

                                                                Integer hasil = Integer.valueOf((int) (lv * It * 0.65 * 18000));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_renovasi_gedung);
                                                            }
                                                        });
                                                    }
                                                }
                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (pilihIzin.equals("Izin Usaha Perikanan")){

                    //menutup view yang tidak diperlukan
                    llpertama.setVisibility(View.GONE);
                    ketTenagaKerja.setVisibility(View.GONE);
                    llkedua.setVisibility(View.GONE);
                    spinRumput.setVisibility(View.GONE);
                    spinHsbg.setVisibility(View.GONE);
                    spinKerang.setVisibility(View.GONE);
                    spinPenangkapanIkan.setVisibility(View.GONE);
                    hasilHitung.setText("");

                    //membuka view yang diperlukan
                    llketiga.setVisibility(View.VISIBLE);
                    jenisPerikanan.setVisibility(View.VISIBLE);
                    jenisPerikanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String pilihPerikanan = jenisPerikanan.getSelectedItem().toString();

                            if (pilihPerikanan.equals("Pilih jenis perikanan")){
                                perikananTawar.setVisibility(View.GONE);
                                perikananPayau.setVisibility(View.GONE);
                                teksLuas.setVisibility(View.GONE);
                                inputLuas.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                spinRumput.setVisibility(View.GONE);
                                spinHsbg.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);
                                spinPenangkapanIkan.setVisibility(View.GONE);
                                keterangan.setVisibility(View.GONE);

                            }else if (pilihPerikanan.equals("Ikan air tawar")){
                                //menutup view yang tidak diperlukan
                                perikananPayau.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                teksLuas.setVisibility(View.GONE);
                                inputLuas.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                perikananTawar.setVisibility(View.VISIBLE);
                                perikananTawar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihTawar = perikananTawar.getSelectedItem().toString();
                                        if (pilihTawar.equals("Pilih metode perikanan air tawar")){
                                            perikananPayau.setVisibility(View.GONE);
                                            hasilHitung.setText("");
                                            teksLuas.setVisibility(View.GONE);
                                            inputLuas.setVisibility(View.GONE);


                                        }else if (pilihTawar.equals("Pembenihan ikan dengan luas 0,75 ha atau lebih")){
                                            //menutup view yang tidak diperlukan
                                            perikananPayau.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_lahan);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_tawar1);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (100000 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_tawar1);
                                                }
                                            });

                                        }else if (pilihTawar.equals("Pembenihan ikan dengan luas 2 ha atau lebih")){
                                            //menutup view yang tidak diperlukan
                                            perikananPayau.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_lahan);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_tawar2);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (100000 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_tawar2);
                                                }
                                            });
                                        }else if (pilihTawar.equals("Pembenihan ikan lebih dari 5 unit")){
                                            //menutup view yang tidak diperlukan
                                            perikananPayau.setVisibility(View.GONE);
                                            hasilHitung.setText("");


                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_unit);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_tawar3);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (150 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_tawar3);
                                                }
                                            });
                                        }else if (pilihTawar.equals("Usaha keramba jaring apung lebih dari 4 unit")){
                                            //menutup view yang tidak diperlukan
                                            perikananPayau.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_unit);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_tawar4);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (15000 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_tawar4);
                                                }
                                            });
                                        }else if (pilihTawar.equals("Usaha keramba lebih dari 50 unit")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_unit);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_tawar5);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (150 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_tawar5);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else if (pilihPerikanan.equals("Ikan air payau")){
                                //menutup view yang tidak diperlukan
                                perikananTawar.setVisibility(View.GONE);
                                teksLuas.setVisibility(View.GONE);
                                inputLuas.setVisibility(View.GONE);
                                hasilHitung.setText("");
                                keterangan.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                perikananPayau.setVisibility(View.VISIBLE);
                                perikananPayau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        final String pilihPayau = perikananPayau.getSelectedItem().toString();
                                        if (pilihPayau.equals("Pilih metode perikanan air payau")){
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);
                                            inputLuas.setVisibility(View.GONE);
                                            teksLuas.setVisibility(View.GONE);
                                            hasilHitung.setText("");
                                            keterangan.setVisibility(View.GONE);

                                        }else if (pilihPayau.equals("Pembenihan ikan dengan luas 0,5 ha atau lebih")){
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_lahan);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_payau1);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (100000 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_payau1);
                                                }
                                            });
                                        }else if (pilihPayau.equals("Pembesaran ikan dengan luas 5 ha atau lebih")){
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang tidak digunakan
                                            teksLuas.setVisibility(View.VISIBLE);
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.luas_lahan);
                                            inputLuas.setText("");
                                            keterangan.setVisibility(View.VISIBLE);
                                            keterangan.setText(R.string.ket_payau2);
                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String luasNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(luasNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strLuas = inputLuas.getText().toString();
                                                    double luas = Double.parseDouble(strLuas);

                                                    Integer hasil = Integer.valueOf((int) (100000 * luas));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_payau2);
                                                }
                                            });
                                        }else if (pilihPayau.equals("Pembudidayaan rumput laut")){
                                            //menutup view yang tidak diperlukan
                                            spinKerang.setVisibility(View.GONE);
                                            hasilHitung.setText("");
                                            keterangan.setVisibility(View.GONE);

                                            //membuka view yang dibutuhkan
                                            spinRumput.setVisibility(View.VISIBLE);
                                            spinRumput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihRumput = spinRumput.getSelectedItem().toString();
                                                    if (pilihRumput.equals("pilih metode budidaya rumput laut")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        teksLuas.setVisibility(View.GONE);
                                                        inputLuas.setVisibility(View.GONE);
                                                        keterangan.setVisibility(View.GONE);

                                                    } else if (pilihRumput.equals("Lepas dasar")) {
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");

                                                        //membuka view yang diperlukan
                                                        teksLuas.setVisibility(View.VISIBLE);
                                                        inputLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setText(R.string.luas_lepas_dasar);
                                                        inputLuas.setText("");
                                                        keterangan.setVisibility(View.VISIBLE);
                                                        keterangan.setText(R.string.ket_rumput_lepas);
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String luasNull = inputLuas.getText().toString();

                                                                if(TextUtils.isEmpty(luasNull)) {
                                                                    inputLuas.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strLuas = inputLuas.getText().toString();
                                                                double luas = Double.parseDouble(strLuas);

                                                                Integer hasil = Integer.valueOf((int) (5 * luas));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_rumput_lepas);
                                                            }
                                                        });
                                                    } else if (pilihRumput.equals("Rakit apung")) {
                                                        //menutup view yang tidak diperlukan

                                                        //membuka view yang tidak digunakan
                                                        teksLuas.setVisibility(View.VISIBLE);
                                                        inputLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setText(R.string.luas_usaha_rakit_apung);
                                                        inputLuas.setText("");
                                                        keterangan.setVisibility(View.VISIBLE);
                                                        keterangan.setText(R.string.ket_rumput_rakit);
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String luasNull = inputLuas.getText().toString();

                                                                if(TextUtils.isEmpty(luasNull)) {
                                                                    inputLuas.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strLuas = inputLuas.getText().toString();
                                                                double luas = Double.parseDouble(strLuas);

                                                                Integer hasil = Integer.valueOf((int) (5 * luas));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_rumput_rakit);
                                                            }
                                                        });
                                                    } else if (pilihRumput.equals("Long line")) {
                                                        //menutup view yang tidak diperlukan

                                                        //membuka view yang tidak digunakan
                                                        teksLuas.setVisibility(View.VISIBLE);
                                                        inputLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setText(R.string.luas_longline);
                                                        inputLuas.setText("");
                                                        keterangan.setVisibility(View.VISIBLE);
                                                        keterangan.setText(R.string.ket_rumput_longline);
                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String luasNull = inputLuas.getText().toString();

                                                                if(TextUtils.isEmpty(luasNull)) {
                                                                    inputLuas.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strLuas = inputLuas.getText().toString();
                                                                double luas = Double.parseDouble(strLuas);

                                                                Integer hasil = Integer.valueOf((int) (50000 * luas));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_rumput_longline);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                        else if (pilihPayau.equals("Usaha kerang hijau")){
                                            //menutup view yang tidak diperlukan
                                            spinRumput.setVisibility(View.GONE);
                                            teksLuas.setVisibility(View.GONE);
                                            inputLuas.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                            //membuka view yang diperlukan
                                            spinKerang.setVisibility(View.VISIBLE);
                                            spinKerang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String pilihKerang = spinKerang.getSelectedItem().toString();

                                                    if (pilihKerang.equals("pilih metode usaha kerang hijau")){
                                                        //menutup view yang tidak diperlukan
                                                        inputLuas.setVisibility(View.GONE);
                                                        teksLuas.setVisibility(View.GONE);
                                                        hasilHitung.setText("");

                                                    }else if (pilihKerang.equals("Rakit apung atau rakit tancap")){
                                                        //menutup view yang tidak diperlukan
                                                        hasilHitung.setText("");
                                                        inputLuas.setText("");

                                                        //membuka view yang tidak digunakan
                                                        inputLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setText(R.string.luas_usaha_rakit_apung);
                                                        inputLuas.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String luasNull = inputLuas.getText().toString();

                                                                if(TextUtils.isEmpty(luasNull)) {
                                                                    inputLuas.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strLuas = inputLuas.getText().toString();
                                                                double luas = Double.parseDouble(strLuas);

                                                                Integer hasil = Integer.valueOf((int) (5 * luas));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_kerang_rakit);
                                                            }
                                                        });

                                                    }else if(pilihKerang.equals("Long line")){
                                                        //menutup view yang tidak diperlukan
                                                        inputLuas.setText("");
                                                        hasilHitung.setText("");

                                                        //membuka view yang tidak digunakan
                                                        inputLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setVisibility(View.VISIBLE);
                                                        teksLuas.setText(R.string.luas_longline);
                                                        inputLuas.setText("");

                                                        tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                String luasNull = inputLuas.getText().toString();

                                                                if(TextUtils.isEmpty(luasNull)) {
                                                                    inputLuas.setError("nilai tidak boleh kosong");
                                                                    return;
                                                                }

                                                                String strLuas = inputLuas.getText().toString();
                                                                double luas = Double.parseDouble(strLuas);

                                                                Integer hasil = Integer.valueOf((int) (10 * luas));
                                                                String strHasil = String.valueOf(hasil);
                                                                hasilHitung.setText(strHasil);
                                                                keterangan.setText(R.string.ket_rumput_longline);
                                                            }
                                                        });

                                                    }

                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });


                            }else if (pilihPerikanan.equals("Usaha perikanan penangkapan ikan")){
                                //menutup view yang tidak diperlukan
                                perikananTawar.setVisibility(View.GONE);
                                perikananPayau.setVisibility(View.GONE);
                                teksLuas.setVisibility(View.GONE);
                                inputLuas.setVisibility(View.GONE);
                                hasilHitung.setText("");

                                spinPenangkapanIkan.setVisibility(View.VISIBLE);
                                spinPenangkapanIkan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String pilihKapal = spinPenangkapanIkan.getSelectedItem().toString();

                                        if (pilihKapal.equals("Pilih metode penangkapan ikan")){
                                            //menutup view yang tidak diperlukan
                                            teksLuas.setVisibility(View.GONE);
                                            inputLuas.setVisibility(View.GONE);
                                            hasilHitung.setText("");

                                        }else if (pilihKapal.equals("penangkapan ikan dengan kapal bobot dibawah 5 GT")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            inputLuas.setText("");

                                            //membuka view yang tidak digunakan
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.jumlah_kapal);
                                            inputLuas.setText("");

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String kapalNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(kapalNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strKapal = inputLuas.getText().toString();
                                                    double kapal = Double.parseDouble(strKapal);

                                                    Integer hasil = Integer.valueOf((int) (40000 * kapal));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_ikan_kapal);
                                                }
                                            });
                                        }else if (pilihKapal.equals("Rawe (long line) dan gill net")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            inputLuas.setText("");

                                            //membuka view yang tidak digunakan
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.jumlah_kapal_tahun);
                                            inputLuas.setText("");

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String kapalNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(kapalNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strKapal = inputLuas.getText().toString();
                                                    double kapal = Double.parseDouble(strKapal);

                                                    Integer hasil = Integer.valueOf((int) (30000 * kapal));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_ikan_longline);
                                                }
                                            });
                                        }else if (pilihKapal.equals("mini purse seine")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            inputLuas.setText("");

                                            //membuka view yang tidak digunakan
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.jumlah_kapal_tahun);
                                            inputLuas.setText("");

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String kapalNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(kapalNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strKapal = inputLuas.getText().toString();
                                                    double kapal = Double.parseDouble(strKapal);

                                                    Integer hasil = Integer.valueOf((int) (350000 * kapal));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_ikan_purse);
                                                }
                                            });
                                        }else if (pilihKapal.equals("alat lainnya dengan bobot kapal dibawah 5 GT")){
                                            //menutup view yang tidak diperlukan
                                            hasilHitung.setText("");
                                            inputLuas.setText("");

                                            //membuka view yang tidak digunakan
                                            inputLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setVisibility(View.VISIBLE);
                                            teksLuas.setText(R.string.jumlah_kapal_tahun);
                                            inputLuas.setText("");

                                            tombolHasil.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String kapalNull = inputLuas.getText().toString();

                                                    if(TextUtils.isEmpty(kapalNull)) {
                                                        inputLuas.setError("nilai tidak boleh kosong");
                                                        return;
                                                    }

                                                    String strKapal = inputLuas.getText().toString();
                                                    double kapal = Double.parseDouble(strKapal);

                                                    Integer hasil = Integer.valueOf((int) (25000 * kapal));
                                                    String strHasil = String.valueOf(hasil);
                                                    hasilHitung.setText(strHasil);
                                                    keterangan.setText(R.string.ket_ikan_other);
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }else if (pilihPerikanan.equals("Usaha kapal pengangkutan ikan")){
                                // menutup view yang tidak diperlukan
                                hasilHitung.setText("");
                                spinPenangkapanIkan.setVisibility(View.GONE);
                                perikananTawar.setVisibility(View.GONE);
                                perikananPayau.setVisibility(View.GONE);
                                spinTk.setVisibility(View.GONE);
                                spinRumput.setVisibility(View.GONE);
                                spinKerang.setVisibility(View.GONE);

                                //membuka view yang diperlukan
                                teksLuas.setVisibility(View.VISIBLE);
                                teksLuas.setText(R.string.jumlah_kapal);
                                inputLuas.setVisibility(View.VISIBLE);
                                inputLuas.setText("");

                                tombolHasil.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String kapalNull = inputLuas.getText().toString();

                                        if(TextUtils.isEmpty(kapalNull)) {
                                            inputLuas.setError("nilai tidak boleh kosong");
                                            return;
                                        }

                                        String strKapal = inputLuas.getText().toString();
                                        double kapal = Double.parseDouble(strKapal);

                                        Integer hasil = Integer.valueOf((int) (40000 * kapal));
                                        String strHasil = String.valueOf(hasil);
                                        hasilHitung.setText(strHasil);
                                        keterangan.setText(R.string.ket_pengangkutan_ikan);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
