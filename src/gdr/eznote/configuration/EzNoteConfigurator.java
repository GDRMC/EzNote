package gdr.eznote.configuration;

import gdr.eznote.exceptions.ConfiguratorException;
import gdr.eznote.util.EzNoteTexts;
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

    private Properties ezP;
    private File f = new File("eznote.ezcfg");

    private boolean erase;
    private boolean saveload;

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

    public EzNoteConfigurator(int erase, int io) {
        if (erase == (1)) {
            this.erase = true;
        }
        if (io == (1)) {
            this.saveload = true;
        }
    }

    public boolean exists() {
        return this.f.exists();
    }

    public void load() throws ConfiguratorException {
        if (erase && f.exists()) {
            boolean delete = f.delete();
            if (delete) {
                System.out.println("DEBUG: CONFIGURATION FILE DELETED ON STARTUP");
            }
        }
        Properties ezP = new Properties();
        InputStream stream = null;
        boolean loaded = false;

        //if the cfg file does not exists, creating new cfg file
        if (!exists()) {
            System.out.println("CONFIGURATOR: NO CFG FILE FOUND\nCONFIGURATOR: CREATING A NEW CFG FILE");
            boolean created = create();
            if (created) {
                System.out.println("CONFIGURATOR: DONE CREATING CFG FILE");
            } else {
                System.out.println("CONFIGURATOR: ERROR WHILE CREATING CFG FILE");
            }
        }
        System.out.println("CONFIGURATOR: LOADING PROPERTIES");
        //try to read file written
        try {
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
            this.debugProperties("load");
            loaded2 = true;
        } catch (IOException ex) {
            System.out.println("CONFIGURATOR: Cannot access eznote.ezcfg");
            throw new ConfiguratorException("Main cfg file is missing or is not accessible");
        }

        if (loaded && loaded2) {
            System.out.println("CONFIGURATOR: CONFIGURATION LOADED");
        } else {
            System.out.println("CONFIGURATOR: ERROR WHILE LOADING CONFIGURATION FILE");
        }
    }

    public boolean save() throws ConfiguratorException {
        //array order {custom1,custom2,custom3,themeselected}
        boolean ok = false;
        OutputStream stream = null;
        try {
            Properties toSave = new Properties();
            stream = new FileOutputStream(f);
            toSave.setProperty("CUSAPPRMODE", "" + cusApprMode);
            toSave.setProperty("THSELECTED", "" + thSelected);
            toSave.setProperty("THTOOLBAR", "" + thToolbar);
            toSave.setProperty("THEDITOR", "" + thEditor);
            toSave.setProperty("THFONT", "" + thFont);
            this.debugProperties("save");
            ok = true;
            toSave.store(stream, "" + EzNoteTexts.CONFIGURATOR_COMMENT);
            stream.close();
        } catch (IOException ex) {
            stream = null;
            System.out.println("CONFIGURATOR: Cannot access eznote.ezcfg");
            throw new ConfiguratorException("Main cfg file is missing or is not accessible");
        }
        return ok;
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
            props.setProperty("CUSAPPRMODE", "" + cusApprMode);
            props.setProperty("THSELECTED", "" + thSelected);
            props.setProperty("THTOOLBAR", "" + thToolbar);
            props.setProperty("THEDITOR", "" + thEditor);
            props.setProperty("THFONT", "" + thFont);
            OutputStream out = new FileOutputStream(f);
            props.store(out, "" + EzNoteTexts.CONFIGURATOR_COMMENT);
            ok = true;
        } catch (Exception e) {
            throw new ConfiguratorException("Cannot create configuration file");
        }
        return ok;
    }

    public int getConfigurationThemeToolbarColor() {
        return this.thToolbar;
    }

    public int getConfigurationThemeEditorColor() {
        return this.thEditor;
    }

    public int getConfigurationThemeFontColor() {
        return this.thFont;
    }

    public int getConfigurationThemeMode() {
        return this.cusApprMode;
    }

    public int getConfigurationThemeChoose() {
        return this.thSelected;
    }

    public void setConfigurationThemeMode(Integer cusApprMode) {
        this.cusApprMode = cusApprMode;
    }

    public void setConfigurationThemeChoose(Integer thSelected) {
        this.thSelected = thSelected;
    }

    public void setConfigurationThemeToolbarColor(Integer thToolbar) {
        this.thToolbar = thToolbar;
    }

    public void setConfigurationThemeEditorColor(Integer thEditor) {
        this.thEditor = thEditor;
    }

    public void setConfigurationThemeFontColor(Integer thFont) {
        this.thFont = thFont;
    }

    private void debugProperties(String str) {
        if (this.saveload) {
            System.out.println("CONFIGURATOR: " + str.toUpperCase() + " " + cusApprMode + " " + thSelected + " " + thToolbar + " " + thEditor + " " + thFont);

        }
    }

}
