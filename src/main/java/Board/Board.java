package Board;

import Pawn.Pawn;
import static Game.Enum.Color.*;
import java.util.Scanner;

public class Board {
    private Pawn[][] board;
    private final int size;

    public Board() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number between 10 and 20: ");
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        this.size = n;
        while (n < 10 || n > 20) {
            System.out.println("Not a valid input please try again: ");
            input = scanner.nextLine();
            n = Integer.parseInt(input);
        }
        board = setPawns(new Pawn[n][n], n);
    }

    private Pawn[][] setPawns(Pawn[][] board, int n)
    {
        return setWhitePawns(setBlackPawns(board, n), n);
    }

    private Pawn[][] setWhitePawns(Pawn[][] board, int n) {
        int whitePlaces = n * 2;
        for (int row = board.length - 1; row >= 0; row--) {
            if ((row - 1) % 2 == 0) {
                for (int i = 0; i < board[row].length; i += 2) {
                    if (whitePlaces > 0) {
                        board[row][i] = new Pawn(WHITE, row, i);
                        whitePlaces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (whitePlaces > 0) {
                        board[row][i] = new Pawn(WHITE, row, i);
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
                        board[row][i] = new Pawn(BLACK, row, i);
                        blackPlaces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (blackPlaces > 0) {
                        board[row][i] = new Pawn(BLACK, row, i);
                        blackPlaces--;
                    }
                }
            }
        }
        return board;
    }

    private void setWhite(Pawn[][] board, int n) {
        int places = n * 2;
    }

    public void setBoard(Pawn[][] board) {
        this.board = board;
    }

    public Pawn[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        int whitePawnCode = (int) 0x26AB;
        String circle = Character.toString((char) whitePawnCode);
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder displayBoard = new StringBuilder("    ");
        for (int row = 0; row < board.length; row++) {
            if (row < 9) {
                displayBoard.append(row + 1).append("  ");
            } else {
                displayBoard.append(row + 1).append(" ");
            }
        }
        displayBoard.append("\n");
        for (int row = 0; row < board.length; row++) {
            displayBoard.append(abc[row]).append("  ");
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
                    if ((row + col) % 2 == 0) {
                        displayBoard.append("\u001b[47;1m" + "   " + "\u001b[0m");


                    }else {
                        displayBoard.append("   ");

                    }
                } else {
                    if(board[row][col].getColor() == BLACK){
                        displayBoard.append("\u001b[36m" + " ").append(circle).append(" ").append("\u001b[0m");
                    }
                    else{
                        displayBoard.append(" ").append(circle).append(" ");
                    }
                }
            }
            displayBoard.append("\n");
        }
        return displayBoard.toString();
    }

    public int size(){
        return this.size;
    }

    public Pawn getPawn(int x, int y){
        return board[x][y];
    }
}

