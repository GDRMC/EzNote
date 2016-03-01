package gdr.eznote.util;

/**
 * String components for Frames
 * @author GDRMc
 */
public enum EzNoteStringDB {

    /**
     * Software string
     */
    SOFTWARE_NAME("EzNote"),

    /**
     * Version number
     */
    SOFTWARE_VERSION("v0.003d"),

    /**
     * String separator (for title only)
     */
    TITLE_SEPARATOR(" - "),

    /**
     * Custom String #1
     */
    TITLE_TEXT1("lightweight, portable and customisable text editor"),
    
    CONFIGURATOR_COMMENT("EZNOTE CONFIGURATION FILE -- DO NOT MODIFY"),
    ;
    
    private final String text;

    private EzNoteStringDB(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
