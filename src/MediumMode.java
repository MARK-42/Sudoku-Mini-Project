import javax.swing.*;
import  java.util.*;

class MediumMode extends SetGameBoard {
    private int numFilledBox;
    MediumMode(){
        super();
        numFilledBox=32;
    }

    public int[][] generateMediumSudokuBox() {
        int[][] MediumBox= super.getSudokuElementArray();
        for(int count=1;count<=81-numFilledBox;count++){
            while(true) {
                Random random = new Random();
                int i = random.nextInt(9);
                Random random2 = new Random();
                int j = random2.nextInt(9);
                if (MediumBox[i][j] != 0) {
                    MediumBox[i][j] = 0;
                    break;
                }
            }
        }

        return MediumBox;
    }
    public void setMediumBoard(JTextField[][] grid){
        int [][] MediumBox=generateMediumSudokuBox();
        PlayingGame pg1=new PlayingGame(MediumBox,"Medium");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(MediumBox[i][j]!=0){
                    grid[i][j].setText(""+MediumBox[i][j]);
                    grid[i][j].setEditable(false);
                }
            }
        }
    }
}
