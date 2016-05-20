import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Problem Statement

Given an array A={a1,a2,…,aN} of N elements, find the maximum possible sum of a

    Contiguous subarray
    Non-contiguous (not necessarily contiguous) subarray.

Empty subarrays/subsequences should not be considered.

This Youtube video by Ben Wright might be useful to understand the Kadane algorithm for the maximum subarray in a 1-D sequence. 
Input Format

First line of the input has an integer T. T cases follow.
Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

Constraints:

    1≤T≤10
    1≤N≤105
    −104≤ai≤104

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative). 
*/
public class MaxSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int iter=0,i=0;
    while(iter<T){
        int n = sc.nextInt();
        int arr[] = new int[n];
        int max=Integer.MIN_VALUE;
        for(i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(max<arr[i])
                max = arr[i];
        }
        int sum = 0;
        int sum1 = 0;
        for(int x:arr){
            if(sum+x>0){
                sum+=x;
                if(max<sum)
                    max = sum;
            }else{
                sum=0;
            }
            if(x>0)
                sum1+=x;
        }
        sum1 = max<0?max:sum1;
        System.out.println(max+"\t"+sum1);
        iter++;
    }
    }
}