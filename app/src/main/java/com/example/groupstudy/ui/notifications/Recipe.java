package com.example.groupstudy.ui.notifications;


import com.example.groupstudy.R;

import java.util.ArrayList;
import java.util.stream.Stream;

import pojo.Food;
import tool.DbHelper;

public class Recipe {
    public int image;
    public String name;
    public String desc;

    static {
        Food[] orders = DbHelper.getInstance().select("food", Food.class, null).toArray(new Food[0]);
        nameArray = Stream.of(orders).map(Food::getName).toArray(String[]::new);
        descArray = Stream.of(orders).map(Food::getDcp).toArray(String[]::new);
    }

    public Recipe(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static final int[] iconArray = {R.drawable.dudulianhaixiangeng, R.drawable.tiwatejiandan, R.drawable.lengroupinpan,
            R.drawable.feiyushijindai, R.drawable.mengdetudoubing, R.drawable.beidiyanxunji};
    private static final String[] nameArray;
    private static final String[] descArray;

    public static ArrayList<Recipe> getDefaultList() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            recipeList.add(new Recipe(iconArray[i], nameArray[i], descArray[i]));
        }
        return recipeList;
    }
}
