package book.sort;

/** zeyu 2017/9/27 */
public class InsertSort extends BaseSort {
  public void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  public void sort(Comparable[] a, int start, int end) {
    for (int i = start; i <= end; i++) {
      Comparable c = a[i];
      for (int j = i; j >= start; j--) {
        //                exch(a, j, i);
        if (j > start && less(c, a[j - 1])) {
          a[j] = a[j - 1];
        } else {
          a[j] = c;
          break;
        }
      }
    }
  }
}
