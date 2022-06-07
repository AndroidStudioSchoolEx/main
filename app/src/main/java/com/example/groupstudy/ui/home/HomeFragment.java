package com.example.groupstudy.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.groupstudy.R;
import com.example.groupstudy.databinding.FragmentHomeBinding;
import com.example.groupstudy.ui.home.adapter.ExpertAdapter;

import java.util.ArrayList;

import pojo.Doctor;
import tool.DbHelper;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Drawable drawable;
    private ListView doctor_doc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        ArrayList<Doctor> planetList = (ArrayList<Doctor>) DbHelper.getInstance().select("doctor", Doctor.class, null);
//        ExpertAdapter adapter = new ExpertAdapter(getActivity(), planetList);
//        doctor_doc = binding.doctorDoc;
//        doctor_doc.setAdapter(adapter);
//        drawable = getResources().getDrawable(R.drawable.divider_red2);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}