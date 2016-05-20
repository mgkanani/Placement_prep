/*
Given an unsorted integer array, find the first missing positive integer. 
Your algorithm should run in O(n) time and uses constant space. 
*/

public class FirstMissing {
    public int firstMissingPositive(int[] arr) {
        int len = arr.length;
        if(len==0)
            return 1;
        int i,last_ind=len-1;
        int temp;
        for(i=0;i<len && last_ind>=0 && i<=last_ind; i++){
            if(arr[i]<=0 || arr[i]>=len){
                if(last_ind==i)
                    continue;
                temp = arr[last_ind];
                arr[last_ind] = arr[i];
                arr[i] = temp;
                i--;
                last_ind--;
            }else{
                if(arr[i]==arr[ arr[i]-1 ])
                    continue;
                temp = arr[ arr[i]-1 ];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
                i--;
            }
        }
        for(i=0;i<len;i++)
            if(arr[i]!=i+1)
                return i+1;
        return i+1;
    }
}
