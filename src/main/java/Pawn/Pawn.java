package Pawn;

import Game.Enum;

public class Pawn {

    private Enum.Color color;
    private Coordinates position;

    public Pawn(Enum.Color whiteOrBlack, int x, int y) {
        this.color = whiteOrBlack;
        this.position = new Coordinates(x, y);
    }

    public Enum.Color getColor() {
        return this.color;
    }

    public class Coordinates {
        private int x;
        private int y;

        public Coordinates(int coordX, int coordY) {
            this.x = coordX;
            this.y = coordY;
        }

        public int getX() {
            return this.x;
        }

        public void setX(int coordX) {
            this.x = coordX;
        }

        public int getY() {
            return this.y;
        }

        public void setY(int coordY) {
            this.y = coordY;
        }
    }

}
