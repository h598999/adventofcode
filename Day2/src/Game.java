import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Game{
    private static final char Rock = 'A';
    private static final char Paper = 'B'; 
    private static final char Scissors = 'C';
    private static final char MeRock = 'X';
    private static final char MePaper = 'Y';
    private static final char MeScissors = 'Z';
    private static final int RockPoints = 1;
    private static final int PaperPoints = 2;
    private static final int ScissorsPoints = 3;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day2/src/input.txt"));
        Iterator<String> it = reader.lines().iterator();
        int totalPoints = 0;
        while(it.hasNext()){
            String temp = it.next();
            if (temp!=null){
                char opponent = (char)temp.getBytes()[0];
                char outcome = (char)temp.getBytes()[2];
                char me = getPlay(outcome, opponent);
                totalPoints += calculatePoints(opponent, me);
            }
        }
        System.out.println("TotalPoints: " + totalPoints);
        reader.close();
    }

    public static int calculatePoints(char opponent, char me){
        int outcome = calculateOutcome(opponent, me);
        int played = 0;
        if (me == MeRock){
            played = RockPoints;
        }
        if (me == MeScissors){
            played = ScissorsPoints;
        }
        if (me == MePaper){
            played = PaperPoints;
        }
        return outcome + played;
    }

    public static int calculateOutcome(char opponent, char me){
        if (opponent == Rock && me == MeRock){
            return 3;
        }
        else if (opponent == Scissors && me == MeScissors){
            return 3;
        }
        else if(opponent == Paper && me == MePaper){
            return 3;
        }
        if (opponent == Rock&&me == MeScissors){
            return 0;
        }
        else if (opponent == Scissors&&me == MePaper){
            return 0;
        }
        else if (opponent == Paper&&me == MeRock){
            return 0;
        }
        else{
            return 6;
        }
    }

    public static char getPlay(char outcome, char opponent){
        if (outcome == 'X'){
            if (opponent == Rock)
                return MeScissors;
            if (opponent == Paper)
                return MeRock;
            if (opponent == Scissors)
                return MePaper;
        }
        if (outcome == 'Y'){
            if (opponent == Rock)
                return MeRock;
            if (opponent == Paper)
                return MePaper;
            if (opponent == Scissors)
                return MeScissors;
        }
        if (outcome == 'Z'){
            if (opponent == Rock)
                return MePaper;
            if (opponent == Paper)
                return MeScissors;
            if (opponent == Scissors)
                return MeRock;
        }
        return 'K';
    }

}
