import java.util.*;
/*
repeted permutations will be ignored.
*/
public class UniquePermutations {
        public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len==0)
            return list;
        int i,j;
        int start[] = new int[nums.length];
        for(i=0;i<len;i++)
            start[i] = nums[i];
        list.add(toArrayList(start));
        nextPermutation(nums);
        while(!equals(start,nums)){
            list.add(toArrayList(nums));
            nextPermutation(nums);
        }
        return list;
    }
    public boolean equals(int a1[] , int a2[]){
        int len = a1.length;
        for(int i=0;i<len; i++){
            if(a1[i]!=a2[i])
                return false;
        }
        return true;
    }
    
    public List<Integer> toArrayList(int arr[]){
        List<Integer> list = new ArrayList<Integer>();
        for (int i:arr)
            list.add(i);
        return list;
    }

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