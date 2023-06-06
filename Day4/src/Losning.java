import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Losning{
    
    public static void main(String[] args) throws IOException{
        findContained();
        findOverlap();
    }

    public static void findContained() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day4/input.txt"));
        Iterator<String> it = reader.lines().iterator();
        int sum = 0;
        while(it.hasNext()){
            String input = it.next();
            int index = input.indexOf('-', 0);
            int indexComma = input.indexOf(',',index);
            int index2 = input.indexOf('-', indexComma);
            int number1pers1 = Integer.valueOf(input.substring(0, index));
            int number2pers1 = Integer.valueOf(input.substring(index+1,indexComma));

            int number1pers2 = Integer.valueOf(input.substring(indexComma+1, index2));
            int number2pers2 = Integer.valueOf(input.substring(index2+1, input.length()));
            /*
            System.out.print("number1pers1: " + number1pers1);
            System.out.println(" number2pers1: " + number2pers1);
            System.out.print("number1pers2: " + number1pers2);
            System.out.println("number2pers2: " + number2pers2);
            */
            Set<Integer> pers1 = new HashSet<Integer>();
            Set<Integer> pers2 = new HashSet<Integer>();

            for (int i = number1pers1; i<=number2pers1; i++){
                pers1.add(i);
            }
            for (int i = number1pers2; i<=number2pers2; i++){
                pers2.add(i);
            }
            if (containsAll(number1pers1, number2pers1, number1pers2, number2pers2)){
                sum++;
            }
        }

        System.out.println("Sum: " + sum);

        reader.close();
    }


    public static void findOverlap() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day4/input.txt"));
        Iterator<String> it = reader.lines().iterator();
        int sum = 0;
        while(it.hasNext()){
            String input = it.next();
            int index = input.indexOf('-', 0);
            int indexComma = input.indexOf(',',index);
            int index2 = input.indexOf('-', indexComma);
            int number1pers1 = Integer.valueOf(input.substring(0, index));
            int number2pers1 = Integer.valueOf(input.substring(index+1,indexComma));

            int number1pers2 = Integer.valueOf(input.substring(indexComma+1, index2));
            int number2pers2 = Integer.valueOf(input.substring(index2+1, input.length()));
            if (overlaps(number1pers1, number2pers1, number1pers2, number2pers2)){
                sum += 1;
            }
        }
        System.out.println("Sum: " + sum);
        reader.close();
    }

    private static boolean containsAll(int number1pers1, int number2pers1, int number1pers2, int number2pers2){
        if (number1pers1<=number1pers2 && number2pers1 >= number2pers2){
            return true;
        }
        if(number1pers2<=number1pers1 && number2pers2>=number2pers1){
            return true;
        }
        return false;
    }

    private static boolean overlaps(int number1pers1, int number2pers1, int number1pers2, int number2pers2){
        if (number1pers1>=number1pers2&&number1pers1<=number2pers2){
            return true;
        }
        if (number1pers2>=number1pers1&&number1pers2<=number2pers1){
            return true;
        }
        return false;
    }
}
