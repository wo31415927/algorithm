package book.sort;

import com.google.common.collect.Maps;

import java.util.Map;

import book.p1.Stack2;

/**
 * zeyu
 * 2017/10/9
 */
public class QuickNonRecursionSort extends QuickSampleSort {
    protected Stack2<Map.Entry<Integer, Integer>> stack = new Stack2<>();

    protected void sort(Comparable[] a) {
        while (stack.size() > 0) {
            Map.Entry<Integer, Integer> entry = stack.pop();
            int lo = entry.getKey();
            int hi = entry.getValue();
            if (hi - lo < M) {
                insertSort.sort(a, lo, hi);
                continue;
            }
            int mid = partition(a, lo, hi);
            //现将较大的数组入栈,这样可以保证栈中的元素较少
            if(mid - lo > hi - mid) {
                stack.push(Maps.immutableEntry(lo, mid - 1));
                stack.push(Maps.immutableEntry(mid + 1, hi));
            }else {
                stack.push(Maps.immutableEntry(mid + 1, hi));
                stack.push(Maps.immutableEntry(lo, mid - 1));
            }
        }
    }

    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        stack.push(Maps.immutableEntry(lo,hi));
        sort(a);
    }
}
