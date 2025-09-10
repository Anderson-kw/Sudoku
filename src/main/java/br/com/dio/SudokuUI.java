package br.com.dio;

import java.util.Scanner;

public class SudokuUI {
    private final SudokuGame game;
    private final Scanner scanner;

    public SudokuUI() {
        this.game = new SudokuGame();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("--- Jogo de Sudoku ---");
        System.out.println("Instruções: Insira a linha, coluna e o número (de 1 a 9).");

        while (!game.isGameWon()) {
            printBoard();

            System.out.print("Digite a linha (1-9): ");
            int row = scanner.nextInt() - 1;

            System.out.print("Digite a coluna (1-9): ");
            int col = scanner.nextInt() - 1;

            System.out.print("Digite o número (1-9): ");
            int number = scanner.nextInt();

            if (row < 0 || row >= SudokuBoard.SIZE || col < 0 || col >= SudokuBoard.SIZE || number < 1 || number > 9) {
                System.out.println("Entrada inválida! Tente novamente.");
                continue;
            }

            if (game.getBoard().isInitial(row, col)) {
                System.out.println("Célula inicial! Você não pode alterar este número.");
                continue;
            }

            boolean success = game.makeMove(row, col, number);
            if (!success) {
                System.out.println("Jogada inválida! O número já existe na linha, coluna ou bloco 3x3.");
            }
        }

        System.out.println("\n--- Tabuleiro Final ---");
        printBoard();
        System.out.println("Parabéns! Você completou o Sudoku!");
        scanner.close();
    }

    private void printBoard() {
        SudokuBoard board = game.getBoard();
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("|-------+-------+-------|");
            }
            System.out.print("| ");
            for (int j = 0; j < SudokuBoard.SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                int number = board.getNumber(i, j);
                System.out.print(number == 0 ? "  " : number + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}
