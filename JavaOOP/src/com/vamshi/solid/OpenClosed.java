package com.vamshi.solid;

class Mobile{
    private String screen;
    private String model;
    private String camera;
}

class SamsungPhone extends Mobile{
    private String fingerPrintSensor;
}
class Nokia extends Mobile{

}
public class OpenClosed {
    public static void main(String[] args) {
       SamsungPhone Samsung = new SamsungPhone();
       Nokia nokia = new Nokia();
    }
}
