package com.ymdx.map.ext.jdk7;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-21 17:21
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {
        ExtHashMap<String, String> extHashMap = new ExtHashMap<>();
        extHashMap.put("1号", "01");
        extHashMap.put("2号", "02");
        extHashMap.put("3号", "03");
        extHashMap.put("4号", "04");
        extHashMap.put("5号", "05");
        extHashMap.put("6号", "06");
        extHashMap.put("7号", "07");
        extHashMap.put("14号", "14");
        extHashMap.put("22号", "22");
        extHashMap.put("26号", "26");
        extHashMap.put("27号", "27");
        extHashMap.put("28号", "28");
        System.out.println("扩容前数据============");
        extHashMap.print();
        extHashMap.put("66号", "66");
        extHashMap.put("30号", "30");
        extHashMap.put("31号", "31");
        System.out.println("扩容后数据============");
        extHashMap.print();
        System.out.println(extHashMap.get("3号"));
        System.out.println("------------");
        extHashMap.put("22号", "XXX");
        System.out.println(extHashMap.get("22号"));
    }

}
