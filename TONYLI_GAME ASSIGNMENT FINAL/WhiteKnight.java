import javax.swing.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class WhiteKnight extends ChessPiece {
    //Making a knight at the start
    private ImageIcon whiteKnight = new ImageIcon("PieceImages/whiteKnight.png");
    private ImageIcon whiteTargetKnight = new ImageIcon("PieceImageTarget/whiteKnight.png");

    public WhiteKnight() {
        white();
        this.type = "whiteKnight";
    }
    //Making a knight when the pawn reaches the end

    @Override
    public void myMove() {
        //8 Moves
        //Move 1
        Integer[] moveOne = {this.getRow() - 2, this.getCol()-1};
        Board.highlightedPossibleMoves.add(moveOne); //Add the move
        //Move 2
        Integer[] moveTwo = {this.getRow() - 2, this.getCol()+1};
        Board.highlightedPossibleMoves.add(moveTwo); //Add the move
        //Move 3
        Integer[] moveThree = {this.getRow() + 2, this.getCol()-1};
        Board.highlightedPossibleMoves.add(moveThree); //Add the move
        //Move 4
        Integer[] moveFour = {this.getRow() + 2, this.getCol()+1};
        Board.highlightedPossibleMoves.add(moveFour); //Add the move
        //Move 5
        Integer[] moveFive = {this.getRow() - 1, this.getCol()-2};
        Board.highlightedPossibleMoves.add(moveFive); //Add the move
        //Move 6
        Integer[] moveSix = {this.getRow() + 1, this.getCol()-2};
        Board.highlightedPossibleMoves.add(moveSix); //Add the move
        //Move 7
        Integer[] moveSeven = {this.getRow() - 1, this.getCol()+2};
        Board.highlightedPossibleMoves.add(moveSeven); //Add the move
        //Move 8
        Integer[] moveEight = {this.getRow() + 1, this.getCol()+2};
        Board.highlightedPossibleMoves.add(moveEight); //Add the move

        Board.highlightedPossibleMoves = ChessPiece.legalMove(Board.highlightedPossibleMoves); //Filter the legal moves and set them to the possible moves
    }

    public ImageIcon getImg() {
        return whiteKnight;
    }

    @Override
    public ImageIcon getTargetImg() {
        return this.whiteTargetKnight;
    }
}
