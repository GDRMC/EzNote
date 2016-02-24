package gdr.eznote.configuration;

import gdr.eznote.exceptions.ConfiguratorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author GDR
 */
public class EzNoteConfigurator {
    
    private final boolean DEBUG_DELETE_CONFIGURATION_ON_STARTUP = false;
    Properties ezP;

    private Integer cusApprMode;
    private Integer thSelected;
    private Integer thToolbar;
    private Integer thEditor;
    private Integer thFont;

    public static final Integer DEFAULT_CUSAPPRMODE = 0;
    public static final Integer DEFAULT_THSELECTED = 0;
    public static final Integer DEFAULT_THTOOLBAR = 3;
    public static final Integer DEFAULT_THEDITOR = 0;
    public static final Integer DEFAULT_THFONT = 3;

    public EzNoteConfigurator() {

    }
    
    public boolean exists(){
        return new File("eznote.ezcfg").exists();
    }

    public void load() throws ConfiguratorException {
        File f = new File("eznote.ezcfg");
        if(DEBUG_DELETE_CONFIGURATION_ON_STARTUP && f.exists()){
            boolean delete = f.delete();
            if(delete){
                System.out.println("DEBUG: CONFIGURATION FILE DELETED ON STARTUP");
            }
        }
        Properties ezP = new Properties();
        InputStream stream = null;
        boolean loaded = false;
        
        //if the cfg file does not exists, creating new cfg file
        if(!exists()){
            System.out.println("CONFIGURATOR: NO CFG FILE FOUND\nCONFIGURATOR: CREATING A NEW CFG FILE");
            boolean created = create();
            if(created){
                System.out.println("CONFIGURATOR: DONE CREATING CFG FILE");
            } else {
                System.out.println("CONFIGURATOR: ERROR WHILE CREATING CFG FILE");
            }
        }
        System.out.println("CONFIGURATOR: LOADING PROPERTIES");
        //try to read file written
        try {
            f = new File("eznote.ezcfg");
            stream = new FileInputStream(f);
            loaded = true;
        } catch (Exception e) {
            stream = null;
            System.out.println("CONFIGURATOR: MISSING CFG FILE");
        }
        //try to load content of the file
        boolean loaded2 = false;
        try {
            ezP.load(stream);
            cusApprMode = new Integer(ezP.getProperty("CUSAPPRMODE"));
            thSelected = new Integer(ezP.getProperty("THSELECTED"));
            thToolbar = new Integer(ezP.getProperty("THTOOLBAR"));
            thEditor = new Integer(ezP.getProperty("THEDITOR"));
            thFont = new Integer(ezP.getProperty("THFONT"));
            loaded2 = true;
        } catch (IOException ex) {
            System.out.println("CONFIGURATOR: Cannot access eznote.ezcfg");
            throw new ConfiguratorException("Main cfg file is missing or is not accessible");
        }
        
        if(loaded && loaded2){
            System.out.println("CONFIGURATOR: CONFIGURATION LOADED");
        } else {
            System.out.println("CONFIGURATOR: ERROR WHILELOADING CONF FILE");
        }
    }

    public void save() {

    }

    public boolean create() throws ConfiguratorException {
        boolean ok = false;
        //creates a new config file
        cusApprMode = DEFAULT_CUSAPPRMODE;
        thSelected = DEFAULT_THSELECTED;
        thToolbar = DEFAULT_THTOOLBAR;
        thEditor = DEFAULT_THEDITOR;
        thFont = DEFAULT_THFONT;
        //tries save file
        try {
            Properties props = new Properties();
            props.setProperty("CUSAPPRMODE", ""+cusApprMode);
            props.setProperty("THSELECTED", ""+thSelected);
            props.setProperty("THTOOLBAR", ""+thToolbar);
            props.setProperty("THEDITOR", ""+thEditor);
            props.setProperty("THFONT", ""+thFont);
            File f = new File("eznote.ezcfg");
            OutputStream out = new FileOutputStream(f);
            props.store(out, "EZNOTE CONFIGURATION FILE -- DO NOT MODIFY");
            ok = true;
        } catch (Exception e) {
            throw new ConfiguratorException("Cannot create configuration file");
        }
        return ok;
    }

    public int getConfigurationThemeToolbarColor(){
        return this.thToolbar;
    }
    
    public int getConfigurationThemeEditorColor(){
        return this.thEditor;
    }
    
    public int getConfigurationThemeFontColor(){
        return this.thFont;
    }
    
    public int getConfigurationThemeMode(){
        return this.cusApprMode;
    }
    
    public int getConfigurationThemeChoose(){
        return this.thSelected;
    }
}
