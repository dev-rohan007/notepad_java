public class FunctionsEdit {
    Gui gui;
    public FunctionsEdit(Gui gui){
        this.gui=gui;
    }
    public void undo(){
        gui.um.undo();
    }
    public void redo(){
        gui.um.redo();
    }
}

