package com.ymdx.map;

/**
 * @ClassName: ExtMap
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 14:30
 * @Version: 1.0
 **/
/**
 * @ClassName: ExtMap
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-20 14:03
 * @Version: 1.0
 **/
public interface ExtMap<Key, Value> {

    int size();

    boolean isEmpty();

    Value get(Key key);

    void put(Key key, Value value);

    Value remove(Key key);

}
