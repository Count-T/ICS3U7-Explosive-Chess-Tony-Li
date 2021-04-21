import javax.swing.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class BlackPawn extends ChessPiece{
    //Making a Knight at the start
    private ImageIcon blackPawn = new ImageIcon("PieceImages/blackPawn.png");
    private ImageIcon blackTargetPawn = new ImageIcon("PieceImageTarget/blackPawn.png");
    public BlackPawn(){
        black();
        this.isPawn = true; //To check if it a pawn so it won't explode
        this.type ="blackPawn";
    }

    @Override
    public void myMove() {
        //Add the double up move, only on the pawn's first move
        if(this.getRow() + 1 <= 7 && Board.btn[this.getRow() +1][this.getCol()].piece != null){ //If there is a piece blocking
            //dont add moves
        }
        else{
            if(this.getRow() == 1){
                Integer[] doubleUpMove = {this.getRow()+2,this.getCol()};
                if(this.getRow() + 2 <=7 && Board.btn[this.getRow()+2][this.getCol()].piece != null){ //If there is a piece blocking two spaces up
                    //Dont do anything
                }
                else{
                    Board.highlightedPossibleMoves.add(doubleUpMove); //Add the move
                }
            }
            //Add the move up one rule
            if(this.getRow()-1 >= 0){
                Integer[] moveOneUp = {this.getRow() + 1, this.getCol()};
                Board.highlightedPossibleMoves.add(moveOneUp);//Add the move
            }
        }
        //Left attack
        if(this.getCol() - 1 >= 0 && this.getRow()+1 <= 7 && Board.btn[this.getRow() + 1][this.getCol() - 1].piece != null && Board.btn[this.getRow() + 1][this.getCol() - 1].piece.white ){
            Integer[] attackLeft = {this.getRow()+1, this.getCol() - 1};
            Board.highlightedPossibleMoves.add(attackLeft);//Add the move
        }
        //Right attack
        if(this.getCol() + 1 <= 7 && this.getRow()+1 <= 7 && Board.btn[this.getRow() + 1][this.getCol() + 1].piece != null && Board.btn[this.getRow() + 1][this.getCol() + 1].piece.white){
            Integer[] rightAttack = {this.getRow()+1, this.getCol() + 1};
            Board.highlightedPossibleMoves.add(rightAttack);//Add the move
        }
        Board.highlightedPossibleMoves = ChessPiece.legalMove(Board.highlightedPossibleMoves); //Filter the legal moves and set them to the possible moves
    }

    @Override
    public ImageIcon getTargetImg() {
        return this.blackTargetPawn;
    }

    public ImageIcon getImg(){
        return blackPawn;
    }
}
