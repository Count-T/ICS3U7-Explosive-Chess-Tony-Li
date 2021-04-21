
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Chess_Panel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    public static double mouseX;
    public static double mouseY;
    public static Board myBoard;
    public static Boolean newGame = true;
    JButton goInstruction;

    static {
        try {
            myBoard = new Board();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static TopPanel myTopPanel = new TopPanel();
    public static RightPanel myRightPanel = new RightPanel();
    public static LeftPanel myLeftPanel = new LeftPanel();
    public Chess_Panel() {
        // constructor
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1250,750));
        myBoard.setPreferredSize(new Dimension(700,700));
        myLeftPanel.setPreferredSize(new Dimension(250,750));
        myRightPanel.setPreferredSize(new Dimension(250,750));
        myTopPanel.setPreferredSize(new Dimension(1250, 25));
        this.add(myTopPanel, BorderLayout.NORTH);
        this.add(myRightPanel, BorderLayout.EAST);
        this.add(myLeftPanel, BorderLayout.WEST);
        this.add(myBoard, BorderLayout.CENTER);
        JButton wholeBoard = new JButton();
        goInstruction = new JButton("Instructions");
        goInstruction.addActionListener(this);
        this.add(goInstruction, BorderLayout.SOUTH);


    }// end of constructor
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goInstruction){
            System.out.println("Pressed");
            MyFrame.cardsL.show(MyFrame.c, "Instructions");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(knight, 80,80, null);
    }//end of paint

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}