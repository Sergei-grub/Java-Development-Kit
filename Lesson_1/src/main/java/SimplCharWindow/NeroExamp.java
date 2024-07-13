package SimplCharWindow;

import javax.swing.*;
import java.awt.*;

public class NeroExamp extends JFrame {
    final JFrame frame = new JFrame("JTextArea Demo");
    String text = "one\ntwo\nthree\nfour\nfive";
    JTextArea ta = new JTextArea(text, 10,30);
    JScrollPane sp = new JScrollPane(ta);

    public static void main(String[] args) {
        new NeroExamp();

    }

    private NeroExamp() {


        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);
//        frame.getContentPane().add(sp);
        frame.add(sp);
        frame.pack();

        frame.setVisible(true);
    }
}
