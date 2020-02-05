import java.io.*;

class BlockShootReload {

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

        } else {
            System.out.println("Only easy is implemented. Starting game on easy");
        }

    }
}