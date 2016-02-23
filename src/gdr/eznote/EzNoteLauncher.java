package gdr.eznote;

import gdr.eznote.themes.EzNoteThemeLibrary;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author GDR
 */
public class EzNoteLauncher {
    
    /**
     * Program launcher class
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws UnsupportedLookAndFeelException
     */
    public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            //keep system LoF if class not found, preventing program from crashing
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //e.printStackTrace();
        }
        EzNoteFrame main = new EzNoteFrame();
        main.setTitle("EzNote - Lightweight txt editor");
        main.setLocationRelativeTo(null);
        main.setIconImage(Toolkit.getDefaultToolkit().getImage(main.getClass().getResource("/gdr/icons/icon.png")));
        main.initializeStartup();
        
        main.themeApply(EzNoteThemeLibrary.getDefaultTheme());
        main.setVisible(true);
    }

}
