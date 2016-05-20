import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),Q=sc.nextInt();
        TreeMap<Integer,Integer> map1 = new TreeMap<Integer,Integer>();
        TreeMap<Integer,Integer> map2 = new TreeMap<Integer,Integer>();
/*        int la[] = new int[Q];
        int ra[] = new int[Q];
        int ca[] = new int[Q];
        byte cmd_a[] = new byte[Q];
        */
        byte cmd = 0;
        int l=0,r=0,c=0;

        int min_i=N,max_i=0;
        int i,j;
        int old=0;
        map1.put(1,0);
        map1.put(N+1,0);
        map2.put(1,0);
        map2.put(N+1,0);
        for(i=0;i<Q;i++){
            c = sc.nextByte();
            switch(c){
                case 1:
                        //array a increment by c
                        l = sc.nextInt();
                        r = sc.nextInt();
                        c = sc.nextInt();
                        if(map1.containsKey(l)){
                            old = map1.get(l) + c;
                            map1.put(l,old);
                        }else{
                            map1.put(l,c);
                        }
                        if(map1.containsKey(r)){
                            old = map1.get(r) - c;
                            map1.put(r,old);
                        }else{
                            map1.put(r,-c);
                        }
                        break;
                case 2:
                        //array b increment by c
                        l = sc.nextInt();
                        r = sc.nextInt();
                        c = sc.nextInt();
                        if(map2.containsKey(l)){
                            old = map2.get(l) + c;
                            map2.put(l,old);
                        }else{
                            map2.put(l,c);
                        }
                        if(map2.containsKey(r)){
                            old = map2.get(r) - c;
                            map2.put(r,old);
                        }else{
                            map2.put(r,-c);
                        }
                        break;
                
                case 3:
                        // print result
                        System.out.println(map1.keySet());
                        System.out.println(map1.values());
                        System.out.println(map2.keySet());
                        System.out.println(map2.values());
                        l = sc.nextInt();
                        r = sc.nextInt();
            }
/*
            if(la[i]<min_i){
                min_i=la[i];
            }
            if(ra[i]>max_i){
                max_i = ra[i];
            }
            */
        }
        /*
        N=max_i-min_i+1;
        long a[] = new long[N+1];
        long b[] = new long[N+1];
        //long temp1[] = new long[N+1];
        //long temp2[] = new long[N+1];
        long sum=0;
        long mod = 1000000007;
        long t_long=0;
        long last1=0,last2=0;
        StringBuilder br = new StringBuilder(Q*12);
        for(i=0;i<Q;i++){
            switch(cmd_a[i]){
                case 1:
                        //array a increment by c
                        a[la[i]-min_i] += ca[i];
                        a[ra[i]-min_i+1] -= ca[i];
                        break;
                case 2:
                        //array b increment by c
                        b[la[i]-min_i] += ca[i];
                        b[ra[i]-min_i+1] -= ca[i];
                        break;
                
                case 3:
                        // print result
                        last1 = 0;//a[0];
                        last2 = 0;//b[0];
                        sum=0;                
                        for(j=0;j<ra[i]-min_i+1;j++){
                            last1 = last1 + a[j];
                            last2 = last2 + b[j];
                            //System.out.print("\ta :-"+last1+"\t b:-"+last2);
                            if(j>=(la[i]-min_i)){
                                sum+=(last1*last2);
                                sum = sum % mod;
                            }
                            //System.out.print(temp2[j-1]+" ");
                        }
                        //System.out.println("\t sum:-"+sum +"\tla[i]:-"+la[i]+"\tmin_i:-"+min_i);
                        //sum = sum % mod;
                        br.append(sum+"\n");
                        break;
            }
        }
        System.out.println(br);*/
    }
}
