// References
// https://www.dummies.com/programming/java/how-to-write-java-code-to-show-an-image-on-the-screen/
// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
// https://docs.oracle.com/javase/tutorial/uiswing/events/index.html
// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#getresource

// Compile
// javac Lamp.java

// Create jar file
// jar cfe Lamp.jar Lamp *.class images

// Execute the jar file
// java -jar Lamp.jar

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Lamp {
    static String state = "off";

    public static void main(String args[]) {
        JFrame frame = new JFrame("Off");
        ImageIcon off = new ImageIcon(Lamp.class.getResource("images/lamp_off.jpg"));
	ImageIcon on = new ImageIcon(Lamp.class.getResource("images/lamp_on.jpg"));
        JLabel label = new JLabel(off);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent event) {

                if (event.getClickCount() == 2) { // double clicked

                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                } else if (state.equals("off")) {
                    frame.setTitle("On");
                    label.setIcon(on);
                    state = "on";
                } else {
                    frame.setTitle("Off");
                    label.setIcon(off);
                    state = "off";
                }
            }
        });
    }
}
