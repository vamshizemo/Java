package com.vamshi.solid;

class Desktop{
    Monitor monitor ;
    KeyBoard keyBoard ;

    void setMonitor(Monitor monitor){
        this.monitor=monitor;

    }
    void setKeyBoard(KeyBoard keyBoard){
        this.keyBoard=keyBoard;

    }
}

class Monitor{

}

class KeyBoard{

}
public class DependencyInversion {
    public static void main(String[] args) {
        Desktop myDesktop = new Desktop();
    }
}
