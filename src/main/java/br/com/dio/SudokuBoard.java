package br.com.dio;

import java.util.Scanner;

public class SudokuBoard {

    private final int[][] board;
    private final boolean[][] isInitial;
    public static final int SIZE = 9;

    public SudokuBoard() {
        this.board = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        this.isInitial = new boolean[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (this.board[row][col] != 0) {
                    this.isInitial[row][col] = true;
                }
            }
        }
    }

    public int getNumber(int row, int col) {
        return this.board[row][col];
    }

    public void setNumber(int row, int col, int number) {
        if (!isInitial[row][col]) {
            this.board[row][col] = number;
        }
    }

    public boolean isInitial(int row, int col) {
        return this.isInitial[row][col];
    }
}
