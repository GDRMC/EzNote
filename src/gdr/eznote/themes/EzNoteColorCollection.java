package gdr.eznote.themes;

import java.awt.Color;

/**
 *
 * @author GDR
 */
public class EzNoteColorCollection {
    
    public static final EzNoteColor[]COLORS_ALL = {
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),                       //0
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),               //1
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),                         //2
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),             //3
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),                       //4
        
        new EzNoteColor(Color.BLUE,"Blue",Color.WHITE),                         //5
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),                         //6
        
        new EzNoteColor(Color.GREEN,"Green",Color.BLACK),                       //7
        
        new EzNoteColor(Color.MAGENTA,"Magenta",Color.BLACK),                   //8
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),                         //9
        
        new EzNoteColor(Color.RED,"Red",Color.WHITE),                           //10
        new EzNoteColor(Color.ORANGE,"Orange",Color.BLACK),                     //11
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),                     //12
        new EzNoteColor(255,157,0,"Orange (Aperture)",Color.BLACK)              //13
    };
    
    public static final EzNoteColor[]COLORS_UI = {
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),                       //0
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),                         //1
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),               //2
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),                         //3
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),             //4
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),                         //5
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),                     //6
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),                       //7
        new EzNoteColor(Color.ORANGE,"Orange",Color.BLACK),                     //8
        new EzNoteColor(255,157,0,"Orange (Aperture)",Color.BLACK),             //9
    };
    
    public static final EzNoteColor[]COLORS_TEXT = {
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),                       //0
        new EzNoteColor(Color.BLUE,"Blue",Color.WHITE),                         //1
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),                         //2
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),               //3
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),                         //4
        new EzNoteColor(Color.GREEN,"Green",Color.BLACK),                       //5
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),             //6
        new EzNoteColor(Color.MAGENTA,"Magenta",Color.BLACK),                   //7
        new EzNoteColor(Color.ORANGE,"Orange",Color.BLACK),                     //8
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),                         //9
        new EzNoteColor(Color.RED,"Red",Color.WHITE),                           //10
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),                     //11
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),                       //12
    };
    
    public static final EzNoteColor[]COLORS_CARET = {
        new EzNoteColor(Color.BLACK,"Black",Color.WHITE),                       //0
        new EzNoteColor(Color.DARK_GRAY,"Dark Gray",Color.WHITE),               //1
        new EzNoteColor(Color.GRAY,"Gray",Color.WHITE),                         //2
        new EzNoteColor(Color.LIGHT_GRAY,"Light Gray",Color.BLACK),             //3
        new EzNoteColor(Color.WHITE,"White",Color.BLACK),                       //4
        
        new EzNoteColor(Color.BLUE,"Blue",Color.WHITE),                         //5
        new EzNoteColor(Color.CYAN,"Cyan",Color.BLACK),                         //6
        
        new EzNoteColor(Color.GREEN,"Green",Color.BLACK),                       //7
        
        new EzNoteColor(Color.MAGENTA,"Magenta",Color.BLACK),                   //8
        new EzNoteColor(Color.PINK,"Pink",Color.BLACK),                         //9
        
        new EzNoteColor(Color.RED,"Red",Color.WHITE),                           //10
        new EzNoteColor(Color.ORANGE,"Orange",Color.BLACK),                     //11
        new EzNoteColor(Color.YELLOW,"Yellow",Color.BLACK),                     //12
    };
    
    public static EzNoteColor[] getUIColors(){
        return COLORS_UI;
    }
    
    public static EzNoteColor[] getTextColors(){
        return COLORS_TEXT;
    }
    
    public static EzNoteColor[] getCaretColors(){
        return COLORS_CARET;
    }
    
    public static EzNoteColor[] getAllColors(){
        return COLORS_ALL;
    }
    
}
