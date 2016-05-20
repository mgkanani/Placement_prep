/*
Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
import java.util.*;
public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> que = new PriorityQueue<String>(nums.length, new Comparator<String>(){
            public int compare(String s1, String s2){
                String t1 = s1+s2;
                String t2 = s2+s1;
                return -t1.compareTo(t2);
            }
        });
        String s1=null;
        int total=0;
        for(int i:nums){
            s1 = i+"";
            total += s1.length();
            que.offer(s1);
        }
        StringBuilder br = new StringBuilder(total);
        while(!que.isEmpty()){
            br.append(que.poll());
        }
        return br.toString().matches("0*")?"0":br.toString();
    }
}