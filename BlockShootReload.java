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

    public static void main(String[] args){

        BlockShootReload newGame = new BlockShootReload();
        newGame.printIntro();

    }
}