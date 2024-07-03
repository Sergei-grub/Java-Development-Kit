package TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;

    JButton btnStart = new JButton("Start New Game");
    JLabel label = new JLabel("Выберите режим игры");
    JLabel label2 = new JLabel("Выберите размеры поля");
    JLabel label3 = new JLabel("Установленный размер поля:");
    JLabel label4 = new JLabel("Выберите длину для победы");
    JLabel label5 = new JLabel("Установленная длина:");
    JRadioButton jrb1 = new JRadioButton("Человек против компьютера");
    JRadioButton jrb2 = new JRadioButton("Человек против человека");
    ButtonGroup btnGroup = new ButtonGroup();
    JSlider js1 = new JSlider(3, 10);
    JSlider js2 = new JSlider(3, 10);


    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setLayout(new GridLayout(10, 1));

        add(label);
        btnGroup.add(jrb1);
        btnGroup.add(jrb2);
        js1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label3.setText("Установленный размер поля: " + js1.getValue());
            }
        });
        js2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label5.setText("Установленная длина: " + js2.getValue());
            }
        });

        add(jrb1);
        add(jrb2);
        add(label2);
        add(label3);
        add(js1);
        add(label4);
        add(label5);
        add(js2);


        add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(jrb1.isSelected() ? 0 : 1, js1.getValue(), js1.getValue(), js2.getValue());
                setVisible(false);
            }
        });
    }
}