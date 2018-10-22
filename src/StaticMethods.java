import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class StaticMethods {
    static JSONParser reader = new JSONParser();
    static Random random = new Random(System.currentTimeMillis());
    static String pathToEnemies = "src/resources/Enemies.json";
    static String pathToBoss = "src/resources/Boss.json";
    static Sword commonSword = new Sword("Common Sword", 3, 30);
    static Sword rareSword = new Sword("Rare Sword", 5, 50);
    static Sword epicSword = new Sword("Epic Sword", 7, 70);
    static Sword legendarySword = new Sword("Legendary Sword", 11, 100);
    static Armor commonArmor = new Armor("Common Armor", 5, 30);
    static Armor rareArmor = new Armor("Rare Armor", 7, 50);
    static Armor epicArmor = new Armor("Epic Armor", 9, 70);
    static Armor legendaryArmor = new Armor("Legendary Armor", 12, 100);
    static Trinket commonTrinket = new Trinket("Common Trinket", 4, 30);
    static Trinket rareTrinket = new Trinket("Rare Trinket", 6, 50);
    static Trinket epicTrinket = new Trinket("Epic Trinket", 8, 70);
    static Trinket legendaryTrinket = new Trinket("Legendary Trinket", 10, 100);
    static Sword overseasSword = new Sword("Overseas Sword", 13, 300);
    static Armor overseasArmor = new Armor("Overseas Armor", 14, 300);
    static Trinket overseasTrinket = new Trinket("Overseas Trinket", 12, 300);

    public static void pressAnyKeyToContinue() {
        System.out.println("Press any key to go back: " + "\n");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {

        }
    }

    public static void waitAMoment(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
        }
    }

    static boolean fight(Player player, Enemy enemy) {

        int timeout = 1;

        String[] fightAnnouncements = new String[]{player.getPlayerName() + ", do you have enough boldness to challenge a notorious " + enemy.getName() + "?" + "\n",
                "Let the slaughter begin!" + "\n" + "Fight for your life!" + "\n"};
        System.out.println(fightAnnouncements[random.nextInt(fightAnnouncements.length)]);
        waitAMoment(timeout);
        while (true) {
            int phraseId = random.nextInt(enemy.getCatchPhrases().size() - 1);
            waitAMoment(timeout);
            System.out.println(enemy.getName() + " yells: \"" + enemy.getCatchPhrases().get(phraseId) + "\"" + "\n");
            int randomInteger = random.nextInt(2);
            if (randomInteger % 2 == 0) {
                System.out.println(player.getPlayerName() + " swings his sword and inflicts " + player.getDmg() + " damage to " + enemy.getName() + "!" + "\n");
                enemy.setHp(enemy.getHp() - player.getDmg());
                if (enemy.getHp() < 0) {
                    enemy.setHp(0);
                }
            } else {
                System.out.println(player.getPlayerName() + " casts a fireball and inflicts " + player.getIntellect() + " damage to " + enemy.getName() + "!" + "\n");
                enemy.setHp(enemy.getHp() - player.getIntellect());
                if (enemy.getHp() < 0) {
                    enemy.setHp(0);
                }
            }
            System.out.println("Your hp: " + player.getCurrentHP() + "    Enemy hp: " + enemy.getHp() + "\n");
            if (enemy.getHp() <= 0) {
                System.out.println("You won! " + enemy.getName() + " is defeated!" + "\n");
                waitAMoment(timeout);
                return true;
            }
            waitAMoment(timeout);
            System.out.println(enemy.getName() + " inflicts " + enemy.getDmg() + " damage to " + player.getPlayerName() + "!" + "\n");
            player.setCurrentHP(player.getCurrentHP() - enemy.getDmg());
            if (player.getCurrentHP() < 0) {
                player.setCurrentHP(0);
            }
            System.out.println("Your hp: " + player.getCurrentHP() + "    Enemy hp: " + enemy.getHp() + "\n");
            if (player.getCurrentHP() <= 0) {
                System.out.println("You lose!");
                waitAMoment(timeout);
                return false;
            }
            waitAMoment(timeout);
        }
    }

    static boolean bossFight(Player player) {
        Enemy boss = reader.getBoss(pathToBoss);
        int timeout = 1;
        System.out.println("You are entering a cave" + "\n");
        waitAMoment(timeout);
        while (true) {
            int phraseId = random.nextInt(boss.getCatchPhrases().size() - 1);
            waitAMoment(timeout);
            System.out.println(boss.getName() + " yells: \"" + boss.getCatchPhrases().get(phraseId) + "\"" + "\n");
            int randomInteger = random.nextInt(2);
            if (randomInteger % 2 == 0) {
                System.out.println(player.getPlayerName() + " swings his sword and inflicts " + player.getDmg() + " damage to " + boss.getName() + "!" + "\n");
                boss.setHp(boss.getHp() - player.getDmg());
                if (boss.getHp() < 0) {
                    boss.setHp(0);
                }
            } else {
                System.out.println(player.getPlayerName() + " casts a fireball and inflicts " + player.getIntellect() + " damage to " + boss.getName() + "!" + "\n");
                boss.setHp(boss.getHp() - player.getIntellect());
                if (boss.getHp() < 0) {
                    boss.setHp(0);
                }
            }
            System.out.println("Your hp: " + player.getCurrentHP() + "    Enemy hp: " + boss.getHp() + "\n");
            if (boss.getHp() <= 0) {
                System.out.println("You won! " + boss.getName() + " is defeated!" + "\n");
                return true;
            }
            waitAMoment(timeout);
            System.out.println(boss.getName() + " inflicts " + boss.getDmg() + " damage to " + player.getPlayerName() + "!" + "\n");
            player.setCurrentHP(player.getCurrentHP() - boss.getDmg());
            if (player.getCurrentHP() < 0) {
                player.setCurrentHP(0);
            }
            System.out.println("Your hp: " + player.getCurrentHP() + "    Enemy hp: " + boss.getHp() + "\n");
            if (player.getCurrentHP() <= 0) {
                System.out.println("You lose!");
                return false;
            }
            waitAMoment(timeout);
        }
    }

    static boolean dungeonJourney(Player player, Backpack backpack) {
        List<Enemy> enemyList = reader.getEnemies(pathToEnemies);
        boolean victory = true;
        Random random = new Random(System.currentTimeMillis());
        Scanner in = new Scanner(System.in);
        int amountOfEnemies;
        int difficulty;
        while (true) {
            System.out.println("How many enemies will you try to defeat? The more enemies the better prize awaits you" + "\n" +
                    "1) 1 - 3 common" + "\n" +
                    "2) 4 - 5 rare" + "\n" +
                    "3) 6 - 7 epic" + "\n" +
                    "4) 8 - 10 legendary" + "\n");
            difficulty = in.nextInt();
            if(difficulty == 1){
                amountOfEnemies = 1 + random.nextInt(4 - 1);
                break;
            }else if(difficulty == 2){
                amountOfEnemies = 4 + random.nextInt(6 - 4);
                break;
            }else if(difficulty == 3){
                amountOfEnemies = 6 + random.nextInt(8 - 6);
                break;
            }else if(difficulty == 4){
                amountOfEnemies = 8 + random.nextInt(11 - 8);
                break;
            }else{
                System.out.println("Wrong number!" + "\n");
                continue;
            }
        }
        System.out.println("You have rolled " + amountOfEnemies + " enemies" + "\n");
        for (int i = 0; i < amountOfEnemies; i++) {
            Enemy enemy = enemyList.get(random.nextInt(enemyList.size()));
            enemyList.remove(enemy);
            if (!StaticMethods.fight(player, enemy)) {
                victory = false;
                break;
            }
        }
        if (victory) {
            int r = random.nextInt(3);
            if(difficulty == 1) {
                if (r == 0) {
                    backpack.addItemInStuff(commonArmor);
                } else if (r == 1) {
                    backpack.addItemInStuff(commonSword);
                    ;
                } else {
                    backpack.addItemInStuff(commonTrinket);
                }
            } else if(difficulty == 2) {
                if (r == 0) {
                    backpack.addItemInStuff(rareArmor);
                } else if (r == 1) {
                    backpack.addItemInStuff(rareSword);
                } else {
                    backpack.addItemInStuff(rareTrinket);
                }
            } else if(difficulty == 3) {
                if (r == 0) {
                    backpack.addItemInStuff(epicArmor);
                    ;
                } else if (r == 1) {
                    backpack.addItemInStuff(epicSword);
                } else {
                    backpack.addItemInStuff(epicTrinket);
                }
            } else {
                if (r == 0) {
                    backpack.addItemInStuff(legendaryArmor);
                } else if (r == 1) {
                    backpack.addItemInStuff(legendarySword);
                } else {
                    backpack.addItemInStuff(legendaryTrinket);
                }
            }
        }
        return victory;
    }

    static void merchant(Player player, Backpack backpack) {
        Scanner in = new Scanner(System.in);
        System.out.println( "\n" + "Greetings traveler!" + "\n");
        while (true) {
            System.out.println("Your money: $" + player.getMoney() + "\n" +
                    "1) Buy food" + "\n" + "2) Sell your items" + "\n" + "3) Buy a pass to mysterious cave $500 " + "\n" +
                    "4) Buy overseas items" + "\n" + "5) Go back" + "\n");
            int input = in.nextInt();
                if (input == 1)
                    while (true) {
                    System.out.println("1) Buy an apple $" + Backpack.Apple.getPrice() + "\n" + "2) Buy a pie $" + Backpack.Pie.getPrice() + "\n" + "3) Go back" + "\n"
                            + "Your money: $" + player.getMoney() + "    " + "Your HP: " + player.getCurrentHP() + "(" + player.getMaxHP() + ")" + "\n");
                    input = in.nextInt();
                    if (input == 1) {
                        if (player.getMoney() >= Backpack.Apple.getPrice()) {
                            player.setMoney(player.getMoney() - Backpack.Apple.getPrice());
                            Backpack.Apple.addAnApple();
                            System.out.println("You bought an apple!" + "\n");
                        } else {
                            System.out.println("You have not enough money!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                        }
                    } else if (input == 2) {
                        if (player.getMoney() >= Backpack.Pie.getPrice()) {
                            player.setMoney(player.getMoney() - Backpack.Pie.getPrice());
                            Backpack.Pie.addAPie();
                            System.out.println("You bought a pie!" + "\n");
                        } else {
                            System.out.println("You have not enough money!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                        }
                    } else if (input == 3) {
                        break;
                    }
                }else if (input == 2)
                    while (true) {
                    if (backpack.isAnyItemInStuff()) {
                        backpack.showContent();
                        System.out.println("Choose an item to sell: " + "\n" + "0 to go back" + "\n");
                        input = in.nextInt();
                        if (input == 0){
                            break;
                        }else if (Backpack.StuffItems[input] == null) {
                            System.out.println("Wrong number!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                        }
                        player.setMoney(player.getMoney() + backpack.StuffItems[input].getPrice());
                        Backpack.dropItem(Backpack.StuffItems[input], input);

                    } else {
                        System.out.println("You have no items yet!" + "\n");
                        StaticMethods.pressAnyKeyToContinue();
                        break;
                    }
            }else if (input == 3) {
                if (player.getMoney() >= 500) {
                    player.passToBoss = true;
                    player.setMoney(player.getMoney() - 500);
                } else {
                    System.out.println("Not enough money!" + "\n");
                }
            }else if(input == 4){

                    while(true){
                        System.out.println("1) " + overseasSword.getName() +" $" + overseasSword.getPrice()+ "\n" +
                                "2) " + overseasArmor.getName() +" $" + overseasArmor.getPrice()+ "\n" +
                                "3) " + overseasTrinket.getName() +" $" + overseasTrinket.getPrice() + "\n" +
                                "4) Go back"  + "\n");
                        input = in.nextInt();
                        if(input == 1) {
                            if(overseasSword.getPrice() <= player.getMoney()){
                                backpack.addItemInStuff(overseasSword);
                                player.setMoney(player.getMoney() - overseasSword.getPrice());
                            }else{
                                System.out.println("Not enough money!");
                            }
                        }else if(input == 2) {
                            if(overseasArmor.getPrice() <= player.getMoney()){
                                backpack.addItemInStuff(overseasArmor);
                                player.setMoney(player.getMoney() - overseasArmor.getPrice());
                            }else{
                                System.out.println("Not enough money!");
                            }
                        }else if(input == 3) {
                            if(overseasTrinket.getPrice() <= player.getMoney()){
                                backpack.addItemInStuff(overseasTrinket);
                                player.setMoney(player.getMoney() - overseasTrinket.getPrice());
                            }else{
                                System.out.println("Not enough money!");
                            }
                        }else if(input == 4){
                            break;
                        }
                    }
                    }else if (input == 5) {
                return;
            }
        }
    }
}


