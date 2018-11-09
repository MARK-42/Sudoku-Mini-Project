import javax.swing.*;
import  java.util.*;

class EasyMode extends SetGameBoard {
    private int numFilledBox;
    EasyMode(){
        super();
        numFilledBox=41;
    }

    public int[][] generateEasySudokuBox() {
        int[][] easyBox= super.getSudokuElementArray();
        for(int count=1;count<=81-numFilledBox;count++){
            while(true) {
                Random random = new Random();
                int i = random.nextInt(9);
                Random random2 = new Random();
                int j = random2.nextInt(9);
                if (easyBox[i][j] != 0) {
                    easyBox[i][j] = 0;
                    break;
                }
            }
        }

        return easyBox;
    }
    public void setEasyBoard(JTextField[][] grid){
        int [][] easyBox=generateEasySudokuBox();
        PlayingGame pg1=new PlayingGame(easyBox,"easy");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(easyBox[i][j]!=0){
                    grid[i][j].setText(""+easyBox[i][j]);
                    grid[i][j].setEditable(false);
                }
            }
        }
    }
}
