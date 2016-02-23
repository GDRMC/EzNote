package gdr.eznote.themes;

public class EzNoteTheme {
    
    private final String name;
    private final EzNoteColor toolbarColor;
    private final EzNoteColor editorColor;
    private final EzNoteColor fontColor;
    
    public EzNoteTheme(String name, EzNoteColor toolbarColor, EzNoteColor editorColor, EzNoteColor fontColor){
        this.name = name;
        this.toolbarColor = toolbarColor;
        this.editorColor = editorColor;
        this.fontColor = fontColor;
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

}
