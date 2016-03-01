package gdr.eznote.components;

import gdr.eznote.themes.EzNoteColor;
import gdr.eznote.themes.EzNoteColorCollection;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author GDR
 */
public class EzNoteComboBoxColorPicker extends AbstractListModel implements ComboBoxModel{

    private EzNoteColor[]colors;
    private EzNoteColor selection = null;
    
    public EzNoteComboBoxColorPicker(int mode){
        switch (mode) {
            case 0: //Toolbar colors
                this.colors = EzNoteColorCollection.getUIColors();
                break;
            case 1: //editor colors
                this.colors = EzNoteColorCollection.getUIColors();
                break;
            case 2: //texts
                this.colors = EzNoteColorCollection.getTextColors();
                break;
            case 3: //caret
                this.colors = EzNoteColorCollection.getCaretColors();
                break;
            default:
                this.colors = EzNoteColorCollection.getTextColors();
                break;
        }
        this.selection = this.colors[0];
    }
    
    @Override
    public void setSelectedItem(Object color) {
        this.selection = (EzNoteColor) color;
    }

    @Override
    public Object getSelectedItem() {
        return this.selection;
    }

    @Override
    public int getSize() {
        return this.colors.length;
    }

    @Override
    public Object getElementAt(int index) {
        return this.colors[index];
    }
    
    @Override
    public String toString(){
        return this.selection.getName();
    }
}
