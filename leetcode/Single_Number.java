public class Single_Number {
    /*
     Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
    */
    public int singleNumber(int[] nums) {
        int arr[]= new int[32];
        int j;
        for(int i:nums){
            j=0;
            while(i!=0){
                if((i&1)==1){
                    arr[j]++;
                }
                i = i>>>1;
                j++;
            }
        }
        int res=0;
        for(int i=31;i>=0;i--){
            res = res<<1;
            if(arr[i]%3!=0){
                res = res|1;
            }
        }
        return res;
    }
}