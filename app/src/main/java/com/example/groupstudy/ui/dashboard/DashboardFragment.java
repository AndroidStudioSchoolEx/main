package com.example.groupstudy.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.groupstudy.R;
import com.example.groupstudy.databinding.FragmentDashboardBinding;
import com.example.groupstudy.ui.dashboard.adapter.DocListAdapter;

import java.util.ArrayList;

import pojo.Doctor;
import tool.DbHelper;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ArrayList<Doctor> doctorList = DbHelper.getInstance().select("doc");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Spinner spinner1 = binding.spLevel;
        String[] items1 = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_select, items1);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner1.setAdapter(adapter);
        spinner1.setSelection(0);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    doctorList = DbHelper.getInstance().select("doc");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 1){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "医师");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 2){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "专家");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner2 = binding.spType;
        String[] items2 = getResources().getStringArray(R.array.type);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), R.layout.item_select, items2);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(0);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    doctorList = DbHelper.getInstance().select("doc");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 1){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "儿科");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 2){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "妇科");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 3){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "外科");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                } else if (i == 4){
                    doctorList = DbHelper.getInstance().selectByCondition("doc", "肛肠科");
                    DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
                    ListView listView = binding.lvDocList;
                    listView.setAdapter(adapter4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        DocListAdapter adapter4 = new DocListAdapter(getActivity(), doctorList);
        ListView listView = binding.lvDocList;
        listView.setAdapter(adapter4);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}