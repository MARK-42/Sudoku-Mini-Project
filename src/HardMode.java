import javax.swing.*;
import  java.util.*;

class HardMode extends SetGameBoard {
    private int numFilledBox;
    HardMode(){
        super();
        numFilledBox=22;
    }

    public int[][] generateHardSudokuBox() {
        int[][] hardBox= super.getSudokuElementArray();
        for(int count=1;count<=81-numFilledBox;count++){
            while(true) {
                Random random = new Random();
                int i = random.nextInt(9);
                Random random2 = new Random();
                int j = random2.nextInt(9);
                if (hardBox[i][j] != 0) {
                    hardBox[i][j] = 0;
                    break;
                }
            }
        }

        return hardBox;
    }
    public void setHardBoard(JTextField[][] grid){
        int [][] hardBox=generateHardSudokuBox();
        PlayingGame pg1=new PlayingGame(hardBox,"Hard");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(hardBox[i][j]!=0){
                    grid[i][j].setText(""+hardBox[i][j]);
                    grid[i][j].setEditable(false);
                }
            }
        }
    }
}
