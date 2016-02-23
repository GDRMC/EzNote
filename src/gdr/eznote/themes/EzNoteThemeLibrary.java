package gdr.eznote.themes;

public class EzNoteThemeLibrary {
    
    private static final EzNoteTheme[]THEMES = {
        new EzNoteTheme(
                "EzNote Default",
                EzNoteColorCollection.COLORS_UI[3],
                EzNoteColorCollection.COLORS_UI[0],
                EzNoteColorCollection.COLORS_TEXT[3]
        ),
        new EzNoteTheme(
                "Aquamarine",
                EzNoteColorCollection.COLORS_UI[1],
                EzNoteColorCollection.COLORS_UI[4],
                EzNoteColorCollection.COLORS_TEXT[3]
        )
    };
    
    public static EzNoteTheme[] getAvailableThemes(){
        return EzNoteThemeLibrary.THEMES;
    }
    
    public static EzNoteTheme getDefaultTheme(){
        return EzNoteThemeLibrary.THEMES[0];
    }
}
