import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class swing4 {
    JButton b1;

    swing4() {
        b1 = new JButton("Enter");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(null);

            swing4 app = new swing4();

            app.b1.setBounds(100, 70, 100, 40);

            app.b1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    app.b1.setText("Hello");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    app.b1.setText("Enter");
                }
            });

            frame.add(app.b1);
            frame.setVisible(true);
        });
    }
}

