package Player;

import java.util.Scanner;
import Game.Enum;

public class Player {
    private final String name;
    private final Enum.Color color;
    private final Enum.Direction direction;
    public Player(Enum.Color color){
        System.out.println("New player: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        this.color = color;
        if(color == Enum.Color.WHITE){
            this.direction = Enum.Direction.DOWN;
        }
        else{
            this.direction = Enum.Direction.UP;
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
