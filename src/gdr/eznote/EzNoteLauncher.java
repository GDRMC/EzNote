package gdr.eznote;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EzNoteLauncher {
    
    public static void main(String[]args){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EzNoteFrame main = new EzNoteFrame();
        main.setVisible(true);
        main.setTitle("EzNote - Lightweight txt editor");
        main.setLocationRelativeTo(null);
    }
    
}
