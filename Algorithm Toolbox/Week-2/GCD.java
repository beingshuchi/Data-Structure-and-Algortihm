import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  private static int gcd_efficient(int a, int b) {
	 
    if(b<=0) return a;
	
    return gcd_efficient(b,a%b);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(gcd_naive(a, b));
	System.out.println(gcd_efficient(a, b));
	
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
			int res1 = gcd_naive(a,b);
			int res2 = gcd_efficient(a,b);
			if (res1 != res2) {
				System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
				} else {
					System.out.println("OK");
				}
		}*/
  }
}
