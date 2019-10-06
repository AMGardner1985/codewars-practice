package com.gardner.adam.codewarspractice.PrizeDraw;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrizeDraw {

    public static  String nthRank(String names, Integer[] weights, int n){
        if(names.isEmpty())
            return  "No participants";

        String[] participants = names.split(",");

        if (participants.length < n)
            return "Not enough participants";


        List<Participant> participantList =
                //basically a for loop by stream format
                IntStream.range(0, participants.length)
                        //basically do this action on each of the things in the stream
                        .mapToObj(i -> new Participant(weights[i], participants[i]))

                        //sort the stream first by winning number then name
                        .sorted(Comparator.comparing(Participant::getWinningNumber).reversed()
                        .thenComparing(Comparator.comparing(Participant::getName)))

                        //put it all back into a list
                        .collect(Collectors.toList());

        return participantList.get(n - 1).getName();

    }

}

class Participant{

    private String name;
    private int weight;
    private int winningNumber;

    public Participant(int weight, String name){
        this.weight = weight;
        this.name = name;
        setWinningNumber();
    }

    private void setWinningNumber() {
        int score = name.length();
        for (char ch: name.toLowerCase().toCharArray()) {
            int letterAlphabetScore = ch - 'a' + 1;
            score += letterAlphabetScore;
        }
        winningNumber = (score * weight);
    }

    public String getName() {
        return name;
    }

    public int getWinningNumber() {
        return winningNumber;
    }
}
