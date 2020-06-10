import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //initialization
		int coin[]={10,5,1},count=0,temp=m;
		//iterate through each coin
		for(int i:coin){
			//use the coin until m becomes less than i and increase count
			//if i is less than i then use next coin and enter while loop
			//continue until m becomes 0 and we exit both the loops.
			//Safe move: use coins until m is less than i and increase count
			//proof: coins count only upto coin value <= knapsack value.
			while(i<=temp){
				temp=temp-i;
				count++;
				//System.out.println(i);
				if(temp==0){
					break;
				}
			}
		}
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
		/*
		*Stress test
		*/
		

    }
}

