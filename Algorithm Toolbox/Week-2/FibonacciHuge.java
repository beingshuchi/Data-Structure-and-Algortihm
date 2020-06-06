import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
	 static long get_pisano_period(long m) {
    long a = 0, b = 1, c = a + b,count=0;
    for (int i = 0; i < m * m; i++) {
        c = (a + b) % m;
		//increase counter to get the length
       count++;
        if (b == 0 && c == 1){
			break;
		}
		a = b;
        b = c;
    }
	return count;
}
	
	private static long getFibonacciHugeEfficient(long n, long m) {
		
		
        long previous = 0;
        long current  = 1;
		
		long length=get_pisano_period(m);
		if(n%length<=1){
			return n%length;
		}
        for (long i = 0; i <n%length-1; i++) {
            long tmp = (previous%m + current%m)%m;
			previous = current;
            current = tmp;
			
			
        }/*
		//System.out.println(count+"-count---");
        return n%count;*/
		
		/*System.out.println("--length---");
		System.out.println(length);
		System.out.println("-----------------");
		System.out.println("remainder");
		System.out.println(n%length);
		System.out.println("-----------------");*/
		//we need to find the cycle length
		//divide n by that cycle length 
		//Further divide the remainder by m to get the final answer!
		
		return current;
   }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeNaive(n, m));
		System.out.println(getFibonacciHugeEfficient(n, m));
		
		
	/*
	*stress test
	*/
	
	/*while(true){
			Random rand=new Random();
			long max=1000000000;
			long min=1;
			int a=rand.nextInt((max-min)+1)+min;
			int b=rand.nextInt((1000-2)+1)+2;
			
			System.out.println("");
			System.out.println(a+" "+b);
			System.out.println("");
			long res1 = getFibonacciHugeNaive(a,b);
			long res2 = getFibonacciHugeEfficient(a,b);
			if (res1 != res2) {
				System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
				} else {
					System.out.println("OK");
				}
		}*/
    }
}

