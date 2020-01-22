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

    /**
     * 定义单链表数据table
     */
    private Node<K, V>[] table = null;

    /**
     * map大小，即元素个数
     */
    private int size = 0;

    /**
     * 定义map默认的初始化容量为16
     */
    static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 定义负载因子，默认为0.75
     */
    static float DEFAULT_LOAD_FACTOR = 0.75f;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K k, V v) {
        // 延迟初始化数组
        if (table == null) {
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }

        if (size >= DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR) {
            System.out.println("-----开始扩容-----");
            resize();
        }

        // 计算下标
        int index = getIndex(k, DEFAULT_INITIAL_CAPACITY);
        // 获取下标为index的链表
        Node<K, V> node = table[index];
        // 下标为index的链表为空，表示第一次存放数据
        if (node == null) {
            node = new Node<>(k, v, null);
            size++;
        } else {
            // 遍历单链表
            for (Node<K, V> tmpNode = node; tmpNode != null; tmpNode = tmpNode.next) {
                // hashCode相同，equals相等，表示同一个对象，直接将对象原来的值修改为新值
                if (tmpNode.getKey().equals(k) || tmpNode.getKey() == k) {
                    return tmpNode.setValue(v);
                } else {
                    // key不同，但是通过对key进行hash算法，取出的下标位置相同，即发生了hash碰撞
                    // 新节点存在在原来节点前面
                    node = new Node<>(k, v, tmpNode);
                    size++;
                }
            }
        }
        table[index] = node;
        return null;
    }

    /**
     * 链表数组扩容
     */
    private void resize() {
        // 创建新的链表数组，新数组容量是原来数组的2倍
        Node<K, V>[] newTable = new Node[DEFAULT_INITIAL_CAPACITY << 1];
        // 遍历原来数组
        for (int i = 0; i < table.length; i++) {
            // 原来节点
            Node<K, V> oldNode = table[i];
            while (oldNode != null) {
                // 重新计算index
                int index = getIndex(oldNode.getKey(), newTable.length);
                // 原节点的下一个节点
                Node<K, V> oldNodeNext = oldNode.next;
                // 原节点与原节点的下一个节点分别存储到新数组中
                oldNode.next = newTable[index];
                newTable[index] = oldNode;
                // 获取下一个节点，判断是否继续循环
                oldNode = oldNodeNext;
            }
        }
        // 将新数组引用赋值给原来数组
        table = newTable;
        // 修改默认容量为新数组长度
        DEFAULT_INITIAL_CAPACITY = newTable.length;
        // 将对象设置为不可达对象
        newTable = null;
    }

    /**
     * 打印map元素
     */
    public void print() {
        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            System.out.print("下标位置[" + i + "] -> ");
            for (Node tmpNode = node; tmpNode != null; tmpNode = tmpNode.next) {
                System.out.print("[key=" + tmpNode.key + "; value=" + tmpNode.value + "]");
            }
            System.out.println();
        }
    }

    private int getIndex(K k, int length) {
        return k.hashCode() % length;
    }

    @Override
    public V get(K k) {
        Node<K, V> node = getNode(k);
        return node == null ? null : node.getValue();
    }

    private Node<K, V> getNode(K k) {
        int index = getIndex(k, DEFAULT_INITIAL_CAPACITY);
        Node<K, V> node = table[index];
        // 遍历链表
        for (Node<K, V> tmpNode = node; tmpNode != null; tmpNode = tmpNode.next) {
            if (tmpNode.getKey().equals(k) || tmpNode.getKey() == k) {
                return tmpNode;
            }
        }
        return null;
    }


    @Override
    public V remove(K k) {
        // TODO
        return null;
    }

}

/**
 * 定义单链表
 *
 * @param <K>
 * @param <V>
 */
class Node<K, V> implements ExtMap.Entry<K, V> {

    K key;
    V value;
    Node<K, V> next;

    public Node() {
    }

    public Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

}
