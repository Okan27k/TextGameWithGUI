public class Enemy {


    protected String name;
    protected int   HP;
    protected int AD;

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAD() {
        return AD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAD(int AD) {
        this.AD = AD;
    }



    public Enemy(String name, int HP, int AD){
        this.name = name;
        this.HP = HP;
        this.AD = AD;


    }
    public static void changeEnemy(Enemy e,String newName, int newHP, int newAD){
        e.setName(newName);
        e.setAD(newAD);
        e.setHP(newHP);

    }




    public static String getInfo(Enemy enemy, Character character){
        //todo: edit text

        return enemy.name +" ile karşılaştın\n"+enemy.name+" Cani : " +enemy.HP+"\n"+enemy.name
                +" Hasarı : "+ enemy.AD+"\n"+character.name+" Canı : "+ character.HP
        +"\n"+character.name+" Hasarı : "+character.AD+"\n       Ne yapacaksın";

    }

}
