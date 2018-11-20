import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PlayingGame {
    private int playingDuration;//check datatype before use
    static int numBlocksFilled=0;
    static JTextField grid [][];
    static int sudokuBoxArray[][];
    static int sudokuBoxArrCopy[][];
    private String mode;
    int hr, min, sec;

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
                grid[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        clickSoundSetter("sound.wav");
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        try {
                            if (!(grid[i_curr][j_curr].getText().equals(""))) {
                                sudokuBoxArray[i_curr][j_curr] = Integer.parseInt(grid[i_curr][j_curr].getText());
                            } else if (grid[i_curr][j_curr].getText().equals("")) {
                                sudokuBoxArray[i_curr][j_curr] = 0;
                            }
                        }
                        catch (NumberFormatException e1){
                            grid[i_curr][j_curr].setBackground(Color.RED);
                        }
//                        if(Character.isLetter(grid[i_curr][j_curr].getText().charAt(0))){
//                        }
                        checkCollisionForInput(i_curr,j_curr,sudokuBoxArray[i_curr][j_curr]);
                        if(!checkIntervalForTheInput(Integer.parseInt(grid[i_curr][j_curr].getText()))){
                            grid[i_curr][j_curr].setBackground(Color.RED);
                        }


                    }
                });
               /* grid[i][j].addActionListener(new ActionListener() {
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

                });*/

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
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==3){
            for(int w=0;w<=2;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==4){
            for(int w=3;w<=5;w++)
                for(int y=0;y<=2;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==5){
            for(int w=3;w<=5;w++)
                for(int y=3;y<=5;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==6){
            for(int w=3;w<=5;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==7){
            for(int w=6;w<=8;w++)
                for(int y=0;y<=2;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==8){
            for(int w=6;w<=8;w++)
                for(int y=3;y<=5;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
                    }

                }
        }
        if(c==9){
            for(int w=6;w<=8;w++)
                for(int y=6;y<=8;y++){
                    if(sudokuBoxArray[w][y]==element && (!(w==i && y==j))) {
                        grid[i][j].setBackground(Color.RED);
                        flagMiniBox=1;
//                        for(int icount=0;icount<9;icount++)
//                            for(int jcount=0;jcount<9;jcount++)
//                            {
//                                if((icount!=i)||(jcount!=j))
//                                    grid[icount][jcount].setEditable(false);
//                            }
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
//                for(int icount=0;icount<9;icount++)
//                    for(int jcount=0;jcount<9;jcount++)
//                    {
//                        if((icount!=i)||(jcount!=j))
//                            grid[icount][jcount].setEditable(false);
//                    }
            }
        }
        for(int y=0;y<9;y++){
            if(sudokuBoxArray[y][j]==element && (!(y==i))) {
                grid[i][j].setBackground(Color.RED);
                flagRowCol=1;
//                for(int icount=0;icount<9;icount++)
//                    for(int jcount=0;jcount<9;jcount++)
//                    {
//                        if((icount!=i)||(jcount!=j))
//                            grid[icount][jcount].setEditable(false);
//                    }
            }
        }
        if (flagRowCol==0 && flagMiniBox==0) {
            grid[i][j].setBackground(Color.LIGHT_GRAY);
        }
//            numBlocksFilled=numBlocksFilled+1;
        if(checkAllAreFilled())
        {
            SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
            Date date2 = new Date();
            System.out.println(t.format(date2));
            String str2 = t.format(date2);

            String[] arr2 = str2.split(":");
            String str1 = mainFrame.timeslice;
            String[] arr1 = str1.split(":");
            int a1= (Integer.parseInt(arr1[0]));
            int b1= (Integer.parseInt(arr1[1]));
            int c1= (Integer.parseInt(arr1[2]));
            int result1_sec= (a1*(60*60))+(b1*60)+(c1);

            int a2= (Integer.parseInt(arr2[0]));
            int b2= (Integer.parseInt(arr2[1]));
            int c2= (Integer.parseInt(arr2[2]));
            int result2_sec= (a2*(60*60))+(b2*60)+(c2);

            int final_sec=result2_sec-result1_sec;

            hr = final_sec/(60*60);
            final_sec=final_sec-(hr*(60*60));
            min = final_sec/60;
            final_sec=final_sec-(min*60);
            sec = final_sec;


                /*for (int i = 0; i < 3; i++) {
                    System.out.println(arr2[i]);
                }*/
            //insert new congratulations box frame here

            //comment down the line below when point above done.
//                JOptionPane.showMessageDialog(mainFrame.class,"Eggs are not supposed to be green.","Inane custom dialog",JOptionPane.INFORMATION_MESSAGE,JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(new JFrame(),"<html>CONGRAGULATIONS!!! You Won!<br> your timing is: "+Integer.toString(hr)+" : "+Integer.toString(min)+" : "+Integer.toString(sec)+"</html>","You Won!",JOptionPane.INFORMATION_MESSAGE);

            //mainFrame.q.setText("          YOU WON!!!"+ hr +" "+min+" "+sec);

        }
//            for(int icount=0;icount<9;icount++)
//                for(int jcount=0;jcount<9;jcount++)
//                {
//                    grid[icount][jcount].setEditable(true);
//                }
//            for(int icount=0;icount<9;icount++)
//                for(int jcount=0;jcount<9;jcount++)
//                {
//                    if(sudokuBoxArrCopy[icount][jcount]!=0)
//                        grid[icount][jcount].setEditable(false);
//                }



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

    public boolean checkIntervalForTheInput(int t)
    {
        System.out.println(t);
        if(t>0&&t<=9)
            return true;
        else return false;
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
                    public void mouseClicked(MouseEvent mouseEvent) {

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
//
//    public String getTime()
//    {
//        if(checkAllAreFilled) {
//            SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
//            Date date1 = new Date();
//            System.out.println(t.format(date1));
//            String str = t.format(date1);
//            return str;
//        }
//    }

    public boolean checkAllAreFilled()
    {
        numBlocksFilled=0;
        for(int w=0;w<9;w++) {
            for(int y=0;y<9;y++) {
                if(sudokuBoxArray[w][y]>0 && sudokuBoxArray[w][y]<=9)
                    numBlocksFilled++;
            }
        }
        if(numBlocksFilled>=81)
            return true;
        else
            return false;
    }

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

    public static synchronized void clickSoundSetter(final String url) {
        new Thread(new Runnable() { // the wrapper thread is unnecessary, unless it blocks on the Clip finishing, see comments
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream( url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

}
