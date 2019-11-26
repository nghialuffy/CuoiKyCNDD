package com.example.doctruyenchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvTruyen;
    CustomAdapter<Truyen> customAdapter;
    public static ArrayList<Truyen> arrayList;
    DatabaseAccess dbAccess;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTruyen = findViewById(R.id.lvtruyen);
        arrayList = new ArrayList<Truyen>();
        String data = "";
//        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
        Truyen truyen = new Truyen("",data,10,1,"hihi");
        database = new MyDatabase(this);
        database.addBooks(truyen);
        arrayList = database.getAllBook();

        customAdapter = new CustomAdapter<Truyen>(this, android.R.layout.simple_list_item_1, arrayList);
        lvTruyen.setAdapter(customAdapter);

        customAdapter.notifyDataSetChanged();

        dbAccess = DatabaseAccess.getInstance(this);
        lvTruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Read.class);
                String s = arrayList.get(position).getDatatruyen();
                intent.putExtra("send",s);
                startActivity(intent);
            }
        });


    }
}
