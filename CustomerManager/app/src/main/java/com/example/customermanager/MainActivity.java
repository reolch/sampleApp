package com.example.customermanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());

        for (int i = 0; i < parser.objects.size(); i++) {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setName(parser.objects.get(i).getName());
            customerInfo.setSex(parser.objects.get(i).getSex());
            customerInfos.add(customerInfo);
        }

        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < customerInfos.size(); i++) {
            titles.add(i, customerInfos.get(i).getName());
        }
        // ListViewにデータをセットする
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titles
        ));

        // テキストフィルターを有効にする
        list.setTextFilterEnabled(true);
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    // 入力テキストに変更があったとき
                    @Override
                    public boolean onQueryTextChange(String s) {
                        if (s.equals("")) {
                            list.clearTextFilter();
                        } else {
                            list.setFilterText(s);
                        }
                        return false;
                    }

                    // 検索ボタンを押したとき
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }
                }
        );

        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Log.d("#a", "intent");
        Intent intent = new Intent(this, SubActivity.class);
        // clickされたpositionのtextとphotoのID
        String name = customerInfos.get(position).getName();
        Log.d("#a", name);
        // インテントにセット
        CustomerInfo customerInfo = customerInfos.get(position);
        intent.putExtra("name", customerInfo.getName());
        intent.putExtra("sex", customerInfo.getSex());
        intent.putExtra("address", customerInfo.getAddress());
        // Activity をスイッチする
        startActivity(intent);
        Log.d("#a", "startActivity");
    }

}