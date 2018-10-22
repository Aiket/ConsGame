
class Item {
    String name;
    int price;

    void showStats() {
        System.out.println(price + "\n");
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}

    class Armor extends Item {
        int price;
        int hpBonus;
        String name;

        Armor(String name, int hpBonus, int price) {
            this.hpBonus = hpBonus;
            this.price = price;
            this.name = name;
        }

        @Override
        void showStats() {
            System.out.println(name + "\n" + "Health Points Bonus: " + hpBonus + "\n" + "Price: " + price + "\n");
        }
        @Override
        String getName() {
            return name;
        }
        @Override
        int getPrice() {
            return price;
        }
    }

    class Sword extends Item {
        int price;
        int dmgBonus;
        String name;

        Sword(String name, int dmgBonus, int price) {
            this.dmgBonus = dmgBonus;
            this.price = price;
            this.name = name;
        }

        @Override
        void showStats() {
            System.out.println(name + "\n" + "Damage Bonus: " + dmgBonus + "\n" + "Price: " + price + "\n");
        }
        @Override
        String getName() {
            return name;
        }
        @Override
        int getPrice() {
            return price;
        }
    }

    class Trinket extends Item {
        int price;
        int intellectBonus;
        String name;

        Trinket(String name, int intBonus, int price) {
            this.intellectBonus = intBonus;
            this.price = price;
            this.name = name;
        }

        @Override
        void showStats() {
            System.out.println(name + "\n" + "Intellect Bonus: " + intellectBonus + "\n" + "Price: " + price + "\n");
        }
        @Override
        String getName() {
            return name;
        }
        @Override
        int getPrice() {
            return price;
        }
    }

