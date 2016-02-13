package gdr.eznote.util;

public enum EzNoteTexts {
    SOFTWARE_NAME("EzNote"),
    SOFTWARE_VERSION("0.001d"),
    TITLE_SEPARATOR(" - "),
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
