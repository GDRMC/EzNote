package gdr.eznote.util;

import gdr.eznote.frames.EzNoteFrame;
import gdr.eznote.*;
import java.io.File;

/**
 *
 * @author GDR
 */
public class EzNoteFrameUtil {

    private EzNoteFrame p;

    /**
     *
     * @param parent
     */
    public EzNoteFrameUtil(EzNoteFrame parent) {
        this.p = parent;
    }
    
    /**
     *
     * @param absolutePath
     * @return
     */
    public static String getProperFileExtension(String absolutePath){
        if(absolutePath.endsWith("txt")){
            return absolutePath;
        } else {
            return absolutePath+".txt";
        }
    }
    
    /**
     *
     * @param f
     */
    public static void debugFile(File f){
        System.out.println("Absolute Path: "+f.getAbsolutePath());
        System.out.println("File Name: "+f.getName());
        System.out.println("String: "+f.toString());
        System.out.println("Exists: "+f.exists());
    }

    /**
     *
     * @param fileLoaded
     * @param filename
     * @return
     */
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
