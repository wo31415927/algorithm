package book.p2.p2d1d25;

import book.BaseSort;

/**
 * zeyu
 * 2017/9/27
 */
public class InsertSort extends BaseSort {
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable c = a[i];
            for (int j = i; j > 0; j--) {
//                exch(a, j, i);
                if (less(c, a[j - 1])) {
                    a[j] = a[j - 1];
                } else {
                    a[j] = c;
                    break;
                }
            }
        }
    }
}
