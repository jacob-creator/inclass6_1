package io.git.jacob_creator.inclass6_1;

import java.util.Locale;

public enum HandChoices {
    PAPER("Paper"),
    SCISSORS("Scissors"),
    ROCK("Rock"),
    TAPE("Tape"),
    LIGHTER("Lighter");

    //the name that should be used in game outputs;
    private final String readableName;
    HandChoices(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    public int getCyclePosition() {
        return this.ordinal();
    }

    public HandChoices getNext() {
        //if this is the last choice return the first one.
        if(getCyclePosition() == HandChoices.values().length-1) {
            return HandChoices.values()[0];
        }
        return HandChoices.values()[this.getCyclePosition() +1];
    }

    public static HandChoices getFromAnyRelation(String input) throws IllegalArgumentException {
        if(input.chars().allMatch(Character::isDigit)) {
            int id = Integer.valueOf(input);
            if(HandChoices.values().length > id) {
                return HandChoices.values()[id];
            }
        }
        return HandChoices.valueOf(input.toUpperCase());
    }

}