package com.example.groupstudy.ui.dashboard.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupstudy.R;
import com.example.groupstudy.ui.dashboard.DialogActivity;

import java.text.MessageFormat;
import java.util.ArrayList;

import pojo.Doctor;


public class DocListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Doctor> mDocList;

    public DocListAdapter(Context context, ArrayList<Doctor> doc_list) {
        mContext = context;
        mDocList = doc_list;
    }

    // 获取列表项的个数
    public int getCount() {
        return mDocList.size();
    }

    // 获取列表项的数据
    public Object getItem(int arg0) {
        return mDocList.get(arg0);
    }

    // 获取列表项的编号
    public long getItemId(int arg0) {
        return arg0;
    }

    // 获取指定位置的列表项视图
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) { // 转换视图为空
            holder = new ViewHolder(); // 创建一个新的视图持有者
            convertView = LayoutInflater.from(mContext).inflate(R.layout.doctor_list, null);
            holder.doc_image = convertView.findViewById(R.id.doc_image);
            holder.doc_name = convertView.findViewById(R.id.doc_name);
            holder.doc_level = convertView.findViewById(R.id.doc_level);
            holder.doc_type = convertView.findViewById(R.id.doc_type);
            holder.button = convertView.findViewById(R.id.doc_btn);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        } else { // 转换视图非空
            // 从转换视图中获取之前保存的视图持有者
            holder = (ViewHolder) convertView.getTag();
        }
        Doctor doc = mDocList.get(position);
        holder.doc_image.setImageResource(R.drawable.doc);
        holder.doc_name.setText(MessageFormat.format("姓名：{0}", doc.getName()));
        holder.doc_level.setText(MessageFormat.format("级别：{0}", doc.getLevel()));
        holder.doc_type.setText(MessageFormat.format("医科：{0}", doc.getType()));
        holder.button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(view.getContext(), DialogActivity.class);
            view.getContext().startActivity(intent);
        });
        return convertView;
    }

    // 定义一个视图持有者，以便重用列表项的视图资源
    public final class ViewHolder {
        public ImageView doc_image;
        public TextView doc_name;
        public TextView doc_level;
        public TextView doc_type;
        public Button button;
    }

}
