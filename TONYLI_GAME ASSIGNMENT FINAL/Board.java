
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Board extends JPanel implements ActionListener{
    //Images
    //CREATE A TIMER LATER
    public static Tile[] selectedTiles = new Tile[2]; //Stores a tile array [tileSelected, tileToMoveTo]
    public double secondsCounter = 0.0;
    public static Timer timer;
    public static HashSet<Integer[]> highlightedPossibleMoves = new HashSet<Integer[]>(); //Create a set of coordinates
    private static ImageIcon greenDotImage = new ImageIcon("greendot.png"); //DELETE THIS LATER
    public static Image smallerGreenDot = greenDotImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    public static ImageIcon greenDot = new ImageIcon(smallerGreenDot);
    public static Tile btn[][];     //declare array of buttons
    public static boolean explosiveChessMode = true;
    public static boolean firstTurn = true;
    public static boolean whitesTurn = true;
    public static boolean newPieceSelected = false;
    public static ArrayList<ChessPiece> whitePiecesCaptured = new ArrayList<ChessPiece>();
    public static ArrayList<ChessPiece> blackPiecesCaptured = new ArrayList<ChessPiece>();
    //METHODS
    public Tile[][] returnBoard(){
        return btn;
    }

    public static void transformPawns(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(Board.btn[i][j].piece != null && Board.btn[i][j].piece.type.equals("whitePawn") && Board.btn[i][j].getRow() == 0){
                    Board.btn[i][j].removePiece();
                    Board.btn[i][j].addPiece(new WhiteQueen()); //CHANGES A WHITE PAWN TO QUEEN WHEN IT REACHES THE END
                }
                if(Board.btn[i][j].piece != null && Board.btn[i][j].piece.type.equals("blackPawn") && Board.btn[i][j].getRow() == 7){
                    Board.btn[i][j].removePiece();
                    Board.btn[i][j].addPiece(new BlackQueen()); //CHANGES A BLACK PAWN TO QUEEN WHEN IT REACHES THE END
                }
            }
        }
    }
    public static void clearMovables(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                btn[i][j].setIsMovable(false); //Changes all the pieces to not movable
                btn[i][j].checkMarking(); //reverts the changed
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){ //Timer
            LeftPanel.checkTimer();
            RightPanel.checkTimer();
            TopPanel.checkTurn();
            transformPawns();
            //System.out.println("Is white's turn: " + whitesTurn);
            secondsCounter += 0.1;
            if(selectedTiles[0] != null){
                //System.out.println("Current Piece " + selectedTiles[0].piece);
            }
            if(selectedTiles[1] != null){

               //System.out.println("Current Piece to move to " + selectedTiles[1].piece);
            }
            if(selectedTiles[0] != null){
                Board.highlightPossibleMoves(Board.highlightedPossibleMoves);
                //System.out.println("Tile[0], the selected tile" + selectedTiles[0].piece);
                //System.out.println("Tile[1], the selected tile to move to" + selectedTiles[1].piece);
            }

            for(Integer[] coordinate : highlightedPossibleMoves){
               //System.out.println("Possible move, " + coordinate[0] + "," + coordinate[1]);
            }
            //Set tiles to MOVEABLE
            Board.setTilesToMovable();
            //System.out.println(selectedPiece);
           // System.out.println(pieceSelected);
        }
    }
    public static void highlightPossibleMoves(Set<Integer[]> possibleMoves){
        //Loop over the current possible moves and then set their isMovable value to true
    }
    public static void setTilesToMovable(){
        outerloop:
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Integer[] current = {i,j};
                for(Integer[] coordinate : highlightedPossibleMoves){
                    if(current[0] == coordinate[0] && current[1] == coordinate[1]){
                        //Checks the board and marks the possible moves but only if its not its own side's piece
                        btn[i][j].setIsMovable(true);
                        btn[i][j].checkMarking();
                    }
                    else if(Board.newPieceSelected){ //When a new piece is selected then revert the greendots
                        break outerloop;
                    }
                }
            }
        }
        if(Board.newPieceSelected == true){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    btn[i][j].setIsMovable(false); //Makes sure the piece is not able to be moved on and reverts the green dots
                    btn[i][j].checkMarking();
                }
            }
            Board.newPieceSelected = false;
        }
    }
    public Board() throws UnsupportedAudioFileException, IOException, LineUnavailableException {    // constructor
        timer = new Timer(1, this); //Set to 1000 temporarily
        PlayerWhite whitePlayer = new PlayerWhite(); //Initialize the white player
        PlayerBlack blackPlayer = new PlayerBlack(); //Initialize the black player
        btn = new Tile[8][8];
        this.setLayout(new GridLayout(btn.length, btn[0].length));// 8 rows 8 columns using grid layout
        this.setPreferredSize(new Dimension(700,700));
        for (int i = 0; i < btn.length; i++){
            for (int j = 0; j < btn[0].length; j++) {
                btn[i][j]= new Tile(i , j);
                if (i % 2 == 0 && j % 2 == 1) {
                    btn[i][j].setBackground(Color.DARK_GRAY); //Setting alternate color to black
                }
                else if (i % 2 == 1 && j % 2 == 0){
                    btn[i][j].setBackground(Color.DARK_GRAY);
                }
                //Add the pieces
                this.add(btn[i][j]);
                btn[i][j].addActionListener(this);
            }
        }

        //Create pieces
        //WHITE SIDE
        //WHITE PAWNS
        WhitePawn whitePawn1 = new WhitePawn(); whitePawn1.setRow(6); whitePawn1.setCol(0); btn[whitePawn1.getRow()][whitePawn1.getCol()].addPiece(whitePawn1);
        WhitePawn whitePawn2 = new WhitePawn(); whitePawn2.setRow(6); whitePawn2.setCol(1); btn[whitePawn2.getRow()][whitePawn2.getCol()].addPiece(whitePawn2);
        WhitePawn whitePawn3 = new WhitePawn(); whitePawn3.setRow(6); whitePawn3.setCol(2); btn[whitePawn3.getRow()][whitePawn3.getCol()].addPiece(whitePawn3);
        WhitePawn whitePawn4 = new WhitePawn(); whitePawn4.setRow(6); whitePawn4.setCol(3); btn[whitePawn4.getRow()][whitePawn4.getCol()].addPiece(whitePawn4);
        WhitePawn whitePawn5 = new WhitePawn(); whitePawn5.setRow(6); whitePawn5.setCol(4); btn[whitePawn5.getRow()][whitePawn5.getCol()].addPiece(whitePawn5);
        WhitePawn whitePawn6 = new WhitePawn(); whitePawn6.setRow(6); whitePawn6.setCol(5); btn[whitePawn6.getRow()][whitePawn6.getCol()].addPiece(whitePawn6);
        WhitePawn whitePawn7 = new WhitePawn(); whitePawn7.setRow(6); whitePawn7.setCol(6); btn[whitePawn7.getRow()][whitePawn7.getCol()].addPiece(whitePawn7);
        WhitePawn whitePawn8 = new WhitePawn(); whitePawn8.setRow(6); whitePawn8.setCol(7);  btn[whitePawn8.getRow()][whitePawn8.getCol()].addPiece(whitePawn8);

        //WHITE KNIGHTS
        WhiteKnight whiteKnight1 = new WhiteKnight(); whiteKnight1.setRow(7); whiteKnight1.setCol(1);btn[whiteKnight1.getRow()][whiteKnight1.getCol()].addPiece(whiteKnight1);
        WhiteKnight whiteKnight2 = new WhiteKnight(); whiteKnight2.setRow(7); whiteKnight2.setCol(6);btn[whiteKnight2.getRow()][whiteKnight2.getCol()].addPiece(whiteKnight2);

        //WHITE ROOKS
        WhiteRook whiteRook1 = new WhiteRook(); whiteRook1.setRow(7); whiteRook1.setCol(0); btn[whiteRook1.getRow()][whiteRook1.getCol()].addPiece(whiteRook1);
        WhiteRook whiteRook2 = new WhiteRook(); whiteRook2.setRow(7); whiteRook2.setCol(7); btn[whiteRook2.getRow()][whiteRook2.getCol()].addPiece(whiteRook2);

        //WHITE BISHOPS
        WhiteBishop whiteBishop1 = new WhiteBishop(); whiteBishop1.setRow(7); whiteBishop1.setCol(2); btn[whiteBishop1.getRow()][whiteBishop1.getCol()].addPiece(whiteBishop1);
        WhiteBishop whiteBishop2 = new WhiteBishop(); whiteBishop2.setRow(7); whiteBishop2.setCol(5); btn[whiteBishop2.getRow()][whiteBishop2.getCol()].addPiece(whiteBishop2);

        //WHITE QUEEN AND KING
        WhiteQueen whiteQueen = new WhiteQueen(); whiteQueen.setRow(7); whiteQueen.setCol(3); btn[whiteQueen.getRow()][whiteQueen.getCol()].addPiece(whiteQueen);
        WhiteKing whiteKing = new WhiteKing(); whiteKing.setRow(7); whiteKing.setCol(4); btn[whiteKing.getRow()][whiteKing.getCol()].addPiece(whiteKing);

        //BLACK SIDE
        //BLACK PAWNS
        BlackPawn blackPawn1 = new BlackPawn(); blackPawn1.setRow(1); blackPawn1.setCol(0);btn[blackPawn1.getRow()][blackPawn1.getCol()].addPiece(blackPawn1);
        BlackPawn blackPawn2 = new BlackPawn(); blackPawn2.setRow(1); blackPawn2.setCol(1);btn[blackPawn2.getRow()][blackPawn2.getCol()].addPiece(blackPawn2);
        BlackPawn blackPawn3 = new BlackPawn(); blackPawn3.setRow(1); blackPawn3.setCol(2);btn[blackPawn3.getRow()][blackPawn3.getCol()].addPiece(blackPawn3);
        BlackPawn blackPawn4 = new BlackPawn(); blackPawn4.setRow(1); blackPawn4.setCol(3);btn[blackPawn4.getRow()][blackPawn4.getCol()].addPiece(blackPawn4);
        BlackPawn blackPawn5 = new BlackPawn(); blackPawn5.setRow(1); blackPawn5.setCol(4);btn[blackPawn5.getRow()][blackPawn5.getCol()].addPiece(blackPawn5);
        BlackPawn blackPawn6 = new BlackPawn(); blackPawn6.setRow(1); blackPawn6.setCol(5);btn[blackPawn6.getRow()][blackPawn6.getCol()].addPiece(blackPawn6);
        BlackPawn blackPawn7 = new BlackPawn(); blackPawn7.setRow(1); blackPawn7.setCol(6);btn[blackPawn7.getRow()][blackPawn7.getCol()].addPiece(blackPawn7);
        BlackPawn blackPawn8 = new BlackPawn(); blackPawn8.setRow(1); blackPawn8.setCol(7);btn[blackPawn8.getRow()][blackPawn8.getCol()].addPiece(blackPawn8);

        //BLACK KNIGHTS
        BlackKnight blackKnight1 = new BlackKnight(); blackKnight1.setRow(0); blackKnight1.setCol(1);btn[blackKnight1.getRow()][blackKnight1.getCol()].addPiece(blackKnight1);
        BlackKnight blackKnight2 = new BlackKnight(); blackKnight2.setRow(0); blackKnight2.setCol(6);btn[blackKnight2.getRow()][blackKnight2.getCol()].addPiece(blackKnight2);

        //BLACK ROOKS
        BlackRook blackRook1 = new BlackRook(); blackRook1.setRow(0); blackRook1.setCol(0); btn[blackRook1.getRow()][blackRook1.getCol()].addPiece(blackRook1);
        BlackRook blackRook2 = new BlackRook(); blackRook2.setRow(0); blackRook2.setCol(7); btn[blackRook2.getRow()][blackRook2.getCol()].addPiece(blackRook2);

        //BLACK BISHOPS
        BlackBishop blackBishop1 = new BlackBishop(); blackBishop1.setRow(0); blackBishop1.setCol(2); btn[blackBishop1.getRow()][blackBishop1.getCol()].addPiece(blackBishop1);
        BlackBishop blackBishop2 = new BlackBishop(); blackBishop2.setRow(0); blackBishop2.setCol(5); btn[blackBishop2.getRow()][blackBishop2.getCol()].addPiece(blackBishop2);

        //BLACK QUEEN AND KING
        BlackQueen blackQueen = new BlackQueen(); blackQueen.setRow(0); blackQueen.setCol(3); btn[blackQueen.getRow()][blackQueen.getCol()].addPiece(blackQueen);
        BlackKing blackKing = new BlackKing(); blackKing.setRow(0); blackKing.setCol(4); btn[blackKing.getRow()][blackKing.getCol()].addPiece(blackKing);
    }// end of constructor

}
