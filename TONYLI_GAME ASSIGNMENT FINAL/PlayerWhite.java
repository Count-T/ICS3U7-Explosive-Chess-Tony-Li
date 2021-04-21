public class PlayerWhite {
    /*
    Game Assignment
    ICS3U7
    Tony Li
    Ms Strelkovska
    */
    private boolean isTurn;
    public PlayerWhite(){
        System.out.println("White Player Created");
        this.isTurn = true;
        Tile selectedTile;
        Tile tileToMoveTo;
    }
    //Getter and setter
    public boolean getIsTurn(){
        return isTurn;
    }
    public void setIsTurn(boolean isTurn){
        this.isTurn = isTurn;
    }
}
