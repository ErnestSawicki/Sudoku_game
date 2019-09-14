import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {
        if (!isSingleNumber(e.getKeyChar())) {
            e.consume();
        }
    }

    private boolean isSingleNumber(char str) {
        if (str < '1' || str > '9')
            return false;
        return true;
    }

}
