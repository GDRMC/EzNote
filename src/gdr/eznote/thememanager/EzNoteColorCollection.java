package gdr.eznote.thememanager;

import java.awt.Color;

/**
 *
 * @author GDR
 */
public class EzNoteColorCollection {
    
    public static final EzNoteColor[]COLORS_ALL = {
        //JAVA COLORS REIMPLEMENTATION
        new EzNoteColor(Color.BLACK,"Black","black",Color.WHITE),               //0
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray","darkgray",Color.WHITE),    //1
        new EzNoteColor(Color.GRAY,"Gray","gray",Color.WHITE),                  //2
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray","lightgray",Color.BLACK), //3
        new EzNoteColor(Color.WHITE,"White","white",Color.BLACK),               //4
        new EzNoteColor(Color.BLUE,"Blue","blue",Color.WHITE),                  //5
        new EzNoteColor(Color.CYAN,"Cyan","cyan",Color.BLACK),                  //6
        new EzNoteColor(Color.GREEN,"Green","green",Color.BLACK),               //7
        new EzNoteColor(Color.MAGENTA,"Magenta","magenta",Color.BLACK),         //8
        new EzNoteColor(Color.PINK,"Pink","pink",Color.BLACK),                  //9
        new EzNoteColor(Color.RED,"Red","red",Color.WHITE),                     //10
        new EzNoteColor(Color.ORANGE,"Orange","orange",Color.BLACK),            //11
        new EzNoteColor(Color.YELLOW,"Yellow","yellow",Color.BLACK),            //12
        //CUSTOM COLORS
        new EzNoteColor(255,157,0,"Orange - Aperture","orange_ap",Color.BLACK), //13
        new EzNoteColor(85,74,107,"Gray - NY","gray_ny",Color.WHITE),           //14
        new EzNoteColor(119,18,62,"Purple - Wine","purple_wine",Color.WHITE),   //15
    };
    
    public static EzNoteColor[] getAllColors(){
        return COLORS_ALL;
    }
    
    public static EzNoteColor[] getSystemColors(){
        EzNoteColor[]result = new EzNoteColor[13];
        System.arraycopy(COLORS_ALL, 0, result, 0, 13);
        return result;
    }
    
    public static EzNoteColor[] getCustomColors(){
        EzNoteColor[]result = new EzNoteColor[COLORS_ALL.length-13];
        int start = 13;
        for(int i=0;i<result.length;i++){
            result[i] = COLORS_ALL[start];
            start++;
        }
        return result;
    }
    
    public static EzNoteColor searchColorByName(String str){
        EzNoteColor result = null;
        for (int i=0;i<COLORS_ALL.length;i++) {
            if (COLORS_ALL[i].getSearchName().equals(str)) {
                result = COLORS_ALL[i];
            }
        }
        return result;
    }
    
    public static EzNoteColor getColorByPosition(int n){
        EzNoteColor result = null;
        if(n >= 0 && n < COLORS_ALL.length){
            result = COLORS_ALL[n];
        }
        return result;
    }
    
    
}
