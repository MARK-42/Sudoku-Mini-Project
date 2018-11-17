import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class mainFrame extends JFrame
{
    static JLabel q;
    static String timeslice;
    mainFrame(String choice,String timeslice)
    {
        this.timeslice=timeslice;
        JFrame gameFrame = new JFrame("SUDOKU");
        gameFrame.setLayout(null);
        gameFrame.setBounds(400, 100, 600, 600);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=gameFrame.getContentPane();
        JTextField grid[][] = new JTextField[9][9];
        CreateGrid cg=new CreateGrid(c,grid);
        PlayingGame pg=new PlayingGame(grid,choice);
        pg.highlightTheBlockOnMouseClick();
        // easymode board setter -->
        if(choice.equals("Easy")) {
            EasyMode easy = new EasyMode();
            easy.setEasyBoard(grid);//<--Add mode selector for this
        }
        else if(choice.equals("Medium")) {
            MediumMode medium = new MediumMode();
            medium.setMediumBoard(grid);//<--Add mode selector for this
        }
        else {
        HardMode hard = new HardMode();
        hard.setHardBoard(grid);//<--Add mode selector for this
    }

        pg.addUserInputToSudokuArray();
        JButton newgame=new JButton("NewGame");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result =JOptionPane.showConfirmDialog(gameFrame, "Do you want to start a new Game ?","PLease confirm ", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    gameFrame.setVisible(false);
                    LandingPage lp=new LandingPage();
                }
            }
        });
        JButton solution=new JButton("SOLUTION");
        JButton exit=new JButton("EXIT");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result =JOptionPane.showConfirmDialog(gameFrame, "Do you want to exit ?","PLease confirm exit", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    gameFrame.setVisible(false);
                    System.exit(0);
                }
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
        q=new JLabel("                        The Game is on !!!");
        q.setBounds(115,20,500,30);
        q.setFont(f1);
        c.add(q);

        solution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.setText("                             Solution is ...");
//                PlayingGame.printfilledSudo();
                pg.setSolution(q);
            }
        });
       ImageIcon i = new ImageIcon(getClass().getResource("icon.jpg"));
        JLabel rules=new JLabel(i);

        rules.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame f = new JFrame("Rules");
                JPanel p=new JPanel();
                p.setLayout(new FlowLayout());
                p.setBounds(300, 80, 600  , 600);
                f.setBounds(400, 100, 600  , 400);
                f.setVisible(true);
                JLabel til=new JLabel("RULES-",JLabel.CENTER);

                JLabel rulepage=new JLabel("<html>      <font color='red'>When you start a game of Sudoku, some blocks will be pre-filled for you.<br>You cannot change these numbers in the course of the game.<br> <br></font>" +
                                           "            <font color='blue'>Each column must contain all of the numbers 1 through 9 and no two <br>numbers in the same column of a Sudoku puzzle can be the same.<br> <br> </font>"+
                                           "            <font color='red'>Each row must contain all of the numbers 1 through 9 and no two  <br>numbers in the same row of a Sudoku puzzle can be the same. <br><br> </font>"+
                                            "               <font color='blue'>Each block must contain all of the numbers 1 through 9 and no two <br>numbers in the same block of a Sudoku puzzle can be the same.<br><br> </font>"+
                        "               <font color='red'>Scoring is done on the basis of time consumed.<br> </font>"+
                        "</html>"
                        ,JLabel.CENTER);


                rulepage.setFont(f1);
                til.setFont(f1);
                f.setBackground(new Color(200, 236, 196));
                Font f1=new Font("Arial",Font.BOLD,14);
                p.add(til);
                p.add(rulepage);

            f.add(p);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        rules.setBounds(0,0,50,50);


    c.add(rules);
    JLabel hints=new JLabel("Click for Hints");
    hints.addMouseListener(new MouseListener() {
    @Override

        public void mouseClicked(MouseEvent e) {
            JFrame f = new JFrame("HINTS");
            JPanel p=new JPanel();
            p.setLayout(new FlowLayout());
            p.setBounds(300, 80, 600  , 600);
            f.setBounds(400, 100, 600  , 400);
            f.setVisible(true);
            JLabel til=new JLabel("HINTS-",JLabel.CENTER);

            JLabel rulepage=new JLabel("<html>      <font color='green'>Start by first looking for a number that has the most \"givens\". <br> The more the merrier.<br> <br></font>" +
                    "            <font color='blue'>Start with a block and find missing numbers, then cross out all columns ,<br> and rows having that missing number.<br> <br> </font>"+
                    "            <font color='green'>Sudoku pencilmarking is a systematic process writing small <br> numbers inside the squares to denote which ones may fit in. <br><br> </font>"+
                    "               <font color='blue'> After pencilmarking the puzzle, the solver must analyze the results,<br> identify special number combinations and deduce which numbers should<br> be placed where.<br><br> </font>"+
                    "               <font color='green'>The easiest way starting a Sudoku puzzle is to scan rows and columns<br> within each triple-box area, eliminating numbers or squares and finding<br> situations where only a single number can fit into a single square.<br> </font>"+
                    "</html>"
                    ,JLabel.CENTER);

            rulepage.setFont(f1);
            til.setFont(f1);
            f.setBackground(new Color(200, 150, 196));
            Font f1=new Font("Arial",Font.BOLD,14);
            p.add(til);
            p.add(rulepage);

            f.add(p);

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    });
        hints.setBounds(500,0,100,50);
    c.add(hints);
    }
    public void winnerDialog(){
        String s=q.getText();
//        JOptionPane.showMessageDialog(new JFrame(),"Eggs are not supposed to be green.","Inane custom dialog",JOptionPane.INFORMATION_MESSAGE);

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



    }
}
