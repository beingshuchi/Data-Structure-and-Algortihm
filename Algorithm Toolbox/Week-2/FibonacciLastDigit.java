import java.util.*;
import java.math.*; 

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
			//System.out.println(current+"-current---"+previous+"-previous");
        }

        return current % 10;
    }
	
	private static int getFibonacciLastDigitEfficient(int n) {
		if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
			//System.out.println(current+"-current---"+previous+"-previous");
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int c = getFibonacciLastDigitNaive(n);
		int c=getFibonacciLastDigitEfficient(n);
        System.out.println(c);
		
		
		/*
		*Stress test
		*/
	
	/*while(true){
		Random rand=new Random();
		int max=5;
		int min=0;
		//int ranNum=rand.nextInt((max-min)+1)+min;
		int ranNum=rand.nextInt(1000);
		System.out.println("");
		System.out.println(ranNum);
		System.out.println("");
		int res1=getFibonacciLastDigitNaive(ranNum);
		int res2=getFibonacciLastDigitEfficient(ranNum);
		if(res1!=res2){
			System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
		}
		else{
			System.out.println("OK");
		}
	}*/
    }
}

