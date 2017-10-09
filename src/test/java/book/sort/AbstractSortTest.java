package book.sort;

import com.google.common.truth.Truth;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * cctv 2017/10/1
 */
public class AbstractSortTest {
    public static final LinkedList<Integer[][]> intList =
            new LinkedList<Integer[][]>(
          /*Lists.newArrayList(
              new Integer[][] {{0}, {0}, {4, 3, 2, 1}, {4, 3, 2, 1}},
              new Integer[][] {{0}, {3}, {1, 2, 3, 4}, {1, 2, 3, 4}},
              new Integer[][] {{0}, {3}, {4, 3, 2, 1}, {1, 2, 3, 4}},
              new Integer[][] {{1}, {2}, {4, 3, 2, 1}, {4, 2, 3, 1}})*/);
    public static Random random = new Random();

    static {
    /*
         test for MergeSort1
         */
        /*initArrList(20);
        Integer[] testArr =
                new Integer[]{
                        403, 344, 406, 648, 456, 894, 652, 554, 1039, 1106, 1152, 1155, 1278, 1415, 1443, 1218, 1683, 1168, 1934, 1990
                };
        intList.getFirst()[2] = testArr;
        intList.getFirst()[3] = Arrays.copyOfRange(testArr, 0, testArr.length);
        Arrays.sort(intList.getFirst()[3]);*/
//                initArrList(10000);
//                initArrList(100000);
//                initArrList(10000000);
    }

    public BaseSort baseSort;
    @Parameterized.Parameter(0)
    public Integer[] start;
    @Parameterized.Parameter(1)
    public Integer[] end;
    @Parameterized.Parameter(2)
    public /* NOT private */ Integer[] arr;
    @Parameterized.Parameter(3)
    public /* NOT private */ Integer[] expected;

    public static Integer[] initArr(int size) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(size * 100);
        }
        return a;
    }

    public static void initArrList(int size) {
        Integer[] a = initArr(size);
        Integer[] orgin = Arrays.copyOfRange(a, 0, a.length);
        Arrays.parallelSort(a);
        intList.addFirst(new Integer[][]{{0}, {a.length - 1}, orgin, a});
    }

    public void testSort() throws Exception {
        Integer[] tmp = Arrays.copyOf(arr, arr.length);
        long from = System.currentTimeMillis();
        Arrays.sort(tmp);
        System.out.println("Arrays.sort()耗时：" + (System.currentTimeMillis() - from) / 1000.0);
        from = System.currentTimeMillis();
        baseSort.sort(arr, start[0], end[0]);
        System.out.println(baseSort.getClass().getSimpleName() + "耗时：" + (System.currentTimeMillis() - from) / 1000.0);
        from = System.currentTimeMillis();
        Truth.assertThat(arr).isEqualTo(expected);
        System.out.println("校验耗时：" + (System.currentTimeMillis() - from) / 1000.0);
    }
}
