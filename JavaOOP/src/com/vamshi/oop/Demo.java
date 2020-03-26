package com.vamshi.oop;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.util.Calendar;

public class Demo {
    public  static void main(String[] args){
        Fan myFan = new Fan(true);
        myFan.turnOn();
        myFan.turnOff();
        Fan yourFan =new Fan(false);
        System.out.println(myFan.num);
        myFan.num =6;
        System.out.println(yourFan.num);
        System.out.println("hello world");
        Addition x=new Addition();
        System.out.println(x.findSum(3,5));
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(Addition.findSum(5,8));
        psudoAdd pa=new psudoAdd();
        System.out.println(pa.findSum(3,5));

        test t1=new test();
        t1.m1();

    }
}
