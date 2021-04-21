import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class Tile extends JButton implements ActionListener {
    private int row;
    private int col;
    private boolean isMovable;
    ChessPiece piece;
    private File file;
    private Clip myClip;
    public Tile(int row, int col) throws IOException, UnsupportedAudioFileException, LineUnavailableException { //Error handling
        super();
        this.row = row;
        this.col = col;
        this.addActionListener(this);
    }
    public void checkMarking(){ //If it is marked as a movable square then it will paint itself green
        if(this.isMovable && this.piece != null){ //The enemy piece is killable
            this.setIcon(this.piece.getTargetImg()); //Sets the red outline
        }
        else if(this.isMovable){
            this.setIcon(Board.greenDot); //If it is marked as a possible move then paint green
        }
        else if(this.getIsMovable() == false){ //Not movable
            if(this.piece == null){
                this.setIcon(null); //If it is not marked then revert itself back
            }
            else if(this.piece != null){
                //Keep the icon as it is
                this.setIcon(this.piece.getImg());
            }
        }
    }
    public void removePiece(){
        this.isMovable = false;
        this.piece = null;
        this.setIcon(null);
    }
    public boolean getIsMovable(){
        return isMovable;
    }
    public void setIsMovable(boolean isMovable){
        this.isMovable = isMovable;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public static boolean canExplode(int row, int col){
        return ((row >= 0 && row <=7) && (col >= 0 && col <=7));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //CASTLING
        if(Board.selectedTiles[0] != null && Board.selectedTiles[0].piece != null && Board.selectedTiles[0].piece.type.equals("whiteKing") && Board.selectedTiles[0].getRow() == 7 && Board.selectedTiles[0].getCol() ==4 && this.piece != null && this.piece.type.equals("whiteRook")){
            //White Left Side castle
            if(this.getRow() == 7 && this.getCol() == 0 && Board.btn[7][1].piece == null && Board.btn[7][2].piece == null && Board.btn[7][3].piece == null){
                Board.btn[7][2].addPiece(new WhiteKing());
                Board.btn[7][3].addPiece(new WhiteRook());
                Board.btn[this.getRow()][this.getCol()].removePiece();
                Board.btn[Board.selectedTiles[0].getRow()][Board.selectedTiles[0].getCol()].removePiece();
                this.removePiece();
                Board.whitesTurn = false;
                Board.selectedTiles[0] = null;
                this.piece = null;
                Board.highlightedPossibleMoves.clear();
                Board.clearMovables();
            }
            //White Right Side Castle
            if(this.getRow() == 7 && this.getCol() == 7 && Board.btn[7][6].piece == null && Board.btn[7][5].piece == null){
                Board.btn[7][6].addPiece(new WhiteKing());
                Board.btn[7][5].addPiece(new WhiteRook());
                Board.btn[this.getRow()][this.getCol()].removePiece();
                Board.btn[Board.selectedTiles[0].getRow()][Board.selectedTiles[0].getCol()].removePiece();
                this.removePiece();
                Board.whitesTurn = false;
                Board.selectedTiles[0] = null;
                this.piece = null;
                Board.highlightedPossibleMoves.clear();
                Board.clearMovables();
            }
        }
        if(Board.selectedTiles[0] != null && Board.selectedTiles[0].piece != null && Board.selectedTiles[0].piece.type.equals("blackKing") && Board.selectedTiles[0].getRow() == 0 && Board.selectedTiles[0].getCol() ==4 && this.piece != null && this.piece.type.equals("blackRook")){
            //Black Left Side castle
            if(this.getRow() == 0 && this.getCol() == 0 && Board.btn[0][1].piece == null && Board.btn[0][2].piece == null && Board.btn[0][3].piece == null){
                Board.btn[0][2].addPiece(new BlackKing());
                Board.btn[0][3].addPiece(new BlackRook());
                Board.btn[this.getRow()][this.getCol()].removePiece();
                Board.btn[Board.selectedTiles[0].getRow()][Board.selectedTiles[0].getCol()].removePiece();
                this.removePiece();
                Board.whitesTurn = true;
                Board.selectedTiles[0] = null;
                this.piece = null;
                Board.highlightedPossibleMoves.clear();
                Board.clearMovables();
            }
            //Black Right Side castle
            if(this.getRow() == 0 && this.getCol() == 7 && Board.btn[0][6].piece == null && Board.btn[0][5].piece == null){
                Board.btn[0][6].addPiece(new BlackKing());
                Board.btn[0][5].addPiece(new BlackRook());
                Board.btn[this.getRow()][this.getCol()].removePiece();
                Board.btn[Board.selectedTiles[0].getRow()][Board.selectedTiles[0].getCol()].removePiece();
                this.removePiece();
                Board.whitesTurn = true;
                Board.selectedTiles[0] = null;
                this.piece = null;
                Board.highlightedPossibleMoves.clear();
                Board.clearMovables();
            }
        }
        if(this.isMovable && Board.selectedTiles[0] != null){
            //If a piece is selected and
            //This tile is clicked and it is movable
            //Perform move
            file = new File("explosion.wav");
            AudioInputStream audioStream = null;
            try {
                audioStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                myClip = AudioSystem.getClip();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
            try {
                myClip.open(audioStream);
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if(this.piece != null && Board.whitesTurn){ //If a black piece is captured store it
                //EXPLOSIONS WORK ON THIS LATER
                /*
                if(this.getRow() -1 >= 0 && this.getCol() -1 >=0 && !Board.btn[this.getRow() -1][this.getCol() -1].piece.isPawn){ //If the top corner is available and not pawn then explode
                    Board.btn[this.getRow() -1][this.getCol() -1].removePiece();
                }

                 */
                myClip.start(); //Play explosion sound effect
                Board.blackPiecesCaptured.add(this.piece);
            }
            if(this.piece != null && !Board.whitesTurn){ //If a white piece is captured store it
                System.out.println("CAPTURED");
                myClip.start(); //Play explosion sound effect
                Board.whitePiecesCaptured.add(this.piece);
                for(ChessPiece x : Board.whitePiecesCaptured){
                    System.out.println(x);
                }
            }
            boolean pieceCaptured = false;
            if(this.piece != null){ //If a piece is captured then the original piece explodes too
                pieceCaptured = true;
            }
            this.addPiece(Board.selectedTiles[0].piece);
            if(pieceCaptured){
                //EXPLOSION
                int i, j;
                //Top Left Corner
                i = this.getRow() -1;
                j = this.getCol() -1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //One up
                i = this.getRow() -1;
                j = this.getCol();
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //Top right corner
                i = this.getRow() -1;
                j = this.getCol() +1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //One right
                i = this.getRow();
                j = this.getCol() + 1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //Bottom right corner
                i = this.getRow()+1;
                j = this.getCol() + 1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //One down
                i = this.getRow()+1;
                j = this.getCol();
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //Bottom left
                i = this.getRow()+1;
                j = this.getCol()-1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                //One left
                i = this.getRow();
                j = this.getCol()-1;
                if(canExplode(i,j) && Board.btn[i][j].piece!=null && !Board.btn[i][j].piece.isPawn){
                    if(Board.whitesTurn){
                        Board.blackPiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    else{
                        Board.whitePiecesCaptured.add(Board.btn[i][j].piece);
                    }
                    if(Board.btn[i][j].piece.type.equals("whiteKing")){
                        MyFrame.cardsL.show(MyFrame.c, "BlackWins");
                    }
                    else if(Board.btn[i][j].piece.type.equals("blackKing")){
                        MyFrame.cardsL.show(MyFrame.c, "WhiteWins");
                    }
                    Board.btn[i][j].removePiece();
                }

                if(Board.whitesTurn){
                    Board.whitePiecesCaptured.add(Board.selectedTiles[0].piece); //Add the dead original piece to the grave
                    if(Board.selectedTiles[0].piece != null && Board.selectedTiles[0].piece.type.equals("blackKing")){
                        //Switch to white player wins panel
                        MyFrame.cardsL.show(MyFrame.c,"WhiteWins" );
                    }
                    else if(Board.selectedTiles[0].piece != null && Board.selectedTiles[0].piece.type.equals("whiteKing")){
                        //Switch to black player wins panel
                        MyFrame.cardsL.show(MyFrame.c,"BlackWins" );
                    }
                }
                else{
                    Board.blackPiecesCaptured.add(Board.selectedTiles[0].piece); //Add the dead original piece to the grave
                }
                this.removePiece();
                pieceCaptured = false;
                //Print Check Test
                System.out.println("WHITE PIECES CAPTURED");
                for(int k = 0; k < Board.whitePiecesCaptured.size();k++){
                    System.out.println("Piece: " + Board.whitePiecesCaptured.get(k));
                    if(Board.whitePiecesCaptured.get(k)!= null && Board.whitePiecesCaptured.get(k).type.equals("whiteKing")){ //If white king is captured
                        //Switch to black player wins panel
                        MyFrame.cardsL.show(MyFrame.c,"BlackWins" );
                    }
                }
                System.out.println("BLACK PIECES CAPTURED");
                for(int k = 0; k < Board.blackPiecesCaptured.size();k++){
                    System.out.println("Piece: " + Board.blackPiecesCaptured.get(k));
                    if(Board.blackPiecesCaptured.get(k)!= null && Board.blackPiecesCaptured.get(k).type.equals("blackKing")){ //If black king is captured
                        //Switch to white player wins panel
                        MyFrame.cardsL.show(MyFrame.c,"WhiteWins" );
                    }
                }
            }
            Board.selectedTiles[0].removePiece();
            Board.selectedTiles[0] = null;
            Board.clearMovables();
            Board.highlightedPossibleMoves.clear();
            if(Board.whitesTurn){ //White or black turn
                Board.whitesTurn = false;
            }
            else{
                Board.whitesTurn = true;
            }
            Chess_Panel.myLeftPanel.checkTimer();
            Chess_Panel.myRightPanel.checkTimer();
            //Reset
        }
        if(this.piece == null){ //Empty Tile
            /*
            System.out.println("Row " + this.getRow() + " Col " + this.getCol() );
            System.out.println("Icon" + this.getIcon());
            System.out.println("Movable:" + this.isMovable);
            System.out.println("Piece " + this.piece);
            System.out.println("Current Selected Piece: " + Board.selectedTiles[0].piece + "at coordinate row: " + Board.selectedTiles[0].piece.getRow() + " column: " + Board.selectedTiles[0].piece.getCol());
            System.out.println("Piece to move to: " + Board.selectedTiles[1].piece + "at coordinate row: " + Board.selectedTiles[1].piece.getRow() + " column: " + Board.selectedTiles[1].piece.getCol());
            System.out.println();
             */

        }
        else{ //There is a piece on the tile clicked then store it as the current selected piece when clicked
            if((this.piece.white && Board.whitesTurn) || (this.piece.black && Board.whitesTurn == false)){ //If the piece matches the turn
                Board.highlightedPossibleMoves.clear(); //Clears the moves for the new piece
                //System.out.println("test ");
                Board.selectedTiles[0] = this; //Adds the current tile to the selected tile
                Board.selectedTiles[0].piece.myMove();
                //System.out.println(Board.selectedTiles[0]);
                Board.clearMovables();
            }
            /*
            System.out.println("Row " + this.piece.getRow() + " Col " + this.piece.getCol() );
            System.out.println(this.getIcon());
            System.out.println(this.piece);
            System.out.println("Black: " + this.piece.black);
            System.out.println("White: " + this.piece.white);
            System.out.println("Is movable" + isMovable);
            System.out.println("Piece: " + this.piece);
            if(Board.selectedTiles[0] == null){ //No piece set yet
                Board.selectedTiles[0] = this;
                this.piece.myMove();
            }
            else if(Board.selectedTiles[0] != this){
                Board.highlightedPossibleMoves.clear(); //Clear the old possible moves
                Board.selectedTiles[0] = this;
                this.piece.myMove();
                Board.newPieceSelected = true;
            }
            if(Board.selectedTiles[0] != null){
                System.out.println("Current Selected Piece: " + Board.selectedTiles[0].piece + "at coordinate row: " + Board.selectedTiles[0].piece.getRow() + " column: " + Board.selectedTiles[0].piece.getCol());
            }
            if(Board.selectedTiles[1] != null){
                System.out.println("Piece to move to: " + Board.selectedTiles[1].piece + "at coordinate row: " + Board.selectedTiles[1].piece.getRow() + " column: " + Board.selectedTiles[1].piece.getCol());
            }
            System.out.println();
             */
        }
        if(Board.selectedTiles[0] != null){ //If a piece is already selected then add the piece that the user wants to move to
            Board.selectedTiles[1] = this;
        }
    }
    public void setIcon(){
        System.out.println("hi");
    }
    //Add a piece to the tile and set its row and col
    public void addPiece(ChessPiece piece){
        this.isMovable = false;
        this.piece = piece;
        this.piece.setCol(this.col);
        this.piece.setRow(this.row);
        ImageIcon pieceImage = this.piece.getImg();
        //Image newImg = pieceImage.getImage().getScaledInstance(93, 93, java.awt.Image.SCALE_SMOOTH);
        //pieceImage = new ImageIcon(newImg);
        this.setIcon(pieceImage);
    }
}
