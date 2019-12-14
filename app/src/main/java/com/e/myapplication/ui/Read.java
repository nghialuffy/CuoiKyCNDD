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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.e.myapplication.MainActivity;
import com.e.myapplication.R;
import com.e.myapplication.ui.mybooks.MybooksFragment;

public class Read extends AppCompatActivity {

    private ImageButton mBtnBack, mBtnFordward;
    private TextView mTv, tvNameTruyen;
    private Switch switchMode, switchMode2;
    private LinearLayout llTruyen;
    private Integer id;
    private Truyen truyen;
    private String nameTruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mBtnBack = (ImageButton) findViewById(R.id.btnBack);
        mBtnFordward = (ImageButton) findViewById(R.id.btnForward);
        mTv = (TextView) findViewById(R.id.tvContent);
        switchMode = (Switch) findViewById(R.id.switch_id);
        switchMode2 = (Switch) findViewById(R.id.switch_idEng);
        llTruyen = (LinearLayout) findViewById(R.id.idlayout);
        tvNameTruyen = (TextView) findViewById(R.id.nametruyen);

        final Bitmap back_dark = BitmapFactory.decodeResource(getResources(), R.drawable.back_dark);
        final Bitmap forw_dark = BitmapFactory.decodeResource(getResources(), R.drawable.forw_dark);
        final Bitmap home_dark = BitmapFactory.decodeResource(getResources(), R.drawable.home_dark);

        final Bitmap back_light = BitmapFactory.decodeResource(getResources(), R.drawable.back_light);
        final Bitmap forw_light = BitmapFactory.decodeResource(getResources(), R.drawable.forw_light);
        final Bitmap home_light = BitmapFactory.decodeResource(getResources(), R.drawable.home_light);




        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        truyen = (Truyen) bundle.getSerializable("truyen");
        id = (Integer) bundle.getSerializable("id");
        tvNameTruyen.setText(truyen.getTentruyen());
        mTv.setText(truyen.getDatatruyen());


        mTv.setTextColor(getColor(R.color.colorWordLight));
        llTruyen.setBackgroundColor(Color.parseColor("#ffffff"));
        mBtnBack.setImageBitmap(back_light);
        mBtnFordward.setImageBitmap(forw_light);

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mTv.setTextColor(getColor(R.color.colorWordDark));
                    tvNameTruyen.setTextColor(getColor(R.color.colorWordDark));
                    switchMode.setTextColor(getColor(R.color.colorWordDark));
                    switchMode2.setTextColor(getColor(R.color.colorWordDark));
                    llTruyen.setBackgroundColor(Color.parseColor("#000000"));
                    mBtnBack.setImageBitmap(back_dark);
                    mBtnFordward.setImageBitmap(forw_dark);

                }else {
                    mTv.setTextColor(getColor(R.color.colorWordLight));
                    tvNameTruyen.setTextColor(getColor(R.color.colorWordLight));
                    switchMode.setTextColor(getColor(R.color.colorWordLight));
                    switchMode2.setTextColor(getColor(R.color.colorWordLight));
                    llTruyen.setBackgroundColor(Color.parseColor("#ffffff"));
                    mBtnBack.setImageBitmap(back_light);
                    mBtnFordward.setImageBitmap(forw_light);
                }
            }
        });

        switchMode2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mTv.setText(truyen.getDatatruyenEng());
                    tvNameTruyen.setText(truyen.getTentruyenEng());
                }else {
                    mTv.setText(truyen.getDatatruyen());
                    tvNameTruyen.setText(truyen.getTentruyen());
                }
            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id > 0){
                    id-=1;
                    truyen = (Truyen) MybooksFragment.arrayList.get(id);
                    tvNameTruyen.setText(truyen.getTentruyen());
                    mTv.setText(truyen.getDatatruyen());
                }
                else{
                    Toast.makeText(Read.this,"Đây là chương đầu",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnFordward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id < MybooksFragment.arrayList.size() - 1){
                    id +=1;
                    truyen = (Truyen) MybooksFragment.arrayList.get(id);
                    tvNameTruyen.setText(truyen.getTentruyen());
                    mTv.setText(truyen.getDatatruyen());
                }
                else{
                    Toast.makeText(Read.this,"Đây là chương cuối",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
