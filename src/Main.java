import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        game:
        while (true) {
            String pathToLocations = "/media/leonid/D/Idea/ConsGame/src/Locations.json";
            String pathToEnemies = "/media/leonid/D/Idea/ConsGame/src/Enemies.json";
            Random random = new Random();

            Scanner in = new Scanner(System.in);
            System.out.println("New game!");
            System.out.print("Enter your name:" + "\n");
            String chosenName = in.nextLine();
            String chosenRace;
            while (true) {
                System.out.println("Choose your race:" + "\n" + "1) Human" + '\n' + "2) Orc");
                String race = in.nextLine();
                if (race.equals("1") || race.toLowerCase().equals("human")) {
                    chosenRace = "human";
                    break;
                }
                if (race.equals("2") || race.toLowerCase().equals("orc")) {
                    chosenRace = "orc";
                    break;
                }
            }
            Player player = new Player(chosenRace, chosenName);
            player.showInfo();
            Backpack backpack = new Backpack();
            Item mirror = new Item("Mirror", 10);
            backpack.addItem(mirror);
            mirror.showStats();
            Sword ironSword = new Sword("Iron Sword", 9, 100);
            backpack.addItem(ironSword);
            ironSword.showStats();
            player.showInfo();
            //asd

            JSONParser reader = new JSONParser();
            List<Location> locationList = reader.getLocations(pathToLocations);
            List<Enemy> enemyList = reader.getEnemies(pathToEnemies);

            while (enemyList.size() > 0){
                Enemy enemy = enemyList.get(random.nextInt(enemyList.size()));
                enemyList.remove(enemy);
                if (!Level.fight(player, enemy)) {
                    break game;
                }
            }


            System.out.println("\n" + "Play again? (yes/no)");
            String playAgain = in.nextLine();
            if (playAgain.equals("no")) {break;}
        }
    }
}

