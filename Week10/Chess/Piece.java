abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
        color = "white";
    }

    public Piece(int x, int y, String c) {
        coordinatesX = x;
        coordinatesY = y;
        if (!c.equals("white") && !c.equals("black")) {
            throw new IllegalArgumentException("Color must be either 'white' or 'black'");
        }
        color = c;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int newX, int newY);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.equals("white") && !color.equals("black")) {
            throw new IllegalArgumentException("Color must be either 'white' or 'black'");
        }
        this.color = color;
    }

    public boolean checkPosition(Piece p) {
        if (this.equals(p)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            Piece p = (Piece) obj;
            if (p.getCoordinatesX() == coordinatesX && p.getCoordinatesY() == coordinatesY) {
                return true;
            }
        }
        return false;
    }
}