import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayingGame {
    private int playingDuration;//check datatype before use
    private int numBlocksFilled=0;
    static JTextField grid [][];
    static int sudokuBoxArray[][];
    static int sudokuBoxArrCopy[][];
    private String mode;

    public PlayingGame(JTextField[][] grid,String mode) {
        this.grid = grid;
        this.mode=mode;
        if(mode.equals("Easy"))
            numBlocksFilled=41;
        else if(mode.equals("Medium"))
            numBlocksFilled=32;
        else
            numBlocksFilled=22;
    }

    public PlayingGame(int sudokuBoxArray[][],String mode){
        this.sudokuBoxArray=sudokuBoxArray;
        this.mode=mode;
        sudokuBoxArrCopy=new int[9][9];
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
            {
                sudokuBoxArrCopy[i][j]=sudokuBoxArray[i][j];
            }
        if(mode.equals("Easy"))
            numBlocksFilled=41;
        else if(mode.equals("Medium"))
            numBlocksFilled=32;
        else
            numBlocksFilled=22;
    }

    public void addUserInputToSudokuArray(){
        for(int i=0;i<9;i++) {
            final int i_curr = i;
            for (int j = 0; j < 9; j++) {
                final int j_curr = j;

                grid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        grid[i_curr][j_curr].setBackground(grid[i_curr][j_curr].getBackground());
                        if(!(grid[i_curr][j_curr].getText().equals(""))) {
                            sudokuBoxArray[i_curr][j_curr] = Integer.parseInt(grid[i_curr][j_curr].getText());
                        }
                        checkCollisionForInput(i_curr,j_curr,sudokuBoxArray[i_curr][j_curr]);
//to check if won when filled completely
//  if(checkAllAreFilled() && grid[i_curr][j_curr].getBackground()!=Color.RED){
//                            mainFrame.q.setText("Congratulations You Won");
//                        }

                    }

                });

            }
        }
    }

    public void checkCollisionForInput(int i,int j,int element) {
        //check collision in mini box
        int flagMiniBox=0;
        int c=getSector(i,j);
        if(c==1){
            for(int w=0;w<=2;w++)
                for(int y=0;y<=2;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }
//                    else if(sudokuBoxArray[w][y]==element && ((w==i && y==j)))
//                        grid[i][j].setBackground(Color.LIGHT_GRAY);

                }
        }
        if(c==2){
            for(int w=0;w<=2;w++)
                for(int y=3;y<=5;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==3){
            for(int w=0;w<=2;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==4){
            for(int w=3;w<=5;w++)
                for(int y=0;y<=2;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==5){
            for(int w=3;w<=5;w++)
                for(int y=3;y<=5;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==6){
            for(int w=3;w<=5;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==7){
            for(int w=6;w<=8;w++)
                for(int y=0;y<=2;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==8){
            for(int w=6;w<=8;w++)
                for(int y=3;y<=5;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        if(c==9){
            for(int w=6;w<=8;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
                        for(int icount=0;icount<9;icount++)
                            for(int jcount=0;jcount<9;jcount++)
                            {
                                if((icount!=i)||(jcount!=j))
                                    grid[icount][jcount].setEditable(false);
                            }
                    }

                }
        }
        //check collision in row and coloumn
//        for(int w=0;w<9;w++)
//        {
//            for(int y=0;y<9;y++)
//            {
//                if(w==i || y==j)
//                {
//                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j)))
//                        grid[i][j].setBackground(Color.RED);
//                    else if(sudokuBoxArray[w][y]==element && ((w==i && y==j)))
//                        grid[i][j].setBackground(Color.LIGHT_GRAY);
//                }
//            }
//        }
        int flagRowCol=0;
        for(int y=0;y<9;y++){
            if(sudokuBoxArray[i][y]==element && (!(y==j))) {
                grid[i][j].setBackground(Color.RED);
                flagRowCol=1;
                for(int icount=0;icount<9;icount++)
                    for(int jcount=0;jcount<9;jcount++)
                    {
                        if((icount!=i)||(jcount!=j))
                            grid[icount][jcount].setEditable(false);
                    }
            }
        }
        for(int y=0;y<9;y++){
            if(sudokuBoxArray[y][j]==element && (!(y==i))) {
                grid[i][j].setBackground(Color.RED);
                flagRowCol=1;
                for(int icount=0;icount<9;icount++)
                    for(int jcount=0;jcount<9;jcount++)
                    {
                        if((icount!=i)||(jcount!=j))
                            grid[icount][jcount].setEditable(false);
                    }
            }
        }
        if (flagRowCol==0 && flagMiniBox==0) {
            grid[i][j].setBackground(Color.LIGHT_GRAY);
            numBlocksFilled=numBlocksFilled+1;
            if(numBlocksFilled==81)
                mainFrame.q.setText("                        YOU WON!!!");
            for(int icount=0;icount<9;icount++)
                for(int jcount=0;jcount<9;jcount++)
                {
                    grid[icount][jcount].setEditable(true);
                }
            for(int icount=0;icount<9;icount++)
                for(int jcount=0;jcount<9;jcount++)
                {
                    if(sudokuBoxArrCopy[icount][jcount]!=0)
                        grid[icount][jcount].setEditable(false);
                }
        }


    }

    public void setSolution(JLabel q)
    {
        int [][] tempArr;
        for(int w=0;w<9;w++) {
            for(int y=0;y<9;y++) {
                if(grid[w][y].getBackground()==Color.RED)
                    sudokuBoxArray[w][y]=0;
            }
        }
        Algo sa1=new Algo(sudokuBoxArray);
        if(sa1.getk()==0)
            q.setText("No valid solution available!!");
         else {
            tempArr = sa1.getGrid();
            for (int w = 0; w < 9; w++) {
                for (int y = 0; y < 9; y++) {
                    grid[w][y].setText("" + tempArr[w][y]);
                    grid[w][y].setEditable(false);
                }
            }
        }
    }

    public int checkIntervalForTheInput(int t)
    {
        return 1;
    }

    public void highlightTheBlockOnMouseClick()
    {
        for(int i=0;i<9;i++)
        { final int i_curr = i;
            for(int j=0;j<9;j++)
            {   final int j_curr = j;
                grid[i][j].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {
//
                    }

                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        setBoardBackground();
                        for(int w=0;w<9;w++)
                        {
                            for(int y=0;y<9;y++)
                            {
                                if(w==i_curr || y==j_curr)
                                {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                            }
                        }
                        int c=getSector(i_curr,j_curr);
                        if(c==1){
                            for(int w=0;w<=2;w++)
                                for(int y=0;y<=2;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==2){
                            for(int w=0;w<=2;w++)
                                for(int y=3;y<=5;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==3){
                            for(int w=0;w<=2;w++)
                                for(int y=6;y<=8;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==4){
                            for(int w=3;w<=5;w++)
                                for(int y=0;y<=2;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==5){
                            for(int w=3;w<=5;w++)
                                for(int y=3;y<=5;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==6){
                            for(int w=3;w<=5;w++)
                                for(int y=6;y<=8;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==7){
                            for(int w=6;w<=8;w++)
                                for(int y=0;y<=2;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==8){
                            for(int w=6;w<=8;w++)
                                for(int y=3;y<=5;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                        if(c==9){
                            for(int w=6;w<=8;w++)
                                for(int y=6;y<=8;y++) {
                                    if(grid[w][y].getBackground()==Color.RED)
                                        continue;
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {


                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {


                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

//                        setBoardBackground();

                    }
                });
            }
        }
    }

    public void getTheTimeCounter(int dont_know_datatype)
    {
        //
    }

    public void getTime()
    {

    }

//    public boolean checkAllAreFilled()
//    {
//        for(int w=0;w<9;w++) {
//            for(int y=0;y<9;y++) {
//                if(sudokuBoxArray[w][y]!=0)
//                    numBlocksFilled++;
//            }
//        }
//        if(numBlocksFilled==81)
//            return true;
//        else
//            return false;
//    }

    public int getSector(int i,int j){
        if((i==0||i==1||i==2)){
            if(j==0||j==1||j==2)
                return 1;
            if(j==3||j==4||j==5)
                return 2;
            if(j==6||j==7||j==8)
                return 3;
        }
        if((i==3||i==4||i==5)){
            if(j==0||j==1||j==2)
                return 4;
            if(j==3||j==4||j==5)
                return 5;
            if(j==6||j==7||j==8)
                return 6;
        }
        if((i==6||i==7||i==8)){
            if(j==0||j==1||j==2)
                return 7;
            if(j==3||j==4||j==5)
                return 8;
            if(j==6||j==7||j==8)
                return 9;
        }
            return 0;

    }

    public void setBoardBackground(){
        for(int w=0;w<9;w++)
        {
            for(int y=0;y<9;y++)
            {
                if(grid[w][y].getBackground()==Color.RED && !(grid[w][y].getText().equals("")))
                    continue;
                //grid[w][y].setBackground(Color.WHITE);
                if((w==0 || w==1 || w==2 ) && (y==0 || y==1 || y==2 || y==6 || y==7 || y==8 ))
                {
                    grid[w][y].setBackground(Color.WHITE);
                }
                else if ((w==3|| w==4 || w==5 ) && (y==3 || y==4 || y==5  ))
                {
                    grid[w][y].setBackground(Color.WHITE);
                }
                else if((w==6 || w==7 || w==8 ) && (y==0 || y==1 || y==2 || y==6 || y==7 || y==8 ))
                {
                    grid[w][y].setBackground(Color.WHITE);
                }
                else
                    grid[w][y].setBackground(new Color(255, 248, 176));

            }
        }
    }
    public static void printfilledSudo(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                System.out.print(""+sudokuBoxArray[i][j]+" ");
            System.out.println("\n");
        }
    }

}
