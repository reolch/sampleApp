package com.example.customermanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomerInfoAdapter extends BaseAdapter {

    private List<CustomerInfo> customerInfoList;
    private final int layoutID;
    private final LayoutInflater inflater;

    static class ViewHolder {
        TextView name;
        TextView sex;
    }

    /**
     * コンストラクタ
     * @param customerInfos List {@link CustomerInfo}
     */
    public CustomerInfoAdapter(Context context, int itemLayoutId, List<CustomerInfo> customerInfos) {
        this.customerInfoList = customerInfos;
        layoutID = itemLayoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return customerInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return customerInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(layoutID, null);
            holder = new ViewHolder();
            holder.name = view.findViewById(R.id.name);
            holder.sex = view.findViewById(R.id.sex);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(customerInfoList.get(i).getName());
        holder.sex.setText(customerInfoList.get(i).getSex());
        return view;
    }
}
