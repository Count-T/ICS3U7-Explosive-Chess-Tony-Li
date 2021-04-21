import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class MyFrame extends JFrame{
    static CardLayout cardsL;
    static Container c;

    MenuPanel  menuP;  // object of my customized class MyMenuPanel
    Chess_Panel gameP;   // object of my customized class MyGamePanel
    Instructions_Panel instructionsP; // object of my customized class MyGamePanel
    WhiteWins whiteWins; //object of my customized class whiteWins;
    BlackWins blackWins; //object of my customized class blackWins;



    public MyFrame(String title){    //constructor
        super();
        this.setTitle(title);
        c=getContentPane();
        cardsL=new CardLayout();
        c.setLayout(cardsL);

        menuP = new MenuPanel();
        gameP = new Chess_Panel();
        instructionsP = new Instructions_Panel();
        whiteWins = new WhiteWins();
        blackWins = new BlackWins();

        c.add("Menu", menuP);
        c.add("Board", gameP);
        c.add("Instructions", instructionsP);
        c.add("WhiteWins", whiteWins);
        c.add("BlackWins", blackWins);

    }

} //end of demo class





