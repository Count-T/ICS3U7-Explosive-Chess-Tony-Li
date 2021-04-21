
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
import javax.swing.*;
import java.awt.*;
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/
public class GAME_MAIN {
    public static void main(String[] args){
        JFrame frame= new MyFrame("Game Assignment Tony Li");
        frame.setSize(1250,740); //The top panel is 40 pixel
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //stop the window from being changed
        ImageIcon image = new ImageIcon("boomimage.png"); //Create the image logo to put on the top left corner
        frame.setIconImage(image.getImage()); //Change
    }
}
