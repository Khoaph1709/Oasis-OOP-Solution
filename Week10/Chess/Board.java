import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>();
    }
    
    /**
     * .
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY()) && !samePosition(piece)) {
            pieces.add(piece);
        }
    }

    /**
     * .
     */
    public boolean validate(int x, int y) {
        if (x <= 0 || x > WIDTH || y <= 0 || y > HEIGHT) {
            return false;
        }
        return true;
    }

    /** 
     *.
     */
    public boolean samePosition(Piece piece) {
        for (int i = 0; i < pieces.size(); i++) {
            if (piece.checkPosition(pieces.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * .
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    /**
     * .
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
        
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
