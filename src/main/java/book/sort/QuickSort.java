package book.sort;

import lombok.RequiredArgsConstructor;

/** cctv 2017/10/3 */
@RequiredArgsConstructor
public class QuickSort extends BaseSort {
  //数组长度小于此值时使用插入排序
  protected final int M;
  protected InsertSort insertSort = new InsertSort();

  public QuickSort() {
    this(5);
  }

  @Override
  protected void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) return;
    if(hi - lo < M) {
      insertSort.sort(a,lo,hi);
      return;
    }
    int mid = partition(a, lo, hi);
    sort(a, lo, mid - 1);
    sort(a, mid + 1, hi);
  }

  protected int partition(Comparable[] a, int lo, int hi) {
    if (lo >= hi) return lo;
    Comparable v = a[lo];
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (less(a[++i], v)) if (hi == i) break;
      while (less(v, a[--j])) {}
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }
}
