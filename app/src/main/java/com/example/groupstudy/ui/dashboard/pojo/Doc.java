package com.example.groupstudy.ui.dashboard.pojo;


import com.example.groupstudy.R;

import java.util.ArrayList;

public class Doc{
    public int image;
    public String name;
    public String desc;
    public String age;
    public String hospital;

    public Doc(int image, String name, String desc, String age, String hospital) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.age = age;
        this.hospital = hospital;
    }

    private static int[] iconArray = {R.drawable.doc};
    private static String[] nameArray = {"张三"};
    private static String[] profArray = {"dddd"};
    private static String[] ageArray = {"28"};
    private static String[] hospitalArray = {"第一医院"};

    public static ArrayList<Doc> getDefaultList() {
        ArrayList<Doc> recipeList = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            recipeList.add(new Doc(iconArray[i], nameArray[i], profArray[i], ageArray[i], hospitalArray[i]));
        }
        return recipeList;
    }
}
