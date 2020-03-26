package com.vamshi.behav.state;

public class Main {
    public static void main(String[] args) {
        Canvas canvas=new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
