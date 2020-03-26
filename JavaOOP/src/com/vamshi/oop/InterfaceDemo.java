package com.vamshi.oop;

public interface InterfaceDemo {
    static final  String a ="static constatnt";
    public void  m1();
    public int m2();
    static void m3(){

    }
    default int m4(){
        return 0;
    }
    private int m5(){
        return 1;
    }

}

class test implements InterfaceDemo{

    @Override
    public void m1() {
        System.out.println("m1 function");
    }

    @Override
    public int m2() {
        return 0;
    }

    @Override
    public int m4() {
        return 0;
    }
}
