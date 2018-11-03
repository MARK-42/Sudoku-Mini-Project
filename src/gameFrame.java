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
        gameFrame.setBounds(30, 30, 600, 600);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=gameFrame.getContentPane();
        JTextField grid[][] = new JTextField[9][9];
        CreateGrid cg=new CreateGrid(c,grid);
        JButton newgame=new JButton("Back");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                LandingPage lp=new LandingPage();
            }
        });
        JButton solution=new JButton("SOLUTION");
        JButton exit=new JButton("EXIT");
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
                grid[i][j].setBackground(new Color(255, 248, 216));
                Font f=new Font("Arial",Font.BOLD,18);
                grid[i][j].setFont(f);
            }
        }
    }
}
