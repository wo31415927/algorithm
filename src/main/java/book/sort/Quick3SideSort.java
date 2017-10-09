package book.sort;

/** zeyu 2017/10/9 */
public class Quick3SideSort extends QuickSampleSort {
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
    return indexArr[super.calcMedian(cmpArr, 0, 2)];
  }

  @Override
  protected void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) return;
    if (hi - lo < M) {
      insertSort.sort(a, lo, hi);
      return;
    }
    Comparable V = a[lo];
    int p, q, i, j;
    p = i = lo + 1;
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
