import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pairs {
    static int pairs(int[] a,int k) {
      /* Complete this function */
        Arrays.sort(a);
        int t1=-1,t2=-1;
        int cnt=0;
        for(int i:a){
            t1 = Arrays.binarySearch(a,i-k);
            if((t1>-1)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
/*
Problem Statement

Given N integers, count the number of pairs of integers whose difference is K.

Input Format

The first line contains N and K.
The second line contains N numbers of the set. All the N numbers are unique.

Output Format

An integer that tells the number of pairs of integers whose difference is K.

Constraints:
N≤105
0<K<109
Each integer will be greater than 0 and at least K smaller than 231−1.


*/