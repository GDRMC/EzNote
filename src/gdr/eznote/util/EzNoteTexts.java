package gdr.eznote.util;

/**
 * String components for Frames
 * @author GDRMc
 */
public enum EzNoteTexts {

    /**
     * Software string
     */
    SOFTWARE_NAME("EzNote"),

    /**
     * Version number
     */
    SOFTWARE_VERSION("v0.002d"),

    /**
     * String separator (for title only)
     */
    TITLE_SEPARATOR(" - "),

    /**
     * Custom String #1
     */
    TITLE_TEXT1("Lightweight txt editor"),
    ;
    
    private final String text;

    private EzNoteTexts(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
