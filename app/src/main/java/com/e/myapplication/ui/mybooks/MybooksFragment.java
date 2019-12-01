package com.e.myapplication.ui.mybooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.e.myapplication.R;
import com.e.myapplication.ui.CustomAdapter;
import com.e.myapplication.ui.DatabaseAccess;
import com.e.myapplication.ui.Truyen;

import java.util.ArrayList;
import java.util.List;

public class MybooksFragment extends Fragment {

    private MybooksViewModel myBooksFragment;
    DatabaseAccess dbAccess;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);

        ArrayList<Truyen> arrayList = new ArrayList<Truyen>();
        ListView lv = (ListView)rootView.findViewById(R.id.lvTruyen);
        CustomAdapter<Truyen> customAdapter = new CustomAdapter<Truyen>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        dbAccess = DatabaseAccess.getInstance(getActivity());

        // Doc truyen tu database
        dbAccess.open();
        List<String> name = dbAccess.getName();
        List<String> data = dbAccess.getData();
        dbAccess.close();
        for (int i = 0; i < name.size(); i++){
            Truyen truyen = new Truyen(name.get(i),data.get(i),1,1,"");
            arrayList.add(truyen);
        }
        customAdapter.notifyDataSetChanged();
        lv.setAdapter(customAdapter);
        return rootView;
    }
}