package gdr.eznote.test;

import gdr.eznote.thememanager.EzNoteColor;
import gdr.eznote.thememanager.EzNoteColorCollection;
import gdr.eznote.thememanager.EzNoteTheme;
import gdr.eznote.thememanager.EzNoteThemeLibrary;
import java.util.ArrayList;

/**
 *
 * @author GDR
 */
public class TestOverall {

    public static void main(String[] args) {
        
        EzNoteThemeLibrary lib = new EzNoteThemeLibrary(true);
        
        System.out.println("LOADED COLORS: ");
        EzNoteColor[] array = EzNoteColorCollection.getAllColors();
        for (int i = 0; i < array.length; i++) {
            if (i < 10) {
                System.out.println("|--  " + i + " / " + array[i]);
            } else if (i < 100) {
                System.out.println("|-- " + i + " / " + array[i]);
            }
        }
        
        System.out.println("SYSTEM COLORS: ");
        EzNoteColor[] array2 = EzNoteColorCollection.getSystemColors();
        for (int i = 0; i < array2.length; i++) {
            if (i < 10) {
                System.out.println("|--  " + i + " / " + array2[i]);
            } else if (i < 100) {
                System.out.println("|-- " + i + " / " + array2[i]);
            }
        }
        
        System.out.println("CUSTOM COLORS: ");
        EzNoteColor[] array3 = EzNoteColorCollection.getCustomColors();
        for (int i = 0; i < array3.length; i++) {
            if (i < 10) {
                System.out.println("|-- " + (i+13) + " / " + array3[i]);
            } else if (i < 100) {
                System.out.println("|--" + (i+13) + " / " + array3[i]);
            }
        }
        
        System.out.println("THEMES LOADED: ");
        
        ArrayList<EzNoteTheme> themes = EzNoteThemeLibrary.getAvailableThemes();
        for (EzNoteTheme theme : themes) {
            System.out.println(theme);
        }
    }
}
