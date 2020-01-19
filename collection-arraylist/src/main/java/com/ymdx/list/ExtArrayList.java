package com.ymdx.list;

import java.util.Arrays;

/**
 * @ClassName: ExtArrayList
 * @Description: 自定义ArrayList
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-15 17:53
 * @Version: 1.0
 **/
public class ExtArrayList<E> implements ExtList<E> {

    /**
     * 对象数组
     */
    private Object[] elementData;

    /**
     * 初始化容量，默认为10
     */
    private static final int DEFAULT_INIT_CAPACITY = 10;

    /**
     * 元素个数
     */
    private int size;

    public ExtArrayList(int initCapacity) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("初始化容量（" + initCapacity + "）不能小于0");
        }
        elementData = new Object[initCapacity];
        size = 0;
    }

    public ExtArrayList() {
        this(DEFAULT_INIT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object obj : elementData) {
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E e) {
        ensureExplicitCapacity(size + 1);
        elementData[size++] = e;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // 如果元素的个数等于数组的长度，说明数组已经满，此时需要扩容
        if (size == elementData.length) {
            // 原数组容量
            int oldCapacity = elementData.length;
            // 新数组容量，是原数组容量的1.5倍
            int newCapacity = oldCapacity + oldCapacity >> 1;
            // 新数组容量小于最小扩容容量，则将最小扩容容量赋值给新数组容量
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
//            Object[] newElementData = new Object[newCapacity];
//            for(int i = 0; i < newElementData.length; i++){
//                newElementData[i] = elementData[i];
//            }
//            elementData = newElementData;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @Override
    public void add(int index, E e) {
        rangeCheck(index);
        ensureExplicitCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("数组越界啦!");
        }
    }

    @Override
    public E set(int index, E e) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        E e = get(index);
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return e;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            for (int i = 0; i < elementData.length; i++) {
                Object removing = elementData[i];
                if (removing == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < elementData.length; i++) {
                Object removing = elementData[i];
                if (obj.equals(removing)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

}
