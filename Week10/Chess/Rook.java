public class Rook extends Piece  {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String c) {
        super(x, y, c);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int newX, int newY) {
        // Kiểm tra di chuyển thẳng ngang hoặc dọc
        if (newX != this.getCoordinatesX() && newY != this.getCoordinatesY()) {
            return false;
        }
        
        // Kiểm tra không di chuyển tại chỗ
        if (newX == this.getCoordinatesX() && newY == this.getCoordinatesY()) {
            return false;
        }
        
        // Kiểm tra đường đi không bị chặn
        int stepX = Integer.compare(newX, this.getCoordinatesX());
        int stepY = Integer.compare(newY, this.getCoordinatesY());
        
        int currentX = this.getCoordinatesX() + stepX;
        int currentY = this.getCoordinatesY() + stepY;
        
        while (currentX != newX || currentY != newY) {
            Piece piece = board.getAt(currentX, currentY);
            if (piece != null) {
                return false;
            }
            currentX += stepX;
            currentY += stepY;
        }
        
        // Kiểm tra ô đích
        Piece destinationPiece = board.getAt(newX, newY);
        if (destinationPiece != null && destinationPiece.getColor().equals(this.getColor())) {
            return false;
        }
        
        return true;
    }
}
