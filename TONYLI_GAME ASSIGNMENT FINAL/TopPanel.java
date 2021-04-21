import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class TopPanel extends JPanel{
    private static JLabel displayTurn;
    public TopPanel(){
        displayTurn = new JLabel("WHITE's turn");
        displayTurn.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(displayTurn);
    }

    public static void checkTurn() {
        if(Board.whitesTurn){
            displayTurn.setText("WHITE's Turn");
        }
        else{
            displayTurn.setText("BLACK's Turn");
        }
    }
}
