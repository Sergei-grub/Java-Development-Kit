package ExceptionalWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exeptional extends JFrame implements
        ActionListener, Thread.UncaughtExceptionHandler {
    private Exeptional(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        JButton btn = new JButton("Push me!");
        btn.addActionListener(this);
        add(btn);
        setVisible(true);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exeptional();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new ArrayIndexOutOfBoundsException("Bad thing happened!");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null,
                e.getMessage(),"EXEPTION ON BORD!",
                JOptionPane.ERROR_MESSAGE);

    }
}
