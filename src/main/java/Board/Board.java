package Board;

import Pawn.Pawn;

import java.io.PrintStream;
import java.util.Scanner;

public class Board {
    private Pawn[][] board;
    private Scanner scanner;
    private int n;

    Board() {
        scanner = new Scanner(System.in);
        System.out.println("Type a number between 10 and 20: ");
        String input = scanner.nextLine();
        n = Integer.parseInt(input);

        while (n < 10 || n > 20) {
            System.out.println("Not a valid input please try again: ");
            input = scanner.nextLine();
            n = Integer.parseInt(input);
        }
        board = setPawns(new Pawn[n][n], n);
    }

    private Pawn[][] setPawns(Pawn[][] board, int n) {
        return setWhitePawns(setBlackPawns(board, n), n);
    }

    private Pawn[][] setWhitePawns(Pawn[][] board, int n) {
        int whitePlaces = n * 2;
        for (int row = board.length - 1; row >= 0; row--) {
            if ((row - 1) % 2 == 0) {
                for (int i = 0; i < board[row].length; i += 2) {
                    if (whitePlaces > 0) {
                        board[row][i] = new Pawn("white", row, i);
                        whitePlaces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (whitePlaces > 0) {
                        board[row][i] = new Pawn("white", row, i);
                        whitePlaces--;
                    }
                }
            }
        }
        return board;
    }

    private Pawn[][] setBlackPawns(Pawn[][] board, int n) {
        int blackPlaces = n * 2;
        for (int row = 0; row < board.length; row++) {
            if ((row + 1) % 2 == 0) {
                for (int i = 0; i < board[row].length; i += 2) {
                    if (blackPlaces > 0) {
                        board[row][i] = new Pawn("black", row, i);
                        blackPlaces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (blackPlaces > 0) {
                        board[row][i] = new Pawn("black", row, i);
                        blackPlaces--;
                    }
                }
            }
        }
        return board;
    }

    private void setWhite(Pawn[][] board, int n)
    {
        int places = n * 2;
    }

    public void setBoard(Pawn[][] board)
    {
        this.board = board;
    }
    public Pawn[][] getBoard()
    {
        return board;
    }

    public static void printBoard(Pawn[][] board)
    {
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }
}

