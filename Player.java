import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player {

    public String name;
    private final List<String> NAMES = new ArrayList<String>(List.of("Cal 'the Cowboy' Calhoon", "Ginne 'the GunSlinger' Geronimo", "Pete 'the Pistol' Pancreatitus", "RockHard Reid", "Sallie 'the Saloon' Sensuality", "Tyrone 'the Tequila' Texico"));
    public String action;
    public int bullets = 0;
    
    void Player(){}

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setRandomName(){
        Random randy = new Random();
        int length = NAMES.size();
        int randomInt = randy.nextInt(length);
        name = NAMES.get(randomInt);
    }

    public String getEasyAction(){
        Random randy = new Random();
        int actionInt = randy.nextInt(3);
        switch(actionInt){
            case 0: return "block";
            case 1: return "shoot";
            case 2: return "reload";
            default: return "oops";
        }
    }
    
}