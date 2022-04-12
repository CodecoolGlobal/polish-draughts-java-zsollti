package Main;

import Game.Game;
import Board.Board;
import Pawn.Pawn;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board();
        board.printBoard();
        game.start();
    }
}
