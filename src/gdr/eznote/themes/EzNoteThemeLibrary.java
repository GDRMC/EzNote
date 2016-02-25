package gdr.eznote.themes;

public class EzNoteThemeLibrary {
    
    public static final EzNoteTheme[]THEMES = {
        new EzNoteTheme(
                "EzNote Default",
                EzNoteColorCollection.COLORS_UI[3],
                EzNoteColorCollection.COLORS_UI[0],
                EzNoteColorCollection.COLORS_TEXT[3],
                EzNoteColorCollection.COLORS_CARET[0]
        ),
        new EzNoteTheme(
                "Aquamarine",
                EzNoteColorCollection.COLORS_UI[1],
                EzNoteColorCollection.COLORS_UI[4],
                EzNoteColorCollection.COLORS_TEXT[3],
                EzNoteColorCollection.COLORS_CARET[0]
        ),
        new EzNoteTheme(
                "Cool Metal",
                EzNoteColorCollection.COLORS_UI[2],
                EzNoteColorCollection.COLORS_UI[2],
                EzNoteColorCollection.COLORS_TEXT[6],
                EzNoteColorCollection.COLORS_CARET[4]
        ),
        new EzNoteTheme(
                "High Contrast",
                EzNoteColorCollection.COLORS_UI[7],
                EzNoteColorCollection.COLORS_UI[0],
                EzNoteColorCollection.COLORS_TEXT[12],
                EzNoteColorCollection.COLORS_CARET[0]
        ),
        new EzNoteTheme(
                "Matrix --submitted by ZetaFoX",
                EzNoteColorCollection.COLORS_UI[3],
                EzNoteColorCollection.COLORS_UI[7],
                EzNoteColorCollection.COLORS_TEXT[5],
                EzNoteColorCollection.COLORS_CARET[7]
        ),
        new EzNoteTheme(
                "Aperture Sciences (Orange)",
                EzNoteColorCollection.COLORS_UI[9],
                EzNoteColorCollection.COLORS_UI[7],
                EzNoteColorCollection.COLORS_TEXT[8],
                EzNoteColorCollection.COLORS_CARET[11]
        ),
    };
    
    public static EzNoteTheme[] getAvailableThemes(){
        return EzNoteThemeLibrary.THEMES;
    }
    
    public static EzNoteTheme getDefaultTheme(){
        return EzNoteThemeLibrary.THEMES[0];
    }
}
