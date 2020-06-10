import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
		/*
		*
		* 1. create an array to store weights, values and value/weight
		* 2. sort the array according to value/weight
		* 3. Iterate through each item and check if whole weight can be considered or not
		* 4. If the whole weight is considered then subtract capacity with current item's weight and increase value with 
		*    current item's value
		* 5. Else check the consider the fraction of remaining capacity left and add the item's value*fraction to value and 
		*    subtract capacity with item's weight*fraction
		*
		* Safe move: considering value/weight sort based on which we take the max benefit
		*
		*/
		Items [] item=new Items[values.length];
		for(int i=0;i<values.length;i++){
			item[i]=new Items(values[i],weights[i],i);
		}
		
		Arrays.sort(item,new Comparator<Items>(){
			@Override
			public int compare(Items o1,Items o2){
				return o2.cost.compareTo(o1.cost);
			}
		});
		
		for(Items i: item){
			
			//considering whole weight
			if(capacity-i.weight>=0){
				capacity=capacity-(int)i.weight;
				value=value+i.value;
			}
			//Considering fractional weight
			else{
				if(capacity<=0)break;
				double fraction=(double)(capacity)/i.weight;
				value=value+(i.value*fraction);
				capacity=capacity-(int)(i.weight*fraction);
				break;
			}
		}
        return value;
    }
	static class Items{
		Double cost;
		double value,weight,i;
		public Items(double value,double weight,double i){
			this.value=value;
			this.weight=weight;
			this.i=i;
			this.cost=new Double(this.value/this.weight);
		}
	}
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
