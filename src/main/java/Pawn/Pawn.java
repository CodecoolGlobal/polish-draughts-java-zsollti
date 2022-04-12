package Pawn;



public class Pawn {
    private String color;
    private Coordinates position;

    public Pawn(String whiteOrBlack, int x, int y){
        color = whiteOrBlack;
        position = new Coordinates(x, y);
    }
    public String getColor(){
        return this.color;
    }

public class Coordinates{
        private int x;
        private int y;
        public Coordinates (int coordX, int coordY){
            this.x = coordX;
            this.y = coordY;
        }
        public int getX(){
            return this.x;
        }
        public void setX(int coordX){
            this.x = coordX;
        }
    public int getY(){
        return this.y;
    }
    public void setY(int coordY){
        this.y = coordY;
    }
}

}
