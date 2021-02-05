package io.git.jacob_creator.inclass6_1;

import static io.git.jacob_creator.inclass6_1.HandChoices.*;

public class Game {

    private int wins, losses, draws;

    public enum Results {
        WIN("won"),
        DRAW("tied"),
        LOSS("lost");

        private final String pastTense;
        Results(String pastTense) {
            this.pastTense = pastTense;
        }

        public String getPastTense() {
            return pastTense;
        }
    }

    public Results getResult(HandChoices player1, HandChoices ai) {
        //IF THEY PICKED THE SAME THING
        if(player1 == ai) {
            draws++;
            return Results.DRAW;
        }
        //if the next hand choice in line (they always lose to next one) is what the ai picked
        else if(player1.getNext().getCyclePosition() == ai.getCyclePosition()) {
            losses++;
            return Results.LOSS;
        }
        //inverse of losing.
        else if(ai.getNext().getCyclePosition() == player1.getCyclePosition()) {
            wins++;
            return Results.WIN;
        }
        draws++;
        return Results.DRAW; //this will happen if they pick something that isn't inline with each other. Example: Rock(2) and Lighter(4)
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getWins() {
        return wins;
    }

    public HandChoices getRandomChoice() {
        double ran = Math.random(); //random double between 0 and 1
        if(ran <= .2) {
            return PAPER;
        }
        else if(ran <= .4) {
            return SCISSORS;
        }
        else if(ran <= .6) {
            return ROCK;
        }
        else if(ran <= .8) {
            return TAPE;
        }
        return LIGHTER;
    }

    @Override
    public String toString() {
        return "Game {\n" +
                "\twins=" + wins + ",\n" +
                "\tlosses=" + losses + ",\n" +
                "\tdraws=" + draws + "\n" +
                '}';
    }
}