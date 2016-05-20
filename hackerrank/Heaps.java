import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Max heap and min heap examples.
*/

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> minhp = new PriorityQueue<Integer>(n/2);
        PriorityQueue<Integer> maxhp = new PriorityQueue<Integer>((n+1)/2, new Comparator<Integer>(){
            public int compare(Integer x,Integer y){
                return y-x;
            }
        });
        
        for(int i=0;i<10;i++){
            maxhp.add(i);
            minhp.add(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(maxhp.remove()+"\t"+minhp.remove());
        }
    }
}