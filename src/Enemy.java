import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Enemy {
    private String name;
    private int hp;
    private int dmg;
    private List<String> catchPhrases = new ArrayList<>();

    void setName(String name) {
        this.name = name;
    }
    void setHp(int hp) {
        this.hp = hp;
    }
    void setDmg(int dmg){
        this.dmg = dmg;
    }

    String getName() {
        return this.name;
    }
    int getHp(){
        return this.hp;
    }
    int getDmg(){
        return this.dmg;
    }
    List<String> getCatchPhrases(){
        return this.catchPhrases;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Hp: " + hp + "\n" + "Dmg: " + dmg + "\n" + "catchPhrases: " + catchPhrases + "\n";
    }
}

class Boss extends Enemy {

}

