package Player;

import java.util.Scanner;


public class Player {
    public enum Color {
        BLACK,
        WHITE
    }
    public enum Direction {
        UP,
        DOWN
    }
    private final String name;
    private final Color color;
    private final Direction direction;
    public Player(Color color){
        System.out.println("New player: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        this.color = color;
        if(color == Color.WHITE){
            this.direction = Direction.DOWN;
        }
        else{
            this.direction = Direction.UP;
        }
        System.out.flush();
    }

    public void printName(){
        System.out.println("Player: " + this.name);
    }

    public Color getColor(){
        return this.color;
    }

    public Direction getDirection(){
        return direction;
    }
}
