import java.util.*;
import java.io.*;
public class FileDemo{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		File file = new File("./test");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while( (line = br.readLine())!= null ){
        // \\s+ means any number of whitespaces between tokens
		    String [] tokens = line.split("\\s+");
		    for(String s:tokens){
		    	if(str.equals(s))
		    		System.out.println(s);
		    }
		}
	}
}