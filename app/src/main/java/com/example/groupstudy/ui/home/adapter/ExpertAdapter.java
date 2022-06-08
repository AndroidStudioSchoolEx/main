package com.example.groupstudy.ui.home.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupstudy.R;

import java.util.ArrayList;

import pojo.Doctor;

public class ExpertAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Doctor> doctors;

    public ExpertAdapter(Context context, ArrayList<Doctor> list) {
        this.context = context;
        doctors = list;
    }

    public int getCount() {
        return doctors.size();
    }

    // 获取列表项的数据
    public Object getItem(int arg0) {
        return doctors.get(arg0);
    }

    // 获取列表项的编号
    public long getItemId(int arg0) {
        return arg0;
    }

    // 获取指定位置的列表项视图
    @SuppressLint("InflateParams")
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.doc_list, null);
            holder.doctor_image = convertView.findViewById(R.id.doctor_image);
            holder.doctor_name = convertView.findViewById(R.id.doctor_name);
            holder.doctor_level = convertView.findViewById(R.id.doctor_level);
            holder.doctor_type = convertView.findViewById(R.id.doctor_type);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Doctor doctor = doctors.get(position);
        holder.doctor_image.setImageResource(R.drawable.doc);
        holder.doctor_name.setText(doctor.getName());
        holder.doctor_level.setText(doctor.getLevel());
        holder.doctor_type.setText(doctor.getType());
        Button button = convertView.findViewById(R.id.doctor_btn);
        button.setOnClickListener(view -> {
            if ("预约".contentEquals(button.getText())) {
                Toast.makeText(context,"已预约", Toast.LENGTH_SHORT).show();
                button.setBackgroundColor(Color.parseColor("#808080"));
                button.setText("已预约");
            }
            else {
                Toast.makeText(context,"已取消预约", Toast.LENGTH_SHORT).show();
                button.setBackgroundColor(Color.parseColor("#FF3700B3"));
                button.setText("预约");
            }
        });
        return convertView;
    }

    public static final class ViewHolder {
        public ImageView doctor_image;
        public TextView doctor_name;
        public TextView doctor_level;
        public TextView doctor_type;
    }

}
