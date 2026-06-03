package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Question {


    private String text;
    private ArrayList<String> options;
    private int indexAnswer;
    private Item reward;

    public Question(String text, ArrayList<String> options, int indexAnswer, Item reward) {
        this.text = text;
        this.options = options;
        this.indexAnswer=indexAnswer;
        this.reward = reward;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getIndexAnswer() {
        return indexAnswer;
    }

    public Item getReward() {
        return reward;
    }


}

