package Interfaces.MouseListener;

public class Main {

    private static void addMouseListener (MouseListener l){
        l.mouseDown();
        l.mouseUp();
    }
    public static void main(String[] args) {
        MouseAdapter m = new MouseAdapter();
        addMouseListener(m);
        addMouseListener(new MouseAdapter());
        MouseListener l = new MouseListener() {
            @Override
            public void mouseUp() {

            }

            @Override
            public void mouseDown() {

            }
        };
        addMouseListener(l);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseUp() {
            }

            @Override
            public void mouseDown() {
            }
        });
    }
}
