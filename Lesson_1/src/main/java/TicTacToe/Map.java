package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 2;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final String MSG_DRAW = "Ничья!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private int gameOverType;
    private final int EMPTY_DOT = 0;
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private int fieldSizeX = 5;
    private int fieldSizeY = 5;
    private char[][] field;
    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;


    Map() {
        setBackground(Color.CYAN);
//        setBackground(new Color(13, 33, 44));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
                update(e);
            }
        });
        isInitialized = false;

    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) {
            return;
        }

        int cellX = e.getX() / cellWidth;

        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        field[cellY][cellX] = HUMAN_DOT;
        repaint();
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) {
            return;
        }
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) {
            return;
        }
        System.out.printf("x-%d, y-%d\n", cellX, cellY);
    }


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("\nMode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }


    private void render(Graphics g) {
        if (!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWidth = panelWidth / 5;
        cellHeight = panelHeight / 5;


        g.setColor(Color.BLACK);
        for (int h = 0; h < 5; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < 5; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;
                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xD45D5D));
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " +
                            field[y][x] + " in cell: x=" + x + " y=" + y);
                }
            }
        }
//        repaint();
        if (isGameOver) {
            showMessageGameOver(g);
        }
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);

        }
    }

    private void initMap() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(int symbol) {
        // Проверка по горизонталям
        int count = 0;
        int temp;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == symbol) {
                    temp = i;
                    if (temp == i) {
                        System.out.println("temp = " + temp);
                        System.out.println("i = " + i);
                        System.out.println("count = " + count);
                        count++;
                    }
                    if (count == field.length) return true;
                }
            }
            // Проверка по трем вертикалям
//        if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) return true;
//        if (field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol) return true;
//        if (field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) return true;

//        for (int i = 0; i < field.length; i++){
//            int countY = 0;
//            for (int j = 0; j < field.length; j++){
//                if (field[i][j] == symbol) countY++;
//                if (countY == field.length) return true;
//            }
//        }

            // Проверка по диагоналям
//        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) return true;
//        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) return true;

//        int countXY = 0;
//        for (int i = 0; i < field.length; i++){
//            for (int j = 0; j < field.length; j++){
//                if (field[i][j] == symbol) countXY++;
//                if (countXY == field.length) return true;
//            }
//        }

        }
        return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            isGameOver = true;
            this.gameOverType = gameOverType;
            repaint();
            return true;
        }
        if (isMapFull()) {
            isGameOver = true;
            this.gameOverType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }
}