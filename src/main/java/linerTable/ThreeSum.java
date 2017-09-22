package linerTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo.My;

/**
 * zeyu
 * 2017/9/22
 */
public class ThreeSum {
    /**
     * 找出数组中三个值的和为指定sum值得多组记录(可重复,记录中存储的是int[]的index)
     */
    @My
    public static List<int[]> threeSum(int[] arr, int sum) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<int[]>> indexMap = new HashMap<>();
        if (null == arr || 0 == arr.length) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            int des = sum - arr[i];
            List<int[]> tmpList;
            if (null != (tmpList = indexMap.get(des))) {
                for (int[] tmpArr : tmpList) {
                    int[] row = new int[3];
                    row[0] = tmpArr[0];
                    row[1] = tmpArr[1];
                    row[2] = i;
                    result.add(row);
                }
            }
            for (int j = 0; j < i; j++) {
                int sum1 = arr[i] + arr[j];
                if (null != (tmpList = indexMap.get(sum1))) {
                    tmpList.add(new int[]{j, i, 0});
                } else {
                    List<int[]> curList = new ArrayList<>();
                    curList.add(new int[]{j, i, 0});
                    indexMap.put(sum1, curList);
                }
            }
        }
        return result;
    }

    /**
     * 不重复,即
     * given array S = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     效率太慢
     * @param arr
     * @return
     */
    @My
    public static List<List<Integer>> threeSum0(int[] arr) {
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        //不能用数组作为HashMap的key
        Set<List<Integer>> resultSet = new HashSet<>();
        Map<Integer,List<Integer[]>> indexMap = new HashMap<>();
        if (null == arr || 0 == arr.length) {
            return result;
        }
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        for (int i = 0; i < arr.length; i++) {
            int des = sum - arr[i];
            List<Integer[]> tmpList;
            if (null != (tmpList = indexMap.get(des))) {
                for (int k=tmpList.size()-1;k>=0;k--) {
                    Integer[] tmpArr = tmpList.get(k);
                    if (Integer.MAX_VALUE == tmpArr[2]) {
                        tmpArr[2] = arr[i];
                        Arrays.sort(tmpArr);
                        resultSet.add(Arrays.asList(tmpArr));
                    }else{
                        break;
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int sum1 = arr[i] + arr[j];
                Integer[] tmpArr = {arr[j],arr[i],Integer.MAX_VALUE};
                if (null != (tmpList = indexMap.get(sum1))) {
                    tmpList.add(tmpArr);
                } else {
                    List<Integer[]> curList = new ArrayList<>();
                    curList.add(tmpArr);
                    indexMap.put(sum1, curList);
                }
            }
        }
        result.addAll(resultSet);
        return result;
    }
}
