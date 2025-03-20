public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;
    
    public Piece(int x, int y, String c) {
        coordinatesX = x;
        coordinatesY = y;

        if (!c.equals("white") && !c.equals("black")) {
            throw new IllegalArgumentException("Invalid color");
        }
        color = c;
    }

    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
        color = "white";
    }

    abstract String getSymbol();

    abstract boolean canMove(int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int x) {
        coordinatesX = x;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int y) {
        coordinatesY = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color = c;
    }

    public boolean checkPosition(Piece p) {
        if (p.getCoordinatesX() == getCoordinatesX() && p.getCoordinatesY() == getCoordinatesY()) {
            return true;
        }
        return false;
    }
}

class SuKhoa {
    public static void main(String[] args) {
        int x, y=15,z=3;
        x=(y--)/(z++);
        System.out.println(x);
    }
}