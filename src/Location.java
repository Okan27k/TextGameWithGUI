import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Location extends JFrame {
    private JTextArea BarText;
    private JTextArea SquareText;
    private JTextArea SewereText;
    private JButton buttonBar;
    private JButton buttonSquare;
    private JButton buttonSewer;
    private JPanel location;
    private JButton Attack;
    private JButton Ulti;
    private JButton TalkButton;
    private JButton runButton;
    private JButton nextEnemy;
    private JPanel buttonBarPanel;
    private JPanel SquarePanel;
    private JButton evenButton;
    private JButton oddButton;
    private JPanel optionAttack;
    private JButton ThreatButton;
    private JButton TalkNicelyButton;
    private JPanel BarTextPanel;
    private JPanel SqrTextPanel;
    private JPanel sewerPan;
    private JLabel barImage;
    private JLabel dungeonImage;
    private JLabel graveyardImage;
    private boolean isBarNotVisited = true;
    private boolean isSquareNotVisited = true;
    private boolean isSewerNotVisited = true;
    private Image backgroundImage;
    int enemyId = 1;
    Enemy enemy = CreateEnemy(enemyId);
    public Location(Character player) {

        add(location);

        Attack.setVisible(false);
        Ulti.setVisible(false);
        TalkButton.setVisible(false);
        runButton.setVisible(false);
        nextEnemy.setVisible(false);
        runButton.setVisible(false);
        ThreatButton.setVisible(false);
        TalkNicelyButton.setVisible(false);
        evenButton.setVisible(false);
        oddButton.setVisible(false);
        setSize(650, 500);
        setVisible(true);
        buttonBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBarNotVisited) {
                    SquareText.setVisible(false);
                    SewereText.setVisible(false);
                    buttonSewer.setVisible(false);
                    buttonSquare.setVisible(false);
                    dungeonImage.setVisible(false);
                    graveyardImage.setVisible(false);

                    if(isSquareNotVisited) {
                        BarText.setText("Meyhaneye girdin Barmen:\n'Ho??geldin Macerac??, buyur; ilk " +
                                "i??kiler bizden!'\n diyerek sana i??ki teklif etti.");
                        buttonBar.setText("????kiyi i?? ve geri d??n.");
                    }
                    if(!isSquareNotVisited){
                        BarText.setText("B??t??n d????manlar?? ??ld??rm????s??n. Te??ekk??rler");
                        buttonBar.setText("Geri d??n.");
                    }

                    isBarNotVisited = false;
                } else {
                    if(isSquareNotVisited) {
                        player.HP += 100;
                        player.AD += 50;
                        System.out.println(player.HP + " " + player.AD);
                        JOptionPane.showMessageDialog(null, "????ki can??n?? 100 hasar??n?? 50 artt??rd??." + "\n" + "Art??k can??n : "
                                + player.HP + " Hasar??n : " + player.AD);
                    }
                    SquareText.setVisible(true);
                    SewereText.setVisible(true);
                    buttonSewer.setVisible(true);
                    buttonSquare.setVisible(true);
                    buttonBarPanel.remove(buttonBar);
                    dungeonImage.setVisible(true);
                    graveyardImage.setVisible(true);
                    //todo:edit text
                    BarText.setText("Bara zaten girdin...");
                    if (!isSewerNotVisited && !isBarNotVisited && !isSquareNotVisited) {
                        JOptionPane.showMessageDialog(null, "OYUNU KAZANDINIZ!");
                        System.exit(1);
                    }
                }
            }
        });


        buttonSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSquareNotVisited) {
                    buttonBar.setVisible(false);
                    buttonSewer.setVisible(false);
                    BarText.setVisible(false);
                    SewereText.setVisible(false);
                    isSquareNotVisited = false;
                    buttonSquare.setVisible(false);
                    Attack.setVisible(true);
                    Ulti.setVisible(true);
                    barImage.setVisible(false);
                    graveyardImage.setVisible(false);
                    SquareText.setText(Enemy.getInfo(enemy, player));
                } else {
                    buttonBar.setVisible(true);
                    buttonSewer.setVisible(true);
                    BarText.setVisible(true);
                    SewereText.setVisible(true);
                    SquareText.setText("Zindana zaten girdin...");
                    SquarePanel.setVisible(false);
                    SquarePanel.remove(buttonSquare);
                    barImage.setVisible(true);
                    graveyardImage.setVisible(true);
                    if (!isSewerNotVisited && !isBarNotVisited && !isSquareNotVisited) {
                        JOptionPane.showMessageDialog(null, "OYUNU KAZANDINIZ!");
                        System.exit(1);
                    }

                }

            }
        });


        buttonSewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSewerNotVisited) {
                    isSewerNotVisited = false;
                    SquarePanel.setVisible(false);
                    SqrTextPanel.setVisible(false);
                    BarTextPanel.setVisible(false);
                    buttonBarPanel.setVisible(false);
                    enemy = CreateEnemy(6);
                    SewereText.setText(Enemy.getInfo(enemy, player));
                    buttonSewer.setVisible(false);
                    TalkButton.setVisible(true);
                    runButton.setVisible(true);
                    barImage.setVisible(false);
                    dungeonImage.setVisible(false);
                } else {
                    SquarePanel.setVisible(true);
                    SqrTextPanel.setVisible(true);
                    BarTextPanel.setVisible(true);
                    buttonBarPanel.setVisible(true);
                    barImage.setVisible(true);
                    dungeonImage.setVisible(true);
                    sewerPan.setVisible(false);
                    SewereText.setText("Mezarl????a zaten girdin.");
                    enemy= CreateEnemy(enemyId);




                    if (!isSewerNotVisited && !isBarNotVisited && !isSquareNotVisited) {
                        JOptionPane.showMessageDialog(null, "OYUNU KAZANDINIZ!");
                        System.exit(1);
                    }


                }


            }
        });


        Attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evenButton.setVisible(true);
                oddButton.setVisible(true);
                Attack.setVisible(false);
            }
        });
        Ulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enemy.HP -= player.AD;
                SquareText.setText(player.name + " D????mana "+player.AD+" vurdu.\n"+player.name+" can?? : "+player.HP+
                        "\n"+ player.name+" hasar?? : "+player.AD+"\n"+ enemy.name+" can?? : "+enemy.getHP()+
                        "\n"+enemy.name+" hasar?? : "+enemy.AD);
                Ulti.setVisible(false);
            }
        });
        TalkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TalkNicelyButton.setVisible(true);
                ThreatButton.setVisible(true);
                TalkButton.setVisible(false);
            }
        });
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.HP = 0;
                //todo edit text
                SewereText.setText("Hayaletten ka??maya ??al????t??n ve ba??ar??s??z oldun.");
                JOptionPane.showMessageDialog(null, "??ld??n");
                System.exit(2);
            }
        });
        nextEnemy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enemyId += 1;
                enemy = CreateEnemy(enemyId);
                SquareText.setText(Enemy.getInfo(enemy, player));
                nextEnemy.setVisible(false);
                Attack.setVisible(true);
                Ulti.setVisible(true);

            }
        });
        evenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SquareText.setText(Character.Attack(player, enemy, 2));
                evenButton.setVisible(false);
                oddButton.setVisible(false);
                Attack.setVisible(true);
                if (enemyId == 5 && player.HP > 0) {
                    Attack.setVisible(false);
                    Ulti.setVisible(false);
                    buttonSquare.setText("????k");
                    buttonSquare.setVisible(true);
                    SquareText.setText("Zindandaki b??t??n d????manlar?? ??ld??rd??n.");
                } else if (enemyId < 5 && enemy.HP < 1) {
                    nextEnemy.setVisible(true);
                    Attack.setVisible(false);
                    Ulti.setVisible(false);
                    evenButton.setVisible(false);
                    oddButton.setVisible(false);
                }
            }
        });
        oddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SquareText.setText(Character.Attack(player, enemy, 1));
                evenButton.setVisible(false);
                oddButton.setVisible(false);
                Attack.setVisible(true);
                if (enemyId == 5 && player.HP > 0) {
                    Attack.setVisible(false);
                    Ulti.setVisible(false);
                    buttonSquare.setText("????k");
                    buttonSquare.setVisible(true);
                    SquareText.setText("Zindandaki b??t??n d????manlar?? ??ld??rd??n.");
                } else if (enemyId < 5 && enemy.HP < 1) {
                    nextEnemy.setVisible(true);
                    Attack.setVisible(false);
                    Ulti.setVisible(false);
                    evenButton.setVisible(false);
                    oddButton.setVisible(false);
                }
            }
        });
        TalkNicelyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSquareNotVisited){
                    SewereText.setText("Hayalet ile nazik??e konu??tun ve can??n?? 100 artt??rd??.");
                    player.HP += 100;
                }
                if(!isSquareNotVisited){

                    if(random() == 1){JOptionPane.showMessageDialog(null,"Hayelet ile konu??urken zindandaki canavarlar??n hayaletleri " +
                            "seni ??ld??rd??.");
                    System.exit(2);
                    }else {
                        SewereText.setText("Hayalet ile nazik??e konu??tun.");
                    }
                }
                TalkNicelyButton.setVisible(false);
                ThreatButton.setVisible(false);
                buttonSewer.setText("????k????");
                buttonSewer.setVisible(true);
                TalkButton.setVisible(false);
                runButton.setVisible(false);
            }
        });
        ThreatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.HP = 0;
                //todo edit text
                SewereText.setText("Hayaleti tehdit ettin ama hayalet seni tek hamlede ??ld??rd??.");
                JOptionPane.showMessageDialog(null, "??ld??n");
                System.exit(2);
            }
        });
    }
    private Enemy CreateEnemy(int id) {
        int hp = SqlQuery.getValuesFromSQL("SELECT HP FROM enemy WHERE id='" + id + "'", "HP");
        int ad = SqlQuery.getValuesFromSQL("SELECT AD FROM enemy WHERE id='" + id + "'", "AD");
        String name = SqlQuery.getValeusFromSQL("SELECT name FROM enemy WHERE id='" + id + "'", "name");
        return new Enemy(name, hp, ad);
    }
    private static int random() {
        if (Math.random() < 0.25) return 1;
        else return 2;
    }
    private void createUIComponents() {
        barImage = new JLabel(new ImageIcon("bar.png"));
        dungeonImage = new JLabel(new ImageIcon("dungeon.png"));
        graveyardImage = new JLabel(new ImageIcon("graveyard.png"));
    }
}
