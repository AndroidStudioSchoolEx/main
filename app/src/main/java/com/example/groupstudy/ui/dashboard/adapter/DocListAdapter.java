package com.example.groupstudy.ui.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.groupstudy.R;
import com.example.groupstudy.ui.dashboard.pojo.Doc;

import java.util.ArrayList;


public class DocListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Doc> mDocList;

    public DocListAdapter(Context context, ArrayList<Doc> doc_list) {
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
            holder.doc_prof = convertView.findViewById(R.id.doc_prof);
            holder.doc_age = convertView.findViewById(R.id.doc_age);
            holder.doc_hospital = convertView.findViewById(R.id.doc_hospital);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        } else { // 转换视图非空
            // 从转换视图中获取之前保存的视图持有者
            holder = (ViewHolder) convertView.getTag();
        }
        Doc doc = mDocList.get(position);
        holder.doc_image.setImageResource(doc.image);
        holder.doc_name.setText(doc.name);
        holder.doc_prof.setText(doc.desc);
        holder.doc_age.setText(doc.age);
        holder.doc_hospital.setText(doc.hospital);
        return convertView;
    }

    // 定义一个视图持有者，以便重用列表项的视图资源
    public final class ViewHolder {
        public ImageView doc_image;
        public TextView doc_name;
        public TextView doc_prof;
        public TextView doc_age;
        public TextView doc_hospital;
    }

}
