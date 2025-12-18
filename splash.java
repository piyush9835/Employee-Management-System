package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(5000); // stops program for 5 seconds
            setVisible(false); // hides the splash window
            new login(); // Opens the login window after splash screen disappears.
        }catch (Exception e){ // block prints errors (if any).
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new splash();
    }
}

