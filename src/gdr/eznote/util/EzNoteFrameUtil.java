package gdr.eznote.util;

import gdr.eznote.frames.EzNoteFrame;
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
    
    public static File getProperFileExtension(File f){
        if(f.getAbsolutePath().endsWith("txt")){
            return f;
        } else {
            return new File(f.getAbsolutePath()+".txt");
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
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.SOFTWARE_NAME
                        + " "
                        + EzNoteStringDB.SOFTWARE_VERSION
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.TITLE_TEXT1;
            } else {
                return "<"+filename+">"
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.SOFTWARE_NAME
                        + " "
                        + EzNoteStringDB.SOFTWARE_VERSION
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.TITLE_TEXT1;
            }
        } else {
            return "<Untitled>"
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.SOFTWARE_NAME
                        + " "
                        + EzNoteStringDB.SOFTWARE_VERSION
                        + EzNoteStringDB.TITLE_SEPARATOR
                        + EzNoteStringDB.TITLE_TEXT1;
        }
        
    }
    
}
