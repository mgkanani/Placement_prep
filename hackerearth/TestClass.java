/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
//import java.lang.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
		Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.nextLine();
        int T,N,K;
        int j;
        T= Integer.parseInt(line);
        StringBuilder br = new StringBuilder(T * 10);
		int cakes=0;
        String temp[];
        for (int i = 0; i < T; i++) {
        	cakes=0;
            //temp = sc.nextLine().split(" ");
            N=sc.nextInt();//Integer.parseInt(temp[0]);
            K=sc.nextInt();//Integer.parseInt(temp[1]);
            int arr[] = new int[N];
            for(j=0;j<N;j++){
            	arr[j] = sc.nextInt();
            	arr[j] = TestClass.bits(arr[j]);
            }
            Arrays.sort(arr);
            for(j=N-1;j>=(N-K);j--){
            	cakes+=arr[j];
            }
            br.append(cakes+"\n");
        }
	System.out.println(br);
    }
    
    public static int bits(int x){
    	int bits=0;
    	while(x>0){
    		if((x&1)==1){
    			bits++;
    		}
    		x=x>>1;
    	}
    	return bits;
    }
}

