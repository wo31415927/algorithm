package data;

import com.google.common.truth.Truth;

import org.junit.Test;

/**
 * zeyu
 * 2017/9/21
 */
public class Stack2Test {
    @Test
    public void testStack2() throws Exception {
        Stack2<Integer> s = new Stack2<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        for(Integer i : s){
            System.out.println(i);
        }
        Truth.assertThat(s.size()).isEqualTo(2);
    }
}