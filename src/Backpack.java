
class Backpack {
    static Item[] StuffItems;

    Backpack(){
        Apple apple = new Apple();
        Pie pie = new Pie();
        StuffItems = new Item[]{null, null, null, null, null, null, null};
    }

    int howManyItems(){
        int i = 0;
        for( int j = 1; j < StuffItems.length; j++){
            if (StuffItems[j] != null) {
                i++;
            }
        }
        return i;
    }
    boolean isAnyItemInStuff(){
        for(int i = 1; i < StuffItems.length; i++){
            if (StuffItems[i] != null) {
                return true;
            }
        }
        return false;
    }
    void equipAnItem(Item item, Player player, int itemNumberToRemove) {
        if (item instanceof Sword) {
            if(Player.activeSword == null) {
                player.setActiveSword((Sword) item);
                Backpack.StuffItems[itemNumberToRemove] = null;
            }else {
                System.out.println("Unequip your sword before equipping new one!" + "\n");
                StaticMethods.pressAnyKeyToContinue();
            }
        }
        if (item instanceof Armor) {
            if(Player.activeArmor == null) {
                player.setActiveArmor((Armor) item);
                Backpack.StuffItems[itemNumberToRemove] = null;
            }else {
                System.out.println("Unequip your armor before equipping new one!" + "\n");
                StaticMethods.pressAnyKeyToContinue();
            }
        }
        if (item instanceof Trinket) {
            if(Player.activeTrinket == null) {
                player.setActiveTrinket((Trinket) item);
                Backpack.StuffItems[itemNumberToRemove] = null;
            }else {
                System.out.println("Unequip your trinket before equipping new one!"+ "\n");
                StaticMethods.pressAnyKeyToContinue();
            }
        }
    }

    static void addItemInStuff(Item item) {
        for (int i = 1; i < StuffItems.length; i++) {
            if (StuffItems[i] == null) {
                StuffItems[i] = item;
                break;
            }
        }
    }

    static void dropItem(Item item, int i) {
        StuffItems[i] = null;
        System.out.println("Item " + item.getName() + " has been removed from your backpack, position " + i + " is empty now" + "\n");
    }

    void showContent() {
        System.out.println("You have " + Apple.amount + " apples and " + Pie.amount + " pies." + "\n");
        for (int i = 1; i < StuffItems.length; i++) {
            if (StuffItems[i] != null) {
                System.out.print(i + ") ");
                StuffItems[i].showStats();
            }
        }
    }

    abstract static class Food {
        String name;
        static int amount;
        static int HPRecovery;
        int price;
    }

    static class Apple extends Food {
        static int amount = 0;
        static final int HPRecovery = 10;
        static int price = 15;

        static void eatAnApple() {
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

        static void addAnApple() {
            amount++;
        }

        static int appleAmount() {
            return amount;
        }
        static int getPrice() { return price;}

    }

    static class Pie extends Food {
        static int amount;
        static final int HPRecovery = 30;
        static int price = 40;

        static void eatAPie() {
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

        static void addAPie() {
            amount++;
        }

        static int pieAmount() {
            return amount;
        }
        static int getPrice() { return price;}
    }
}
