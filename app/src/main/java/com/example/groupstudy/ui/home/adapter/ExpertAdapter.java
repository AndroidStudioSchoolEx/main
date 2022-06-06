package com.example.groupstudy.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupstudy.R;

import java.util.ArrayList;

import pojo.Doctor;

public class ExpertAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Doctor> mRecipeList;

    public ExpertAdapter(Context context, ArrayList<Doctor> list) {
        mContext = context;
        mRecipeList = list;
    }

    public int getCount() {
        return mRecipeList.size();
    }

    // 获取列表项的数据
    public Object getItem(int arg0) {
        return mRecipeList.get(arg0);
    }

    // 获取列表项的编号
    public long getItemId(int arg0) {
        return arg0;
    }

    // 获取指定位置的列表项视图
    public View getView(final int position, View convertView, ViewGroup parent) {
        ExpertAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            holder.icon = convertView.findViewById(R.id.doc_img);
            holder.name = convertView.findViewById(R.id.doc_n);
            convertView.setTag(holder);
        } else {
            holder = (ExpertAdapter.ViewHolder) convertView.getTag();
        }
        Doctor doctor = mRecipeList.get(position);
        holder.icon.setImageResource(R.drawable.doc);
        holder.name.setText(doctor.getName());
        return convertView;
    }

    public static final class ViewHolder {
        public ImageView icon;
        public TextView name;
    }

}
