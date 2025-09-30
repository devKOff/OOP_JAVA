import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The EventHandler class is functionally correct.
// It listens for an action (like a button click).
class EventHandler implements ActionListener {
    swing2 s;

    // Constructor to get a reference to the main class instance.
    EventHandler(swing2 s) {
        this.s = s;
    }

    // This method is called when the button is clicked.
    public void actionPerformed(ActionEvent e) {
        // Get the text from the text field.
        String s1 = s.t1.getText();
        // Set the label's text to what was in the text field.
        s.l1.setText("You entered: " + s1);
    }
}

class swing2 {
    JTextField t1;
    JLabel l1;
    JButton b1;
    EventHandler eh;

    swing2() {
        // Initialize the GUI components.
        t1 = new JTextField();
        l1 = new JLabel("Enter text above and click the button.");
        // It's good practice to give buttons descriptive text.
        b1 = new JButton("Submit");
        // Create the event handler and pass it a reference to this class.
        eh = new EventHandler(this);
    }

    public static void main(String[] args) {
        swing2 obj = new swing2();
        JFrame jf = new JFrame("Simple Swing App");

        jf.setSize(400, 300); // Adjusted size for better layout.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null); // Using absolute positioning.

        // Add the components to the frame.
        jf.add(obj.l1);
        jf.add(obj.t1);
        jf.add(obj.b1);

        // --- CORRECTIONS and IMPROVEMENTS ---

        // 1. Set distinct bounds for the text field and label to avoid overlap.
        obj.t1.setBounds(50, 50, 200, 30);  // Text field near the top.
        obj.b1.setBounds(50, 100, 200, 30); // Button below the text field.
        obj.l1.setBounds(50, 150, 250, 30); // Label below the button to show the result.

        // Add the action listener to the button.
        obj.b1.addActionListener(obj.eh);

        // 2. The frame must be set to visible to be displayed. This was the main error.
        jf.setVisible(true);
    }
}