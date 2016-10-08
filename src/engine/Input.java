package engine;

import java.awt.event.*;

/**
 * Created by Leo on 27.09.2016.
 */

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    Engine engine;

    private static boolean[] buttons = new boolean[256];
    private static boolean[] prevButtons = new boolean[256];
    private static boolean[] keys = new boolean[256];
    private static boolean[] prevKeys = new boolean[256];

    public Input(Engine en) {
        this.engine = en;
        engine.getWindow().getCanvas().addKeyListener(this);
        engine.getWindow().getCanvas().addMouseListener(this);
        engine.getWindow().getCanvas().addMouseMotionListener(this);
        engine.getWindow().getCanvas().addMouseWheelListener(this);

    }

    public void update() {
        prevKeys = keys.clone();
        prevButtons = buttons.clone();
    }

    public static boolean isKeyDown(final int keyCode) {
        return keys[keyCode];
    }

    public static boolean isKeyPressed(final int keyCode) {
        return keys[keyCode] && !prevKeys[keyCode];
    }

    public static boolean isKeyReleased(final int keyCode) {
        return !keys[keyCode] && prevKeys[keyCode];
    }

    public static boolean isButtonDown(final int button) {
        return buttons[button];
    }

    public static boolean isButtonPressed(final int button) {
        return keys[button] && !prevButtons[button];
    }

    public static boolean isButtonReleased(final int button) {
        return !buttons[button] && prevButtons[button];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
