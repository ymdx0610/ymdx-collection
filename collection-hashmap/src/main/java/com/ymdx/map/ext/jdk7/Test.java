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
        extHashMap.put("1号", "111");
        extHashMap.put("2号", "222");
        extHashMap.put("3号", "333");
        extHashMap.put("4号", "444");
        extHashMap.put("5号", "555");
        extHashMap.put("6号", "666");
        extHashMap.put("7号", "777");
        extHashMap.put("14号", "14");
        extHashMap.print();
        System.out.println(extHashMap.get("3号"));
    }
}
