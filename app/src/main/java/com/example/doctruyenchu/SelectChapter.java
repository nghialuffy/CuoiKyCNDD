package com.example.doctruyenchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class SelectChapter extends AppCompatActivity {
    private ImageButton btnBackHome;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chapter);
        btnBackHome =(ImageButton) findViewById(R.id.backHome);
        mListView = (ListView) findViewById(R.id.listView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectChapter.this,Read.class);

                startActivityForResult(intent,REQUEST_CODE_EDIT);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {


                Toast.makeText(SelectChapter.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.backHome:{
                        Intent intent = new Intent(SelectChapter.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

    }
}