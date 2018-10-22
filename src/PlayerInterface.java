
import java.util.Scanner;

class PlayerInterface {
     static boolean playerMainInterface(Player player, Backpack backpack) {
        Scanner in = new Scanner(System.in);
        while (true) {
            StaticMethods.clearConsole();
            System.out.println("So, you have some free time, do what you want." + "\n" +
                    "1) It is time to eat some food" + "\n" +
                    "2) I want to know about myself" + "\n" +
                    "3) Let me check my backpack" + "\n" +
                    "4) Visit a merchant" + "\n" +
                    "5) Go to the next dungeon!");
            if(player.passToBoss) {
                System.out.print("6) Go to mysterious cave..."  + "\n");
            }
            int userInput = in.nextInt();
            if (userInput == 1) {
                while (true) {
                    StaticMethods.clearConsole();
                    System.out.println("You have " + Backpack.Apple.amount  + " apples and " + Backpack.Pie.amount + " pies."
                            + " Your HP: " + player.getCurrentHP() + "(" + player.getMaxHP() + ")" + "\n"
                            + "1) Eat an apple (+" + Backpack.Apple.HPRecovery + " HP)" + "\n"
                            + "2) Eat a pie (+" + Backpack.Pie.HPRecovery + " HP)" + "\n" + "3) Go back");
                    int input = in.nextInt();
                    if (input == 1) {
                        Backpack.Apple.eatAnApple();
                        continue;
                    }
                    if (input == 2) {
                        Backpack.Pie.eatAPie();
                        continue;
                    }
                    if (input == 3) {
                        break;
                    }
                }
            }
            if (userInput == 2) {
                StaticMethods.clearConsole();
                player.showInfo();
                System.out.println("\n");
                player.showActiveStuff();
                StaticMethods.pressAnyKeyToContinue();
            }
            if (userInput == 3) {
                while (true) {
                    StaticMethods.clearConsole();
                    backpack.showContent();
                    System.out.println("1) Show equipped items " + "\n" + "2) Equip an item " + "\n" + "3) Unequip an item " + "\n" + "4) Go back" + "\n");
                    int input = in.nextInt();
                    if (input == 1){
                        if (player.isAnyActiveStuff()) {
                            player.showActiveStuff();
                            StaticMethods.pressAnyKeyToContinue();
                        }else {
                            System.out.println("You have no items equipped!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                        }
                    }
                    if (input == 2) {
                        if(backpack.isAnyItemInStuff()) {
                            backpack.showContent();
                            System.out.println("Choose an item to equip: " + "\n");
                            input = in.nextInt();
                            if (Backpack.StuffItems[input] == null) {
                                System.out.println("Wrong number!" + "\n");
                                StaticMethods.pressAnyKeyToContinue();
                                continue;
                            }
                            if ((Player.activeTrinket != Backpack.StuffItems[input]) && (Player.activeArmor != Backpack.StuffItems[input]) && (Player.activeSword != Backpack.StuffItems[input])) {
                                backpack.equipAnItem(Backpack.StuffItems[input], player, input);
                            } else {
                                System.out.println("Item is already equipped!" + "\n");
                                StaticMethods.pressAnyKeyToContinue();
                            }
                        }else {
                            System.out.println("You have no items yet!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                            continue;
                        }
                    }else if (input == 3) {
                        if (player.isAnyActiveStuff()) {
                                if (player.activeArmor!=null){
                                    System.out.println("1) Active armor: " + player.activeArmor.getName() + "\n");
                                }
                                if(player.activeSword!=null){
                                    System.out.println("2) Active sword: " + player.activeSword.getName() + "\n");
                                }
                                if(player.activeTrinket!=null){
                                    System.out.println("3) Active trinket: " + player.activeTrinket.getName() + "\n");
                                }
                                System.out.println("Choose an item do unequip: " + "\n");
                                input = in.nextInt();
                                if(input == 1){
                                    Backpack.addItemInStuff(player.activeArmor);
                                    player.removeActiveArmor();
                                }else if(input == 2){
                                    Backpack.addItemInStuff(player.activeSword);
                                    player.removeActiveSword();
                                }else if(input == 3){
                                    Backpack.addItemInStuff(player.activeTrinket);
                                    player.removeActiveTrinket();
                                }
                                continue;
                        }else {
                            System.out.println("You have no items equipped!" + "\n");
                            StaticMethods.pressAnyKeyToContinue();
                            continue;
                        }

                    }else if (input == 4) {
                        System.out.println("\n");
                        break;
                    }
                }
            }else if(userInput == 4){
                StaticMethods.merchant(player, backpack);
            }else if ((userInput == 6) && (Player.passToBoss)){
                while(true){
                    System.out.println("Are you sure?" + "\n" + "1) Yes" + "\n" + "2) No" + "\n");
                    int input = in.nextInt();
                    if(input == 1) {
                        if (StaticMethods.bossFight(player)) {
                            for (int i = 0; i < 10; i++) {
                                System.out.println("YOU WON!!!" + "\n");
                                StaticMethods.waitAMoment(1);
                            }
                            return true;
                        }else {
                            return true;
                        }
                    }else
                        {
                            break;
                        }
                }
            }else if (userInput == 5){
                if(backpack.howManyItems() < backpack.StuffItems.length-1) {
                    return false;
                }else {
                    System.out.println("Your backpack is full! Sell something to enter the dungeon!" + "\n");
                }
            }
            }
        }
    }
