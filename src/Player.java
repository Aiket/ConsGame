import java.util.Random;

class Player {
    String playerName;
    static int maxHP;
    static int currentHP;
    static int basicDmg;
    static int basicIntellect;
    static int money;
    static int dmg;
    static int intellect;
    enum Race {HUMAN, ORC, GNOME}
    Race race;

    Player (Race race, String playerName) {
        if (race.equals(Race.ORC)) {
            this.playerName = playerName;
            currentHP = maxHP = 25;
            dmg = basicDmg = 6;
            intellect = basicIntellect = 2;
            money = 50;
            this.race = Race.ORC;
        }
        if (race.equals(Race.HUMAN)) {
            this.playerName = playerName;
            currentHP = maxHP = 19;
            dmg = basicDmg = 3;
            intellect = basicIntellect = 10;
            money = 80;
            this.race = Race.HUMAN;
        }
        if (race.equals(Race.GNOME)) {
            this.playerName = playerName;
            currentHP = maxHP = 19;
            dmg = basicDmg = 3;
            intellect = basicIntellect = 10;
            money = 80;
            this.race = Race.GNOME;

        }
    }

    String getPlayerName() {
        return this.playerName;
    }
    int getHp(){
        return this.currentHP;
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

    void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    void setHp(int hp){
        Player.currentHP = hp;
    }
    void setDmg(int dmg){
        Player.dmg = dmg;
    }
    void setIntellect(int intellect){
        Player.intellect = intellect;
    }
    void setMoney (int money){
        Player.money = money;
    }
    void setRace (Race race){
        this.race = race;
    }



    void showInfo() {
        System.out.println ("Name: " + playerName + "\n" + "Race: " + race + "\n" + "Money: " + money + "\n" + "Health Points: " + currentHP + "(" + maxHP + ")" + "\n" +
                "Damage: " + dmg + "\n" + "Intellect: " + intellect + "\n");
    }

}
