package com.example.groupstudy.ui.notifications;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.groupstudy.R;
import com.example.groupstudy.databinding.FragmentHomeBinding;
import com.example.groupstudy.databinding.FragmentNotificationsBinding;
import com.example.groupstudy.ui.home.HomeViewModel;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    private final static String TAG = "ListViewActivity";
    private ListView lv_recipe; // 声明一个列表视图对象
    private Drawable drawable;  // 声明一个图形对象

    RecipeListAdapter adapter;
    RecipeListAdapter2 adapter2;

    // 初始化分隔线显示方式的下拉框
    private void initDividerSpinner() {
        ArrayAdapter<String> dividerAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.item_select, dividerArray);
        Spinner sp_list = binding.spList;
        sp_list.setPrompt("请选择食谱种类");
        sp_list.setAdapter(dividerAdapter);
        sp_list.setOnItemSelectedListener(new DividerSelectedListener());
        sp_list.setSelection(0);
    }

    private String[] dividerArray = {
            "提瓦特幻想美食",
            "提瓦特上流饮品",
    };
    class DividerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            int dividerHeight = 10;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            lv_recipe.setDivider(drawable);  // 设置lv_recipe的分隔线
//            lv_recipe.setDividerHeight(dividerHeight);  // 设置lv_recipe的分隔线高度
            lv_recipe.setAdapter(adapter);
            // 给lv_recipe设置列表项的点击监听器
            lv_recipe.setOnItemClickListener(adapter);
            // 给lv_recipe设置列表项的长按监听器
            lv_recipe.setOnItemLongClickListener(adapter);
            lv_recipe.setDivider(null);
            lv_recipe.setPadding(0, 0, 0, 0);  // 设置lv_recipe的四周空白
            lv_recipe.setBackgroundColor(Color.TRANSPARENT);  // 设置lv_recipe的背景颜色
            if (arg2 == 1) {
                lv_recipe.setAdapter(adapter2);
                // 给lv_recipe设置列表项的点击监听器
                lv_recipe.setOnItemClickListener(adapter2);
                // 给lv_recipe设置列表项的长按监听器
                lv_recipe.setOnItemLongClickListener(adapter2);
            }
            lv_recipe.setLayoutParams(params);  // 设置lv_recipe的布局参数
        }

        public void onNothingSelected(AdapterView<?> arg0) {}
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        ArrayList<Recipe> planetList = Recipe.getDefaultList();
        ArrayList<Recipe2> planetList2 = Recipe2.getDefaultList();
        // 构建一个行星队列的列表适配器
         adapter = new RecipeListAdapter(getActivity(), planetList);
         adapter2 = new RecipeListAdapter2(getActivity(), planetList2);
        // 从布局视图中获取名叫lv_recipe的列表视图
        lv_recipe = binding.lvRecipe;
        // 给lv_recipe设置行星列表适配器
        lv_recipe.setAdapter(adapter);
        // 给lv_recipe设置列表项的点击监听器
        lv_recipe.setOnItemClickListener(adapter);
        // 给lv_recipe设置列表项的长按监听器
        lv_recipe.setOnItemLongClickListener(adapter);
        // 从资源文件中获取分隔线的图形对象
        drawable = getResources().getDrawable(R.drawable.divider_red2);
        // 初始化分隔线下拉框
        initDividerSpinner();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}