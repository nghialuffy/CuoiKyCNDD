package com.example.doctruyenchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTruyen;
    CustomAdapter<Truyen> customAdapter;
    public static ArrayList<Truyen> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTruyen = findViewById(R.id.lvtruyen);
        arrayList = new ArrayList<Truyen>();

        customAdapter = new CustomAdapter<Truyen>(this, android.R.layout.simple_list_item_1, arrayList);
        lvTruyen.setAdapter(customAdapter);
        Truyen truyen1 = new Truyen("Con meo day hai au bay",1 ,1,"");
        arrayList.add(truyen1);
        arrayList.add(truyen1);
        customAdapter.notifyDataSetChanged();


    }
}
