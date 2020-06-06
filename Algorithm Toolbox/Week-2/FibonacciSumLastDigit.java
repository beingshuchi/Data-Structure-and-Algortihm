import java.util.*;
import java.math.BigInteger;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
	private static long fib(long n){
		if(n%60<=1){
			return n%60;
		}
		long previous=0;
		long current=1;
		for (long i = 0; i <n%60-1; i++) {
            long tmp = (previous + current);
			previous = current;
            current = tmp;
        }
		return current;
	}
	private static long getFibonacciSumEfficient(long n) {
		//double phi=(1+Math.sqrt(5))/2;
		//long sum=(long)(Math.pow(phi,n)-(Math.pow((1-phi),n))/Math.sqrt(5));
		long sum=fib(n+2)-1;
		
        return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive(n);
		long s = getFibonacciSumEfficient(n);
        System.out.println(s);
		
		/*
	*stress test
	*/
	
	/*while(true){
			Random rand=new Random();
			BigInteger max= new BigInteger("100000000000000");
			BigInteger min= new BigInteger("0");
			BigInteger r= max.subtract(min);
			int len=max.bitLength();
			BigInteger a= new BigInteger(len,rand);
			
			System.out.println("");
			System.out.println(a);
			System.out.println("");
			long res1 = getFibonacciSumNaive(a.longValue());
			long res2 = getFibonacciSumEfficient(a.longValue());
			if (res1 != res2) {
				System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
				} else {
					System.out.println("OK");
				}
		}*/
    }
}

