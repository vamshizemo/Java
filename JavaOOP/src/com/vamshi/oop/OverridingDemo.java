package com.vamshi.oop;
class Vehicle{
    int version=1;
    public void run(){
        System.out.println("vehicle is running");
    }
}
class car extends Vehicle{
    int price=1000;
    public void run(){
        System.out.println("car is running");
    }
}
public class OverridingDemo {
    public static void main(String[] args) {
        Vehicle v=new Vehicle();
        v.run();
        car c=new car();
        c.run();
        System.out.println(c.price);
        Vehicle vcar=new car();
        vcar.run();
        System.out.println(vcar.version);
    }
}
