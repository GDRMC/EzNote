package gdr.eznote.themes;

import java.awt.Color;

/**
 *
 * @author GDR
 */
public class EzNoteColorCollection {
    
    public static final EzNoteColor[]COLORS_UI = {
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),
    };
    
    public static final EzNoteColor[]COLORS_TEXT = {
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),
        new EzNoteColor(Color.BLUE,"Blue",Color.WHITE),
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),
        new EzNoteColor(Color.GREEN,"Green",Color.BLACK),
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),
        new EzNoteColor(Color.MAGENTA,"Magenta",Color.BLACK),
        new EzNoteColor(Color.ORANGE,"Orange",Color.BLACK),
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),
        new EzNoteColor(Color.RED,"Red",Color.WHITE),
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),
    };
    
    public static EzNoteColor[] getUIColors(){
        return COLORS_UI;
    }
    
    public static EzNoteColor[] getTextColors(){
        return COLORS_TEXT;
    }
    
}
