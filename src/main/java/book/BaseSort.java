package book;

/**
 * zeyu
 * 2017/9/27
 */
public class BaseSort {
    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
