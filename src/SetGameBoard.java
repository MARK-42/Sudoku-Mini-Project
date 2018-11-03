import java.util.*;

public class SetGameBoard {
    private int[][] sudokuBoxElementArray;

    SetGameBoard(){
        sudokuBoxElementArray = new int[9][9];
        int i,j;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                sudokuBoxElementArray[i][j]=0;
            }
        }
    }

    public int[][] getSudokuElementArray(){
        return sudokuBoxElementArray;
    }

}
