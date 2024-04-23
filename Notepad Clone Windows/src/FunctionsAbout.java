import javax.swing.JFrame;
import javax.swing.JLabel;

public class FunctionsAbout extends JFrame {
    Gui gui;

    
    public  FunctionsAbout(Gui gui) {
        this.gui=gui;
    }
    public void openAbout(){
        
        // gui.textArea.setText("Hello there! \nThis is my notepad"); // it will show the about text
        // gui.window.setTitle("About"); // title

        JLabel  label = new JLabel();
        label.setText("Hello there! My name is Rohan Das.");
        label.setText("This is my notepad which I built using Java Swing. It's created on Febuary,2024.");


        // Basic Structure
        JFrame frame = new JFrame();// Create a frame
        this.setTitle("About");// Title of frame
        this.setResizable(false);
        this.setSize(600, 500);// Set the x dimension and y dimension
        this.setVisible(true);// Frame make visible
        this.add(label);// This will add the label
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
