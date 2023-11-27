package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel{
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    //Противник
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    //Бизнес логика
    private int gameOverType;
    private static final int STAT_DRAW = 0;
    private static final int STAT_WIN_HUMAN = 1;
    private static final int STAT_WIN_AI = 2;
    //Сообщения об окончании игры
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY;
    private int fieldSizeX;
    private int wLen;
    private char[][] field;

    private boolean isGameOver;
    private boolean isInitialized;

    Map(){
//        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private void update(MouseEvent e){
        if (isGameOver || !isInitialized) return;

        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
//        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();

        if(checkEndGame(HUMAN_DOT, STAT_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if(checkEndGame(AI_DOT, STAT_WIN_AI)) return;

    }

    private boolean checkEndGame(int dot, int gameOverType){
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STAT_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        fieldSizeY = fSzY;
        fieldSizeX = fSzX;
        this.wLen = wLen;
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    // Метод отрисовки
    private void render(Graphics g){
        if(!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) continue;

                if(field[y][x] == HUMAN_DOT){
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                            " in cell: x=" + x + " y=" + y);
                }

            }
        }

        if(isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200,getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType){
            case STAT_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2); break;
            case STAT_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2); break;
            case STAT_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2); break;
            default:
                throw new RuntimeException("Unexected gameOver state: " + gameOverType);
        }
    }

    //Метод инициализации поля
    /**
     * Tic Tac Toe game logic
     */
    private void initMap(){
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn(){
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean checkWin(int c) {
        if(field[0][0]==c && field[0][1]==c && field[0][2]==c) return true;
        if(field[1][0]==c && field[1][1]==c && field[1][2]==c) return true;
        if(field[2][0]==c && field[2][1]==c && field[2][2]==c) return true;

        if(field[0][0]==c && field[1][0]==c && field[2][0]==c) return true;
        if(field[0][1]==c && field[1][1]==c && field[2][1]==c) return true;
        if(field[0][2]==c && field[1][2]==c && field[2][2]==c) return true;

        if(field[0][0]==c && field[1][1]==c && field[2][2]==c) return true;
        if(field[0][2]==c && field[1][1]==c && field[2][0]==c) return true;
        return false;
    }

    private boolean isMapFull(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
