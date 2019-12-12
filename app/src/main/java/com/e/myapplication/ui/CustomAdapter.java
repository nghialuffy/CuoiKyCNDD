package com.e.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.e.myapplication.MainActivity;
import com.e.myapplication.R;
import com.e.myapplication.ui.mybooks.MybooksFragment;

import java.util.ArrayList;

public class CustomAdapter<C> extends ArrayAdapter<Truyen> implements Filterable {

    private FragmentActivity context;

    private int resource;
    private ArrayFilter customFilter;
    private ArrayList<Truyen> arrContact;
    private ArrayList<Truyen> arrFiltered;

    public CustomAdapter(FragmentActivity context, int resource, ArrayList<Truyen> arrContact) {
        super(context, resource, arrContact);
        this.context = context;
        this.resource = resource;
        this.arrContact = arrContact;
        this.arrFiltered = arrContact;
        getFilter();
    }
    @Override
    public int getCount() {
        return arrFiltered.size();
    }

    @Override
    public Truyen getItem(int i) {
        return arrFiltered.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        final Truyen truyen = (Truyen) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_truyen, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgAvatar = convertView.findViewById(R.id.imgtruyen);
            viewHolder.tvTruyen = convertView.findViewById(R.id.edttentruyen);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTruyen.setText(truyen.getTentruyen());
//        viewHolder.tvChuong.setText(String.valueOf(truyen.getChuongdangdoc()));
//        viewHolder.imgAvatar.setImageResource(1);

        //Even Click Custom Adapter
        viewHolder.tvTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Truyen truyen = arrContact.get(position);
                Intent intent = new Intent(context, Read.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("truyen",truyen);
                bundle.putSerializable("id", position);
                intent.putExtra("package", bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        ImageView imgAvatar;
        TextView tvTruyen;
        TextView tvChuong;
    }
    @Override
    public Filter getFilter() {
        if (customFilter == null) {
            customFilter = new ArrayFilter();
        }
        return customFilter;
    }
    /**
     * Custom filter for friend list
     * Filter content in friend list according to the search text
     */
    private class ArrayFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                ArrayList<Truyen> tempList = new ArrayList<Truyen>();

                // search content in friend list
                for (Truyen truyen: arrContact) {
                    if (truyen.getTentruyen().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(truyen);

                        Log.d("aaaaaaaaaaaaaaaaaaaaaaa"," aaaa : "+truyen.getTentruyen());
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = arrContact.size();
                filterResults.values = arrContact;
            }

            return filterResults;
        }
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrFiltered = (ArrayList<Truyen>) results.values;
            notifyDataSetChanged();
        }
    }
}
