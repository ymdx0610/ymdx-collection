package com.ymdx.map.ext.my;

import java.util.LinkedList;

/**
 * @ClassName: ExtLinkedListMap
 * @Description: 自定义Map，基于数组+链表实现
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 14:30
 * @Version: 1.0
 **/
public class ExtLinkedListMap<Key, Value> implements ExtMap<Key, Value> {

    /**定义链表类型的数组*/
    private LinkedList<Entry<Key, Value>>[] tables = new LinkedList[999];
    /**实际map大小*/
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
        if(entry != null){
            return entry.value;
        }
        return null;
    }

    /**
     * 根据键值key从链表数据中获取entry数据
     * @param key
     * @return
     */
    private Entry<Key, Value> getEntry(Key key){
        int hashValue = getHashValue(key);
        LinkedList<Entry<Key, Value>> linkedList = tables[hashValue];
        if(linkedList != null){
            for (Entry<Key, Value> entry : linkedList){
                if(entry.key.equals(key)){
                    return entry;
                }
            }
        }
        return null;
    }

    /**
     * 根据key值获取hash值
     * @param key
     * @return
     */
    private int getHashValue(Key key){
        int hashCode = key.hashCode();
        // 哈希算法计算散列值
        int hashValue = hashCode % tables.length;
        return hashValue;
    }

    @Override
    public void put(Key key, Value value) {
        // 新的键值数据
        Entry<Key, Value> newEntry = new Entry<>(key, value);
        // 根据key值获取hash值 -> 链表数组下标
        int hashValue = getHashValue(key);
        // 从链表数组中获取下标为hashValue的链表linkedList
        LinkedList<Entry<Key, Value>> linkedList = tables[hashValue];
        if(linkedList == null){
            // 链表为空，表示第一此在下标为hashValue的位置存放值，需要新建链表，将新数据entry存放进去
            linkedList = new LinkedList<>();
            linkedList.add(newEntry);
            tables[hashValue] = linkedList;
        }else{
            // 链表不为空，遍历链表
            for(Entry entry : linkedList){
                // 数据的key值等于新key值，直接将新的value替换掉原来的对象值entry.value
                if(entry.key.equals(key)){
                    // hashCode相同，对象值也相同的情况
                    entry.value = value;
                }else{
                    // hashCode相同，对象值不同的情况
                    linkedList.add(newEntry);
                }
            }
        }
        size ++;
    }

    @Override
    public Value remove(Key key) {
        int hashValue = getHashValue(key);
        LinkedList<Entry<Key, Value>> linkedList = tables[hashValue];
        if(linkedList != null){
            Entry<Key, Value> entry = getEntry(key);
            if(entry != null){
                Value oldValue = entry.value;
                linkedList.remove(entry);
                size --;
                return oldValue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ExtLinkedListMap<String, String> extLinkedListMap = new ExtLinkedListMap<>();
        extLinkedListMap.put("aaa", "AAA");
        extLinkedListMap.put("bbb", "BBB");
        extLinkedListMap.put("ccc", "CCC");

        System.out.println(extLinkedListMap.get("aaa"));
        System.out.println(extLinkedListMap.get("bbb"));
        System.out.println(extLinkedListMap.get("ccc"));

        extLinkedListMap.remove("aaa");
        System.out.println(extLinkedListMap.get("aaa"));
    }

}
