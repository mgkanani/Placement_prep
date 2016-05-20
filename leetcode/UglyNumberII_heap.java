import java.util.*;
/*
Ugly Number II

 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
*/
public class UglyNumberII_heap {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> que = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        que.add((long)1);
        set.add((long)1);
        long elem=-1,temp=-1;
        int i=1,cnt=0;
        while(cnt<n){
            elem = que.poll();
            set.remove(elem);
            temp =elem*2;
            if(!set.contains(temp) && temp>0){
                que.add(temp);
                set.add(temp);
            }
            temp =elem*3;
            if(!set.contains(temp) && temp>0){
                que.add(temp);
                set.add(temp);
            }
            temp =elem*5;
            if(!set.contains(temp) && temp>0){
                que.add(temp);
                set.add(temp);
            }
            i<<=1;
            cnt++;
        }
        while(cnt<n){
            elem = que.poll();
            cnt++;
        }
        //System.out.println(elem);
        return (int)elem;
    }
}