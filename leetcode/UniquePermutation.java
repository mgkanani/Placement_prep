import java.util.*;
public class UniquePermutation {
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
        if(len>1){
            i=0;
            j=1;
            int cnt=0;
            while(nums[i]==nums[j] && cnt<len){ 
                j = (j+len+1)%len;
                i = (i+len+1)%len;
                cnt++;
            }
            int temp=nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            while(!equals(start,nums)){//if all nums are same then it never reach into this loop.
                System.out.println(i+"\t"+j);
                list.add(toArrayList(nums));
                j = (j+len+1)%len;
                i = (i+len+1)%len;
                while(nums[i]==nums[j]){
                    j = (j+len+1)%len;
                    i = (i+len+1)%len;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                System.out.println(i+"\t"+j);
            }
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
    public static void main(String[] args) {
        UniquePermutation u = new UniquePermutation();
        int a[]={2,2,1,1};
        System.out.println(u.permuteUnique(a));
    }
}