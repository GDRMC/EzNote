package gdr.eznote.util;

import gdr.eznote.*;
import java.io.File;

public class EzNoteFrameUtil {

    private EzNoteFrame p;

    public EzNoteFrameUtil(EzNoteFrame parent) {
        this.p = parent;
    }
    
    public static String getProperFileExtension(String absolutePath){
        if(absolutePath.endsWith("txt")){
            return absolutePath;
        } else {
            return absolutePath+".txt";
        }
    }
    
    public static void debugFile(File f){
        System.out.println("Absolute Path: "+f.getAbsolutePath());
        System.out.println("File Name: "+f.getName());
        System.out.println("String: "+f.toString());
        System.out.println("Exists: "+f.exists());
    }

    public String getWindowTitle(boolean fileLoaded, String filename) {
        if (!filename.isEmpty()) {
            if (fileLoaded) {
                return "*"
                        + "<"+filename+">"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
            } else {
                return "<"+filename+">"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
            }
        } else {
            return "<Untitled>"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
        }
        
    }
    
}
