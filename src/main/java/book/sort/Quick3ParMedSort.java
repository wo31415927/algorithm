package book.sort;

/**
 * 三向切分,重复元素放在中间
 * 交换的是与V不同的元素,交换次数较多,所以比Arrays.sort慢
 * zeyu
 * 2017/10/9
 */
public class Quick3ParMedSort extends QuickSort {
    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) return;
        if(hi - lo < M){
            insertSort.sort(a,lo,hi);
            return;
        }
        Comparable V = a[lo];
        int lt = lo;
        int gt = hi;
        for (int i = lo + 1; i <= gt; ) {
            if (a[i].compareTo(V) < 0) {
                exch(a, lt++, i++);
            } else if (0 == a[i].compareTo(V)) {
                i++;
            } else if (a[i].compareTo(V) > 0) {
                exch(a, i, gt--);
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
