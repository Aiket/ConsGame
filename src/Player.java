import java.util.Random;

class Player {
    String playerName;
    static int basicHp;
    static int basicDmg;
    static int basicIntellect;
    static int hp;
    static int money;
    static int dmg;
    static int intellect;
    enum Race {human, orc}
    Race race;

    Player (String race, String name){
        if (race.equals("orc")) {
            playerName = name;
            hp = basicHp = 25;
            dmg = basicDmg = 6;
            intellect = basicIntellect = 2;
            money = 50;
            this.race = Race.orc;
        }
        else {
            playerName = name;
            hp = basicHp = 19;
            dmg = basicDmg = 3;
            intellect = basicIntellect= 5;
            money = 80;
            this.race = Race.human;
        }
    }

    String getPlayerName() {
        return this.playerName;
    }
    int getHp(){
        return this.hp;
    }
    int getDmg(){
        return this.dmg;
    }
    int getIntellect(){
        return this.intellect;
    }
    int getMoney(){
        return this.money;
    }

    void setHp(int hp){
        this.hp = hp;
    }


    void showInfo() {
        System.out.println ("Name: " + playerName + "\n" + "Race: " + race + "\n" + "Money: " + money + "\n" + "Health Points: " + hp + "\n" +
                "Damage: " + dmg + "\n" + "Intellect: " + intellect + "\n");
    }

}
