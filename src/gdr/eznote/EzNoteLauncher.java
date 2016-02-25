package gdr.eznote;

import gdr.eznote.frames.EzNoteFrame;
import gdr.eznote.configuration.EzNoteConfigurator;
import gdr.eznote.exceptions.ConfiguratorException;
import gdr.eznote.themes.EzNoteColorCollection;
import gdr.eznote.themes.EzNoteTheme;
import gdr.eznote.themes.EzNoteThemeLibrary;
import gdr.eznote.util.EzNoteTexts;
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
     * @param args JVM arguments
     * @throws ClassNotFoundException 
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws UnsupportedLookAndFeelException
     */
    public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ConfiguratorException{
        //setting debug mode
        boolean debugMode = false;
        boolean ioMode = false;
        if(args.length==0){
            System.out.println("NOTICE: TO ACTIVATE DEBUG MODE, PROMPT 'java -jar <jarfile>.jar <parameter>");
        }
        if(args.length==1 && "debug".equals(args[0])){
            debugMode = true;
            System.out.println("LAUNCHER: ERASE DEBUG MODE ACTIVATED");
        } else {
            System.out.println("LAUNCHER: ERASE DEBUG MODE DEACTIVATED");
        }
        if(args.length==1 && "io".equals(args[0])){
            ioMode = true;
            System.out.println("LAUNCHER: IO DEBUG MODE ACTIVATED");
        } else {
            System.out.println("LAUNCHER: IO DEBUG MODE DEACTIVATED");
        }
        //setting the look and feel for this app
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            //keep system LoF if class not found, preventing program from crashing
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //e.printStackTrace();
        }
        
        //configuration loader
        EzNoteConfigurator conf;
        if(debugMode){
            conf = new EzNoteConfigurator(1, 0);
        } else if(ioMode) {
            conf = new EzNoteConfigurator(0, 1);
        } else {
            conf = new EzNoteConfigurator(0, 0);
        }
        conf.load();
        EzNoteFrame main = new EzNoteFrame(conf);
        
        //theme apply with configuration
        if(conf.getConfigurationThemeMode()==0){
            main.themeApply(EzNoteThemeLibrary.THEMES[conf.getConfigurationThemeChoose()]);
            System.out.println("LAUNCHER: Factory theme loaded "+conf.getConfigurationThemeChoose());
        } else {
            main.themeApply(
                    new EzNoteTheme(
                            "",
                            EzNoteColorCollection.COLORS_UI[conf.getConfigurationThemeToolbarColor()],
                            EzNoteColorCollection.COLORS_UI[conf.getConfigurationThemeEditorColor()],
                            EzNoteColorCollection.COLORS_TEXT[conf.getConfigurationThemeFontColor()],
                            EzNoteColorCollection.COLORS_CARET[0]
                    ));
            System.out.println("LAUNCHER: Custom theme loaded "+conf.getConfigurationThemeToolbarColor()+" "+conf.getConfigurationThemeEditorColor()+" "+conf.getConfigurationThemeFontColor());
        }
        
        //main frame settings
        main.setTitle("EzNote - Lightweight txt editor");
        main.setLocationRelativeTo(null);
        
        //setting icon
        main.setIconImage(Toolkit.getDefaultToolkit().getImage(main.getClass().getResource("/gdr/icons/icon.png")));
        
        //initializing startup
        System.out.println("LAUNCHER: STARTING EZNOTE "+EzNoteTexts.SOFTWARE_VERSION);
        main.initializeStartup();
        
        //setting the window as visible
        main.setVisible(true);
    }

}
