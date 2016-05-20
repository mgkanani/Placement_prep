import java.io.*;
import java.util.*;

public class Temp {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        long r,c;
        r=scan.nextInt();
        c=scan.nextInt();
        r--;
        c--;
        long output=(10*(r/2))+((r&1) + c*2);
        System.out.println(output);
    }
}
