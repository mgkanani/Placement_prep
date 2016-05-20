import java.util.*;

public class StringSimilarity {
    /* Head ends here */
    public static void findZ(int z[], String str){
        int n = str.length();
        int R=0,L=0,k=0,i=0;
        for(i=1;i<n;i++){
            if(i>R){
                R=L=i;
                while(R<n && str.charAt(R-L)==str.charAt(R)) R++;
                z[i]=R-L;
                R--;
            }else{
                k=i-L;
                if(z[k]<R-i+1)
                    z[i]=z[k];
                else{
                    L=i;
                    while(R<n && str.charAt(R-L)==str.charAt(R)) R++;
                    z[i] = R-L;
                    R--;
                }
            }
        }
    }
    static long stringSimilarity(String a) {
        int n =a.length();
        int z[] = new int[n];
        findZ(z,a);
        long sum=n;
        for(int i:z)
            sum+=i;
        return sum;
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;
        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i<_t_cases; _t_i++) {
            String _a = in.nextLine();
            res = stringSimilarity(_a);
            System.out.println(res);
        }
    }
}
/*
Z algorithm
ZArray Z Array 
*/