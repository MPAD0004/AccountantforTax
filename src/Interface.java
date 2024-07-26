import javax.swing.*;

public class Interface {

    public Interface(){
        // Create new frame
        JFrame frame = new JFrame("Tradie Tax Calculator");
        // Set size of frame
        frame.setSize(1200, 900);
        // Create frame label
        JLabel label = new JLabel("Hello, World!");
        // Add label to frame
        frame.add(label);
        // Display the frame
        frame.setVisible(true);
    }
}
