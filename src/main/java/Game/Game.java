package Game;

import Board.Board;
import Player.Player;

public class Game {

    private Board board;
    private final Player POne;
    private final Player PTwo;
    private boolean isGameOn;

    public Game(){
        this.board = new Board();
        this.POne = new Player();
        this.PTwo = new Player();
        this.isGameOn = false;
    }
    public void start(){

    }

    public void playRound(){

    }

    public void tryToMakeMove(){

    }

    public void checkForWinner(){

    }

    private void setIsGameOn(){
        this.isGameOn = !this.isGameOn;
    }

    public void printBoard(){
        // this.board.toString();
    }

    private void getUserInput(){

    }
}
