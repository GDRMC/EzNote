package gdr.eznote.components;

import gdr.eznote.themes.EzNoteColor;
import gdr.eznote.themes.EzNoteColorCollection;
import gdr.eznote.themes.EzNoteTheme;
import gdr.eznote.themes.EzNoteThemeLibrary;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author GDR
 */
public class EzNoteComboBoxThemePicker extends AbstractListModel implements ComboBoxModel{

    private EzNoteTheme[]themes;
    private EzNoteTheme selection = null;
    
    public EzNoteComboBoxThemePicker(){
        this.themes = EzNoteThemeLibrary.getAvailableThemes();
        this.selection = this.themes[0];
    }
    
    @Override
    public void setSelectedItem(Object color) {
        this.selection = (EzNoteTheme) color;
    }

    @Override
    public Object getSelectedItem() {
        return this.selection;
    }

    @Override
    public int getSize() {
        return this.themes.length;
    }

    @Override
    public Object getElementAt(int index) {
        return this.themes[index];
    }
    
    @Override
    public String toString(){
        return this.selection.getName();
    }
}
