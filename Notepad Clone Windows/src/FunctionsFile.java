import java.awt.FileDialog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class FunctionsFile{
    Gui gui;
    String fileName;
    String fileAddress;

    public FunctionsFile(Gui gui) {
        this.gui = gui;
    }

    // functions to create new file
    public void newFile() {
        gui.textArea.setText(""); // it will erase the current text
        gui.window.setTitle("New"); // set the default new name of the new file
    }

    // functions to open a existing file
    public void newOpen() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        // logic to open a file
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName); // it will show the file name as title
        }
        // display the content
        // use buffer reader
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // functions to save as
    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // functions to exit
    public void exit() {
        System.exit(0);
    }


}
