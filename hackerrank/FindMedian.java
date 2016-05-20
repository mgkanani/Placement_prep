/*
Problem Statement

The median of a finite list of numbers can be found by arranging all the integers from lowest to highest value and picking the middle one. For example, the median of {3,3,5,9,11} is 5. If there is an even number of integers, then there is no single middle value, and the median is then usually defined to be the mean of the two middle values. For examples, the median of {3,5,7,9} is (5+7)2=6.

Given that integers are read from a data stream, find the median of elements read so far in an efficient way.

Input Format

The first line of input will contain integer N, i.e. the number of integers in the data stream.
Each of the next N lines will contain an integer ai.

Constraints
1≤N≤105
0≤ai≤105

Output Format

Print N integers, i.e. the median after each of the input. Report it with precision up to 10−1.

Sample Input

10
1
2
3
4
5
6
7
8
9
10

Sample Output

1.0
1.5
2.0
2.5
3.0
3.5
4.0
4.5
5.0
5.5

Explanation

See the sorted list after each input.
*/

import java.util.*;

public class FindMedian {

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
        int val=0,root;
        for(int i=0;i<n;i++){
            val = sc.nextInt();
            if(!maxhp.isEmpty()){
                root=maxhp.peek();
                if(val<=root)
                    maxhp.add(val);
                else
                    minhp.add(val);
            }else{
                maxhp.add(val);
            }
            balance(maxhp,minhp);
            if((i&1)==0){//odd numbers
                System.out.println(maxhp.peek());
            }else{
                int v1=maxhp.peek();
                int v2 = minhp.peek();
                System.out.println((float)(v1+v2)/2);
            }
        }
    }
    public static void balance(PriorityQueue<Integer> maxhp, PriorityQueue<Integer> minhp){
        int s1=maxhp.size();
        int s2=minhp.size();
        int j=0;
        if(s1>s2+1){
            while(maxhp.size()>minhp.size()+1){
                j = maxhp.remove();
                minhp.add(j);
            }            
        }else{
            while(maxhp.size()<minhp.size()){
                j = minhp.remove();
                maxhp.add(j);
            }
        }
    }
}