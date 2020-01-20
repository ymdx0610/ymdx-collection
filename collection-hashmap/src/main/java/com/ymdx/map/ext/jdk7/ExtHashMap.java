package com.ymdx.map.ext.jdk7;

/**
 * @ClassName: ExtHashMap
 * @Description: 手写JDK7版本的HashMap
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 16:18
 * @Version: 1.0
 **/
public class ExtHashMap<K, V> implements ExtMap<K, V> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public V remove(K k) {
        return null;
    }

}
