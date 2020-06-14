import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        /*
         * 
         * iterate through each string in array
         * compare first element of adjacent strings
         * incase next elemnt is greater we swap index
         * incase both first elemnts of string are equal, we check if concatenation of [j][i]
         * is greater than [i][j] then we swap index
         * 
         * Now we check if k th  and i th values are not same then we swap
         * values of both index
         * 
        */
        for(int i=0;i<a.length-1;i++){
            int k=i;
            for(int j=i+1;j<a.length;j++){
                if(a[k].charAt(0)<a[j].charAt(0)){
                    k=j;
                }else if(a[k].charAt(0)==a[j].charAt(0)){
                    if(!((a[k]+a[j]).compareTo((a[j]+a[k]))>0)){
                        k=j;
                    }
                }

            }
            if(k!=i){
                String tmp=a[i];
                a[i]=a[k];
                a[k]=tmp;
            }
        }
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

