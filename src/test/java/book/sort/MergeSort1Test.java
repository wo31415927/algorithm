package book.sort;

import com.google.common.truth.Truth;

import org.junit.Before;

import java.util.Arrays;

/** cctv 2017/10/1 */
public class MergeSort1Test extends MergeSortTest {
  @Override
  @Before
  public void setUp() throws Exception {
    baseSort = new MergeSort1(new Integer[arr.length]);
  }

  @Override
  public void testSort() throws Exception {
    Integer[] tmp = Arrays.copyOf(arr,arr.length);
    long from = System.currentTimeMillis();
    Arrays.sort(tmp);
    System.out.println("Arrays.sort()耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    from = System.currentTimeMillis();
    MergeSort1 mergeSort1 = (MergeSort1) baseSort;
    mergeSort1.sort(arr, mergeSort1.getAux(), start[0], end[0]);
    System.out.println(baseSort.getClass().getSimpleName() + "耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    from = System.currentTimeMillis();
    Truth.assertThat(arr).isEqualTo(expected);
    System.out.println("校验耗时：" + (System.currentTimeMillis() - from) / 1000.0);
  }
}
