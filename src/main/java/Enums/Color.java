package main.java.Enums;


import main.java.Constants.CustomColors;

import java.util.ArrayList;
import java.util.Random;


public enum Color {
    Black(java.awt.Color.BLACK),
    Yellow(java.awt.Color.YELLOW),
    Gold(CustomColors.GOLD),
    Red(java.awt.Color.RED),
    Green(java.awt.Color.GREEN),
    Blue(java.awt.Color.BLUE),
    Cyan(java.awt.Color.CYAN);
    public final java.awt.Color color;

    private static final ArrayList<Color> blockColors = getColorsExceptBlack();

    private static ArrayList<Color> getColorsExceptBlack(){
        ArrayList<Color> list = new ArrayList<Color>();
        for(Color color : Color.values()){
            if(color == Black){
                continue;
            }
            list.add(color);
        }
        return list;
    }

    public static Color getRandom(Random random){
        return blockColors.get(random.nextInt(blockColors.size()));
    }


    Color(java.awt.Color color) {
        this.color = color;
    }

}
