import java.io.*;

class BlockShootReload {

    public Player user = new Player();
    public Player opponent;
    public boolean gameOver = false;

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
                System.out.println(opponent.name + " shot you! YOU LOSE!");
                gameOver = true;
            } else if (opponentAction.equals("reload")){
                System.out.println("Your opponent reloaded. Beware, they get another shot!");
            } else {
                System.out.println(opponent.name + " blocked.");
            }
        } else if (userAction.equals("shoot") || userAction.equals("s")){
            if (user.bullets > 0){
                if (opponentAction.equals("block")){
                    System.out.println(opponent.name + " blocked your shot.");
                } else if (opponentAction.equals("shoot")){
                    System.out.println("This one is a draw, keep shooting!");
                } else {
                    System.out.println("YOU WIN! You're the greatest shooter in all the land.");
                    gameOver = true;
                }
            } else {
                System.out.println("You don't have any bullets!");
            }
        } else if (userAction.equals("block") || userAction.equals("b")){
            if (opponentAction.equals("shoot")){
                System.out.println("You blocked " + opponent.name + "'s shot. Keep shooting!");
            } else if (opponentAction.equals("block")){
                System.out.println("You both blocked. Smart...");
            } else {
                System.out.println("Your opponent reloaded. Beware, they get another shot!");
            }
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
        if (newGame.getUserString().equals("easy")){
            System.out.println("Okay. Starting game on easy.");
            newGame.opponent = new Player();
            newGame.opponent.setRandomName();
            System.out.println("You are playing " + newGame.opponent.getName() + ".");
        } else {
            System.out.println("Only easy is implemented. Starting game on easy");
        }
        while(!newGame.gameOver){
            System.out.println("What would you like to do?");
            newGame.user.action = newGame.getUserString();
            newGame.opponent.action = newGame.opponent.getEasyAction();
            newGame.compareActions(newGame.user.action, newGame.opponent.action);
        }

    }
}