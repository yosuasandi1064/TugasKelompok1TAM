package com.e.simpleapp;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private EditText num;
    private Button proses;
    private TextView result;
    private Spinner spinner1, spinner2;
    ArrayAdapter<String> adapter;
    String item1, item2;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final ArrayList<String> data = new ArrayList<>();
        data.add(0,"Pilih");
        data.add(1,"km");
        data.add(2,"hm");
        data.add(3,"dam");
        data.add(4,"m");
        data.add(5,"dm");
        data.add(6,"cm");
        data.add(7,"mm");


        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Pilih")){
                    //nothing
                }
                else {
                    item1 = parent.getItemAtPosition(position).toString();
                    //Toast.makeText(parent.getContext(),"Selected : "+item1, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Pilih")){
                    //nothing
                }
                else {
                    item2 = parent.getItemAtPosition(position).toString();
                    //Toast.makeText(parent.getContext(),"Selected : "+item2, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        num = (EditText) view.findViewById(R.id.angka);
        proses = (Button) view.findViewById(R.id.hitung);
        result = (TextView) view.findViewById(R.id.hasil);

        num.setHint("Input here");

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.hitung){
                    String nilai = num.getText().toString().trim();
                    boolean isEmptyFields = false;
                    if(TextUtils.isEmpty(nilai)){
                        isEmptyFields = true;
                        num.setError("Field ini tidak boleh kosong");
                    }
                    if(!isEmptyFields){
                            if(item1=="km"){
                                double n = Double.parseDouble(nilai);
                                double km = n*1;
                                double hm = n * 10;
                                double dam = n * 100;
                                double m = n * 1000;
                                double dm = n * 10000;
                                double cm = n * 100000;
                                double mm = n * 1000000;
                                if(item2=="km"){
                                    result.setText(String.valueOf(km));
                                }else if(item2=="hm"){
                                    result.setText(String.valueOf(hm));
                                }else if(item2=="dam"){
                                    result.setText(String.valueOf(dam));
                                }else if(item2=="m"){
                                    result.setText(String.valueOf(m));
                                }else if(item2=="dm"){
                                    result.setText(String.valueOf(dm));
                                }else if(item2=="cm"){
                                    result.setText(String.valueOf(cm));
                                }else if(item2=="mm"){
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="hm"){
                                double n = Double.parseDouble(nilai);
                                double km = n/10;
                                double hm = n * 1;
                                double dam = n * 10;
                                double m = n * 100;
                                double dm = n * 1000;
                                double cm = n * 10000;
                                double mm = n * 100000;
                                if(item2=="km"){
                                    result.setText(String.valueOf(km));
                                }else if(item2=="hm"){
                                    result.setText(String.valueOf(hm));
                                }else if(item2=="dam"){
                                    result.setText(String.valueOf(dam));
                                }else if(item2=="m"){
                                    result.setText(String.valueOf(m));
                                }else if(item2=="dm"){
                                    result.setText(String.valueOf(dm));
                                }else if(item2=="cm"){
                                    result.setText(String.valueOf(cm));
                                }else if(item2=="mm"){
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="dam") {
                                double n = Double.parseDouble(nilai);
                                double km = n / 100;
                                double hm = n / 10;
                                double dam = n * 1;
                                double m = n * 10;
                                double dm = n * 100;
                                double cm = n * 1000;
                                double mm = n * 10000;
                                if (item2 == "km") {
                                    result.setText(String.valueOf(km));
                                } else if (item2 == "hm") {
                                    result.setText(String.valueOf(hm));
                                } else if (item2 == "dam") {
                                    result.setText(String.valueOf(dam));
                                } else if (item2 == "m") {
                                    result.setText(String.valueOf(m));
                                } else if (item2 == "dm") {
                                    result.setText(String.valueOf(dm));
                                } else if (item2 == "cm") {
                                    result.setText(String.valueOf(cm));
                                } else if (item2 == "mm") {
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="m") {
                                double n = Double.parseDouble(nilai);
                                double km = n / 1000;
                                double hm = n / 100;
                                double dam = n / 10;
                                double m = n * 1;
                                double dm = n * 10;
                                double cm = n * 100;
                                double mm = n * 1000;
                                if (item2 == "km") {
                                    result.setText(String.valueOf(km));
                                } else if (item2 == "hm") {
                                    result.setText(String.valueOf(hm));
                                } else if (item2 == "dam") {
                                    result.setText(String.valueOf(dam));
                                } else if (item2 == "m") {
                                    result.setText(String.valueOf(m));
                                } else if (item2 == "dm") {
                                    result.setText(String.valueOf(dm));
                                } else if (item2 == "cm") {
                                    result.setText(String.valueOf(cm));
                                } else if (item2 == "mm") {
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="dm") {
                                double n = Double.parseDouble(nilai);
                                double km = n / 10000;
                                double hm = n / 1000;
                                double dam = n / 100;
                                double m = n / 10;
                                double dm = n * 1;
                                double cm = n * 10;
                                double mm = n * 100;
                                if (item2 == "km") {
                                    result.setText(String.valueOf(km));
                                } else if (item2 == "hm") {
                                    result.setText(String.valueOf(hm));
                                } else if (item2 == "dam") {
                                    result.setText(String.valueOf(dam));
                                } else if (item2 == "m") {
                                    result.setText(String.valueOf(m));
                                } else if (item2 == "dm") {
                                    result.setText(String.valueOf(dm));
                                } else if (item2 == "cm") {
                                    result.setText(String.valueOf(cm));
                                } else if (item2 == "mm") {
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="cm") {
                                double n = Double.parseDouble(nilai);
                                double km = n / 100000;
                                double hm = n / 10000;
                                double dam = n / 1000;
                                double m = n / 100;
                                double dm = n / 10;
                                double cm = n * 1;
                                double mm = n * 10;
                                if (item2 == "km") {
                                    result.setText(String.valueOf(km));
                                } else if (item2 == "hm") {
                                    result.setText(String.valueOf(hm));
                                } else if (item2 == "dam") {
                                    result.setText(String.valueOf(dam));
                                } else if (item2 == "m") {
                                    result.setText(String.valueOf(m));
                                } else if (item2 == "dm") {
                                    result.setText(String.valueOf(dm));
                                } else if (item2 == "cm") {
                                    result.setText(String.valueOf(cm));
                                } else if (item2 == "mm") {
                                    result.setText(String.valueOf(mm));
                                }
                            }else if(item1=="mm") {
                                double n = Double.parseDouble(nilai);
                                double km = n / 1000000;
                                double hm = n / 100000;
                                double dam = n / 10000;
                                double m = n / 1000;
                                double dm = n / 100;
                                double cm = n / 10;
                                double mm = n * 1;
                                if (item2 == "km") {
                                    result.setText(String.valueOf(km));
                                } else if (item2 == "hm") {
                                    result.setText(String.valueOf(hm));
                                } else if (item2 == "dam") {
                                    result.setText(String.valueOf(dam));
                                } else if (item2 == "m") {
                                    result.setText(String.valueOf(m));
                                } else if (item2 == "dm") {
                                    result.setText(String.valueOf(dm));
                                } else if (item2 == "cm") {
                                    result.setText(String.valueOf(cm));
                                } else if (item2 == "mm") {
                                    result.setText(String.valueOf(mm));
                                }
                            }
                    }
                }
            }
        });

        if(savedInstanceState!= null){
            String hasilakhir = savedInstanceState.getString(STATE_HASIL);
            result.setText(hasilakhir);
        }
        return view;
    }

    private static final String STATE_HASIL = "state_hasil";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, result.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
