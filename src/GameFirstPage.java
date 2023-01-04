import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFirstPage extends JFrame {
    private JPanel firstpage;
    private JButton character1;
    private JButton character2;
    private JButton character3;
    private JTextPane char1Info;
    private JTextPane char2Info;
    private JTextPane char3Info;
    private JLabel char1Image;
    private JLabel char2Image;
    private JLabel char3Image;


    public GameFirstPage(){
       add(firstpage);
       setVisible(true);
       setSize(600,400);
        character1.addActionListener(e -> {
            int hp = SqlQuery.getValuesFromSQL("SELECT HP FROM characters WHERE id='1'","HP");
            int ad =  SqlQuery.getValuesFromSQL("SELECT AD FROM characters WHERE id='1'","AD");
            Character player = new Character("Şövalye", hp,ad);
            System.out.println(player.AD + " " + player.HP + " " + player.name);
            new Location(player);
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();


        });
        character2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hp = SqlQuery.getValuesFromSQL("SELECT HP FROM characters WHERE id='2'","HP");
                int ad =  SqlQuery.getValuesFromSQL("SELECT AD FROM characters WHERE id='2'","AD");
                Character player = new Character("Büyücü", hp,ad);
                System.out.println(player.AD + " " + player.HP + " " + player.name);
                new Location(player);
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();


            }
        });
        character3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hp = SqlQuery.getValuesFromSQL("SELECT HP FROM characters WHERE id='3'","HP");
                int ad =  SqlQuery.getValuesFromSQL("SELECT AD FROM characters WHERE id='3'","AD");
                Character player = new Character("Avcı", hp,ad);
                System.out.println(player.AD + " " + player.HP + " " + player.name);
                new Location(player);
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();


            }
        });
    }


    private void createUIComponents() {
        char1Image = new JLabel(new ImageIcon("sword.png"));
        char2Image = new JLabel(new ImageIcon("wand.png"));
        char3Image = new JLabel(new ImageIcon("bow.png"));
    }
}
