package com.example.dethicuachien;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList<HangMT> hangList;
    private ArrayAdapter<HangMT> adapter;
    ListView lv;
    private HangMT mainHang;
    Button btnNextMT;
    TextView tvJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        hangList = new ArrayList<>();
        hangList.add(new HangMT("Dell"));
        hangList.add(new HangMT("Apple"));
        hangList.add(new HangMT("HP"));
        hangList.add(new HangMT("ACER"));
        hangList.add(new HangMT("ASUS"));

        adapter = new ArrayAdapter<>(MainActivity3.this, android.R.layout.simple_list_item_1, hangList);
        lv = findViewById(R.id.lvHangmt);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mainHang = hangList.get(i);
                ShowAlert("Day la: " + mainHang);
            }
        });

        btnNextMT = findViewById(R.id.btnNextt);
        btnNextMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJSON();
            }
        });
    }
    private void loadJSON(){
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);
            is.close();

            String json = new String(b, StandardCharsets.UTF_8);
            JSONArray jsa = new JSONArray(json);
            String name, color;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < jsa.length(); i++){
                JSONObject jso = jsa.getJSONObject(i);
                color = jso.getString("color");
                name = jso.getString("name");

                sb.append(String.format("Ten may tinh: %s\nMau sac: %s\n",name,color));
                tvJSON = findViewById(R.id.tvJSON);
                tvJSON.setText(sb);
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
    private void ShowAlert(String mess){
        new AlertDialog.Builder(this).setMessage(mess).setPositiveButton("Dong", null).show();
    }
}