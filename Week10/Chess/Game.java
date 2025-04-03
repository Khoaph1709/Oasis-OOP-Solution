import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<Move>();
    }

    /**
     * .
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move;
            Piece newPiece = board.getAt(x, y);
            if (newPiece != null) {
                move = new Move(piece.getCoordinatesX(), x, 
                piece.getCoordinatesY(), y, piece, newPiece);
                board.removeAt(x, y);
            } else {
                move = new Move(piece.getCoordinatesX(), x, 
                piece.getCoordinatesY(), y, piece);
                board.removeAt(x, y);
            }
            moveHistory.add(move);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
