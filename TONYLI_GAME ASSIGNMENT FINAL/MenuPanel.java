import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
class MenuPanel  extends JPanel implements ActionListener {
    private JButton goGame;    // variables: button
    private ImageIcon img;
    private JLabel label1;
    public MenuPanel() {  // constructor
        img = new ImageIcon(getClass().getResource("ExplosiveChessICS3U7.png"));
        label1 = new JLabel(img);
        this.add(label1);
        goGame = new JButton("Start");
        goGame.addActionListener(this);
        label1.setLayout(new BorderLayout());
        label1.add(goGame, BorderLayout.SOUTH);     // add the button on the image
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==goGame){
            MyFrame.cardsL.next(MyFrame.c);
            LeftPanel.changedToGamePanel = true;
            Board.timer.start();
        }
    }
}