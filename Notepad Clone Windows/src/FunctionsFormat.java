import java.awt.Font;

public class FunctionsFormat {
    Gui gui;

    Font arial, comicSanMs, timesNewRoman;

    String selectedFont;

    public FunctionsFormat(Gui gui) {
        this.gui = gui;
    }

    // word wrap function
    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iwrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iwrap.setText("Word Wrap: Off");
        }
    }

    // font type
    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSanMs = new Font("Comic Sans Ms", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    // set font method
    public void setFont(String font) {
        String selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans Ms":
                gui.textArea.setFont(comicSanMs);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }

    }
}
