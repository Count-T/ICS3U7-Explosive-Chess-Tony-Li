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
public class WhiteWins extends JPanel implements ActionListener {
    JButton exit;
    public WhiteWins(){
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("whiteWins.png")));
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
