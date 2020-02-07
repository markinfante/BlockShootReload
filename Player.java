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

    public String getMediumAction(){
        Random randy = new Random();
        int actionInt;
        if (bullets == 0){
            actionInt = randy.nextInt(2);
            if (actionInt == 0){
                return "reload";
            } else {
                return "block";
            }
        } else {
            actionInt = randy.nextInt(10);
            if (actionInt < 6){
                return "shoot";
            } else if (actionInt < 9){
                return "block";
            } else {
                return "reload";
            }
        }
    }

    public String getHardAction(int bulletCount){
        Random randy = new Random();
        int actionInt;
        // if the opponent has 0 bullets
        if (bullets == 0){
            // and the user has 0 bullets, reload
            if (bulletCount == 0){
                return "reload";
            // if the user does not have zero bullets, reload 20 %
            } else {
                actionInt = randy.nextInt(10);
                if (actionInt < 2){
                    return "reload";
                } else {
                    return "block";
                }
            }
        // if the opponent has any bullets
        } else {
            actionInt = randy.nextInt(100);
            // if the opponent has more than 2 bullets
            // and the user has 0, shoot 90%
            if (bulletCount == 0 && bullets > 2){
                if (actionInt < 90){
                    return "shoot";
                } else {
                    return "reload";
                }
            // if the opponent has 1 or 2 bullets, and the user none, shoot 75%
            } else if (bulletCount == 0){
                if (actionInt < 75){
                    return "shoot";
                } else {
                    return "reload";
                }
            // if the user has 6 or more bullets shoot 15%
            } else if (bulletCount > 5){
                if (actionInt < 15){
                    return "shoot";
                } else if (actionInt < 95){
                    return "block";
                } else {
                    return "reload";
                }
            } else {
                if (actionInt < 20) {
                    return "shoot";
                } else if(actionInt < 85){
                    return "block";
                } else {
                    return "reload";
                }
            }
        }

    }
    
}