/*
 * Dice Cup Problem states start with 2 inputs on the same line, between 4 and 20.
 * Then print out the modes (number that occurs the most), in order smallest to largest.
 * Condensed without comments is 39 lines.
 */ 

import java.util.Scanner;

public class DiceCup {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int n;
        int m;
        
        // Receive input, only while between our 4 and 20 limit.
        do {
            n = input.nextInt();
            m = input.nextInt();
        } while (n < 4 || n > 20 || m < 4 || m > 20);
        
        // Nested loop to fill an array with all the possible additions between
        // The two die
        int firstCount = 0;
        int[] xArray = new int[n * m];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m ; j++){
                xArray[firstCount] = i + j;
                firstCount++;
            }
        }
        
        // Count all the occurences of the possibilites of the two die
        // And find max, the mode
        int max = 0;
        int[] yArray = new int[n + m + 1];
        for (int i = 1; i <= yArray.length - 1; i++){
            for (int j = 0; j < xArray.length; j++){
                if(xArray[j] == i){
                    yArray[i] += 1;
                }
                if(yArray[i] > max){
                    max = yArray[i];
                }
            }
        }
        
        // Increases count while checking to see which numbers are the mode,
        // Prints the count as that index
        int count = 0;
        for (int i = 1; i <= yArray.length - 1; i++){
             count++;
             if(yArray[i] == max){
                 System.out.println(count);
             }
             
         }
         
    }
    
}
