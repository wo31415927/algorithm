package book.sort.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * zeyu
 * 2017/10/16
 */
public class KendallTauTest {
    @Test
    public void testCalcDistance() throws Exception {
        int[] a1 = {0, 3, 1, 6, 2, 5, 4};
        int[] a2 = {1, 0, 3, 6, 4, 2, 5};
        System.out.println(KendallTau.calcDistance(Arrays.stream(a2).boxed().toArray(Integer[]::new), Arrays.stream(a1).boxed().toArray(
                Integer[]::new)));
        System.out.println(KendallTau.distance(a1, a2));
    }

    @Test
    public void testTmp() throws Exception {
        Integer[] a1 = {2, 4, 6, 0, 3, 5};
        System.out.println(Inversions.merge(a1,new Integer[a1.length],0,2,a1.length-1));
    }
}