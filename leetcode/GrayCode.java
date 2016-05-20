import java.util.*;
/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/
public class GrayCode{
	public static void PR(Object obj){ System.out.print(obj);}
	public List<Integer> generate(int n){
        int max=1;
		max = max<<n;
		int pow2=1;
        List<Integer> lst = new ArrayList<Integer>();
		//int arr[] = new int[max];
		int cnt=1,j,i;
		lst.add(0);
		while(pow2<max){
			j = cnt-1;
			while(j>=0){
				//arr[cnt] = pow2 + arr[j];
				lst.add(pow2 + lst.get(j));
				j--;
				cnt++;
			}
			pow2 <<= 1;
		}
		return lst;
	}
	public List<Integer> grayCode(int n) {
		int max = 1<<n;
		List<Integer> list = new ArrayList<Integer>();
		for(int j=0;j<max;j++){
			//list.add(binaryToGray(j));
			list.add(grayToBinary(j));
		}
		//list.add(grayToBinary(4));
		return list;
	}


	public int binaryToGray(int num){
        return (num >> 1) ^ num;
	}

	public int grayToBinary(int num){
    	int n=31;
    	n = 1<<n;
    	int result = n & num;
    	int last = result>>1;
    	n >>>=1;
    	for (int j=30;j>=0;j--,n>>>=1){
    		result = result | ((num&n)^last);
    		last = (((num&n)^last))>>1;
    	}
    	return result;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		GrayCode gcode = new GrayCode();
		PR(gcode.generate(n)+"\n");
		PR(gcode.grayCode(n)+"\n");
	}
}