package com.example.groupstudy.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.groupstudy.R;
import com.example.groupstudy.databinding.FragmentDashboardBinding;

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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}