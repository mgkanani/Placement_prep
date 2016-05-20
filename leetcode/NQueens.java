import java.util.*;
public class NQueens {
    List<List<String>> list;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        list = new ArrayList<List<String>>();
        int arr[] =new int[n];
        process(arr,0);
        return list;
    }
    public void process(int arr[], int index){
        if(index==n){
            int j=0;
            List<String> ls = new ArrayList<String>();
            StringBuilder br;
            for(int i=0;i<n;i++){
                br = new StringBuilder(n);
                for(j=0;j<n;j++){
                    if(arr[i]==j){
                        br.append('Q');
                    }else{
                        br.append('.');
                    }
                }
                ls.add(br.toString());
            }
            list.add(ls);
        }
        for(int i=0; i<arr.length; i++){
            if(check(arr,index,i)){
                arr[index] = i;
                process(arr,index+1);
            }
        }
    }
    public boolean check(int[] arr, int i, int j){
        for(int k=0;k<i;k++){
            if(Math.abs(i-k)==Math.abs(arr[k]-j) || arr[k]==j)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        System.out.println(nq.solveNQueens(4));
    }

}