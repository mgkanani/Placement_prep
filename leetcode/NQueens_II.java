public class NQueens_II {
    /*
    Follow up for N-Queens problem.
    Now, instead outputting board configurations, return the total number of distinct solutions.
    */
    public int totalNQueens(int n) {
        int arr[] =new int[n];
        return process(arr,0);
    }
    public int process(int arr[], int index){
        if(index==arr.length)
            return 1;
        int cnt=0;
        for(int i=0; i<arr.length; i++){
            if(check(arr,index,i)){
                arr[index] = i;
                cnt+=process(arr,index+1);
            }
        }
        return cnt;
    }
    public boolean check(int[] arr, int i, int j){
        for(int k=0;k<i;k++){
            if(Math.abs(i-k)==Math.abs(arr[k]-j) || arr[k]==j)
                return false;
        }
        return true;
    }
}