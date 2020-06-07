import java.util.*;
import java.math.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
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
		 //double phi = (1 + Math.sqrt(5)) / 2; 
		 //return (long) Math.round(Math.pow(phi, n) / Math.sqrt(5)); 
	}
	
	private static long getFibonacciPartialSumEfficient(long from,long to) {
		long sum=0;
		if(from==to){
			
			sum= fib(from);
			return sum%10;
		}else{
		//System.out.println("from "+(fib(from+1)));
		//System.out.println("to "+(fib(to+2)-1));
		//long sumFrom=(fib((from-1)+2)-1);
		//long sumTo=(fib(to+2)-1);
		long sumFrom=fib(from+1);
		long sumTo=fib(to+2);
		//if(sumFrom>sumTo){
			//long tmp=sumFrom;
			//sumFrom=sumTo;
			//sumTo=tmp;
		//}
		//System.out.println("sumfrom "+sumFrom);
		//System.out.println("sumto "+sumTo);
        sum = (sumTo%10-sumFrom%10+10);
		}

        return sum%10;
    }
	
	
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println(getFibonacciPartialSumNaive(from, to));
		System.out.println(getFibonacciPartialSumEfficient(from,to));
		
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

