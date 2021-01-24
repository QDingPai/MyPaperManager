package com.nefu.se.graduationprocessmanagement.component;

public class TestUtils {
//    懒汉式
    private static TestUtils testUtils = null;

    private TestUtils(){}

    public static synchronized TestUtils getInstance(){
        if( testUtils == null ){
            testUtils = new TestUtils();
        }
        return testUtils;
    }
}
