package Game;

import Board.Board;
import Pawn.Pawn;
import Player.Player;
import Game.Enum.Color;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player actualPlayer;
    private boolean isGameOn;

    public Game(){
        this.board = new Board();
        this.isGameOn = false;

    }
    public void start(){
        this.isGameOn = true;
        Player POne = new Player(Color.WHITE);
        Player PTwo = new Player(Color.BLACK);
        while(isGameOn){
            changeActualPlayer(POne, PTwo);
            this.printBoard();
            int[] startPos = this.getStartingPosition();
            int[] endPos = this.getEndingPosition();
            this.tryToMakeMove(startPos, endPos);
            if(checkForWinner() != Color.BLUE){
                isGameOn = false;
            }
        }
    }

    public void changeActualPlayer(Player p1, Player p2){
        if(actualPlayer == p1){
            actualPlayer = p2;
        }
        else {
            actualPlayer = p1;
        }
    }

    public void tryToMakeMove(int[] startingPos, int[] endingPos){

    }

    public Color checkForWinner(){
        boolean hasBlack = false;
        boolean hasWhite = false;
        for(int i = 0; i < this.board.size(); i++){
            for(int j = 0; j < this.board.size(); j ++){
                if(this.board.getBoard()[i][j] != null ){
                    if(this.board.getBoard()[i][j].getColor() == Color.BLACK){
                        hasBlack = true;
                    }else{
                        hasWhite = true;
                    }
                }
            }
        }
        if (!hasBlack) {
            return Color.WHITE;
        }else if (!hasWhite){
            return Color.BLACK;
        }else{
            return Color.BLUE;
        }
    }

    private void printBoard(){
        actualPlayer.printName();
        System.out.println(this.board.toString());
    }

    private boolean isIndexesValid(int[] indexes){
        if (this.board.size() >= indexes[0] && this.board.size() >= indexes[1] && indexes[0] >= 0 && indexes[1] >= 0){
            return true;
        }
        return false;
    }

    private boolean isPawnAtIndex(int[] indexes){
        Pawn pawn = board.getPawn(indexes[0], indexes[1]);
        if(pawn != null){
            if(pawn.getColor() == actualPlayer.getColor()){
                return true;
            }
        }
        return false;
    }

    private int[] convertCoordinateToIndexes(String input){
        int[] indexes = new int[2];
        indexes[0] = (int)input.charAt(0) - 97;
        if(input.length() == 2){
            indexes[1] = (input.charAt(1) - '0') - 1;
        }
        else{
            indexes[1] = Integer.parseInt(input.substring(1,3)) - 1;
        }
        return indexes;
    }

    private int[] getStartingPosition(){
        boolean isInputValid = false;
        int[] indexes = new int[2];
        while(!isInputValid){
            System.out.println("Choose your pawn: ");
            Scanner scanner = new Scanner(System.in);
            String coordinate = scanner.nextLine();
            coordinate = coordinate.toLowerCase();
            indexes = convertCoordinateToIndexes(coordinate);
            if(isIndexesValid(indexes)){
                   if(isPawnAtIndex(indexes)){
                       isInputValid = true;
                   }
            }
        }
        return indexes;
    }

    private int[] getEndingPosition(){
        boolean isInputValid = false;
        int[] indexes = new int[2];
        while(!isInputValid){
            System.out.println("Choose destination: ");
            Scanner scanner = new Scanner(System.in);
            String coordinate = scanner.nextLine();
            coordinate = coordinate.toLowerCase();
            indexes = convertCoordinateToIndexes(coordinate);
            if(isIndexesValid(indexes)){
                if(board.getPawn(indexes[0], indexes[1]) == null){
                    isInputValid = true;
                }
            }
        }
        return indexes;
    }
}
