/*
Next Permutation

 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
import java.util.*;
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int st = find(nums),dis=0;
        int i,len = nums.length;
        if(st==-1){
            Arrays.sort(nums);
        }else{
            replace(nums,st);
            Arrays.sort(nums,st+1,len);
        }
    }
    public void replace(int nums[], int start){
        int temp=nums[start];
        int val = nums[start];
        int len = nums.length;
        int dist = Integer.MAX_VALUE;
        for(int i=start+1; i<len; i++){
            if(val<nums[i] && dist>(nums[i]-val)){
                dist=nums[i]-val;
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public int find(int nums[]){
        int len = nums.length;
        int i=len-1;
        while(i>0 && nums[i]<=nums[i-1]){ i--;}
        return i-1;
    }
}
