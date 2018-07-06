package com.viettel.voffice.tablet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.viettel.voffice.tablet.R;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView txtVie, txtEng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnLogin = findViewById(R.id.btn_login);
        txtVie = findViewById(R.id.txt_vie);
        txtEng = findViewById(R.id.txt_eng);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),Voffice.class);
                startActivity(it);
                finish();
            }
        });

        txtVie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSelectAll();
                txtVie.setTextColor(getResources().getColor(R.color.WHITE_COLOR));
                txtVie.setBackground(getResources().getDrawable(R.drawable.tab_stroke_select_left));
            }
        });

        txtEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSelectAll();
                txtEng.setTextColor(getResources().getColor(R.color.WHITE_COLOR));
                txtEng.setBackground(getResources().getDrawable(R.drawable.tab_stroke_select_right));
            }
        });
        txtVie.performClick();
    }

    public void unSelectAll(){
        txtVie.setBackground(getResources().getDrawable(R.drawable.tab_stroke_notselect_left));
        txtVie.setTextColor(getResources().getColor(R.color.toolbar_title_color));
        txtEng.setBackground(getResources().getDrawable(R.drawable.tab_stroke_not_select_right));
        txtEng.setTextColor(getResources().getColor(R.color.toolbar_title_color));
    }
}
