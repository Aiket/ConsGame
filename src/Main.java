import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.lang.Enum;

public class Main {
    public static void main(String[] args) {
        game:
        while (true) {
            String pathToLocations = "src/resources/Locations.json";
            String pathToEnemies = "src/resources/Enemies.json";
            Random random = new Random();
            Scanner in = new Scanner(System.in);

            System.out.println("New game!");
            System.out.print("Enter your name:" + "\n");
            String chosenName = in.nextLine();
            Player.Race chosenRace;
            while (true) {
                System.out.println("Choose your race:" + "\n" + "1) Human" + '\n' + "2) Orc");
                String race = in.nextLine();
                if (race.equals("1") || race.toLowerCase().equals("human")) {
                    chosenRace = Player.Race.HUMAN;
                    break;
                }
                if (race.equals("2") || race.toLowerCase().equals("orc")) {
                    chosenRace = Player.Race.ORC;
                    break;
                }
                if (race.equals("3") || race.toLowerCase().equals("gnome")) {
                    chosenRace = Player.Race.GNOME;
                    break;
                }
            }
            Player player = new Player(chosenRace, chosenName);
            Backpack backpack = new Backpack();
            Apple apple = new Apple();
            Pie pie = new Pie();


            JSONParser reader = new JSONParser();
            List<Location> locationList = reader.getLocations(pathToLocations);
            List<Enemy> enemyList = reader.getEnemies(pathToEnemies);
            playerInterface.playerMainInterface(player, backpack, apple, pie);

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

