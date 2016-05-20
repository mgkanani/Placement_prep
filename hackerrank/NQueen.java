import java.util.*;
public class NQueen {
    static StringBuilder br;

    public static boolean process(short arr[], int index){
        if(index==arr.length)
            return true;
        //int cnt=0;
        boolean f=false;
        for(short i=0; i<arr.length; i++){
            if(check(arr,index,i)){
                arr[index] = i;
                if(process(arr,index+1)){
                    f=true;
                    break;
                }
            }
        }
        if(f && index==0){
            br.append(arr.length+"\n");
            for(short i:arr)
                br.append(i+1+" ");
            br.append("\n");
        }
        return f;
    }
    public static boolean check(short[] arr, int i, int j){
        for(int k=0;k<i;k++){
            if(arr[k]==j || Math.abs(i-k)==Math.abs(arr[k]-j))
                return false;
        }
        for(int k=0;k<i;k++){
            if(i>=2){
                for(int t1=k+1;t1<i;t1++){
                    if( (t1-k)*(j-arr[k])==(arr[t1]-arr[k])*(i-k) ) {
                       return false;
                    }
                }
            }            
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        br = new StringBuilder(50*1000);
        br.append("1\n1\n");
        short arr[]=null;
        //int cnt=0;
        for(int i=999;i<1000;i+=2){
            arr = new short[i];
            if(process(arr,0))
                System.out.println(br.substring(0,br.length()-2));
                //System.out.print(br);
            br.setLength(0);
            //br = new StringBuilder(i*4);            
        }
    }
}
/*

*/