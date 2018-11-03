import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class mainFrame extends JFrame
{
    mainFrame()
    {
        JFrame gameFrame = new JFrame("SUDOKU");
        gameFrame.setLayout(null);
        gameFrame.setBounds(600, 300, 600, 600);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=gameFrame.getContentPane();
        JTextField grid[][] = new JTextField[9][9];
        CreateGrid cg=new CreateGrid(c,grid);
        JButton newgame=new JButton("Back");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setVisible(false);
                setVisible(false);
                LandingPage lp=new LandingPage();
            }
        });
        JButton solution=new JButton("SOLUTION");
        JButton exit=new JButton("EXIT");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result =JOptionPane.showConfirmDialog(gameFrame, "Do you want to exit ?","PLease confirm exit", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION)
                    gameFrame.setVisible(false);
                }
        });
        newgame.setBounds(45,500,120,50);
        gameFrame.add(newgame);
        solution.setBounds(235,500,120,50);
        gameFrame.add(solution);
        exit.setBounds(420,500,120,50);
        gameFrame.add(exit);
        JLabel invalid=new JLabel("Invalid Input");
        invalid.setBounds(225,450,200,50);
        Font f=new Font("Arial",Font.BOLD,25);
        invalid.setFont(f);
        Font f1=new Font("Arial",Font.BOLD,14);
        newgame.setFont(f1);
        solution.setFont(f1);
        exit.setFont(f1);
        invalid.setVisible(false);
        gameFrame.add(invalid);
        invalid.setForeground(Color.RED);
        c.setBackground(new Color(252, 236, 196));
        JLabel q=new JLabel("                        The Game is on !!!");
        q.setBounds(115,20,500,30);
        q.setFont(f1);
        c.add(q);
        solution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.setText("                        Coming Soon ...");

            }
        });

    }




}

class CreateGrid
{
    CreateGrid(Container c,JTextField grid[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                grid[i][j]=new JTextField();
                grid[i][j].setBounds((105+(40*j)+2),(75+(40*i)+2),40,40);
                c.add(grid[i][j]);
                grid[i][j].setHorizontalAlignment(JTextField.CENTER);
                /*
                grid[i][j].addActionListener(new ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                int result =JOptionPane.showConfirmDialog(gameFrame, "Do you want to exit ?","PLease confirm exit", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION)
                    gameFrame.setVisible(false);
                }
        });
                 */

                if((i==0 || i==1 || i==2 ) && (j==0 || j==1 || j==2 || j==6 || j==7 || j==8 ))
                {
                grid[i][j].setBackground(Color.WHITE);
                }
                else if ((i==3|| i==4 || i==5 ) && (j==3 || j==4 || j==5  ))
                {
                    grid[i][j].setBackground(Color.WHITE);
                }
                else if((i==6 || i==7 || i==8 ) && (j==0 || j==1 || j==2 || j==6 || j==7 || j==8 ))
                {
                    grid[i][j].setBackground(Color.WHITE);
                }
                 else
                grid[i][j].setBackground(new Color(255, 248, 176));
                Font f=new Font("Arial",Font.BOLD,18);
                grid[i][j].setFont(f);
            }
        }
        grid[0][5].setText("5");
        grid[0][5].setEditable(false);

        grid[2][3].setText("8");
        grid[2][3].setEditable(false);

        grid[0][1].setText("9");
        grid[0][1].setEditable(false);

        grid[6][2].setText("9");
        grid[6][2].setEditable(false);

        grid[8][5].setText("5");
        grid[8][5].setEditable(false);

        grid[4][7].setText("1");
        grid[4][7].setEditable(false);

        grid[6][8].setText("8");
        grid[6][8].setEditable(false);
        grid[3][8].setText("2");
        grid[3][8].setEditable(false);

        grid[6][1].setText("1");
        grid[6][1].setEditable(false);
        grid[2][4].setText("1");
        grid[2][4].setEditable(false);
        grid[4][4].setText("6");
        grid[4][4].setEditable(false);

        grid[5][1].setText("5");
        grid[5][1].setEditable(false);

        grid[6][4].setText("2");
        grid[6][4].setEditable(false);





    }
}
