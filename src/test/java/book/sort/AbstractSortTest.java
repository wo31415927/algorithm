package book.sort;

import com.google.common.truth.Truth;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/** cctv 2017/10/1 */
public class AbstractSortTest {
  public static Random random = new Random();
  public static final LinkedList<Integer[][]> intList =
      new LinkedList<Integer[][]>(
          /*Lists.newArrayList(
              new Integer[][] {{0}, {0}, {4, 3, 2, 1}, {4, 3, 2, 1}},
              new Integer[][] {{0}, {3}, {1, 2, 3, 4}, {1, 2, 3, 4}},
              new Integer[][] {{0}, {3}, {4, 3, 2, 1}, {1, 2, 3, 4}},
              new Integer[][] {{1}, {2}, {4, 3, 2, 1}, {4, 2, 3, 1}})*/);
  public BaseSort baseSort;

  static {
    /*
         test for MergeSort1
    initArr(100);
    Integer[] testArr =
        new Integer[] {
          655, 3096, 3868, 5298, 7184, 7228, 9849, 4873, 7641, 7049, 2268, 8102, 9500, 8002, 6210,
          9820, 6058, 5914, 5314, 8406, 2912, 419, 102, 8580, 9382, 8114, 5093, 4703, 2687, 1394,
          3095, 258, 1983, 1937, 9072, 1018, 4762, 1607, 9770, 3450, 6437, 198, 5069, 3340, 2315,
          9245, 3422, 8753, 7262, 9047, 5105, 248, 2984, 8657, 6508, 5693, 2956, 329, 106, 3465,
          9470, 5442, 5193, 1736, 8540, 1827, 9009, 5352, 5704, 9887, 9265, 3709, 3667, 6527, 167,
          1249, 9991, 8060, 2171, 1129, 9105, 9321, 1241, 7411, 1657, 2540, 2809, 2763, 7487, 6525,
          7549, 7772, 9348, 7015, 9046, 6771, 1074, 4060, 8099, 2848
        };
    intList.getFirst()[2] = testArr;
    intList.getFirst()[3] = Arrays.copyOfRange(testArr, 0, testArr.length);
    Arrays.sort(intList.getFirst()[3]);*/

    initArr(100);
    //        initArr(10000);
    //        initArr(100000);
  }

  public static void initArr(int size) {
    Integer[] a = new Integer[size];
    for (int i = 0; i < a.length; i++) {
      a[i] = random.nextInt(size * 100);
    }
    Integer[] orgin = Arrays.copyOfRange(a, 0, a.length);
    Arrays.parallelSort(a);
    intList.addFirst(new Integer[][] {{0}, {a.length - 1}, orgin, a});
  }

  @Parameterized.Parameter(0)
  public Integer[] start;

  @Parameterized.Parameter(1)
  public Integer[] end;

  @Parameterized.Parameter(2)
  public /* NOT private */ Integer[] arr;

  @Parameterized.Parameter(3)
  public /* NOT private */ Integer[] expected;

  public void testSort() throws Exception {
    Integer[] tmp = Arrays.copyOf(arr,arr.length);
    long from = System.currentTimeMillis();
    Arrays.sort(tmp);
    System.out.println("Arrays.sort()耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    from = System.currentTimeMillis();
    baseSort.sort(arr, start[0], end[0]);
    System.out.println("MySort耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    from = System.currentTimeMillis();
    Truth.assertThat(arr).isEqualTo(expected);
    System.out.println("校验耗时：" + (System.currentTimeMillis() - from) / 1000.0);
  }
}
