package gdr.eznote.thememanager;

import java.util.ArrayList;

public class EzNoteThemeLibrary {
    
    public static ArrayList<EzNoteTheme> themes;
    
    public EzNoteThemeLibrary(boolean fill){
        themes = new ArrayList<>();
        if(fill){
            this.startupFill();
        }
    }
        
    private void startupFill() {
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "EzNote Default",
                EzNoteColorCollection.searchColorByName("gray"),
                EzNoteColorCollection.searchColorByName("white"),
                EzNoteColorCollection.searchColorByName("darkgray"),
                EzNoteColorCollection.searchColorByName("black")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "EzNote Aquamarine",
                EzNoteColorCollection.searchColorByName("cyan"),
                EzNoteColorCollection.searchColorByName("lightgray"),
                EzNoteColorCollection.searchColorByName("darkgray"),
                EzNoteColorCollection.searchColorByName("black")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "Eznote Metal",
                EzNoteColorCollection.searchColorByName("darkgray"),
                EzNoteColorCollection.searchColorByName("darkgray"),
                EzNoteColorCollection.searchColorByName("lightgray"),
                EzNoteColorCollection.searchColorByName("white")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "EzNote High-Contrast",
                EzNoteColorCollection.searchColorByName("black"),
                EzNoteColorCollection.searchColorByName("white"),
                EzNoteColorCollection.searchColorByName("black"),
                EzNoteColorCollection.searchColorByName("black")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "EzNote Matrix",
                EzNoteColorCollection.searchColorByName("green"),
                EzNoteColorCollection.searchColorByName("black"),
                EzNoteColorCollection.searchColorByName("green"),
                EzNoteColorCollection.searchColorByName("green")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "Aperture Sciences",
                EzNoteColorCollection.searchColorByName("orange_ap"),
                EzNoteColorCollection.searchColorByName("black"),
                EzNoteColorCollection.searchColorByName("orange_ap"),
                EzNoteColorCollection.searchColorByName("orange_ap")
        ));
        EzNoteThemeLibrary.themes.add(new EzNoteTheme(
                "NY at night",
                EzNoteColorCollection.searchColorByName("purple_wine"),
                EzNoteColorCollection.searchColorByName("darkgray"),
                EzNoteColorCollection.searchColorByName("white"),
                EzNoteColorCollection.searchColorByName("white")
        ));
    }
    
    public static ArrayList<EzNoteTheme> getAvailableThemes(){
        return EzNoteThemeLibrary.themes;
    }
    
    public static EzNoteTheme getDefaultTheme(){
        return EzNoteThemeLibrary.themes.get(0);
    }
}
