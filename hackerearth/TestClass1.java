/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
class TestClass1 {
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int T,N,M,K;
    	int temp=0;
    	T = sc.nextInt();
	   	StringBuilder br = new StringBuilder(T*10);
    	int i,j,iter;
    	for(iter=0;iter<T;iter++){
    		N = sc.nextInt();
    		M = sc.nextInt();
    		K = sc.nextInt();
    		int x[] = new int[N];
    		int new_x[] = new int[N];
    		int c[] = new int[M];
    		int z[] = new int[M];
    		for(i=0;i<N;i++){
    			x[i] = sc.nextInt();
    		}
    		for(i=0;i<M;i++){
    			c[i] = sc.nextInt();
    		}
    		for(i=0;i<M;i++){
    			z[i] = sc.nextInt();
    		}
		int res=0,oi;
    		for(oi=0;oi<N;oi++){
			max=0;
    		for(i=0;i<N;i++){
			temp=0;
    			for(j=0;j<M;j++){
    				if(x[i]%c[j]==0 || c[j]%x[i]==0){
    					temp+=z[j];
    				}
    			}
			//System.out.println(x[i]+"\t"+temp);
			if(max)
    			new_x[i]=temp;
    		}
		}
    		Arrays.sort(x);
    		temp=0;
    		for(i=N-1;i>=(N-K);i--)
    			temp+=x[i];
    		br.append(temp+"\n");
    	}
        System.out.println(br);
    }
}

