import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayingGame {
    private int playingDuration;//check datatype before use
    private int numBlocksFilled;
    private JTextField grid [][];
    private int sudokuBoxArray[][];


    public PlayingGame(JTextField[][] grid) {
        this.grid = grid;
    }

    public PlayingGame(){
//
    }

    public int checkCollisionForInput(int[][] arr)
    {
        // to be done
        return 9;
    }

    public int[][] getSolution(int[][] arr)
    {
        //
        return arr;
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
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                                }
                            }
                        }
                        int c=getSector(i_curr,j_curr);
                        if(c==1){
                            for(int w=0;w<=2;w++)
                                for(int y=0;y<=2;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==2){
                            for(int w=0;w<=2;w++)
                                for(int y=3;y<=5;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==3){
                            for(int w=0;w<=2;w++)
                                for(int y=6;y<=8;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==4){
                            for(int w=3;w<=5;w++)
                                for(int y=0;y<=2;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==5){
                            for(int w=3;w<=5;w++)
                                for(int y=3;y<=5;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==6){
                            for(int w=3;w<=5;w++)
                                for(int y=6;y<=8;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==7){
                            for(int w=6;w<=8;w++)
                                for(int y=0;y<=2;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==8){
                            for(int w=6;w<=8;w++)
                                for(int y=3;y<=5;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
                        }
                        if(c==9){
                            for(int w=6;w<=8;w++)
                                for(int y=6;y<=8;y++)
                                    grid[w][y].setBackground(Color.LIGHT_GRAY);
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

    public int checkAllAreFilled()
    {
        return 0;
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

}
