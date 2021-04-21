public class PlayerBlack {
    /*
    Game Assignment
    ICS3U7
    Tony Li
    Ms Strelkovska
    */
    private boolean isTurn;
    public PlayerBlack(){
        System.out.println("Black Player Created");
        this.isTurn = false;
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
