package gdr.eznote.themes;

import gdr.eznote.frames.EzNoteFrame;
import gdr.eznote.frames.EzNoteFrameSettings;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for handling theme lists and installation
 * @author GDR
 */
public class EzNoteThemeManager {
    
    //COMPONENTS
    private EzNoteColorCollection collectionColors;
    private EzNoteThemeLibrary collectionThemes;
    
    //LISTS
    private final ArrayList<EzNoteColor> colorsAll;
    private final ArrayList<EzNoteTheme> themesAll;
    
    //WORKSTATION INSTANCE
    public static EzNoteThemeManager workstation = new EzNoteThemeManager();
    private boolean linked;
    private EzNoteFrameSettings parent;
    private EzNoteFrame frame;
    
    private EzNoteThemeManager(){
        this.colorsAll = new ArrayList<>();
        this.themesAll = new ArrayList<>();
        this.linked = false;
        init();
    }

    //initialize the lists
    private void init() {
        //imports all color lists and themes
        colorsAll.addAll(Arrays.asList(EzNoteColorCollection.COLORS_ALL));
        themesAll.addAll(Arrays.asList(EzNoteThemeLibrary.THEMES));
    }
    
    public void link(EzNoteFrameSettings parent) {
        this.parent = parent;
        this.frame = this.parent.getMainFrame();
        this.linked = true;
    }
    
    public void themeSetup(EzNoteTheme theme){
        frame.getEditor().setBackground(theme.getEditorColor().getColor());
        frame.getEditor().setForeground(theme.getFontColor().getColor());
        frame.getEditor().setCaretColor(theme.getCaretColor().getColor());
        frame.paintThemeToFrame(theme);
        frame.repaint();
    }

    
}
