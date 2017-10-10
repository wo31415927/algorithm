package book.sort;

/**
 * zeyu 2017/10/9
 */
public class Quick3SideSort extends QuickSampleSort {
    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        if (hi - lo < M) {
            insertSort.sort(a, lo, hi);
            return;
        }
        Comparable V = initCmp(a,lo,hi);
        int p, q, i, j;
        p = i = lo;
        q = j = hi;
        while (true) {
            while (a[i].compareTo(V) <= 0) {
                if (0 == a[i].compareTo(V)) {
                    exch(a, i, p++);
                }
                if (i >= j) break;
                i++;
            }
            while (a[j].compareTo(V) >= 0) {
                if (0 == a[j].compareTo(V)) {
                    exch(a, j, q--);
                }
                if (i >= j) break;
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(a, i++, j--);
        }
        /** i>j j==j: a[i] > V ,a[i] < V 三种场景 */
        int mid = j = less(a[i], V) ? i : i - 1;
        for (i = lo; i < p; ) {
            if (!exchIfNotEqual(a, j--, i++)) {
                break;
            }
        }
        sort(a, lo, mid - p + lo);
        for (i = mid + 1, j = hi; i <= q; ) {
            if (!exchIfNotEqual(a, i++, j--)) {
                break;
            }
        }
        sort(a, mid + 1 + hi - q, hi);
    }
}
