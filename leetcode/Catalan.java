/*
Catalan numbers :- total distinct binary search trees.
*/
public class Catalan {
    public int numTrees(int n) {
        int arr[] = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        if(n>1){
            int i=2,j;
            for(i=2;i<=n;i++){
                for(j=0;j<i;j++){
                    arr[i]+=arr[j]*arr[i-j-1];
                }
            }
        }
        return arr[n];
    }
}