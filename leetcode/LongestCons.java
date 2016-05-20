import java.util.*;
public class LongestCons {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int len = nums.length;
        int i=0;
        for(i=0;i<len;i++){
            map.put(nums[i],true);
        }
        int range=0,max=1,temp;
        for(int k=0;k<len && !map.isEmpty();k++){
            i = nums[k];
            range=0;
            while(map.containsKey(i)){
                range++;
                map.remove(i);
                i++;
            }
            i=nums[k]-1;
            while(map.containsKey(i)){
                map.remove(i);
                i--;
                range++;
            }
            if(range>max)
                max=range;
        }
       if(range>max)
            max=range;
        return max;
    }
}
/*
Longest Consecutive Sequence

 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
*/