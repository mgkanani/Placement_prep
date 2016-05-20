import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Practice_Soldier {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int min=5000,max=0,s1,s2,sum=0,temp;
        int arr[] = new int[8001];
        int i;
        for(i=0;i<n;i++){
            temp = sc.nextInt();
            arr[temp]++;
            if(max<temp)
                max=temp;
        }
        i=0;
        sum=0;
        s1=0;
        for(;s1<n;){
            while(i<8001){
                if(arr[i]==1){
                    s1++;
                }
                if(arr[i]>1){
                    break;
                }
                i++;
            }
            if(s1<n){
                arr[i]--;
                int j=i;
                while(j<8001 && arr[j]!=0){j++;}
                sum+=(j-i);
                arr[j]=1;
            }
        }
        System.out.println(sum);
    }
}
/*

Find first missing, and set all value to unique.

Soldier and Badges



Problem Statement

Colonel has n badges. He wants to give one badge to every of his n soldiers. Each badge has a value written on it (called coolness factor), which can be increased by one for the cost of one coin. For every pair of soldiers one of them should get a badge with strictly higher factor than the second one. Exact values of their coolness factors aren't important. Colonel knows, which soldier is supposed to get which badge initially, but there is a problem. Some of badges may have the same factor of coolness. Help him and calculate how much money has to be paid for making all badges have different factors of coolness.

Input Format

First line of input consists of one integer n (1 ≤ n ≤ 3000). Next line consists of n integers a[i] (1 ≤ a[i] ≤ 4000), which stand for coolness factor of each badge.

Output Format

Output single integer — minimum amount of coins the colonel has to pay.

Sample Input

5

1 2 3 2 5

Sample Output

2

Explanation

we can increase factors of the second and the third badge by 1 or we can increase coolness factor of forth badge by 2



*/