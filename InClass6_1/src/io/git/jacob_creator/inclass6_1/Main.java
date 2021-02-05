package io.git.jacob_creator.inclass6_1;


import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Rock, Paper Scissors, Tape, and Lighter!\nPlease enter \"EXIT\" at anytime to stop the program, and view your results!\n");
        boolean running = true;
        Game game = new Game();
        while(running) {
            System.out.println("\nPlease pick your choice:");
            outputChoices();
            String input = scanner.nextLine();
            try {
                if(input.equalsIgnoreCase("exit")) {
                    running = false;
                }
                else if(input.toLowerCase().contains("simulate")) {
                    String[] arg = input.split(" ");
                    HandChoices hand = HandChoices.getFromAnyRelation(arg[1]);
                    int times = 0;
                    if(arg[2].equalsIgnoreCase("max"))
                        times = Integer.MAX_VALUE;
                    else times = Integer.parseInt(arg[2]);
                    for (int i = 0; i < times; i++) {
                        int finalI = i;
                        Thread t = new Thread(() -> {
                            System.out.println("Simulation " + (finalI +1) + ": " + game.getResult(hand, game.getRandomChoice()).getPastTense().toUpperCase());
                            int fuckMyMemory = 0;
                            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                                fuckMyMemory++;
                                System.out.println("get rekt "  + fuckMyMemory);
                            }
                        });
                        t.run();
                    }
                }
                else {
                    HandChoices player = HandChoices.getFromAnyRelation(input);
                    HandChoices computer = game.getRandomChoice();
                    Game.Results result = game.getResult(player, computer);
                    System.out.println("You picked " +player.getReadableName() + " and "+ result.getPastTense().toUpperCase() + " against the Computer's " + computer.getReadableName() + "!");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("You selected an invalid choice! Please try again by entering the name or id.");
            }
        }

        System.out.println("Good bye. Here are your game results:");
        System.out.println(game.toString());
    }

    private static void outputChoices() {
        for (int i = 0; i < HandChoices.values().length; i++) {
            System.out.println("[" + i + "] - " + HandChoices.values()[i].getReadableName());
        }
        System.out.println("");
    }
}