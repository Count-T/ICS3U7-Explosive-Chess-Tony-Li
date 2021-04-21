import javax.swing.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class WhiteBishop extends ChessPiece{
    //Making a Bishop at the start
    private ImageIcon whiteBishop = new ImageIcon("PieceImages/whiteBishop.png");
    private ImageIcon whiteTargetBishop = new ImageIcon("PieceImageTarget/whiteBishop.png");
    public WhiteBishop(){
        white();
        this.type = "whiteBishop";
    }
    //Making a bishop when the pawn reaches the end

    @Override
    public void myMove() {
        System.out.println("White bishop selected");
        int counter = 0;
        for(int i = 0; i <= 7; i++) { //First part of right diagonal
            Integer[] move = { this.getRow() - counter, this.getCol() + counter};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
                counter ++;
                continue; //IF THE TILE BEING CHECKED IS ITSELF
            }
            if(move[0] >= 0 && move[0] <= 7 && move[1] >= 0 && move[1] <= 7){
                if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.black && Board.selectedTiles[0].piece.white){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.white && Board.selectedTiles[0].piece.black){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null){ //Your own piece is blocking
                    break;
                }
            }
            counter ++;
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        counter = 0;
        for(int i = 0; i <= 7; i++) { //Second part of right diagonal
            Integer[] move = { this.getRow() + counter, this.getCol() - counter};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
                counter ++;
                continue; //IF THE TILE BEING CHECKED IS ITSELF
            }
            if(move[0] >= 0 && move[0] <= 7 && move[1] >= 0 && move[1] <= 7){
                if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.black && Board.selectedTiles[0].piece.white){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.white && Board.selectedTiles[0].piece.black){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null){ //Your own piece is blocking
                    break;
                }
            }
            counter ++;
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        counter = 0;
        for(int i = 0; i <= 7; i++) { //Second part of right diagonal
            Integer[] move = { this.getRow() + counter, this.getCol() + counter};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
                counter ++;
                continue; //IF THE TILE BEING CHECKED IS ITSELF
            }
            if(move[0] >= 0 && move[0] <= 7 && move[1] >= 0 && move[1] <= 7){
                if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.black && Board.selectedTiles[0].piece.white){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.white && Board.selectedTiles[0].piece.black){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null){ //Your own piece is blocking
                    break;
                }
            }
            counter ++;
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        counter = 0;
        for(int i = 0; i <= 7; i++) { //Second part of right diagonal
            Integer[] move = { this.getRow() - counter, this.getCol() - counter};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
                counter ++;
                continue; //IF THE TILE BEING CHECKED IS ITSELF
            }
            if(move[0] >= 0 && move[0] <= 7 && move[1] >= 0 && move[1] <= 7){
                if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.black && Board.selectedTiles[0].piece.white){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null && Board.btn[move[0]][move[1]].piece.white && Board.selectedTiles[0].piece.black){ //If the piece is blocking then only add the enemy piece and stop
                    Board.highlightedPossibleMoves.add(move); //Add the move
                    break;
                }
                else if(Board.btn[move[0]][move[1]].piece != null){ //Your own piece is blocking
                    break;
                }
            }
            counter ++;
            Board.highlightedPossibleMoves.add(move); //Add the move
        }

        Board.highlightedPossibleMoves = ChessPiece.legalMove(Board.highlightedPossibleMoves); //Filter the legal moves and set them to the possible moves
    }
    public ImageIcon getImg(){
        return whiteBishop;
    }

    @Override
    public ImageIcon getTargetImg() {
        return whiteTargetBishop;
    }
}
