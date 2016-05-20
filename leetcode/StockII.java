/*
Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class StockII {
    public int maxProfit(int[] prices) {
        if(prices.length>0){
            int max=0,len = prices.length;
            int min;
            int i=1;
            int sum=0;
            while(i<len){
                min=prices[i-1];
                while(i<len && prices[i]>prices[i-1]){
                    i++;
                }
                max = prices[i-1];
                //if(diff<max-min){
                    sum += (max-min);
                //}
                while(i<len-1 && prices[i]>prices[i+1]){
                    i++;
                }
                i++;
            }
            return sum;
        }
        return 0;
    }
}