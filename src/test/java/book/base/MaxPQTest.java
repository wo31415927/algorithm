package book.base;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import book.sort.AbstractSortTest;

/**
 * zeyu
 * 2017/10/11
 */
public class MaxPQTest {
    protected MaxPQ pq;

    @Test
    public void testPQ() throws Exception {
        pq = new MaxPQ(new Integer[]{2, 1, 3});
        pq.insert(4);
        Truth.assertThat(pq.max()).isEqualTo(4);
        Truth.assertThat(pq.size()).isEqualTo(4);
        Truth.assertThat(pq.getArr().length).isEqualTo(8);
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.delMax());
        }
        Truth.assertThat(pq.max()).isEqualTo(1);
        Truth.assertThat(pq.size()).isEqualTo(1);
        Truth.assertThat(pq.getArr().length).isEqualTo(4);
    }

    @Test
    public void testLargeArr() throws Exception {
        Integer[] arr = AbstractSortTest.initArr(1000000);
        Integer[] expected = Arrays.copyOf(arr,arr.length);
        Arrays.parallelSort(expected, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        pq = new MaxPQ(arr);
        for(Integer i : expected){
            Truth.assertThat(i).isEqualTo(pq.delMax());
        }
    }
}