import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowSelected = -1;
        int colSelected = -1;
        JTextField source = (JTextField) e.getSource();
        boolean found = false;
        for (int row = 0; row < GUI.GRID_SIZE && !found; row++) {
            for (int col = 0; col < GUI.GRID_SIZE && !found; col++) {
                if (GUI.cells[row][col] == source) {
                    rowSelected = row;
                    colSelected = col;
                    found = true;
                }
            }
        }
        System.out.println(GUI.solution[rowSelected][colSelected]);
        if (Integer.valueOf(GUI.cells[rowSelected][colSelected].getText()) == GUI.solution[rowSelected][colSelected])
            GUI.cells[rowSelected][colSelected].setBackground(Color.GREEN);
    }


}