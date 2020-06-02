import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductFast(int[] numbers) {
        //long max_product = 0;
        int n = numbers.length;
		 /*for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product =(long) Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }*/
		if(n<2){
			//System.out.println("No pairs");
			return -1;
		}
		int max_index1=-1;
		for(int i = 0; i < n; ++i){
			if(max_index1==-1||numbers[i]>numbers[max_index1]){
				max_index1=i;
			}
		}
		int max_index2=-1;
		for(int j = 0; j < n; ++j){
			if((j!=max_index1) && (max_index2==-1 || numbers[j]>numbers[max_index2])){
				max_index2=j;
			}
		}
		//System.out.println(max_index1+" "+max_index2);
        //return max_product;
		return (long)numbers[max_index1] * numbers[max_index2];
    }
	static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;
		 for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product =(long) Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }
		
		//System.out.println(max_index1+" "+max_index2);
        return max_product;
		//return (long)numbers[max_index1] * numbers[max_index2];
    }
    public static void main(String[] args) {
		//long st=System.nanoTime();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
		System.out.println(getMaxPairwiseProductFast(numbers));
		
		
		
		//long et=System.nanoTime();
		
		//Time to run the algorithm
		//System.out.println("-----------------------------------------------------");
		//System.out.println("Total time(miliseconds): "+(et-st)/1000000);
		//System.out.println("-----------------------------------------------------");
		
		//Stress test
		/*while(true){
			Random rand=new Random();
			int max=5;
			int min=2;
			int ranNum=rand.nextInt((max-min)+1)+min;
			
			int list[]=new int[ranNum];
			for(int i=0;i<ranNum;i++){
				list[i]=rand.nextInt((10)+1);
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			double res1 = getMaxPairwiseProduct(list);
			double res2 = getMaxPairwiseProductFast(list);
			if (result1 != result2) {
				System.out.println("Error! slow:  " + res1 + " fast: " + res2);
				break;
				} else {
					System.out.println("OK");
				}
		}*/
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
