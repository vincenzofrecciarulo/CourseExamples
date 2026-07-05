package org.generation.italy.examples.tropico;

public enum ConsoleChoices {
    SHOW_ALL(1, "See all citizens"),
    DELETE(2, "Delete a citizen"),
    ADD(3, "Add a citizen"),
    FIND_BY_GENDER_EDU(4, "Find citizens by gender and education level"),
    CHANGE_HAPPINESS(5, "Change the happiness level of a citizen"),
    QUIT(6, "Exit");

    private final int number;
    private final String prompt;

    ConsoleChoices(int number, String prompt) {
        this.number = number;
        this.prompt = prompt;
    }

    public int getNumber() {
        return number;
    }

    public String getPrompt() {
        return prompt;
    }

    public static ConsoleChoices fromNumber(int number) {
        for (ConsoleChoices choice : ConsoleChoices.values()) {
            if (choice.getNumber() == number) {
                return choice;
            }
        }
        throw new IllegalArgumentException("Invalid choice number: " + number);
    }
}
