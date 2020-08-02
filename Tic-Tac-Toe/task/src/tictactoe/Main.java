package tictactoe;

import java.util.Scanner;

public class Main {
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int NOUGHT = 2;


    public static final int PLAYING = 0;
    public static final int DRAW = 1;
    public static final int CROSS_WON = 2;
    public static final int NOUGHT_WON = 3;

    public static final int ROWS = 3, COLS = 3;
    public static int[][] cells = new int[ROWS][COLS];

    public static int currentState;
    public static int currentPlayer;
    public static int currentRow, currentCol;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initGame();
        print();
        do {
            playerMove(currentPlayer);
            updateGame(currentPlayer, currentRow, currentCol);
            print();
            if (currentState == CROSS_WON) {
                System.out.println("X wins");
            } else if (currentState == NOUGHT_WON) {
                System.out.println("O wins");
            } else if (currentState == DRAW) {
                System.out.println("Draw");
            }
            currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
        } while (currentState == PLAYING);
    }

    public static void initGame() {
        for (int i = cells.length - 1; i >= 0; i--) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[j][i] = EMPTY;
            }
        }
        currentPlayer = CROSS;
        currentState = PLAYING;
    }

    public static void updateGame(int theSeed, int currentRow, int currentCol) {
        if (hasWon(theSeed, currentRow, currentCol)) {
            currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
        } else if (isDraw()) {  // check for draw
            currentState = DRAW;
        }

    }

    public static boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
        return (cells[currentRow][0] == theSeed
                && cells[currentRow][1] == theSeed
                && cells[currentRow][2] == theSeed
                || cells[0][currentCol] == theSeed
                && cells[1][currentCol] == theSeed
                && cells[2][currentCol] == theSeed
                || currentRow == currentCol
                && cells[0][0] == theSeed
                && cells[1][1] == theSeed
                && cells[2][2] == theSeed
                || currentRow + currentCol == 2
                && cells[0][2] == theSeed
                && cells[1][1] == theSeed
                && cells[2][0] == theSeed);
    }

    public static void playerMove(int theSeed) {
        boolean validInput = false;  // for input validation
        while (!validInput) {
            System.out.print("Enter the coordinates: ");
            String[] s = scanner.nextLine().trim().split(" ");
            try {
                int row = Integer.parseInt(s[0]) - 1;
                int col = Integer.parseInt(s[1]) - 1;

                if (row >= 0 && row < ROWS && col >= 0 && col < COLS && cells[row][col] == EMPTY) {
                    currentRow = row;
                    currentCol = col;
                    cells[currentRow][currentCol] = theSeed;
                    validInput = true;
                } else if ((row >= ROWS || col >= COLS) || (row < 0 || col < 0)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    /**
     * Print data
     */
    public static void print() {
        System.out.println("---------");
        for (int i = cells.length - 1; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < cells[i].length; j++) {
                printCell(cells[j][i]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    private static boolean isGameCorrect(String[][] ttt, String pl1, String pl2) {
        int pl1Cnt = 0;
        int pl2Cnt = 0;
        for (String[] strings : ttt) {
            for (String string : strings) {
                if (string.equals(pl1)) {
                    pl1Cnt++;
                } else if (string.equals(pl2)) {
                    pl2Cnt++;
                }
            }
        }
        return Math.abs(pl1Cnt - pl2Cnt) > 1;
    }
    public static void printCell(int content) {
        switch (content) {
            case EMPTY:
                System.out.print("  ");
                break;
            case NOUGHT:
                System.out.print("O ");
                break;
            case CROSS:
                System.out.print("X ");
                break;
        }

    }
}
