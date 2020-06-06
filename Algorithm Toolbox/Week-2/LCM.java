import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  
  private static long gcd(int a, int b) {
	 
    if(b<=0) return a;
	
    return gcd(b,a%b);
  }
private static long lcm_efficient(int a, int b) {
   
    return (long) a * b/gcd(a,b);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));
	System.out.println(lcm_efficient(a, b));
	
	/*
	*stress test
	*/
	
	/*while(true){
			Random rand=new Random();
			int max=10000;
			int min=1;
			int a=rand.nextInt((max-min)+1)+min;
			int b=rand.nextInt((max-min)+1)+min;
			
			System.out.println("");
			System.out.println(a+" "+b);
			System.out.println("");
			long res1 = lcm_naive(a,b);
			long res2 = lcm_efficient(a,b);
			System.out.println(" fast: " + res2);
			if (res1 != res2) {
				System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
				} else {
					System.out.println("OK");
				}
		}*/
  }
}
