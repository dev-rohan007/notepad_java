import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Gui implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    // top bar items
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuAbout;

    // file submenu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    // format menu items
    JMenuItem iwrap, iFontArial, iFontCSMS, iFontTMR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24,
            iFontSize28;

    // colors
    JMenuItem icolor1, icolor2, icolor3, icolor4, icolor5, icolor6, icolor7;
    // format items
    JMenu menuFont, menuFontSize;

    // edit items
    JMenuItem iundo, iredo;

    // Undo redo manager
    UndoManager um = new UndoManager();

    boolean wordWrapOn = false;

    FunctionsFile file = new FunctionsFile(this);
    FunctionsFormat format = new FunctionsFormat(this);
    FunctionsColor color = new FunctionsColor(this);
    FunctionsEdit edit = new FunctionsEdit(this);
    FunctionsAbout about = new FunctionsAbout(this);

    // constructor
    public Gui() {
        System.out.println("Gui App");

        // calling all the methods
        createWindow();
        textArea();
        createMenubar();
        createFileMenu();
        createFormatMenu();
        createcolor();
        createEditMenu();
        createAbout();

        // set default font and size
        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

        window.setVisible(true);

    }

    public void createWindow() {
        window = new JFrame("My Notepad");
        window.setSize(700, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("Notepad Clone Windows\\src\\media\\download 2.png");// Create an image icon
        window.setIconImage(image.getImage());
    }

    // another method to write text in text area
    public void textArea() {
        textArea = new JTextArea();

        // undo and redo manager
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // window.add(textArea);
        window.add(scrollPane);
    }

    // create a menubar method
    public void createMenubar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        // file
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // edit
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        // format
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        // color
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        // about
        menuAbout = new JMenu("About");
        menuAbout.addActionListener(this);
        menuAbout.setActionCommand("About");
        menuBar.add(menuAbout);
    }

    // method for sub-menu in file
    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu() {
        iwrap = new JMenuItem("Word Wrap: off");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("Word Wrap");
        menuFormat.add(iwrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans Ms");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans Ms");
        menuFont.add(iFontCSMS);

        iFontTMR = new JMenuItem("Times New Roman");
        iFontTMR.addActionListener(this);
        iFontTMR.setActionCommand("Times New Roman");
        menuFont.add(iFontTMR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

    }

    public void createcolor() {
        icolor1 = new JMenuItem("White");
        icolor1.addActionListener(this);
        icolor1.setActionCommand("White");
        menuColor.add(icolor1);

        icolor2 = new JMenuItem("Black");
        icolor2.addActionListener(this);
        icolor2.setActionCommand("Black");
        menuColor.add(icolor2);

        icolor3 = new JMenuItem("Blue");
        icolor3.addActionListener(this);
        icolor3.setActionCommand("Blue");
        menuColor.add(icolor3);

        icolor4 = new JMenuItem("Orange");
        icolor4.addActionListener(this);
        icolor4.setActionCommand("Orange");
        menuColor.add(icolor4);

        icolor5 = new JMenuItem("Magenta");
        icolor5.addActionListener(this);
        icolor5.setActionCommand("Magenta");
        menuColor.add(icolor5);
        icolor6 = new JMenuItem("Green");
        icolor6.addActionListener(this);
        icolor6.setActionCommand("Green");
        menuColor.add(icolor6);

        icolor7 = new JMenuItem("Cyan");
        icolor7.addActionListener(this);
        icolor7.setActionCommand("Cyan");
        menuColor.add(icolor7);
    }

    // edit menu method
    public void createEditMenu() {
        iredo = new JMenuItem("Redo");
        iredo.addActionListener(this);
        iredo.setActionCommand("Redo");
        menuEdit.add(iredo);

        iundo = new JMenuItem("Undo");
        iundo.addActionListener(this);
        iundo.setActionCommand("Undo");
        menuEdit.add(iundo);
    }

    public void createAbout() {

        // Add functionality when about is clicked to show that
        menuAbout.addMouseListener((MouseListener) new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                about.openAbout();
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.newOpen();
                break;
            case "Save":
                file.save();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Comic Sans Ms":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
            case "size8":
                format.createFont(8);
                break;
            case "size12":
                format.createFont(12);
                break;
            case "size16":
                format.createFont(16);
                break;
            case "size18":
                format.createFont(18);
                break;
            case "size20":
                format.createFont(20);
                break;
            case "size24":
                format.createFont(24);
                break;
            case "size28":
                format.createFont(28);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;
            case "Orange":
                color.changeColor(command);
                break;
            case "Cyan":
                color.changeColor(command);
                break;
            case "Magenta":
                color.changeColor(command);
                break;
            case "Yellow":
                color.changeColor(command);
                break;
            case "Green":
                color.changeColor(command);
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "About":
                about.openAbout();
        }
    }

}
