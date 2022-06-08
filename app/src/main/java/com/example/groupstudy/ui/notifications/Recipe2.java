package com.example.groupstudy.ui.notifications;


import com.example.groupstudy.R;

import java.util.ArrayList;

public class Recipe2 {
    public int image;
    public String name;
    public String desc;

    public Recipe2(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static int[] iconArray = {R.drawable.shumeiboheyin, R.drawable.haidengjieteseqindangeng, R.drawable.pinguoniang,
            R.drawable.haidengjietedebaiyutang, R.drawable.binggougouguozhi, R.drawable.shengshui};
    private static String[] nameArray = {"树莓薄荷饮", "海灯节特色禽蛋羹", "苹果酿", "海灯节特色白玉汤", "冰钩钩果汁", "圣水"};
    private static String[] descArray = {
            "清新时尚的无酒精饮品。十分提神的薄荷饮料，用树莓加以装饰，散发着雅致的清香。",
            "为庆祝海灯节而制作的传统佳肴.色泽澄澈金黄的禽蛋羹上点缀了几颗莲子。不管是作为早餐还是饭后点心，都能补充身体所需的优质营养。",
            "清新时尚的无酒精饮品。据说有很不错的醒酒功效，酒客们常点一杯作为聚会结束的标志。",
            "为庆祝海灯节而制作的传统佳肴。热水烧开后，将金鱼草、豆腐和莲子下锅齐煮。因其造型寓意而被戏称为「珍珠翡翠白玉汤」，实质上是一道非常家常的菜品。",
            "清新时尚的无酒精饮品。在鲜榨的钩钩果汁中放入冰块并稍加调制，泛起梦幻般的紫色。",
            "质地透亮，无色无杂质的一小瓶液体。看起来与清泉水无异的这一瓶，真的值得你寄予厚望吗?"
    };

    public static ArrayList<Recipe2> getDefaultList() {
        ArrayList<Recipe2> recipeList2 = new ArrayList<Recipe2>();
        for (int i = 0; i < iconArray.length; i++) {
            recipeList2.add(new Recipe2(iconArray[i], nameArray[i], descArray[i]));
        }
        return recipeList2;
    }
}
