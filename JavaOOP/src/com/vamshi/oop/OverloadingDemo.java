package com.vamshi.oop;

class Addition1{
    public void sum(int a,int b){
        System.out.println("sum is :"+(a+b));
    }
    public void sum(int a, int b, int c){
        System.out.println("sum in 3 nums is ..:"+(a+b+c));
    }
    public void sum(double a, double b){
        System.out.println("double sum is ..:"+(a+b));
    }
}
public class OverloadingDemo {
    public static void main(String[] args) {
        Addition1 add= new Addition1();
        add.sum(5, 7);
    }

}
