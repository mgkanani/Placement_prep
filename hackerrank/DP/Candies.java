import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Problem Statement

Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line, and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

1 <= N <= 105
1 <= ratingi <= 105

Output Format

Output a single line containing the minimum number of candies Alice must buy.
*/
public class Candies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int candies[] = new int[n];
        int i;
        for(i=0;i<n;i++)
            arr[i] = sc.nextInt();
        candies[0]=1;
        for(i=1;i<n;i++){
            if(arr[i]>arr[i-1])
                candies[i]=candies[i-1]+1;
            else
                candies[i] = 1;
        }
        for(i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1])
                candies[i] = Math.max(candies[i+1]+1,candies[i]);
        }
        long sum=0;
        for(i=0;i<n;i++){
            //System.out.println(candies[i]);
            sum+=candies[i];
        }
        System.out.println(sum);
    }
}