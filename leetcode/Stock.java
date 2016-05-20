/*
Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.


*/
public class Stock {
    public int maxProfit(int[] prices) {
        if(prices.length>0){
            int max=0,len = prices.length;
            int cur_min,min;
            int i=1;
            int diff=0;
            min=prices[0];
            while(i<len){
                cur_min=prices[i-1];
                while(i<len && prices[i]>prices[i-1]){
                    i++;
                }
                max = prices[i-1];
                if(min>cur_min){
                    min=cur_min;
                }
                if(diff<max-min){
                    diff = max-min;
                }
                while(i<len-1 && prices[i]>prices[i+1]){
                    i++;
                }
                i++;
            }
            return diff;
        }
        return 0;
    }
}