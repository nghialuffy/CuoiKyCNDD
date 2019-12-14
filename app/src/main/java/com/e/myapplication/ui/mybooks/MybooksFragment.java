package com.e.myapplication.ui.mybooks;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.e.myapplication.R;
import com.e.myapplication.ui.CustomAdapter;
import com.e.myapplication.ui.DatabaseAccess;
import com.e.myapplication.ui.Truyen;

import java.util.ArrayList;
import java.util.List;

public class MybooksFragment extends Fragment {

    private MybooksViewModel myBooksFragment;
    public DatabaseAccess dbAccess;
    public static ArrayList<Truyen> arrayList;
    private ListView lv;
    private EditText inputSearch;
    private CustomAdapter<Truyen> customAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);

        arrayList = new ArrayList<Truyen>();
        inputSearch = (EditText) rootView.findViewById(R.id.inputSearch);
        lv = (ListView)rootView.findViewById(R.id.lvTruyen);
        customAdapter = new CustomAdapter<Truyen>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        dbAccess = DatabaseAccess.getInstance(getActivity());

        customAdapter = new CustomAdapter<Truyen>(getActivity(), android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(customAdapter);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MybooksFragment.this.customAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // Doc truyen tu database
        dbAccess.open();
        List<String> name = dbAccess.getName();
        List<String> data = dbAccess.getData();
        List<String> nameEng = dbAccess.getNameEng();
        List<String> dataEng = dbAccess.getDataEng();

        dbAccess.close();
        for (int i = 0; i < name.size(); i++){
            Truyen truyen = new Truyen(name.get(i),data.get(i),nameEng.get(i),dataEng.get(i),1,1,"");
            arrayList.add(truyen);
        }
        customAdapter.notifyDataSetChanged();
        lv.setAdapter(customAdapter);
        return rootView;
    }
}