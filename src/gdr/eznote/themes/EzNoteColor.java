package gdr.eznote.themes;

import java.awt.Color;

public class EzNoteColor {
    
    private int r;
    private int g;
    private int b;
    private String displayName;
    private Color textColor;
    
    public EzNoteColor(int r, int g, int b, String name, Color textColor){
        this.r = r;
        this.g = g;
        this.b = b;
        this.displayName = name;
        this.textColor = textColor;
    }
    
    public EzNoteColor(Color c, String name, Color textColor){
        this.r = c.getRed();
        this.g = c.getGreen();
        this.b = c.getBlue();
        this.displayName = name;
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
    
    public Color getColor() {
        return new Color(this.r, this.g, this.b);
    }
    
    public Color getTextColor(){
        return textColor;
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
}
