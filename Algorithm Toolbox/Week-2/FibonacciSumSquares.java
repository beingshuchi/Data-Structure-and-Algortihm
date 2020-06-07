import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
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
	
	private static long getFibonacciSumSquaresEfficient(long n) {
       long sum=(fib(n)%10*fib(n+1)%10);
        return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresEfficient(n);
        System.out.println(s);
    }
}

