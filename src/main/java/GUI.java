import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel panel = new JPanel();
    public static final int GRID_SIZE = 9;
    public final int CELL_SIZE = 60;   // Cell width/height in pixels
    public final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
    public final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
    private int SUB_GRID_SIZE = 3;
    public static JTextField[][] cells = new JTextField[GRID_SIZE][GRID_SIZE];
    InputListener listener = new InputListener();

    static int[][] solution = new int[GRID_SIZE][GRID_SIZE];


    private int[][] initialSudoku = new int[][]
            {{0, 0, 0, 4, 5, 6, 7, 8, 9},
                    {0, 8, 0, 0, 5, 6, 7, 8, 9},
                    {6, 0, 2, 4, 5, 6, 7, 0, 9},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 2, 3, 4, 0, 6, 7, 8, 9},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 2, 3, 0, 5, 6, 7, 8, 9},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9}};


    public GUI() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("GUI");
        this.setBounds(400, 400, 600, 600);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(GRID_SIZE + 1, GRID_SIZE));
        cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        constructGrid();
        setUpSolution(solution1);
        this.getContentPane().add(panel);
        pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void constructGrid() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col] = new JTextField();
                getContentPane().add(cells[row][col]);
                cells[row][col].setText(Integer.toString(initialSudoku[row][col]));
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(new Font("Monospaced", Font.BOLD, 20));
                if (initialSudoku[row][col] == 0) {
                    cells[row][col].setBackground(Color.YELLOW);
                }
                cells[row][col].addKeyListener(new KeyListener());
                cells[row][col].addActionListener(listener);
            }
        }
    }



    public int[][] getSolution() {
        return solution;
    }

    private String solution1 = "957613284483257196612849537178364952524971368369528741845792613291436875736185429";
    private void setUpSolution(String s) {
        if (s.length() == 81) {
            int iterator = 0;
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    solution[row][col] = Integer.valueOf(String.valueOf(s.charAt(iterator)));
                    iterator++;
                }
            }
        }
    }

}
