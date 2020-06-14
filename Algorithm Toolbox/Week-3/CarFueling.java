import java.util.*;
//import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        /**
         * if tank value is greater than or equal to the total distance then 0 refueling
         * if there are no stops then return -1 -- impossible to travel distance
         * if tank value is less than first stop then return -1 -- impossible to travel distance
         * if difference between last stop and total distance is greater than tank -- impossible to travel distance
         * iterating all stops:
         *  if differnce between current position and stop less than on equal to tank set previous position to current stop
         *  otherwise if current and previous positions are same then return -1 -- impossible to travel distance
         *            increment the number of fills
         *            set current position to previous value
         *            if differnce between total distance and current position is less than tank value then return number of fills
         * return number of fills +1
         * 
        **/
        int numFills=0,prevPos=0,curPos=0;
        int n=stops.length;
        if(tank>=dist){
            return 0;
        }
        if(stops.length==0){
            return -1;
        }
        if(dist-stops[n-1]>tank|| stops[0]>tank){
            return -1;
        }
        
        for(int i=0;i<n;i++){
          //System.out.println("i: "+i);
            if(tank+curPos >= stops[i] ){
               prevPos=stops[i];
               //System.out.println("Prev pos: "+prevPos);
            }else{
                if(curPos==prevPos) return -1;
                curPos=prevPos;
                numFills++;
               if(dist-curPos <=tank)return numFills;
               i--;
              // System.out.println("i: "+i);
              // System.out.println("fills: "+numFills);
            }
        }
        return numFills+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
