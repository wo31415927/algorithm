package book.search;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.util.Arrays;

import book.sort.AbstractSortTest;

/**
 * zeyu
 * 2017/10/17
 */
public class BinarySearchTest {
    @Test
    public void testBase() throws Exception {
        Integer[] arr = AbstractSortTest.initArr(100000);
        Arrays.sort(arr);
        int index = arr.length / 2;
        Truth.assertThat(Arrays.binarySearch(arr, arr[index])).isEqualTo(index);
        Truth.assertThat(BinarySearch.rankRecursion(arr[index], arr)).isEqualTo(index);
        Truth.assertThat(BinarySearch.rank(arr[index], arr)).isEqualTo(index);

        //-(insertion point) - 1
        Truth.assertThat(Math.abs(Arrays.binarySearch(arr, arr[index]-1)) - 1).isEqualTo(index);
        Truth.assertThat(BinarySearch.rankRecursion(arr[index]-1, arr)).isEqualTo(index);
        Truth.assertThat(BinarySearch.rank(arr[index]-1, arr)).isEqualTo(index);

        Truth.assertThat(Math.abs(Arrays.binarySearch(arr, arr[index]+1)) - 1).isEqualTo(index+1);
        Truth.assertThat(BinarySearch.rankRecursion(arr[index]+1, arr)).isEqualTo(index+1);
        Truth.assertThat(BinarySearch.rank(arr[index]+1, arr)).isEqualTo(index+1);
    }
}