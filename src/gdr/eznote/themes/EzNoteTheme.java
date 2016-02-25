package gdr.eznote.themes;

public class EzNoteTheme {
    
    private final String name;
    private final EzNoteColor toolbarColor;
    private final EzNoteColor editorColor;
    private final EzNoteColor fontColor;
    private final EzNoteColor caretColor;
    
    public EzNoteTheme(String name, EzNoteColor toolbarColor, 
            EzNoteColor editorColor, EzNoteColor fontColor, 
            EzNoteColor caretColor){
        this.name = name;
        this.toolbarColor = toolbarColor;
        this.editorColor = editorColor;
        this.fontColor = fontColor;
        this.caretColor = caretColor;
    }

    public String getName() {
        return name;
    }

    public EzNoteColor getToolbarColor() {
        return toolbarColor;
    }

    public EzNoteColor getEditorColor() {
        return editorColor;
    }

    public EzNoteColor getFontColor() {
        return fontColor;
    }

    public EzNoteColor getCaretColor() {
        return caretColor;
    }
}
