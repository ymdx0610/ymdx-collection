package com.ymdx.map.ext.jdk7;

/**
 * @ClassName: ExtMap
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 16:13
 * @Version: 1.0
 **/
public interface ExtMap<K, V> {

    /** 获取Map集合元素个数 */
    int size();

    /** 判断Map集合是否为空 */
    boolean isEmpty();

    /** 向Map集合中插入数据 */
    V put(K k, V v);

    /** 根据k从Map集合中查询元素 */
    V get(K k);

    /** 从Map集合中删除键值为key的元素 */
    V remove(K k);

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);
    }

}