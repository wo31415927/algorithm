package book.sort;

/**
 * zeyu
 * 2017/10/9
 */
public class Quick3SideSort extends QuickSort {
    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        if (hi - lo < M) {
            insertSort.sort(a, lo, hi);
            return;
        }
        Comparable V = a[lo];
        int p = lo, i = lo + 1;
        int q, j;
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
        /**
         * i>j
         * j==j: a[i] > V ,a[i] < V
         * 三种场景
         */
        int mid = j = less(a[i],V) ? i:i-1;
        for(i=lo;i<Math.min(p-lo,mid+1-p);i++){
            a[j--] = a[i];
        }
        sort(a, lo, mid - p);
        for(i=mid+1,j=hi;i<Math.min(hi-q,q-mid);i++){
            a[i] = a[j--];
        }
        sort(a, mid + hi - q + 1, hi);
    }
}
