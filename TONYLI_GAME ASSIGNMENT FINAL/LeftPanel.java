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
public class LeftPanel extends JPanel implements ActionListener {
    static Timer timer;
    JLabel blackPawns;
    int seconds = 600;
    JLabel timeDisplay;
    public static boolean changedToGamePanel = false;

    public LeftPanel(){
        timer = new Timer(1000, this);
        this.setLayout(new GridLayout(16,1));
        this.setSize(250, 750);
        this.setBackground(Color.GRAY);
        JLabel header = new JLabel("WHITE's TIME", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(header);
        int minutes = seconds / 60;
        int secondsCount = seconds % 60;
        timeDisplay = new JLabel("10:00", SwingConstants.CENTER);
        timeDisplay.setFont(new Font("Serif", Font.PLAIN, 48));
        this.add(timeDisplay);
    }
    public static void checkTimer(){
        if(Board.whitesTurn && changedToGamePanel){
            timer.start();
        }
        else{
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            if(seconds <= 0){ //BLACK WINS IF WHITE TIMER IS DOWN
                MyFrame.cardsL.show(MyFrame.c, "BlackWins");
            }
            int minutes = seconds / 60;
            int secondsCount = seconds % 60;
            seconds --;
            String text = "";
            text += minutes + ":";
            if(secondsCount >= 10){
                text += secondsCount;
            }
            else{ //If the seconds is not 2 digits then we must concactenate a 0
                text += "0" + secondsCount;
            }
            timeDisplay.setText(text);
        }
    }
}
