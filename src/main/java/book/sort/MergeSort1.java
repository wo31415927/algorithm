package book.sort;

/** Merge时不再复制辅助数组，每次递归sort过程中互换目标数据和辅助数据的角色 cctv 2017/10/1 */
public class MergeSort1 extends MergeSort {
  public MergeSort1(Integer[] aux) {
    this.aux = aux;
  }

  public MergeSort1() {
    this(null);
  }

  @Override
  public void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  public void sort(Comparable[] a, Comparable[] b, int lo, int hi) {
    if (hi <= lo) return;
    assert null != a && null != b;
    //小于一定长度使用插入排序，经验表明可以提速10%-15%
    if (hi - lo < MAX && a != aux) {
      insertSort.sort(a, lo, hi);
      return;
    }
    int mid = (hi - lo) / 2 + lo;
    sort(b, a, lo, mid);
    sort(b, a, mid + 1, hi);
    //对有序的数据避免再次merge
    //    if (b[mid].compareTo(b[mid + 1]) > 0) {
    merge(b, a, lo, mid, hi);
    //    }
  }

  /**
   * 将a合并到b中
   *
   * @param a
   * @param lo
   * @param mid
   * @param hi
   */
  protected void merge(Comparable[] a, Comparable[] b, int lo, int mid, int hi) {
    assert a.length == b.length;
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        b[k] = a[j++];
      } else if (j > hi) {
        b[k] = a[i++];
      } else if (less(a[j], a[i])) {
        b[k] = a[j++];
      } else {
        b[k] = a[i++];
      }
    }
  }
}
