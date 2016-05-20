import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        //StringBuilder sbr = new StringBuilder(200*100);
        String str="";
        int i=0,len=str.length(),j;
        StringBuilder br =new StringBuilder(20000);
        int flag=0;
        while(sc.hasNextLine()){
            str = sc.nextLine();
            if(flag){
                if(str.contains("*/")){
                    br.append(str.split("*/")[0]);
                    flag=0;
                }else
                    br.append(str);
            }else{
            len=str.length();
            String temp[] = str.split("//");
                if(temp.length>1){
                    j=1;
                    br.append("//");
                    while(j<temp.length){
                        br.append(temp[j]);
                        j++;
                    }
                }else{
                    temp = str.split("/*");
                    if
                }
            }
        }
/*        str=sbr.toString();
        sbr=null;
       */
        for(i=0;i<len;i++){
            if(str.charAt(i)=='/'){
                if(i<len-1 && (str.charAt(i+1)=='/')){
                    br.append('/');
                    j=0;
                    while((i+j<len)&& str.charAt(i+j)!='\n'){
                        br.append(str.charAt(i+j));
                        j++;
                    }
                    br.append('\n');
                }else if(i<len-1 && (str.charAt(i+1)=='*')){
                    br.append('/');
                    j=0;
                    while((i+j+1<len) && str.charAt(i+j)!='*' && str.charAt(i+j+1)!='/'){
                        br.append(str.charAt(i+j));
                    }
                    br.append("*/");
                }
            }
        }
        System.out.print(br);
    }
}
