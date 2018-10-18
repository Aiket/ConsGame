import java.util.ArrayList;

class Backpack {
    static Apple apple;
    static Pie pie;
    private ArrayList<Item> stuff = new ArrayList<>();

    void addItem(Item item) {
        stuff.add(item);
        if (item instanceof Sword) {
            Player.dmg += ((Sword) item).dmgBonus;
        }
        if (item instanceof Armor) {
            Player.maxHP += ((Armor) item).hpBonus;
            Player.currentHP += ((Armor) item).hpBonus;
        }
        if (item instanceof Trinket) {
            Player.intellect += ((Trinket) item).intellectBonus;
        }
    }
    void removeItem(Item item) {
        stuff.remove(item);
        if (item instanceof Sword) {
            Player.dmg -= ((Sword) item).dmgBonus;
        }
        if (item instanceof Armor) {
            Player.maxHP -= ((Armor) item).hpBonus;
        }
        if (item instanceof Trinket) {
            Player.intellect -= ((Trinket) item).intellectBonus;
        }

    }
    void showContent() {
        System.out.println("You have " + Apple.appleAmount() + " apples and " + Pie.pieAmount() + " pies." + "\n");
        for (Item i: stuff) {
            i.showStats();
        }
    }
}
abstract  class Food {
    String name;
    int amount;
    int HPRecovery;

}
class Apple extends Food {
    private static int amount = 0;
    private static final int HPRecovery = 10;

    void eatAnApple() {
        if (amount > 0) {
            Player.currentHP += HPRecovery;
            if (Player.currentHP > Player.maxHP) {
                Player.currentHP = Player.maxHP;
            }
            amount--;
        } else {
            System.out.println("You have no apples!" + "\n");
        }
    }
    void addAnApple(){
        amount++;
    }
    static int appleAmount(){
        return amount;
    }

}
class Pie extends Food {
    private static int amount;
    private final int HPRecovery = 30;

    void eatAPie() {
        if (amount > 0) {
            Player.currentHP += HPRecovery;
            if (Player.currentHP > Player.maxHP) {
                Player.currentHP = Player.maxHP;
            }
            amount--;
        } else {
            System.out.println("You have no pies!" + "\n");
        }
    }
    void addAPie(){
        amount++;
    }
    static int pieAmount(){
        return amount;
    }
}
