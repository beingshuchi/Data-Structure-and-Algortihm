import java.util.Scanner;
import java.util.Random;

public class Fibonacci {
  private static long calc_fib(int n) {
	 //if (n <= 1)return n;
	long arr[]=new long[n+2];
	arr[0]=0;
	arr[1]=1;
	for(int i=2;i<=n;i++){
		arr[i]=arr[i-1]+arr[i-2];
	}
    return arr[n];
  }
  
  private static long calc_fib_slow(int n) {
	
    if (n <= 1){
		return n;
	}
    return calc_fib_slow(n - 1)+calc_fib_slow(n-2);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
	
	
	/*
	* Stress test
	*/
	
	/*while(true){
		Random rand=new Random();
		int max=5;
		int min=2;
		int ranNum=rand.nextInt((max-min)+1)+min;
		System.out.println("");
		System.out.println(ranNum);
		System.out.println("");
		long res1=calc_fib(ranNum);
		long res2=calc_fib_slow(ranNum);
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
