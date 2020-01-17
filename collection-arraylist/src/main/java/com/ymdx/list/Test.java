package com.ymdx.list;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-16 13:36
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {
        ExtList<String> extList = new ExtArrayList<>();
        extList.add("A");
        extList.add("B");
        extList.add("C");
        extList.add("D");
        extList.add("E");
        System.out.println(extList.get(4));
        System.out.println("############");

        extList.add(2, "X");
        for(int i=0;i<extList.size();i++){
            System.out.print(extList.get(i));
        }
        System.out.println();
        System.out.println("############");

        String oldValue = extList.set(2, "Y");
        System.out.println(oldValue);
        for(int i=0;i<extList.size();i++){
            System.out.print(extList.get(i));
        }
        System.out.println();
        System.out.println("############");

        String removedValue = extList.remove(2);
        System.out.println(removedValue);
        for(int i=0;i<extList.size();i++){
            System.out.print(extList.get(i));
        }
        System.out.println();
        System.out.println("############");

        boolean flag = extList.remove("E");
        System.out.println(flag);
        for(int i=0;i<extList.size();i++){
            System.out.print(extList.get(i));
        }

    }
}
