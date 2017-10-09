package book.sort;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static book.sort.AbstractSortTest.initArr;

/** zeyu 2017/10/9 */
public class SortCompTest {
  protected InsertSort insertSort = new InsertSort();
  protected MergeSort mergeSort = new MergeSort();
  protected MergeSort1 mergeSort1 = new MergeSort1();
  protected QuickSort quickSort = new QuickSort();
  protected QuickSampleSort quickSampleSort = new QuickSampleSort();
  protected QuickNonRecursionSort quickNonRecursionSort = new QuickNonRecursionSort();
  protected Quick3ParMedSort quick3ParMedSort = new Quick3ParMedSort();
  protected Quick3SideSort quick3SideSort = new Quick3SideSort();
  protected List<BaseSort> sortList =
      Lists.newArrayList(
          new BaseSort() {
            @Override
            protected void sort(Comparable[] a, int start, int end) {
              Arrays.sort(a);
            }

            @Override
            protected String name() {
              return "Arrays.sort()";
            }
          },
          new BaseSort() {
            @Override
            protected void sort(Comparable[] a, int start, int end) {
              Arrays.parallelSort(a, start, end);
            }

            @Override
            protected String name() {
              return "Arrays.parallelSort()";
            }
          },
          mergeSort,
          mergeSort1,
          quickSort,
          quickSampleSort,
          quickNonRecursionSort,
          quick3ParMedSort,
          quick3SideSort);
  protected List<Integer[]> arrList = Lists.newArrayList();

  @Before
  public void setUp() throws Exception {
    Integer[] arr = initArr(10000000);
    for (int i = 0; i < sortList.size(); i++) {
      if (0 == i) {
        arrList.add(arr);
      } else {
        arrList.add(Arrays.copyOf(arr, arr.length));
      }
    }
  }

  @Test
  public void comp() throws Exception {
    for (int i = 0; i < sortList.size(); i++) {
      long from = System.currentTimeMillis();
      sortList.get(i).sort(arrList.get(i));
      System.out.println(
          sortList.get(i).name() + "耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    }
  }
}
