import javax.swing.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class WhiteQueen extends ChessPiece{
    //Making a Bishop at the start
    private ImageIcon whiteQueen = new ImageIcon("PieceImages/whiteQueen.png");
    private ImageIcon whiteTargetQueen = new ImageIcon("PieceImageTarget/whiteQueen.png");
    public WhiteQueen(){
        white();
        this.type = "whiteQueen";
    }

    @Override
    public void myMove() {

        for(int i = this.getRow(); i >= 0; i--){ //First part of the vertical
            Integer[] move = {i, this.getCol()};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
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
            System.out.println(i);
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        for(int i = this.getRow(); i <= 7; i++) { //Second part of the vertical
            Integer[] move = {i, this.getCol()};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
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
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        for(int i = this.getCol(); i >= 0; i--){
            Integer[] move = {this.getRow(), i};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
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
            Board.highlightedPossibleMoves.add(move); //Add the move
        }
        for(int i = this.getCol(); i <=7; i++){
            Integer[] move = {this.getRow(), i};
            if(move[0] == this.getRow() && move[1] == this.getCol()){
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
            Board.highlightedPossibleMoves.add(move); //Add the move
        }

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
        return whiteQueen;
    }

    @Override
    public ImageIcon getTargetImg() {
        return this.whiteTargetQueen;
    }
}
