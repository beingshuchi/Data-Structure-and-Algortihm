import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        //sirting based on the end values
        Arrays.sort(segments,new Comparator<Segment>() {
            @Override
            public int compare(Segment o1,Segment o2){
                return Integer.compare(o1.end,o2.end);
            }
        });
        //for (int i = 0; i < segments.length; i++) {
          //  System.out.println(segments[i].start+" , "+segments[i].end);
       // }

       //since in ascending order according to end value we assume that first value is smallest
       //and so that value should fall in the range of next segment
       int j=1,point=segments[0].end;
       points[0]=point;
       //incase we have other values that fall within the the set we iterate and check
       //incase this segment falls in the range
       for(int i=1;i<segments.length;i++){
           if(point<segments[i].start||point>segments[i].end){
               point=segments[i].end;
               points[j]=point;
               j++;
           }
       }
       //finally only storing the values only for paricular points
       int p[]=new int[j];
       for(int i=0;i<j;i++){
           p[i]=points[i];
       }
        /*for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
        return p;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
