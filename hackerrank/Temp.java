import java.util.*;
public class Temp{
	static boolean dbg = true;
	public static void PRINT(Object arg) { System.out.print(arg); }
	public static void PRINTLN(Object arg) { System.out.println(arg); }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(Sample.dbg){
			String s1 = null;
			String s2 = null;
			PRINT(s1==s2);
			PRINTLN(Integer.MAX_VALUE);//2^31 -1;
		}
	}

	public static void meth(){

	}
}