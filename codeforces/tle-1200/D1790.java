import java.util.*;
 
public class D1790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> freqMap = new HashMap<>();
 
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            }
 
            List<Integer> keys = new ArrayList<>(freqMap.keySet());
            Collections.sort(keys);
 
            int count = freqMap.get(keys.get(0));
            for (int i = 1; i < keys.size(); i++) {
                int prevFreq = freqMap.get(keys.get(i - 1));
                int currFreq = freqMap.get(keys.get(i));
 
                if(keys.get(i) - keys.get(i-1) == 1){
                    if (currFreq > prevFreq) {
                        count += currFreq - prevFreq;
                    }
                }else {
                    count += currFreq;
                }
 
            }
 
            System.out.println(count);
        }
    }
}