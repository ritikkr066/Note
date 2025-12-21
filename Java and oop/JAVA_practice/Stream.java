import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        // ArrayList<Integer>list=new ArrayList<>();
        // list.add(9);
        // list.add(99);
        // list.add(11);
        // list.add(3);
        // list.add(13);
        // List<Integer>ans=list.stream().filter((Integer a)->a>10).peek((Integer a)-> System.out.println(a)).sorted((Integer a, Integer b)->b-a).toList();
        // System.out.println(ans);

        int arr[] = { 4,4,6,4,3,6,8,2,1,5,7,99};
        // List<Integer>list=Arrays.stream(arr).boxed().sorted((Integer a, Integer b)->b-a).collect(Collectors.toList());
        //   System.out.println(list);
        int[]  rev= IntStream.range(0, arr.length).map(i->arr[arr.length-i-1]).toArray();
        System.out.println(Arrays.toString(rev));
      
    }
}
