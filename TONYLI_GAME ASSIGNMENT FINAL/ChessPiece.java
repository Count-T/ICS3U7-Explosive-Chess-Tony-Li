
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class ChessPiece {
    public boolean black;
    public boolean white;
    public boolean isKilled = false;
    private int row;
    private int col;
    public abstract void myMove();
    public abstract ImageIcon getImg();
    public abstract ImageIcon getTargetImg();
    public boolean isPawn = false;
    public boolean isKing = false;

    String type;
    //Getters and setters encapsulation
    public  void setRow(int row){
        this.row = row;
    }
    public  void setCol(int col){
        this.col = col;
    }
    public  int getRow(){
        return this.row;
    }
    public  int getCol(){
        return this.col;
    }

    public static HashSet<Integer[]> legalMove(HashSet<Integer[]> movableCoords){
        HashSet<Integer[]> filtered = new HashSet<Integer[]>();
        for(Integer[] coordinate : movableCoords){
            //Make sure that the coordinates are between 0 and 7 else dont add it
            if((coordinate[0] >= 0 && coordinate[0] <=7) && (coordinate[1] >= 0 && coordinate[1] <=7)){
                //Filters if it is on its own side too
                if(Board.btn[coordinate[0]][coordinate[1]].piece == null){ //Empty tile to move ok
                    filtered.add(coordinate);
                }
                else if(Board.btn[coordinate[0]][coordinate[1]].piece.black && Board.selectedTiles[0].piece.black){ //Tile with the same piece so dont add
                    //Dont add
                }
                else if(Board.btn[coordinate[0]][coordinate[1]].piece.white && Board.selectedTiles[0].piece.white){ //Tile with the same piece so dont add
                    //Dont add
                }
                else{ //Enemy tile, you can CAPTURE
                    filtered.add(coordinate);
                }
            }
        }
        movableCoords = filtered;
        return movableCoords;
    }

    public void white(){
        this.black = false;
        this.white = true;
    }
    public void black(){
        this.black = true;
        this.white = false;
    }
    public void setKilled(boolean isKilled){
        this.isKilled = isKilled;
    }
}
