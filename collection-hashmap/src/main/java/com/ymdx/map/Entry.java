package com.ymdx.map;

/**
 * @ClassName: Entry
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 14:27
 * @Version: 1.0
 **/
public class Entry<Key, Value> {
    Key key;
    Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
