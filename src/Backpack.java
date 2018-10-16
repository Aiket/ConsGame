import java.util.ArrayList;

public class Backpack {
    static ArrayList<Item> stuff = new ArrayList<>();

    void addItem(Item item) {
        stuff.add(item);
        if (item instanceof Sword) {
            Player.dmg += ((Sword) item).dmgBonus;
        }
        if (item instanceof Armor) {
            Player.hp += ((Armor) item).hpBonus;
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
            Player.hp -= ((Armor) item).hpBonus;
        }
        if (item instanceof Trinket) {
            Player.intellect -= ((Trinket) item).intellectBonus;
        }

    }
}
