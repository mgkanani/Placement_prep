public class StockIII {
    public int maxProfit(int[] arr) {
        int len = arr.length;
        if(len<2)
            return 0;
        int r_max[] = new int[len];
        r_max[len-1]=-1;
        int max=len-1,i=0;
        int profit[] = new int[len];
        profit[len-1]=0;
        for(i=len-2;i>=0;i--){
            if(arr[i]>arr[max]){
                max = i;
                r_max[i]=-1;
                profit[i] = profit[i+1];
            }else{
                profit[i] = Math.max(arr[max]-arr[i],profit[i+1]);
                r_max[i]=max;
            }
        }
        int min = 0;
        int l_min[] = new int[len];
        l_min[0]=-1;
        for(i=1;i<len;i++){
            if(arr[i]<arr[min]){
                min=i;
                l_min[i]=-1;
            }else{
                l_min[i] = min;
            }
        }
        int sum=0,t1=0,t2=0;
        for(i=1;i<len;i++){
            if(l_min[i]!=-1){
                t1 = Math.max(t1,arr[i]-arr[l_min[i]]);
            }
            t2=profit[i];
            if(sum<(t1+t2)){
                sum=t1+t2;
            }
        }
        return sum;
    }
}

/*
Approach :-
suppose we have maintained 0 to i maximum possible profit and i+1 to N then we have to maximize the sum value of this.

For finding maximum profit from 0 to i :- 
        maintain minimum value index for each position.

For finding maximum profix from i+1 to N:-
    traverse from N to 0(reverse order)
        profit[i] = Max{ max[i] - arr[i] ,  profit[i+1]}; // here max[i] is the maximum value from ith position.


Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/