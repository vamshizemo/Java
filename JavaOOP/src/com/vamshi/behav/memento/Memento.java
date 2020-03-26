package com.vamshi.behav.memento;

public class Memento {
    public static void main(String[] args) {
        var editor =new Editor();
        var history=new History();

        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());
        editor.setContent("c");
        history.push(editor.createState());
        System.out.println(editor.getContent());
        editor.restore(history.pop());
        System.out.println(editor.getContent());


    }
}
