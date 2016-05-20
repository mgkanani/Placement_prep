import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class RegEx{

    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
	String a="(([0-1]?[0-9]?[0-9])|([2][0-5][0-5])|([2][0-4][0-9]))";
	String ip = "^"+a+"\\."+a+"\\."+a+"\\."+a+"$";
	//String ip = a+"\\."+a;
	//System.out.println(ip);
        while(in.hasNext())
        {
            String IP = in.next();
            System.out.println(IP.matches(ip));
        }

    }
}
