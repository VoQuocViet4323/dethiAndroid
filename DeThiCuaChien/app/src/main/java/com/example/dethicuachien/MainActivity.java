package com.example.dethicuachien;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText masv, malop;
    Button Login, Reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        masv = findViewById(R.id.masv);
        malop = findViewById(R.id.malop);
        Login = findViewById(R.id.btnLogin);
        Reset = findViewById(R.id.btnReset);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masinhvien = masv.getText().toString();
                String malopp = malop.getText().toString();
                if(masinhvien.equals("masinhvien") && malopp.equals("cnttk15")){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    ShowAlert("Them thanh cong");
                }else{
                    ShowAlert("Username hoac password sai, Vui long nhap lai!");
                }
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masv.setText("");
                malop.setText("");
            }
        });

    }
    private void ShowAlert(String mess){
        new AlertDialog.Builder(this).setMessage(mess).setPositiveButton("Dong", null).show();
    }
}