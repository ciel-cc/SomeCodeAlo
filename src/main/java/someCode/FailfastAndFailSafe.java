package someCode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FailfastAndFailSafe {

    public static void main(String[] args) {
        /**快速失败*/
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("aaa",1);
        hashMap.put("bbb",2);
        hashMap.put("ccc",3);
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //hashmap put已有的key，即value覆盖，不会发生异常
            hashMap.put("aaa", 7);
            //hashmap结构被改变，会抛出异常
            //hashmap由modCount来负责出现线程问题时，即使抛出异常
            //modCount字段主要用来记录HashMap内部结构发生变化的次数
            hashMap.put("新增元素，改变结构", 2);
            System.out.println("长度为："+hashMap.size());
        }

        //安全失败
        ConcurrentHashMap<String, Integer> conHashMap = new ConcurrentHashMap<>();
        conHashMap.put("aaa",1);
        conHashMap.put("bbb",2);
        conHashMap.put("ccc",3);
        Set setset = conHashMap.entrySet();
        Iterator iteratorit = setset.iterator();
        while (iteratorit.hasNext()){
            System.out.println(iteratorit.next());
            conHashMap.put("下次会发生异常", 1);
            System.out.println("长度为："+conHashMap.size());
        }

        //hashtable
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("aaa",1);
        hashtable.put("bbb",2);
        hashtable.put("ccc",3);
        Set set2 = hashtable.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
            hashtable.put("新增元素，改变结构", 2);
            System.out.println("长度为："+hashtable.size());
        }
    }
}
