package Player;

import java.util.Scanner;

public class Player {
    private final String name;

    public Player(){
        System.out.println("New player: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        System.out.flush();
    }

    public String getName(){
        return this.name;
    }
}
