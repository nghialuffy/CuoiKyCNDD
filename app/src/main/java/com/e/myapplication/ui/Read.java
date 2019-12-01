package com.e.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.myapplication.MainActivity;
import com.e.myapplication.R;

public class Read extends AppCompatActivity {

    private ImageButton mBtnBack, mBtnHome, mBtnFordward;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mBtnBack = (ImageButton) findViewById(R.id.btnBack);
        mBtnHome = (ImageButton) findViewById(R.id.btnHome);
        mBtnFordward = (ImageButton) findViewById(R.id.btnForward);
        mTv = (TextView) findViewById(R.id.tvContent);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        Truyen truyen = (Truyen) bundle.getSerializable("truyen");
        mTv.setText(truyen.getDatatruyen());


        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Read.this,SelectChapter.class);
                startActivity(intent);
            }
        });
        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Read.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnFordward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kiem tra cuoi chuong chua?
            }
        });

    }
}
