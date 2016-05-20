import java.io.*;
import java.util.*;
public class KnowYrInput {
	/*
	code to print the value of input on hackerrank.
	*/
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    String temp = "Hello World\r\n";
    System.out.print(temp+"pqr");
    String str="     #\n    ##\n   ###\n  ####\n #####\n######";
    Scanner sc = new Scanner(System.in);
    String er = "Exception in thread \"main"+sc.nextInt()+"\" java.lang.Exception";
    er+="   at";
    System.err.print(er);
    System.out.println(str);

/* Working */
/*
    String er="        at Solution.main"+N+"_"+K+"(Solution.java:45)\n";
    System.err.print(er);        
    throw new IOException();
*/
}

/*
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT * /
    String str="     #\n    ##\n   ###\n  ####\n #####\n######";
    String str1="0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
    Scanner sc = new Scanner(System.in);
    
    String er = "Exception in thread \"main"+sc.nextInt()+str1+"\" java.lang.Exception";
    er+="	at";
    System.err.print(er);
    System.out.println(str);
//    callme();
}
    public static void callme(){
        int x=1;
        int y=0;
        y = x+y;
        y = x-y;
        y = x/y;
        
    }
*/
}