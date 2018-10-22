import java.util.Random;

class Player {
    static String playerName;
    static int maxHP;
    static int currentHP;
    static int basicDmg;
    static int basicIntellect;
    static int money;
    static int dmg;
    static int intellect;
    static Sword activeSword;
    static Armor activeArmor;
    static Trinket activeTrinket;
    static boolean passToBoss;
    enum Race {HUMAN, ORC, GNOME}
    Race race;

    Player (Race race, String playerName) {
        if (race.equals(Race.ORC)) {
            this.playerName = playerName;
            currentHP = maxHP = 35;
            dmg = basicDmg = 7;
            intellect = basicIntellect = 1;
            money = 50;
            this.race = Race.ORC;
        }
        if (race.equals(Race.HUMAN)) {
            this.playerName = playerName;
            currentHP = maxHP = 27;
            dmg = basicDmg = 5;
            intellect = basicIntellect = 5;
            money = 80;
            this.race = Race.HUMAN;
        }
        if (race.equals(Race.GNOME)) {
            this.playerName = playerName;
            currentHP = maxHP = 20;
            dmg = basicDmg = 4;
            intellect = basicIntellect = 8;
            money = 110;
            this.race = Race.GNOME;

        }
        activeArmor = null;
        activeSword = null;
        activeTrinket = null;
        passToBoss = false;
    }

    String getPlayerName() {
        return this.playerName;
    }
    int getCurrentHP(){
        return this.currentHP;
    }
    int getMaxHP() { return this.maxHP;}
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
        Player.playerName = playerName;
    }
    void setCurrentHP(int hp){
        Player.currentHP = hp;
    }
    void setMaxHP(int hp) { Player.maxHP = hp; }
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

    void setActiveSword (Sword sword) {
        Player.activeSword = sword;
        setDmg(getDmg() + sword.dmgBonus);
    }
    void setActiveArmor (Armor armor) {
            Player.activeArmor = armor;
            setCurrentHP(getCurrentHP() + armor.hpBonus);
            setMaxHP(getMaxHP() + armor.hpBonus);
        }
    void setActiveTrinket (Trinket trinket) {
            Player.activeTrinket = trinket;
            setIntellect(getIntellect() + trinket.intellectBonus);
    }
    void removeActiveSword (){
            setDmg(getDmg() - activeSword.dmgBonus);
            Player.activeSword = null;
    }
    void removeActiveArmor (){
        setMaxHP(getMaxHP() - activeArmor.hpBonus);
        setCurrentHP(getCurrentHP() - activeArmor.hpBonus);
        Player.activeArmor = null;
    }
    void removeActiveTrinket (){
        setIntellect(getIntellect() - activeTrinket.intellectBonus);
        Player.activeTrinket = null;
    }
    void showActiveStuff(){
         if(activeArmor!=null){
             System.out.println("Active armor: " + activeArmor.getName() + "\n");
         }
         if(activeSword!=null){
             System.out.println("Active sword: " + activeSword.getName() + "\n");
         }
         if(activeTrinket!=null){
             System.out.println("Active trinket: " + activeTrinket.getName() + "\n");
         }
    }
    boolean isAnyActiveStuff(){
        return (activeArmor != null) || (activeTrinket != null) || (activeSword != null);
    }

    void showInfo() {
        System.out.println ("Name: " + playerName + "\n" + "Race: " + race + "\n" + "Money: $" + money + "\n" + "Health Points: " + currentHP + "(" + maxHP + ")" + "\n" +
                "Strength: " + dmg + "\n" + "Intellect: " + intellect);
    }

}
