import java.util.Random;
import java.util.concurrent.TimeUnit;

class Level {
    Location location;
    Enemy enemy;
    Item item;

    static boolean fight(Player player, Enemy enemy){
        Random random = new Random();
        int timeout = 1;

        StaticMethods.pressAnyKeyToContinue();
        String[] fightAnnouncements = new String[]{player.getPlayerName() +  ", do you have enough boldness to challenge a notorious " + enemy.getName() + "?" + "\n",
                "Let the slaughter begin!" + "\n" + "Fight for your life!"};
        System.out.println(fightAnnouncements[random.nextInt(fightAnnouncements.length)]);
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }
        catch (Exception e){}
        while (true) {
            int phraseId = random.nextInt(enemy.getCatchPhrases().size()-1);
            try {
                TimeUnit.SECONDS.sleep(timeout);
            }
            catch (Exception e){}
            System.out.println(enemy.getName() + " yells: \"" + enemy.getCatchPhrases().get(phraseId) + "\"" + "\n");
            System.out.println(player.getPlayerName() + " inflicts " + player.getDmg() + " damage to " + enemy.getName() + "!" + "\n");
            enemy.setHp(enemy.getHp() - player.getDmg());
            System.out.println("Your hp: " + player.getHp() + "    Enemy hp: " + enemy.getHp() + "\n");
            if (enemy.getHp() <= 0) {
                System.out.println("You won! " + enemy.getName() + " is defeated!" + "\n");
                return true;
            }
            try {
                TimeUnit.SECONDS.sleep(timeout);
            }
            catch (Exception e){}

            System.out.println(enemy.getName() + " inflicts " + enemy.getDmg() + " damage to " + player.getPlayerName() + "!" + "\n");
            player.setHp(player.getHp() - enemy.getDmg());
            System.out.println("Your hp: " + player.getHp() + "    Enemy hp: " + enemy.getHp() + "\n");
            if (player.getHp() <= 0) {
                System.out.println("You lose!");
                return false;
            }
            try {
                TimeUnit.SECONDS.sleep(timeout);
            }
            catch (Exception e){}
        }
    }


}
