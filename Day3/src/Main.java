import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
java.util.Iterator;

public class Main{
    
    public static void main(final String[] args) throws IOException{
        finnPriFor2Sekker();
        finnPriFor3Sekker();


    }

    public static void finnPriFor3Sekker() throws IOException{
        final BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day3/input2.txt"));
        final Iterator<String> it = reader.lines().iterator();
        int i = 1;
        int sum = 0;
        while(it.hasNext()){
            System.out.println("Gruppe: " + i);
                final String input1 = it.next();
                final String input2 = it.next();
                final String input3 = it.next();

                i++;
                System.out.println(input1);
                System.out.println(input2);
                System.out.println(input3);
                sum += getPriority(finnFellesFor3(input1, input2, input3));
        }

        System.out.println(sum);
        reader.close();
    }

    public static void finnPriFor2Sekker() throws IOException{

        final BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day3/input.txt"));

        final Iterator<String> it = reader.lines().iterator();

        int sum = 0;
        while(it.hasNext()){
            final String input = it.next();

            final char[] firstHalf = input.substring(0, (input.length())/2).toCharArray();
            final char[] secondHalf = input.substring((input.length()/2), input.length()).toCharArray();
            
            sum += getPriority(finnFelles(firstHalf, secondHalf));


        }     
        System.out.println("Sum: " + sum);
        reader.close();
    }
    
    public static char finnFelles(final char[] arr1, final char[] arr2){
            for (int i = 0; i<arr1.length; i++){
                if (finnes(arr2, arr1[i])){
                    return arr1[i];
                }
            }
            return ' ';
    }

    public static char finnFellesFor3(final String str1, final String str2, final String str3){
        final char[] arr1 = str1.toCharArray();
        final char[] arr2 = str2.toCharArray();
        final char[] arr3 = str3.toCharArray();
        
        for (int i = 0; i<arr1.length; i++){
            if (finnes(arr2, arr1[i])&&finnes(arr3, arr1[i])){
                return arr1[i];
            }
        }
        return ' ';
    }

    private static boolean finnes(final char[] arr, final char finnes){
        boolean funnet = false;
        int i = 0;
        while(!funnet&&i<arr.length){
            if (arr[i]==finnes){
               funnet = true; 
            } else {
                i = i+1;
            }
        }
        return funnet;
    }
    
    private static int getPriority(final char verdi){
        if (Character.isLowerCase(verdi)){
            return verdi - 'a' + 1;
        } else if (Character.isUpperCase(verdi)){
            return verdi - 'A' + 27;
        } else {
            return 0;
        }
    }


}
