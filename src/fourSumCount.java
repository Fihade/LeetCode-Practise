import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int len = A.length;
        for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);

            }
        }
        for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){
                    if (map.containsKey(-C[i]-D[j]))
                        count += map.get(-C[i]-D[j]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] A = {-1,-1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = { 1,-1};
        System.out.println(fourSumCount(A,B,C,D) +"");
    }
}
