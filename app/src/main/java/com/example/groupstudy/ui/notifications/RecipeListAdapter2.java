package com.example.groupstudy.ui.notifications;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupstudy.R;

import java.util.ArrayList;


public class RecipeListAdapter2 extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    private Context mContext; // 声明一个上下文对象
    private ArrayList<Recipe2> mRecipeList; // 声明一个食谱信息队列

    // 食谱适配器的构造函数，传入上下文与食谱队列
    public RecipeListAdapter2(Context context, ArrayList<Recipe2> recipes_list) {
        mContext = context;
        mRecipeList = recipes_list;
    }

    // 获取列表项的个数
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
        ViewHolder holder;
        if (convertView == null) { // 转换视图为空
            holder = new ViewHolder(); // 创建一个新的视图持有者
            // 根据布局文件item_list.xml生成转换视图对象
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            holder.iv_icon = convertView.findViewById(R.id.iv_icon);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        } else { // 转换视图非空
            // 从转换视图中获取之前保存的视图持有者
            holder = (ViewHolder) convertView.getTag();
        }
        Recipe2 recipe = mRecipeList.get(position);
        holder.iv_icon.setImageResource(recipe.image); // 显示食谱的图片
        holder.tv_name.setText(recipe.name); // 显示食谱的名称
        holder.tv_desc.setText(recipe.desc); // 显示食谱的描述
        return convertView;
    }

    // 定义一个视图持有者，以便重用列表项的视图资源
    public final class ViewHolder {
        public ImageView iv_icon; // 声明食谱图片的图像视图对象
        public TextView tv_name; // 声明食谱名称的文本视图对象
        public TextView tv_desc; // 声明食谱描述的文本视图对象
    }

    // 处理列表项的点击事件，由接口OnItemClickListener触发
    public void onItemClick(AdapterView<?> recipe, View view, int position, long id) {
        String desc = String.format("您点击了第%d个食谱，它的名字是%s", position + 1,
                mRecipeList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
    }

    // 处理列表项的长按事件，由接口OnItemLongClickListener触发
    public boolean onItemLongClick(AdapterView<?> recipe, View view, int position, long id) {
        String desc = String.format("您长按了第%d个食谱，它的名字是%s", position + 1,
                mRecipeList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
        return true;
    }
}
