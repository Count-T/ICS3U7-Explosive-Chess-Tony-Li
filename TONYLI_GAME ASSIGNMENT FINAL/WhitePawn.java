import javax.swing.*;
import java.util.ArrayList;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class WhitePawn extends ChessPiece {
    //Making a pawn at the start
    private ImageIcon whitePawn = new ImageIcon("PieceImages/whitePawn.png");
    private ImageIcon whiteTargetPawn = new ImageIcon("PieceImageTarget/whitePawn.png");
    public WhitePawn(){
        white();
        this.isPawn = true; //To check if it a pawn so it won't explode
        this.type = "whitePawn";
    }
    //Making a knight when the pawn reaches the end
    //Make an arrayList of possible moves

    @Override
    public void myMove() {
        //Add the double up move, only on the pawn's first move
        if(this.getRow() - 1 >= 0 && Board.btn[this.getRow() -1][this.getCol()].piece != null){ //If there is a piece blocking
            //dont do anything
        }
        else{
            if(this.getRow() == 6){
                Integer[] doubleUpMove = {this.getRow()-2,this.getCol()};
                if(this.getRow() - 2 >= 0 && Board.btn[this.getRow() - 2][this.getCol()].piece != null){ //if there is a piece blocking two spaces
                    //dont add anything
                }
                else{
                    Board.highlightedPossibleMoves.add(doubleUpMove); //Add the move
                }
            }
            //Add the move up one rule
            if(this.getRow()-1 >= 0){
                Integer[] moveOneUp = {this.getRow() - 1, this.getCol()};
                Board.highlightedPossibleMoves.add(moveOneUp);//Add the move
            }
        }
        //Left attack
        if(this.getCol() - 1 >= 0 && this.getRow()-1 >= 0 && Board.btn[this.getRow() - 1][this.getCol() - 1].piece != null && Board.btn[this.getRow() - 1][this.getCol() - 1].piece.black ){
            Integer[] attackLeft = {this.getRow()-1, this.getCol() - 1};
            Board.highlightedPossibleMoves.add(attackLeft);//Add the move
        }
        //Right attack
        if(this.getCol() + 1 <= 7 && this.getRow()+1 <= 7 && Board.btn[this.getRow() - 1][this.getCol() + 1].piece != null && Board.btn[this.getRow() - 1][this.getCol() + 1].piece.black){
            Integer[] rightAttack = {this.getRow()-1, this.getCol() + 1};
            Board.highlightedPossibleMoves.add(rightAttack);//Add the move
        }
        Board.highlightedPossibleMoves = ChessPiece.legalMove(Board.highlightedPossibleMoves); //Filter the legal moves and set them to the possible moves
    }
    public ImageIcon getImg(){
        return whitePawn;
    }

    @Override
    public ImageIcon getTargetImg() {
        return this.whiteTargetPawn;
    }
}
