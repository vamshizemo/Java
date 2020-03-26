package com.vamshi.oop;

class bird{
    public void getinfo(){
        System.out.println("I am a bird");
    }
}
class sparrow extends bird{
    public void fly(){
        System.out.println("I am flying");
    }
}
class ostrich extends bird{

}
public class LSPDemo {
    public static void main(String[] args) {
        bird os=new sparrow();
        os.getinfo();

    }
}

