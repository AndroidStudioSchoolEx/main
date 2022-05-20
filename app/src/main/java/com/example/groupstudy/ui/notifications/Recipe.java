package com.example.groupstudy.ui.notifications;


import com.example.groupstudy.R;

import java.util.ArrayList;

public class Recipe {
    public int image;
    public String name;
    public String desc;

    public Recipe(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static int[] iconArray = {R.drawable.dudulianhaixiangeng, R.drawable.tiwatejiandan, R.drawable.lengroupinpan,
            R.drawable.feiyushijindai, R.drawable.mengdetudoubing, R.drawable.beidiyanxunji};
    private static String[] nameArray = {"嘟嘟莲海鲜羹", "提瓦特煎蛋", "冷肉拼盘", "翡玉什锦袋", "蒙德土豆饼", "北地烟熏鸡"};
    private static String[] descArray = {
            "达达利亚的特色料理。如同血海中漂泊的困兽，在垂死时发出人耳所不能闻的哀嚎....不过达达利亚却笑着解释说，只是海钓的战利品加了一些老家特产而已。",
            "班尼特的特色料理。不知道为什么每份煎蛋边缘都是焦焦的，但焦脆也带来了别具一格的风味",
            "菲谢尔的特色料理。精美的摆盘中似乎传言着某种不为人知的深奥。如果在享受美味的同时看向菲谢尔的话，能透过她半遮脸庞的指尖看到她期待的眼神…这也是秘密的一部分吗？",
            "造型精致的菜肴。咬开白嫩菜叶，鲜香火腿融合脆爽莲子丝丝入味。浓厚高汤犹如暮光倾泻，而舌尖则悠然快哉泛舟湖上。",
            "雷泽的特色料理。被小心翼翼捏成狼爪形状的土豆饼，朴实中带着香甜，能够品尝出他对于人类料理的努力.",
            "蔬菜搭配熏制好的禽肉。完美的口感让人用这道料理招待一国之主也能保持自信。"
    };

    public static ArrayList<Recipe> getDefaultList() {
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        for (int i = 0; i < iconArray.length; i++) {
            recipeList.add(new Recipe(iconArray[i], nameArray[i], descArray[i]));
        }
        return recipeList;
    }
}
