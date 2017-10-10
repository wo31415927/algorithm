package data;

import com.google.common.truth.Truth;

import org.junit.Test;

import book.base.UF;

/**
 * zeyu
 * 2017/9/22
 */
public class UFTest {
    @Test
    public void testUF() throws Exception {
        UF uf = new UF(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(0, 6);
        uf.union(7, 8);
        uf.union(4, 5);
        uf.printById();
        Truth.assertThat(uf.count()).isEqualTo(5);
        Truth.assertThat(uf.connected(1, 3)).isTrue();
        Truth.assertThat(uf.connected(1, 6)).isFalse();
        Truth.assertThat(uf.find(1)).isEqualTo(1);
        uf.union(0, 1);
        uf.union(4, 7);
        uf.union(7, 9);
        System.out.println("");
        uf.printById();
        Truth.assertThat(uf.connected(1, 2)).isTrue();
        Truth.assertThat(uf.connected(1, 6)).isTrue();
        Truth.assertThat(uf.connected(1, 4)).isFalse();
        Truth.assertThat(uf.count()).isEqualTo(2);
        Truth.assertThat(uf.find(1)).isEqualTo(0);
    }
}