package br.com.dio;

public class SudokuGame {
    private final SudokuBoard board;

    public SudokuGame() {
        this.board = new SudokuBoard();
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col, int number) {
        if (isMoveValid(row, col, number)) {
            board.setNumber(row, col, number);
            return true;
        }
        return false;
    }

    public boolean isGameWon() {
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            for (int j = 0; j < SudokuBoard.SIZE; j++) {
                if (board.getNumber(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMoveValid(int row, int col, int number) {
        return !isNumberInRow(row, number) &&
                !isNumberInCol(col, number) &&
                !isNumberInBox(row, col, number);
    }

    private boolean isNumberInRow(int row, int number) {
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            if (board.getNumber(row, i) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInCol(int col, int number) {
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            if (board.getNumber(i, col) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(int row, int col, int number) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (board.getNumber(i, j) == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
