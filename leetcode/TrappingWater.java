public class TrappingWater {
    public int trap(int[] arr) {
        int len = arr.length;
        if(len<=2)
            return 0;
        int max = 0,l=0;
        int[] l_max = new int[len],r_max = new int[len];
        l_max[0]=-1;
        max=0;
        for(l=1;l<len-1;l++){
            if(arr[l]>arr[max]){
                max = l;
                l_max[l] = -1;
            }else{
                l_max[l] = max;
            }
        }
        r_max[len-1]=-1;
        max=len-1;
        for(l=len-2;l>=0;l--){
            if(arr[l]>arr[max]){
                max = l;
                r_max[l] = -1;
            }else{
               r_max[l] = max;
            }
        }
        int sum=0;
        int area;
        for(l=1;l<len-1;l++){
            if(l_max[l]!=-1 && r_max[l]!=-1){
                area = Math.min(arr[l_max[l]],arr[r_max[l]])-arr[l]; // add water on each bar.
                sum+=area;
            }
        }
       return sum;
    }
}
/*
Trapping Rain Water
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 

*/