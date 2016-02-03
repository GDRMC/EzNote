package gdr.eznote.util;

import java.io.File;

public class EzNoteUtil {
    
    public EzNoteUtil(){
        
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
}
