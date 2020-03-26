package com.vamshi.behav.state;

public class EraserTool implements Tool{
    @Override
    public void mouseDown() {
        System.out.println("eraser icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("erase the drawing");
    }
}
