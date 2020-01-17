package com.ymdx.list;

/**
 * @ClassName: ExtList
 * @Description: 自定义List接口
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-15 17:53
 * @Version: 1.0
 **/
public interface ExtList<E> {

    /**
     * 获取集合长度
     * @return
     */
    int size();

    /**
     * 判断集合是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断集合中是否包含元素o
     * @param o 元素
     * @return
     */
    boolean contains(Object o);

    /**
     * 添加元素
     * @param e 指定元素
     */
    void add(E e);

    /**
     * 向指定下标位置添加元素
     * @param index 集合下标
     * @param e 新元素
     */
    void add(int index, E e);

    /**
     * 根据下标获取元素
     * @param index 集合下标
     * @return
     */
    E get(int index);

    /**
     * 向指定下标位置添加元素，并返回旧值
     * @param index 集合下标
     * @param e 新值
     * @return
     */
    E set(int index, E e);

    /**
     * 根据下标删除元素，并返回删除的元素
     * @param index 集合下标
     * @return
     */
    E remove(int index);

    /**
     * 从集合中删除指定元素e
     * @param e 要删除的元素
     * @return true，表示删除成功；false，表示删除失败
     */
    boolean remove(E e);

}
