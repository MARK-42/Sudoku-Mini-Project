import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mainFrame extends JFrame
{
    static JLabel q;
    private JLabel pic2;
    static String timeslice;
    private ImageIcon img2;
    mainFrame(String choice,String
            timeslice)
    {
        this.timeslice=timeslice;
        JFrame gameFrame = new JFrame("SUDOKU");

        gameFrame.setLayout(null);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        gameFrame.setBounds(0, 0, d.width, d.height);
        gameFrame.setVisible(true);
        pic2 = new JLabel(img2);
        img2 = new ImageIcon(getClass().getResource("image_background.jpg"));
        gameFrame.setContentPane(new JLabel(img2));
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
        JButton newgame=new JButton("NEW GAME");

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
        newgame.setBounds(410,800,304,50);
        gameFrame.add(newgame);
        solution.setBounds(810,800,300,50);
        gameFrame.add(solution);
        exit.setBounds(1200,800,200,50);
        gameFrame.add(exit);
        JLabel invalid=new JLabel("Invalid Input");
        invalid.setBounds(225,450,200,50);
        Font f=new Font("Arial",Font.BOLD,25);
        invalid.setFont(f);
        Font f2=new Font("Arial",Font.BOLD,30);
        Font f1=new Font("Arial",Font.BOLD,40);
        newgame.setFont(f1);
        solution.setFont(f1);
        exit.setFont(f1);
        invalid.setVisible(false);
        gameFrame.add(invalid);
        invalid.setForeground(Color.RED);
        //c.setBackground(new Color(252, 236, 196));
        q=new JLabel();
        q.setBounds(400,30,1500,40);



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

        rules.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new rules();

            }


        });
        rules.setBounds(1550,800,50,50);


        c.add(rules);
        JLabel hints=new JLabel("<html><font color='white'>Click for Hints</font>");
        hints.setFont(new Font("Arial",Font.BOLD,20));
        hints.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                new hints();


            }


        });
        hints.setBounds(1500,50,250,80);
        Font fup=new Font("Arial",Font.BOLD,24);
        hints.setFont(fup);
        c.add(hints);
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
                grid[i][j].setBounds((640+(70*j)+2),(105+(70*i)+2),70,70);
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
                    //grid[i][j].setBackground(Color.WHITE);
                    grid[i][j].setBackground(new Color(255, 248, 176));
                Font f=new Font("Arial",Font.BOLD,18);
                grid[i][j].setFont(f);
            }
        }



    }
}
class rules extends JPanel{
    private ImageIcon img34;
//    private JLabel pic1 = new JLabel(img1);

    rules()
    {
        JFrame f = new JFrame("Rules");
        img34 = new ImageIcon(getClass().getResource("image_background.jpg"));
//        f.setContentPane(new JLabel(img34));

//        JPanel p=new JPanel();
//        p.setLayout(new FlowLayout());
//        p.setBounds(300, 80, 600  , 600);

        //p.add(rulepage);

//        pic1.setBounds(300,80,getWidth(),getHeight());
//        f.add(pic1);


//        JLabel til=new JLabel("RULES-",JLabel.CENTER);
JLabel pic1=new JLabel(img34);
pic1.setLayout(new FlowLayout());
f.add(pic1);

        JLabel til=new JLabel("<html><font color='White'>Rules-</font></html>",JLabel.CENTER);
        Font fs=new Font("Arial",Font.BOLD,20);
        pic1.add(til);
        til.setFont(fs);

        JLabel rulepage=new JLabel("<html>      <font color='yellow'><font size='5'>When you start a game of Sudoku, some blocks will be pre-filled for you.<br>You cannot change these numbers in the course of the game<br>/font></font>" +
                "            <font color='white'><font size='5'>Each column must contain all of the numbers 1 through 9 and no two <br>numbers in the same column of a Sudoku puzzle can be the same.<br> <br></font> </font>"+
                "            <font color='yellow'><font size='5'>Each row must contain all of the numbers 1 through 9 and no two  <br>numbers in the same row of a Sudoku puzzle can be the same. <br><br></font> </font>"+
                "               <font color='white'><font size='5'>Each block must contain all of the numbers 1 through 9 and no two <br>numbers in the same block of a Sudoku puzzle can be the same.<br><br> </font></font>"+
                "               <font color='yellow'><font size='5'>Scoring is done on the basis of time consumed.<br> </font></font>"+
                "</html>"
                ,JLabel.CENTER);
        f.setBounds(570, 328, 800  , 450);
        f.setVisible(true);

        pic1.add(rulepage);

        //f.setBackground(new Color(200, 236, 196));
        Font f1=new Font("Arial",Font.BOLD,14);
        rulepage.setFont(f1);
        til.setFont(f1);




        //f.add(p);


    }


}
class hints extends JPanel{
    ImageIcon img34;
    hints()
    {
        Frame f = new JFrame("Hints");
        img34 = new ImageIcon(getClass().getResource("image_background.jpg"));
//        f.setContentPane(new JLabel(img34));

//        JPanel p=new JPanel();
//        p.setLayout(new FlowLayout());
//        p.setBounds(300, 80, 600  , 600);

        //p.add(rulepage);

//        pic1.setBounds(300,80,getWidth(),getHeight());
//        f.add(pic1);


//        JLabel til=new JLabel("RULES-",JLabel.CENTER);
        JLabel pic1=new JLabel(img34);
        pic1.setLayout(new FlowLayout());
        f.add(pic1);

        f.setBounds(570, 328, 800  , 450);
        f.setVisible(true);

        JLabel til=new JLabel("<html><font color='White'>Hint-</font></html>",JLabel.CENTER);
        Font fs=new Font("Arial",Font.BOLD,20);
        pic1.add(til);
        til.setFont(fs);

        JLabel rulepage=new JLabel("<html>      <font color='white'><font size='5'>Start by first looking for a number that has the most \"givens\". <br> The more the merrier.<br> <br></font></font>" +
                "            <font color='yellow'><font size='5'>Start with a block and find missing numbers, then cross out all columns ,<br> and rows having that missing number.<br> <br> </font></font>"+
                "            <font color='white'><font size='5'>Sudoku pencilmarking is a systematic process writing small <br> numbers inside the squares to denote which ones may fit in. <br><br> </font></font>"+
                "               <font color='yellow'> <font size='5'>After pencilmarking the puzzle, the solver must analyze the results,<br> identify special number combinations and deduce which numbers should<br> be placed where.<br><br> </font></font>"+
                "               <font color='white'><font size='5'>The easiest way starting a Sudoku puzzle is to scan rows and columns<br> within each triple-box area, eliminating numbers or squares and finding<br> situations where only a single number can fit into a single square.<br> </font></font>"+
                "</html>"
                ,JLabel.CENTER);


        //f.setBackground(new Color(200, 150, 196));
        Font f1=new Font("Arial",Font.BOLD,14);
        rulepage.setFont(f1);
        pic1.add(rulepage);


    }

}