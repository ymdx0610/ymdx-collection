package com.ymdx.map.ext.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ExtArrayListMap
 * @Description: 自定义Map，基于ArrayList实现，效率比较低
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 14:25
 * @Version: 1.0
 **/
public class ExtArrayListMap<Key, Value> implements ExtMap<Key, Value>{

    private List<Entry<Key, Value>> entries = new ArrayList<>();
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Value get(Key key) {
        Entry<Key, Value> entry = getEntry(key);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    private Entry<Key, Value> getEntry(Key key) {
        for (Entry entry : entries) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        Entry<Key, Value> entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
        } else {
            Entry<Key, Value> newEntry = new Entry(key, value);
            entries.add(newEntry);
            size ++;
        }
    }

    @Override
    public Value remove(Key key) {
        Entry<Key, Value> entry = getEntry(key);
        if (entry != null) {
            Value oldValue = entry.value;
            entries.remove(entry);
            size --;
            return oldValue;
        }
        return null;
    }

    public static void main(String[] args) {
        ExtArrayListMap<String, String> extArrayListMap = new ExtArrayListMap<>();
        extArrayListMap.put("a", "AAA");
        extArrayListMap.put("b", "BBB");
        extArrayListMap.put("c", "CCC");

        System.out.println(extArrayListMap.get("a"));
        System.out.println(extArrayListMap.get("b"));
        System.out.println(extArrayListMap.get("c"));

        extArrayListMap.remove("a");
        System.out.println(extArrayListMap.get("a"));
    }

}
