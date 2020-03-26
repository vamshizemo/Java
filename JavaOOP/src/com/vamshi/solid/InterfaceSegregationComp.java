package com.vamshi.solid;

interface  BaseMobile{
    void call();
    void message();

}
interface Hardkey{
    void dialhardkeypad();
}
class OldNokia1 implements BaseMobile,Hardkey{

    @Override
    public void call() {

    }

    @Override
    public void message() {

    }

    @Override
    public void dialhardkeypad() {

    }
}

class Samsung1 implements BaseMobile{

    @Override
    public void call() {

    }

    @Override
    public void message() {

    }
}

public class InterfaceSegregationComp {
    public static void main(String[] args) {
        OldNokia1 nokia = new OldNokia1();
        Samsung1 samsung = new Samsung1();
    }
}
