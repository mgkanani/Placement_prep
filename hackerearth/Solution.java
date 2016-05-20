/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
				int j;
                Scanner sc = new Scanner(System.in);
                long a[]= new long[4];
                long ans=-1;
                int N=sc.nextInt();
                int in[]= new int[N];
                int i;
                for(i=0;i<N;i++){
                        in[i]=sc.nextInt();
                }
                StringBuilder br = new StringBuilder(N*19);
                for(i=0;i<N;i++){
                        if(i<2){
                                System.out.println(-1);
                                a[i]=in[i];
                        }else if(i==2){
                                a[i] = in[i];
                                System.out.println(a[0]*a[1]*a[2]);
                        }
                        else{
                                a[0]=in[i];
                                Arrays.sort(a);
                                br.append((a[3]*a[1]*a[2])+"\n");
                                //System.out.println();
                        }
                }
				System.out.println(br);
    }
}

