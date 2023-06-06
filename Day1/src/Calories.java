import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.*;

public class Calories{
    
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/jonas/Prosjekt/AdventOfCode/Java/Day1/input.txt"));
            Iterator it = reader.lines().iterator();
            int[] storste = new int[3];
            storste[0] = 0;
            storste[1] = 0;
            storste[2] = 0;
            int temp = 0;
            while(it.hasNext()){
                String temp1 = it.next().toString();
                if (!temp1.equals("")){
                    int konvertert = Integer.parseInt(temp1);
                    temp = temp + konvertert;

                } else {
                   if (temp>storste[0]){
                       storste[0] = temp;
                   } 
                   sort(storste, 0, 2);
                    temp = 0;
                }
            }
            int mega = 0;
            for (int i = 0; i<storste.length; i++){
            System.out.println("Storste" + i + ": " + storste[i]);
            mega+=storste[i];
            }
            System.out.println(mega);
            try {
            reader.close();
            } catch(IOException x){
                System.out.println(x.getMessage());
            }
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally{
            System.out.println("Done");
        }
    }

    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }



}
