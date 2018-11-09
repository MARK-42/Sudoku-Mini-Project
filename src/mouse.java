import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

class mouse
{
    JTextField grid [][];
    mouse(JTextField grid [][])
    {
        this.grid=grid;
        for(int i=0;i<9;i++)
        { final int i_curr = i;
            for(int j=0;j<9;j++)
            {   final int j_curr = j;
                grid[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {
                        for(int w=0;w<9;w++)
                        {
                            for(int y=0;y<9;y++)
                            {
                                if(w==i_curr || y==j_curr)
                                {
                                    grid[w][y].setBackground(Color.CYAN);
                                }
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
                        for(int w=0;w<9;w++)
                        {
                            for(int y=0;y<9;y++)
                            {
                                if(w==i_curr || y==j_curr)
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
                });
            }
        }

    }



}
/*import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

class mouse{
    JTextField grid [][];
    int i,j;
    mouse(JTextField grid [][])
    {
        this.grid=grid;
        for( i=0;i<9;i++)
        {
            for( j=0;j<9;j++)
            {
                grid[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        for(int w=0;w<9;w++)
                        {
                            for(int y=0;y<9;y++)
                            {
                                if(w==i || y==j)
                                {
                                    grid[w][y].setBackground(Color.RED);
                                    System.out.println("HWEW");f
                                }
                            }
                        }
                    }

                   @Override
                    public void mousePressed(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {


                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                });
            }
        }

    }


}*/
