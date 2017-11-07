package tmp;

import com.google.common.collect.Maps;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * zeyu
 * 2017/11/2
 */
public class Test implements Iterable{
    public HashMap init(Map m){
        System.out.println("Map:" + m);
        return Maps.newHashMap(m);
    }
    public void init(HashMap m){
        System.out.println("HashMap:" + m);
    }

    public static void main(String[] args) {
        Test t = new Test();
        TreeMap<String,String> m = Maps.newTreeMap();
        m.put("Chen","Xiang");
        m.put("Chen1","Xiang1");
        int[] a;
        t.init(m);
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
