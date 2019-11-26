package com.example.doctruyenchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvTruyen;
    CustomAdapter<Truyen> customAdapter;
    public static ArrayList<Truyen> arrayList;
    DatabaseAccess dbAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTruyen = findViewById(R.id.lvtruyen);
        arrayList = new ArrayList<Truyen>();

        customAdapter = new CustomAdapter<Truyen>(this, android.R.layout.simple_list_item_1, arrayList);
        lvTruyen.setAdapter(customAdapter);

        customAdapter.notifyDataSetChanged();

        dbAccess = DatabaseAccess.getInstance(this);
        dbAccess.open();
        List<String> name = dbAccess.getName();
        List<String> data = dbAccess.getData();
        dbAccess.close();
        for (int i = 0; i < name.size(); i++){
            Truyen truyen = new Truyen(name.get(i),data.get(i),1,1,"");
            arrayList.add(truyen);
        }
        customAdapter.notifyDataSetChanged();


    }
}
