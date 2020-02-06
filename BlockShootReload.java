import java.io.*;

class BlockShootReload {

    public Player user = new Player();
    public Player opponent;
    public boolean gameOver = false;
    public int errorCount = 0;

    void BlockShootReload(){

    }

    void printIntro(){

        System.out.println("Welcome to Block, Shoot, Reload.");
        System.out.println("The aim of the game is to shoot the computer before it shoots YOU.");
        System.out.println("You will input whether you would like to block(b), shoot(s), or reload(r).");
        System.out.println("You cannot shoot before reloading, and blocking will nullify the opposing player's shot.");
        System.out.println("Try and survive!");

    }

    void printDifficulty(){

        System.out.println("Would you like to play on easy, medium or difficult?");

    }

    public String getUserString(){

        String output;
        // open up readers to take user input and convert to string
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            output = br.readLine().toLowerCase().trim();
            return output;
        }
        catch (IOException io){
            System.out.print(io);
            return "oops.";
        }

    }

    public void compareActions(String userAction, String opponentAction){
        if (userAction.equals("reload") || userAction.equals("r")){
            user.bullets++;
            if (opponentAction.equals("shoot")){
                if (opponent.bullets>0){
                    System.out.println(opponent.name + " shot you! YOU LOSE!");
                    gameOver = true;
                } else {
                    System.out.println("Your opponent tried to shoot you but had no bullets.");
                }
                
            } else if (opponentAction.equals("reload")){
                opponent.bullets++;
                System.out.println("Your opponent reloaded. Beware, they get another shot!");
            } else {
                System.out.println(opponent.name + " blocked.");
            }
        } else if (userAction.equals("shoot") || userAction.equals("s")){
            if (user.bullets > 0){
                user.bullets--;
                if (opponentAction.equals("block")){
                    System.out.println(opponent.name + " blocked your shot.");
                } else if (opponentAction.equals("shoot")){
                    if (opponent.bullets > 0){
                        System.out.println("This one is a draw, keep shooting!");
                        opponent.bullets--;
                    } else {
                        System.out.println("Your opponent tried to shoot you but had no bullets. YOU WIN!");
                        gameOver = true;
                    }
                    
                } else {
                    System.out.println("YOU WIN! You're the greatest shooter in all the land.");
                    gameOver = true;
                }
            } else {
                System.out.println("You don't have any bullets!");
                if (opponentAction.equals("block")){
                    System.out.println("Your opponent tried to block anyway.");
                } else if (opponentAction.equals("shoot")){
                    if (opponent.bullets > 0){
                        System.out.println("Your opponent shot you. You feel the darkness closing in. It feels like your body is floating. A beautiful angel whispers in your ear... 'How many times do we have to teach you this lesson old man?! \n*pause* \nIs there anything you'd like me to tell your family?");
                        getUserString();
                        System.out.println("Really? Yeah... I'm not doing that. \n The angels words echo in your head as the blood starts to pour down your throat... Soon your lungs will fill and you'll asphyxiate. Hey! At least you got to see " + opponent.name + " one more time... they were a good lay.");
                        gameOver = true;
                    } else {
                        System.out.println("Your opponent tried to shoot but also had no bullets.");
                    }
                } else {
                    opponent.bullets++;
                    System.out.println("Your opponent reloaded.");
                }
            }
        } else if (userAction.equals("block") || userAction.equals("b")){
            if (opponentAction.equals("shoot")){
                if (opponent.bullets > 0 ){
                    System.out.println("You blocked " + opponent.name + "'s shot. Keep shooting!");
                    opponent.bullets--;
                } else {
                    System.out.println("You tried to block " + opponent.name + "'s shot but they didn't even have any bullets.");
                }
                
            } else if (opponentAction.equals("block")){
                System.out.println("You both blocked. Smart...");
            } else {
                opponent.bullets++;
                System.out.println("Your opponent reloaded. Beware, they get another shot!");
            }
        } else {
            if (errorCount > 2){
                System.out.println("How many times do we have to teach you this lesson old man!!");
            }
            errorCount++;
            System.out.println("You can only block, shoot, or reload.");
        }
    }

    public static void main(String[] args){
        // If given any arguments print help message and terminate.
        if (args.length > 1) {
            System.out.println("BlockShootReload takes no arguments.");
            System.exit(1);
        }
        BlockShootReload newGame = new BlockShootReload();
        newGame.printIntro();
        newGame.printDifficulty();
        newGame.opponent = new Player();
        newGame.opponent.setRandomName();
        String difficulty = newGame.getUserString();
        if (difficulty.equals("easy")){
            System.out.println("Okay. Starting game on easy.");
            System.out.println("You are playing " + newGame.opponent.getName() + ".");
            while(!newGame.gameOver){
                System.out.println("What would you like to do?");
                newGame.user.action = newGame.getUserString();
                newGame.opponent.action = newGame.opponent.getEasyAction();
                newGame.compareActions(newGame.user.action, newGame.opponent.action);
            }
        } else if (difficulty.equals("medium")){
            System.out.println("Okay. Starting game on medium.");
            System.out.println("You are playing " + newGame.opponent.getName() + ".");
            while(!newGame.gameOver){
                System.out.println("What would you like to do?");
                newGame.user.action = newGame.getUserString();
                newGame.opponent.action = newGame.opponent.getMediumAction();
                newGame.compareActions(newGame.user.action, newGame.opponent.action);
            }
        } else if (difficulty.equals("hard")){
            System.out.println("Only easy is implemented. Starting game on easy");
            System.out.println("You are playing " + newGame.opponent.getName() + ".");
            while(!newGame.gameOver){
                System.out.println("What would you like to do?");
                newGame.user.action = newGame.getUserString();
                newGame.opponent.action = newGame.opponent.getEasyAction();
                newGame.compareActions(newGame.user.action, newGame.opponent.action);
            }
        } else {
            System.out.println("Thats not valid. Ending game.");
        }
        

    }
}