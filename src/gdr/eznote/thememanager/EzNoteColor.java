package gdr.eznote.thememanager;

import java.awt.Color;

public class EzNoteColor {
    
    private final int r;
    private final int g;
    private final int b;
    private final String displayName;
    private final String searchName;
    private final Color textColor;
    
    public EzNoteColor(int r, int g, int b, String name, String search, Color textColor){
        this.r = r;
        this.g = g;
        this.b = b;
        this.displayName = name;
        this.searchName = search;
        this.textColor = textColor;
    }
    
    public EzNoteColor(Color c, String name, String search, Color textColor){
        this.r = c.getRed();
        this.g = c.getGreen();
        this.b = c.getBlue();
        this.displayName = name;
        this.searchName = search;
        this.textColor = textColor;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public String getName() {
        return displayName;
    }
    
    public String getSearchName() {
        return searchName;
    }
    
    public Color getColor() {
        return new Color(this.r, this.g, this.b);
    }
    
    public Color getTextColor(){
        return textColor;
    }
    
    @Override
    public String toString(){
        return "EzNoteColor "+this.getSearchName()+" ("+this.displayName
                +") - RGB: "+this.r+"_"+this.g+"_"+this.b+" - FOREGR: "
                +this.textColor;
    }
}
