package book.sort;

/**
 * zeyu 2017/9/27
 */
public abstract class BaseSort {
    protected void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    protected abstract void sort(Comparable[] a, int start, int end);

    protected String name() {
        return this.getClass().getSimpleName();
    }

    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected Comparable initCmp(Comparable[] arr, int lo, int hi) {
        return arr[lo];
    }

    protected void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    protected boolean exchIfNotEqual(Comparable[] arr, int i, int j) {
        if (0 != arr[i].compareTo(arr[j])) {
            exch(arr, i, j);
            return true;
        }
        return false;
    }
}
