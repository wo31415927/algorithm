package linerTable;

import java.util.HashMap;
import java.util.Map;

/**
 * zeyu
 * 2017/9/21
 */
public class TwoSum {
    /**
     * 需要根据需求考虑
     * 1)是否仅返回第一次符合条件的两个数,还是array中所有的数
     * 2)是否要去重,如[3,3,3] 6,返回[1,2]还是[1,2],[1,3]还是[1,2],[1,3],[2,3]
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSum(int[] arr, int sum) {
//        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];
        if (null == arr || 0 == arr.length) {
            return new int[]{};
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int des = sum - arr[i];
            if (indexMap.containsKey(des)) {
                /*list.add(indexMap.get(des));
                list.add(i);*/
                result[0] = indexMap.get(des);
                result[1] = i;
                break;
            }
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], i);
            }
        }
        /*int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }*/
        return result;
    }
}
