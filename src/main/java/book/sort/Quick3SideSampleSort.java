package book.sort;

/**
 * zeyu
 * 2017/10/10
 */
public class Quick3SideSampleSort extends Quick3SideSort {
    @Override
    public int calcMedian(Comparable[] a, int lo, int hi) {
        if (hi - lo < 8) {
            return super.calcMedian(a, lo, hi);
        }
        int[] indexArr = new int[3];
        indexArr[0] = super.calcMedian(a, lo, lo + 2);
        indexArr[1] = super.calcMedian(a, lo + 3, lo + 5);
        indexArr[2] = super.calcMedian(a, lo + 6, lo + 8);
        Comparable[] cmpArr = new Comparable[3];
        cmpArr[0] = a[indexArr[0]];
        cmpArr[1] = a[indexArr[1]];
        cmpArr[2] = a[indexArr[2]];
        return indexArr[super.calcMedian(cmpArr)];
    }

    @Override
    protected Comparable initCmp(Comparable[] arr, int lo, int hi) {
        if (hi - lo >= 8) {
            return arr[calcMedian(arr, lo, lo + 8)];
        }
        return super.initCmp(arr, lo, hi);
    }
}
