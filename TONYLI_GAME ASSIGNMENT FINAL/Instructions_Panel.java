
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions_Panel extends JPanel implements ActionListener {
    JButton goInstructions;
    JButton returnToGame;
    public Instructions_Panel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.pink);
        ImageIcon img = new ImageIcon(getClass().getResource("explosivechessrules.png"));
        JLabel background = new JLabel(img);
        this.add(background, BorderLayout.CENTER);
        returnToGame = new JButton("Return to game");
        returnToGame.addActionListener(this);

        this.add(returnToGame, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returnToGame){
            MyFrame.cardsL.show(MyFrame.c, "Board");
        }
    }
}
