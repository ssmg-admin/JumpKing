package jumpKing.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean middlePressed;

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftPressed = true;
            case MouseEvent.BUTTON2 -> middlePressed = true;
            case MouseEvent.BUTTON3 -> rightPressed = true;
            default -> { }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftPressed = false;
            case MouseEvent.BUTTON2 -> middlePressed = false;
            case MouseEvent.BUTTON3 -> rightPressed = false;
            default -> { }
        }
    }
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public boolean isLeftPressed() {return leftPressed;}
    public boolean isRightPressed() {return rightPressed;}
    public boolean isMiddlePressed() {return middlePressed;}
}
