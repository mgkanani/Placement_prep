import java.util.*;

public class A{
	public static void PR(Object obj){ System.out.print(obj);}
	public static void main(String[] args) {
		String s="abababababa";
		int Z[] = new int[s.length()];
		getZarr(s,Z);
		for(char i:s.toCharArray()){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:Z){
			System.out.print(i+" ");
		}
	}
	public static void getZarr(String str, int Z[]){
	    int n = str.length();
	    int L, R, k;
	    L = R = 0;
	    for (int i = 1; i < n; ++i){
	        if (i > R){
	        	PR("Straight\n");
	            L = R = i;
	            while (R<n && str.charAt(R-L) == str.charAt(R))
	                R++;
	            Z[i] = R-L;
	            R--;
	        }else{
	            k = i-L;
	            if (Z[k] < R-i+1){//This is optimizing step.
	                 Z[i] = Z[k];
	                 PR("optimization\n");
	            }else{
	            	PR("Sub-Straight R="+R+"\n");
                	L = i;
                	while (R<n && str.charAt(R-L) == str.charAt(R))
                    	R++;
                	Z[i] = R-L;
                	R--;
            	}
        	}
    	}
	}


	// public static void getZarr(String str, int Z[]){
	//     int n = str.length();
	//     int L, R, k;
	//     // [L,R] make a window which matches with prefix of s
	//     L = R = 0;
	//     for (int i = 1; i < n; ++i){
	//         // if i>R nothing matches so we will calculate.
	//         // Z[i] using naive way.
	//         if (i > R){
	//             L = R = i;
	//             // R-L = 0 in starting, so it will start
	//             // checking from 0'th index. For example,
	//             // for "ababab" and i = 1, the value of R
	//             // remains 0 and Z[i] becomes 0. For string
	//             // "aaaaaa" and i = 1, Z[i] and R become 5
	//             while (R<n && str.charAt(R-L) == str.charAt(R))
	//                 R++;
	//             Z[i] = R-L;
	//             R--;
	//         }else{
	//             // k = i-L so k corresponds to number which
	//             // matches in [L,R] interval.
	//             k = i-L;
	//             // if Z[k] is less than remaining interval
	//             // then Z[i] will be equal to Z[k].
	//             // For example, str = "ababab", i = 3, R = 5
	//             // and L = 2
	//             if (Z[k] < R-i+1)
	//                  Z[i] = Z[k];
	//             // For example str = "aaaaaa" and i = 2, R is 5,
	//             // L is 0
	//             else{
 //                	//  else start from R  and check manually
 //                	L = i;
 //                	while (R<n && str.charAt(R-L) == str.charAt(R))
 //                    	R++;
 //                	Z[i] = R-L;
 //                	R--;
 //            	}
 //        	}
 //    	}
	// }
}