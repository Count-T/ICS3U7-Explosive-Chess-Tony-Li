
/*
Game Assignment
ICS3U7
Tony Li
Ms Strelkovska
*/import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackWins extends JPanel implements ActionListener {
    JButton exit;
    public BlackWins(){
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("blackWins.png")));
        exit = new JButton("Exit");
        exit.addActionListener(this);
        this.add(label,BorderLayout.CENTER);
        this.add(exit, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
    }
}
