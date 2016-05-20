public class MaximumSubArrProd {
    public int maxProduct(int[] nums) {
        int i,curmin=nums[0],curmax=nums[0],max=nums[0];
        int tmin,tmax;
        for(i=1;i<nums.length;i++){
            tmin=Math.min(nums[i],nums[i]*curmin);
            tmin=Math.min(tmin,nums[i]*curmax);
            tmax=Math.max(nums[i],nums[i]*curmax);
            tmax=Math.max(tmax,nums[i]*curmin);
            curmin=tmin;
            curmax=tmax;
            if(max<curmax)
                max=curmax;
        }
        return max;
    }
}
