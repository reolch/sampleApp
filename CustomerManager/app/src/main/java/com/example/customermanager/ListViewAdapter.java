package com.example.customermanager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListData> {
    private LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, int resource, List<ListData> objects) {
        super(context, resource, objects);
        Log.d("#a constracter", objects.get(0).getName());
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListData data = (ListData)getItem(position);
        if (null == convertView) {
            Log.d("#abc", "null");
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView nameText;
        TextView sexText;

        nameText = (TextView)convertView.findViewById(R.id.name);
        sexText = (TextView)convertView.findViewById(R.id.sex);


        Log.d("#abc", data.getName());
        nameText.setText(data.getName());
        sexText.setText(data.getSex());

        return convertView;
    }
}