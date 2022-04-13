package Player;

import Game.Enum;

import java.util.Scanner;
import static Game.Enum.Color.*;
import static Game.Enum.Direction.*;

public class Player {
    private final String name;
    private final Enum.Color color;
    private final Enum.Direction direction;
    public Player(Enum.Color color){
        System.out.println("New player: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        this.color = color;
        if(color == WHITE){
            this.direction = UP;
        }
        else{
            this.direction = DOWN;
        }
        System.out.flush();
    }

    public void printName(){
        System.out.println(this.name.toUpperCase() + "'s turn:");
    }

    public Enum.Color getColor(){
        return this.color;
    }

    public Enum.Direction getDirection(){
        return this.direction;
    }
}
