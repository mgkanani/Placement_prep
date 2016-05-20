/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
class TestCl {
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
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int iter=0;
        for(iter=0;iter<t;iter++){
        	int n ,q;
        	n = sc.nextInt();
        	q = sc.nextInt();
        	int arr[] = new int[n+1];
        	int a[] = new int[q];
        	int b[] = new int[q];
        	int i;
        	for(i=1;i<n+1;i++){
        		arr[i] = sc.nextInt();
        	}
		//	PR(i+"\n");
        	for(i=0;i<q;i++){
        		a[i] = sc.nextInt();
        		b[i] = sc.nextInt();
        	}
		//	PR(i+"\n");
        	for(int j=0;j<q;j++){
        		i=find(arr,b[j]);
			//PR(i+"\n");
        		int x =0;
        		while(i>0){
        			if(arr[i]==a[j]){
        				PR(x+"-ancestor\n");
        				break;
        			}else if(arr[i]<a[j]){
        				PR("not an ancestor\n");
        				break;
        			}else{
        				i=i/2;
					x++;
					//PR(i+"\n");
        			}
        		}
        		
        	}
        }

		
        //System.out.println("Hello World!");
    }
    
    public static int find(int arr[], int b){
    	int low,high,mid;
    	low = 1;
    	high = arr.length-1;
    	mid = (low+high)/2;
    	while(low<=high){
    		if(arr[mid]==b)
    			return mid;
    		else if(arr[mid]<b)
    			low = mid + 1;
    		else 
    			high = mid-1;
		mid = (low+high)/2;
    	}
    	return -1;
    }
    
    public static void PR(Object obj){
    	System.out.print(obj);
    }
}

