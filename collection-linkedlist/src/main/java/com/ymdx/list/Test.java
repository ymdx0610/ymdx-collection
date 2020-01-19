package com.ymdx.list;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-17 14:42
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {
        ExtList<String> list = new ExtLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

//        // add(E e) 与 get(int index)
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

//        // add(int index, E e)
//        list.add(0, "X");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

//        // set(int index, E e)
//        list.set(5, "X");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

//        list.remove(4);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

//        // remove(int index)
//        list.remove(4);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

//        // remove(Object obj)
//        list.remove("C");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("############");

        // contains(Object obj)
        System.out.println(list.contains("F"));
        System.out.println("############");

    }

}
