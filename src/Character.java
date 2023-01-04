import javax.swing.*;

public class Character {
    protected String name;
    protected int   HP;
    protected   int AD;


    public Character(String name, int HP, int AD) {
        this.name = name;
        this.HP = HP;
        this.AD = AD;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String Attack(Character character, Enemy enemy, int i){

        if (i!=Defend()) {
            enemy.HP -= character.AD;
            if (character.name.equals("Büyücü"))
            {
                character.HP += 50;
            }
            if (enemy.HP < 0) {
                enemy.HP = 0;
                return " Düşmanı öldürdün. ";
            }
            if (character.name.equals("Şövalye"))
            {
                character.AD += 10;
            }
            if (character.name.equals("Avcı"))
            {
                enemy.AD -= 5;
            }
            return character.name + " Düşmana "+character.AD+" vurdu.\n"+character.name+" canı : "+character.HP+"\n"+
                    character.name+" hasarı : "+character.AD+"\n"+
                    enemy.name+" canı : "+enemy.getHP()+"\n"+enemy.name+" hasarı : "+enemy.AD;
        } else {
            character.HP -= enemy.AD;
            if (character.HP < 0) {
                character.HP = 0;
                JOptionPane.showMessageDialog(null, "ÖLDÜN");
                System.exit(2);
            }
            return enemy.name +" " + enemy.AD+" " + " vurdu. \n"+ character.name + " canı : " + character.HP +"\n"+
                    character.name+" hasarı : "+character.AD+"\n"+
                    enemy.name + " canı : " + enemy.HP+"\n"+
                    enemy.name + " hasarı : " + enemy.AD;
        }
    }
    private static int Defend(){
        if(Math.random()<0.70) return 1;
        else return 2;
    }
}
