import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.JarFile;

import static java.awt.Font.BOLD;


public class LandingPage extends JFrame {

    public LandingPage() {

       // super("Sudoku");

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,d.width,d.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane p= new pane();
        add(p);
        setVisible(true);
    }
}

class develop extends JFrame{
    JLabel til = new JLabel("Anshul Agarwal");
    JLabel t = new JLabel("<html>      <font color='red'>When you start a game of Sudoku, some blocks will be pre-filled for you.<br>You cannot change these numbers in the course of the game.<br> <br></font>" +
                       "            <font color='blue'>Each column must contain all of the numbers 1 through 9 and no two <br>numbers in the same column of a Sudoku puzzle can be the same.<br> <br> </font>"+
                       "            <font color='red'>Each row must contain all of the numbers 1 through 9 and no two  <br>numbers in the same row of a Sudoku puzzle can be the same. <br><br> </font>"+
                       "               <font color='blue'>Each block must contain all of the numbers 1 through 9 and no two <br>numbers in the same block of a Sudoku puzzle can be the same.<br><br> </font>"+
                       "               <font color='red'>Scoring is done on the basis of time consumed.<br> </font>"+
                       "</html>"
                       ,JLabel.CENTER);

    develop()
    {
        super("Developer Page");
        add(til);
        add(t);
        setBounds(400,100,600,400);
        setVisible(true);
    }
}


class pane extends JPanel{
    private JButton start= new JButton("Go");;
    private JLabel difficulty = new JLabel("Difficulty:");
    private JComboBox diff = new JComboBox(levels);
    private JLabel title;
    private ImageIcon img3 = new ImageIcon(getClass().getResource("Title_pic.png"));
    private ImageIcon img1 = new ImageIcon(getClass().getResource("image_background.jpg"));
    private ImageIcon w1 = new ImageIcon(getClass().getResource("block1.png"));
    private ImageIcon w2 = new ImageIcon(getClass().getResource("block2.png"));
    private ImageIcon w3 = new ImageIcon(getClass().getResource("block3.png"));

    private static String[] levels = {"Easy", "Medium", "Hard"};
    private JLabel pic2 = new JLabel(img3);
    private JLabel pic1 = new JLabel(img1);
    private JLabel t1 = new JLabel(w1);
    private JLabel t2 = new JLabel(w2);
    private JLabel t3 = new JLabel(w3);

    ImageIcon i = new ImageIcon(getClass().getResource("icon.jpg"));
    JLabel developer=new JLabel(i);


    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int width=getWidth();
        int height=getHeight();

        remove(developer);
        add(developer);
        developer.setBounds(0,0,50,50);

        remove(pic2);
        add(pic2);
        pic2.setBounds(width*4/13,0,600,400);

        remove(t1);
        add(t1);
        t1.setBounds(width/4,height/2,300,400);

        remove(t2);
        add(t2);
        t2.setBounds(width*2/5,height/2,300,400);

        remove(t3);
        add(t3);
        t3.setBounds(width*4/7,height/2,300,400);

        remove(pic1);
        add(pic1);
        pic1.setBounds(0,0,width,height);

    }
    pane(){
//
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
                Date date1 = new Date();
                String str1 = t.format(date1);
                setVisible(false);
                mainFrame frame=new mainFrame("Easy",str1);
            }
        });
        t2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
                Date date1 = new Date();
                String str1 = t.format(date1);
                setVisible(false);
                mainFrame frame=new mainFrame("Medium",str1);
            }
        });
        t3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
                Date date1 = new Date();
                String str1 = t.format(date1);
                setVisible(false);
                mainFrame frame=new mainFrame("Hard",str1);
            }
        });

        developer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new develop();

            }

        });

    }

}