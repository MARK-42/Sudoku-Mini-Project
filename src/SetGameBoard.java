import java.util.*;

public class SetGameBoard {
    private int[][] sudokuBoxElementArray;

    SetGameBoard(){
       Algo sa=new Algo();
       sudokuBoxElementArray=sa.getGrid();
    }

    public int[][] getSudokuElementArray(){
        return sudokuBoxElementArray;
    }

    public void setSudokuBoxElementArray(int[][] sudokuBoxElementArray) {
        this.sudokuBoxElementArray = sudokuBoxElementArray;
    }
}
