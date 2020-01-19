package com.ymdx.list;

/**
 * @ClassName: ExtLinkedList
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-17 14:42
 * @Version: 1.0
 **/
public class ExtLinkedList<E> implements ExtList<E> {
    /** 集合节点个数，默认为0*/
    private int size = 0;

    /** 头节点 */
    private Node first;

    /** 尾节点 */
    private Node last;

    private static class Node<E>{
        /** 上一个节点 */
        Node prev;
        /** 节点数据 */
        E item;
        /** 下一个节点 */
        Node next;

        public Node(){}

        public Node(Node prev, E item, Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
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
        if(o == null){
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    return true;
                }
            }
        }else{
            for(Node<E> x = first; x != null; x = x.next){
                if(o.equals(x.item)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(E e) {
        // 创建新节点，节点数据item为e
        Node node = new Node();
        node.item = e;
        // 如果头节点为空，表示当前为空链表
        if(first == null){
            // 将新创建的节点赋值给头节点，即当前头节点为新节点
            first = node;
        }else{
            // 将尾节点赋值给新节点的上一个节点
            node.prev = last;
            // 将新节点赋值给尾节点的下一个节点
            last.next = node;
        }
        // 将新节点赋值给尾节点，即当前尾节点为新节点
        last = node;
        size ++;
    }

    @Override
    public void add(int index, E e) {
        // 创建新节点
        Node newNode = new Node();
        newNode.item = e;

        // 获取原来节点
        Node oldNode = getNode(index);
        // 获取原节点的上一个节点
        Node oldNodePrev = oldNode.prev;

        // 原节点的上一个节点为新节点
        oldNode.prev = newNode;
        // 新节点的下一个节点为原节点
        newNode.next = oldNode;

        // 如果原节点的上一个节点为空，说明原节点为链表的头节点
        if(oldNodePrev == null){
            // 将新节点设置为头节点
            first = newNode;
        }else{
            newNode.prev = oldNodePrev;
            oldNodePrev.next = newNode;
        }
        size ++;
    }

    @Override
    public E get(int index) {
        Node node = getNode(index);
        return (E) node.item;
    }

    private Node getNode(int index) {
        // 校验下标是否合法
        checkElementIndex(index);
        Node node = null;
        if(first != null){
            // 从头节点开始一个个查找
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("越界啦！");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public E set(int index, E e) {
        Node oldNode = getNode(index);
        E oldValue = (E) oldNode.item;
        oldNode.item = e;
        return oldValue ;
    }

    @Override
    public E remove(int index) {
        return unlink(getNode(index));
    }

    private E unlink(Node oldNode){
        E oldValue = (E) oldNode.item;
        if(oldNode != null){
            // 获取原节点的上一个节点
            Node oldNodePrev = oldNode.prev;
            // 获取原节点的下一个节点
            Node oldNodeNext = oldNode.next;

            // 如果原节点的上一个节点为空，说明原节点为链表的头节点
            if(oldNodePrev == null){
                first = oldNodeNext;
            }else{
                oldNodePrev.next = oldNodeNext;
                oldNode.prev = null;
            }

            // 如果原节点的下一个节点为空，说明原节点为链表的尾节点
            if(oldNodeNext == null){
                last = oldNodePrev;
            }else{
                oldNodeNext.prev = oldNodePrev;
                oldNode.next = null;
            }
            oldNode.item = null;
            size --;
        }
        return oldValue;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj == null){
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    unlink(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x = first; x != null; x = x.next){
                if(obj.equals(x.item)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

}
