package book.sort;

/**
 * cctv 2017/10/4
 */
public class QuickSampleSort extends QuickSort {
    protected final int sample;

    public QuickSampleSort(int M, int sample) {
        super(M);
        this.sample = sample;
    }

    public QuickSampleSort() {
        this(5, 3);
    }

    public int calcMedian(Comparable[] a) {
        return calcMedian(a, 0, a.length - 1);
    }

    public int calcMedian(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return lo;
        if (0 == (hi - lo) % 2) {
            insertSort.sort(a, lo, hi);
            return lo + (hi - lo) / 2;
        }
        throw new IllegalArgumentException("中位数计算的输入序列必须包含奇数个数字");
    }

    /**
     * 取前sample个数，取其中的中位数作为V来进行切分
     */
    @Override
    protected int partition(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return lo;
        if (hi - lo < sample - 1) {
            return super.partition(a, lo, hi);
        }
        int median = calcMedian(a, lo, lo + sample - 1);
        return super.partition(a, median, hi);
    }
}
