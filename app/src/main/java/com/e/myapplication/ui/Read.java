package com.e.myapplication.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.myapplication.MainActivity;
import com.e.myapplication.R;

public class Read extends AppCompatActivity {

    private ImageButton mBtnBack, mBtnHome, mBtnFordward;
    private TextView mTv;
    private Switch switchMode, switchMode2;
    private LinearLayout llTruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mBtnBack = (ImageButton) findViewById(R.id.btnBack);
        mBtnHome = (ImageButton) findViewById(R.id.btnHome);
        mBtnFordward = (ImageButton) findViewById(R.id.btnForward);
        mTv = (TextView) findViewById(R.id.tvContent);
        switchMode = (Switch) findViewById(R.id.switch_id);
        switchMode2 = (Switch) findViewById(R.id.switch_idEng);
        llTruyen = (LinearLayout) findViewById(R.id.idlayout);

        final Bitmap back_dark = BitmapFactory.decodeResource(getResources(), R.drawable.back_dark);
        final Bitmap forw_dark = BitmapFactory.decodeResource(getResources(), R.drawable.forw_dark);
        final Bitmap home_dark = BitmapFactory.decodeResource(getResources(), R.drawable.home_dark);

        final Bitmap back_light = BitmapFactory.decodeResource(getResources(), R.drawable.back_light);
        final Bitmap forw_light = BitmapFactory.decodeResource(getResources(), R.drawable.forw_light);
        final Bitmap home_light = BitmapFactory.decodeResource(getResources(), R.drawable.home_light);




        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        Truyen truyen = (Truyen) bundle.getSerializable("truyen");
        mTv.setText(truyen.getDatatruyen());

        mTv.setTextColor(getColor(R.color.colorWordLight));
        llTruyen.setBackgroundColor(Color.parseColor("#ffffff"));
        mBtnBack.setImageBitmap(back_light);
        mBtnFordward.setImageBitmap(forw_light);
        mBtnHome.setImageBitmap(home_light);

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mTv.setTextColor(getColor(R.color.colorWordDark));
                    llTruyen.setBackgroundColor(Color.parseColor("#000000"));
                    mBtnBack.setImageBitmap(back_dark);
                    mBtnFordward.setImageBitmap(forw_dark);
                    mBtnHome.setImageBitmap(home_dark);

                }else {
                    mTv.setTextColor(getColor(R.color.colorWordLight));
                    llTruyen.setBackgroundColor(Color.parseColor("#ffffff"));
                    mBtnBack.setImageBitmap(back_light);
                    mBtnFordward.setImageBitmap(forw_light);
                    mBtnHome.setImageBitmap(home_light);
                }
            }
        });

        switchMode2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Intent intent = getIntent();
                    Bundle bundle = intent.getBundleExtra("package");
                    Truyen truyen = (Truyen) bundle.getSerializable("truyen");
                    mTv.setText(truyen.getDatatruyenEng());

                }else {
                    Intent intent = getIntent();
                    Bundle bundle = intent.getBundleExtra("package");
                    Truyen truyen = (Truyen) bundle.getSerializable("truyen");
                    mTv.setText(truyen.getDatatruyen());
                }
            }
        });

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
