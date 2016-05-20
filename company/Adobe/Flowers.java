/* Sample program illustrating input/output methods */
import java.util.*;
/*
Problem Statement

You and your K−1 friends want to buy N flowers. Flower number i has cost ci. 
Unfortunately the seller does not want just one customer to buy a lot of flowers, 
so he tries to change the price of flowers for customers who have already bought some flowers. 
More precisely, if a customer has already bought x flowers, he should pay (x+1)ci dollars to buy flower number i.
You and your K−1 friends want to buy all N flowers in such a way that you spend the least amount of money. 
You can buy the flowers in any order.

Input:

The first line of input contains two integers N and K(K<=N). The next line contains N space separated positive integers c1,c2,...,cN.

Output:

Print the minimum amount of money you (and your friends) have to pay in order to buy all N flowers.

Constraints

1≤N,K≤100
Any ci is not more than 106
Result is guaranteed to be less than 231
*/
class Flowers{
   public static void main( String args[] ){
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
      int N, K;
      N = in.nextInt();
      K = in.nextInt();
      
      int C[] = new int[N];
      for(int i=0; i<N; i++){
         C[i] = in.nextInt();
      }
      Arrays.sort(C);
      int result = 0;
       int cnt=1,i=N-1,j=0;
       while(i>=0){
            for(j=i;j>i-K && j>=0;j--){
                result+=cnt*C[j];
            }
           i=j;
           cnt++;
       }
       System.out.println( result );
      
   }
}
