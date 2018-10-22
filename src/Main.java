import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.lang.Enum;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        gameOver:
        while (true) {
            startOver:
            while (true) {
                Random random = new Random(System.currentTimeMillis());

                System.out.println("New game!");
                System.out.print("Enter your name:" + "\n");
                String chosenName = in.nextLine();
                Player.Race chosenRace;
                while (true) {
                    System.out.println("Choose your race:" + "\n" + "1) Human" + '\n' + "2) Orc" + '\n' + "3) Gnome");
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
                while (true) {
                    if (PlayerInterface.playerMainInterface(player, backpack)) {
                        break startOver;
                    } else {
                        if (!StaticMethods.dungeonJourney(player, backpack)) {
                            break startOver;
                        }
                    }
                }
            }
                System.out.println("\n" + "Game over!" + "\n" + "Play again? (yes/no)");
                String playAgain = in.nextLine();
                if (playAgain.toLowerCase().equals("no")) {
                    break gameOver;
                }
            }
        }
    }


