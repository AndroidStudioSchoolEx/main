package com.example.groupstudy.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.groupstudy.R;
import com.example.groupstudy.databinding.FragmentDashboardBinding;
import com.example.groupstudy.ui.dashboard.adapter.DocListAdapter;
import com.example.groupstudy.ui.dashboard.pojo.Doc;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Spinner spinner1 = binding.spProf;
        String[] items1 = getResources().getStringArray(R.array.prof);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_select, items1);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner1.setAdapter(adapter);
        spinner1.setSelection(0);

        Spinner spinner2 = binding.spAge;
        String[] items2 = getResources().getStringArray(R.array.age);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), R.layout.item_select, items2);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(0);

        Spinner spinner3 = binding.spHospital;
        String[] items3 = getResources().getStringArray(R.array.hospital);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), R.layout.item_select, items3);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner3.setAdapter(adapter3);
        spinner3.setSelection(0);

        ListView listView = binding.lvRecipe;
        List<Doc> doctorList = new ArrayList<>();
//        doctorList.add(new Doctor(0, "张三", "儿科", 3));
//        doctorList.add(new Doctor(R.drawable.doc2, "李四", "内科", 5));
//        doctorList.add(new Doctor(R.drawable.doc3, "王五", "妇科", 7));
//        listView.setAdapter(new DocListViewAdapter(getActivity(), doctorList));
//        listView.setAdapter(new DoctorAdapter(getContext(), doctorList));

        ArrayList<Doc> planetList = Doc.getDefaultList();
        DocListAdapter adapter4 = new DocListAdapter(getActivity(), planetList);
        // 从布局视图中获取名叫lv_recipe的列表视图
        listView = binding.lvRecipe;
        // 给lv_recipe设置行星列表适配器
        listView.setAdapter(adapter4);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}