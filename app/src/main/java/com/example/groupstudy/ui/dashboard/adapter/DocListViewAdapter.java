package com.example.groupstudy.ui.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupstudy.R;
import com.example.groupstudy.ui.dashboard.pojo.Doctor;

import java.util.List;

public class DocListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Doctor> doctorList;

    public DocListViewAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @Override
    public int getCount() {
        return doctorList.size();
    }

    @Override
    public Object getItem(int i) {
        return doctorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Doctor doctor = doctorList.get(i);
        View view1 = LayoutInflater.from(context).inflate(R.layout.doctor_list, null);
        TextView textView1 = view.findViewById(R.id.doc_name);
        TextView textView2 = view.findViewById(R.id.doc_prof);
        TextView textView3 = view.findViewById(R.id.doc_age);
        ImageView imageView = view.findViewById(R.id.doc_image);

        textView1.setText(doctor.getName());
        textView2.setText(doctor.getProf());
        textView3.setText(doctor.getAge());
        imageView.setImageResource(doctor.getImageId());
        return view1;
    }
}
