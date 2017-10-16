package book.sort.app;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import book.sort.InsertSort;

/**
 * zeyu
 * 2017/10/16
 */
public class KendallTau {
    protected static InsertSort insertSort = new InsertSort();

    public static long distance(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array dimensions disagree");
        }
        int n = a.length;
        int[] ainv = new int[n];
        for (int i = 0; i < n; i++) {
            ainv[a[i]] = i;
        }
        Integer[] bnew = new Integer[n];
        for (int i = 0; i < n; i++) {
            bnew[i] = ainv[b[i]];
        }
        return Inversions.count(bnew);
    }

    public static List<Map.Entry<Integer, Integer>> calcDistance(Integer[] std, Integer[] arr) {
        if (null == std || null == arr || std.length != arr.length) {
            throw new IllegalArgumentException();
        }
        List<Map.Entry<Integer, Integer>> resultList = Lists.newArrayList();
        for (int i = 0; i < std.length; i++) {
            insertSort.sort(std, 0, i - 1);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(std[i])) {
                    break;
                }
                if (Arrays.binarySearch(std, 0, i, arr[j]) < 0) {
                    resultList.add(Maps.immutableEntry(arr[j], std[i]));
                }
            }
        }
        return resultList;
    }
}
