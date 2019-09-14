import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grid {

    public int[][] getGrid(String gridName) {
        String gridData = gridData(gridName);
        final int GRID_SIZE = 9;
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        int iterator = 0;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col] = Character.getNumericValue(gridData.charAt(iterator));
                iterator++;
            }
            iterator++;
        }
        return grid;
    }

    public void printGrid(int[][] grid) {
        final int GRID_SIZE = 9;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }

    }

    private String gridData(String gridName) {
        StringBuilder dataFlow = new StringBuilder();
        try {
            FileReader gridFile = new FileReader("grid.txt");
            BufferedReader bufferedReader = new BufferedReader(gridFile);
            String dataStream;
            while ((dataStream = bufferedReader.readLine()) != null) {
                if (dataStream.equals(gridName))
                    for (int i = 0; i < 9; i++) {
                        dataFlow.append(bufferedReader.readLine() + "\n");
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFlow.toString();
    }
}
