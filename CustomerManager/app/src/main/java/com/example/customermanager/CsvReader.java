package com.example.customermanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    List<ListData> objects = new ArrayList<ListData>();
    public void reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("contact.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;
            Integer count = 0;
            while ((line = bufferReader.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }

                //カンマ区切りで１つづつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");

                //CSVの左([0]番目)から順番にセット
                data.setName(RowData[1]);
                data.setSex(RowData[2]);
                data.setAddress(RowData[3]);
                data.setTelephoneNumber(RowData[4]);

                objects.add(data);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}