package com.example.customermanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sub);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String address = intent.getStringExtra("address");

        List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName(name);
        customerInfo.setSex(sex);
        customerInfo.setAddress(address);
        customerInfos.add(customerInfo);
        Log.d("#ab", customerInfos.get(0).getName());

        List<ListData> objects = new ArrayList<ListData>();
        ListData data = new ListData();
        data.setName(name);
        data.setSex(sex);
        objects.add(data);

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, 0, objects);
        ListView listView = (ListView)findViewById(R.id.list2);
        listView.setAdapter(listViewAdapter);
    }
}
