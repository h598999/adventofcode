import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Flytting{

    private static Iterator<String> it;

    public static void main(String[] args) throws IOException{

        List<Stack<String>> arr = findStacks();
        while(it.hasNext()){
            String input = it.next();
            int[] temp = getCommands(input);
            move(arr, temp[0], temp[1], temp[2]);
        }
        for (int i = 0; i<arr.size(); i++){
            System.out.println(arr.get(i).toString());
        }

    }

    public static List<Stack<String>> findStacks() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day5/input.txt"));
      it = reader.lines().iterator();
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        Stack<String> st3 = new Stack<>();
        Stack<String> st4 = new Stack<>();
        Stack<String> st5 = new Stack<>();
        Stack<String> st6 = new Stack<>();
        Stack<String> st7 = new Stack<>();
        Stack<String> st8 = new Stack<>();
        Stack<String> st9 = new Stack<>();
        List<Stack<String>> arr = new ArrayList<Stack<String>>(); 
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        arr.add(st4);
        arr.add(st5);
        arr.add(st6);
        arr.add(st7);
        arr.add(st8);
        arr.add(st9);
        for(int k = 0; k<8; k++){
            String input = it.next();
            char[] temp = input.toCharArray();
            int o = 0;
            for (int i = 1; i<input.length(); i=i+4){
                arr.get(o).add(String.valueOf(temp[i]));
                o++;
            }
        }
        return arr;
    }


    public static void move(List<Stack<String>> arr, int move, int from, int to){
        for (int i = 0; i<move; i++){
            String temp = arr.get(from).pop();
            arr.get(to).add(temp);
        }
    }

    public static int[] getCommands(String input){
        int indexMove = (input.indexOf(" ",0 )) + 1;
        int indexFrom = input.indexOf(" ",indexMove) + 1;
        int indexTo = input.indexOf(" ", indexFrom)+ 1;

        int[] temp = new int[3];
        temp[0] = indexMove;
        temp[1] = indexFrom;
        temp[2] = indexTo;

        return temp;
    }


}




