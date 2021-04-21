import javax.swing.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class WhiteKing extends ChessPiece{
    //Making a Bishop at the start
    private ImageIcon whiteKing = new ImageIcon("PieceImages/whiteKing.png");
    private ImageIcon whiteTargetKing = new ImageIcon("PieceImageTarget/whiteKing.png");
    public WhiteKing(){
        white();
        this.isKing = true;
        this.type = "whiteKing";
    }

    @Override
    public void myMove() {
        //8 Moves
        //Move 1
        Integer[] moveOne = {this.getRow(), this.getCol()-1};
        Board.highlightedPossibleMoves.add(moveOne); //Add the move
        //Move 2
        Integer[] moveTwo = {this.getRow(), this.getCol()+1};
        Board.highlightedPossibleMoves.add(moveTwo); //Add the move
        //Move 3
        Integer[] moveThree = {this.getRow() + 1, this.getCol()};
        Board.highlightedPossibleMoves.add(moveThree); //Add the move
        //Move 4
        Integer[] moveFour = {this.getRow() - 1, this.getCol()};
        Board.highlightedPossibleMoves.add(moveFour); //Add the move
        //Move 5
        Integer[] moveFive = {this.getRow() - 1, this.getCol()-1};
        Board.highlightedPossibleMoves.add(moveFive); //Add the move
        //Move 6
        Integer[] moveSix = {this.getRow() - 1, this.getCol()+1};
        Board.highlightedPossibleMoves.add(moveSix); //Add the move
        //Move 7
        Integer[] moveSeven = {this.getRow() + 1, this.getCol()+1};
        Board.highlightedPossibleMoves.add(moveSeven); //Add the move
        //Move 8
        Integer[] moveEight = {this.getRow() + 1, this.getCol()-1};
        Board.highlightedPossibleMoves.add(moveEight); //Add the move
        Board.highlightedPossibleMoves = ChessPiece.legalMove(Board.highlightedPossibleMoves); //Filter the legal moves and set them to the possible moves
    }
    public ImageIcon getImg(){
        return whiteKing;
    }

    @Override
    public ImageIcon getTargetImg() {
        return this.whiteTargetKing;
    }
}
