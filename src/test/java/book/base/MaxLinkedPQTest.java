package book.base;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import book.sort.AbstractSortTest;

/**
 * zeyu
 * 2017/10/12
 */
public class MaxLinkedPQTest{
    protected MaxLinkedPQ pq;

    @Test
    public void testPQ() throws Exception {
        pq = new MaxLinkedPQ<Integer>(new Integer[]{2, 1, 3});
        pq.insert(4);
        Truth.assertThat(pq.max()).isEqualTo(4);
        Truth.assertThat(pq.size()).isEqualTo(4);
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.delMax());
        }
        Truth.assertThat(pq.max()).isEqualTo(1);
        Truth.assertThat(pq.size()).isEqualTo(1);
    }

    @Test
    public void testLargeArr() throws Exception {
        Integer[] arr = AbstractSortTest.initArr(1000);
        Integer[] expected = Arrays.copyOf(arr,arr.length);
        Arrays.parallelSort(expected, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        pq = new MaxLinkedPQ(arr);
        for(Integer i : expected){
            Truth.assertThat(i).isEqualTo(pq.delMax());
        }
    }
}