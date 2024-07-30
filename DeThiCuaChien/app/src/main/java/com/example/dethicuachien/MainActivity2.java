package com.example.dethicuachien;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    RadioButton dienthoai, laptop, maytinhbang, phukien;
    CheckBox tulanh, tivi, dieuhoa;
    Button Exit, Next, Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        dienthoai = findViewById(R.id.rbDienThoai);
        laptop = findViewById(R.id.rbLapTop);
        maytinhbang = findViewById(R.id.rbPhuKien);
        tulanh = findViewById(R.id.cbTulanh);
        tivi = findViewById(R.id.cbTivi);
        dieuhoa = findViewById(R.id.cbDieuhoa);
        Exit = findViewById(R.id.btnExit);
        Next = findViewById(R.id.btnNext);
        Submit = findViewById(R.id.btnSubmit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dienthoai.isChecked() && tulanh.isChecked() && tivi.isChecked() && dieuhoa.isChecked()){
                    ShowAlert("Day la dien thoai, tu lanh, tivi va dieu hoa");
                }
                if(dienthoai.isChecked() && tulanh.isChecked()){
                    ShowAlert("Day la dien thoai va tu lanh");
                }
                if(laptop.isChecked() && tulanh.isChecked()){
                    ShowAlert("Day la laptop va tu lanh");
                }
                if(maytinhbang.isChecked() && tulanh.isChecked()){
                    ShowAlert("Day la may tinh bang va tu lanh");
                }
                if(phukien.isChecked() && tulanh.isChecked()){
                    ShowAlert("Day la phu kien va tu lanh");
                }
            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
    private void ShowAlert(String mess){
        new AlertDialog.Builder(this).setMessage(mess).setPositiveButton("Dong", null).show();
    }
}