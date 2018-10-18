
class Item {
    private String name;
    int price;
    Item() {
        this.price = 0;
        name = "Unnamed item";
    }
    Item(String name, int price) {
        this.price = price;
        this.name = name;
    }
    void showStats() {
        System.out.println(price + "\n");
    }
}
class Armor extends Item {
    int hpBonus;
    private String name;
    Armor(String name, int hpBonus, int price){
        this.hpBonus = hpBonus;
        this.price = price;
        this.name = name;
    }
    @Override
    void showStats() {
        System.out.println(name + "\n" + "Health Points Bonus: " + hpBonus + "\n" + "Price: " + price + "\n");
    }
}
class Sword extends Item{
    int dmgBonus;
    private String name;
    Sword(String name, int dmgBonus, int price){
        this.dmgBonus = dmgBonus;
        this.price = price;
        this.name = name;
    }
    @Override
    void showStats() {
        System.out.println(name + "\n" + "Damage Bonus: " + dmgBonus + "\n" + "Price: " + price + "\n");
    }
}
class Trinket extends Item{
    int intellectBonus;
    private String name;
    Trinket(String name, int intBonus, int price){
        this.intellectBonus = intBonus;
        this.price = price;
        this.name = name;
    }
    @Override
    void showStats() {
        System.out.println(name + "\n" + "Intellect Bonus: " + intellectBonus + "\n" + "Price: " + price + "\n");
    }
}