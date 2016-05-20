import java.util.Scanner;
class Int{
    int val;
    Int(){val=0;}
    Int(int x){val=x;}
    void set(int x){val=x;}
    int get(){return val;}
}
public class ExtendedEuclid{
    void modInverse(int a, int m){
        Int x = new Int(0);
        Int y = new Int(0);
        int g = gcdExtended(a, m, x, y);
        if (g != 1)
            System.out.println("Inverse doesn't exist");
        else{
            int res = (x.get()%m + m) % m;
            System.out.println("Modular multiplicative inverse is "+res);
        }
    }

    int gcdExtended(int a, int b, Int x, Int y){
        // Base Case
        if (a == 0){
            x.set(0);
            y.set(1);
            return b;
        }
        // To store results of recursive call
        Int x1=new Int();
        Int y1=new Int(); 
        int gcd = gcdExtended(b%a, a, x1, y1);
        x.set( y1.get() - (b/a) * x1.get());
        y.set(x1.get());
        return gcd;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        ExtendedEuclid ee = new ExtendedEuclid();
        int a = scan.nextInt();
        int b = scan.nextInt();
        ee.modInverse(a, b);        
    }
}