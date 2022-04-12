package Game;

import Board.Board;
import Pawn.Pawn;
import Player.Player;
import static Player.Player.Color.*;
import static Player.Player.Direction.*;

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
        Player POne = new Player(WHITE);
        Player PTwo = new Player(BLACK);
        while(isGameOn){
            this.actualPlayer = POne;
            this.printBoard(POne, PTwo);
            int[] startPos = this.getStartingPosition();
            int[] endPos = this.getEndingPosition();
            this.tryToMakeMove(startPos, endPos);

        }
    }

    public void playRound(){

    }

    public void tryToMakeMove(int[] startingPos, int[] endingPos){

    }

    public String checkForWinner(){
        boolean hasBlack = false;
        boolean hasWhite = false;
        for(int i = 0; i < this.board.size(); i++){
            for(int j = 0; j < this.board.size(); j ++){
                if(this.board.getBoard()[i][j] != null ){
                    if(this.board.getBoard()[i][j].getColor() == "black"){
                        hasBlack = true;
                    }else{
                        hasWhite = true;
                    }
                }
            }
        }
        if (!hasBlack) {
            return "white";
        }else if (!hasWhite){
            return "black";
        }else{
            return "";
        }
    }

    private void printBoard(Player POne, Player PTwo){
        System.out.flush();
        POne.printName();
        System.out.println(this.board.toString());
        PTwo.printName();
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
            if(pawn.getColor() == "white"){
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
        System.out.println("indexX: " + indexes[0] + " indexY: " + indexes[1]);
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
