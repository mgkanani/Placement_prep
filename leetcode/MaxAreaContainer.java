public class MaxAreaContainer {
    public int maxArea(int[] arr) {
        int len = arr.length;
        if(len<2)
            return 0;
        int maxa=0,area=0;
        int l=0,r=len-1;
        while(l<r){
            area = Math.abs(r-l)*Math.min(arr[l],arr[r]);
            if(area>maxa)
                maxa=area;
            if(arr[l]<=arr[r])
                l++;
            else
                r--;
        }
        return maxa;
    }
}
/*
Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
*/