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
    private ImageIcon img;

    develop()
    {
        Frame f = new JFrame("Developers");
        img = new ImageIcon(getClass().getResource("image_background.jpg"));

        JLabel pic1=new JLabel(img);
        pic1.setLayout(new FlowLayout());
        f.add(pic1);


        f.setBounds(570, 328, 800  , 450);
        f.setVisible(true);
        JLabel til=new JLabel("<html><font color='White'>Developers-</font></html>",JLabel.CENTER);
        Font fs=new Font("Arial",Font.BOLD,20);
        pic1.add(til);
        til.setFont(fs);
        JLabel t = new JLabel("<html>    <font color='yellow'>  <br> </font>" +
                "            <font color='yellow'>  <br> </font>"+
                "<font color='white'><font size='5'>This Sudoku game has been developed as a part of OOM Mini-Project<br>      by our team comprising of 6 members under<br>       the supervision of Dr  R. Kala and Dr O.P. Vyas  <br></font></font>" +
                "            <font color='yellow'>  <br> </font>"+
                "            <font color='yellow'> <font size='5'>  Ritik Raj   IIM20170039<br> </font></font>"+
                "            <font color='yellow'>   <br> </font>"+
                "            <font color='white'> <font size='5'>  Arya Krishnan ICM2017501<br></font> </font>"+
                "            <font color='yellow'>  <br> </font>"+
                "               <font color='yellow'> <font size='5'>  Anshul Agarwal IWM2017008<br> </font></font>"+
                "            <font color='yellow'>   <br> </font>"+
                "               <font color='white'> <font size='5'>  Harsh Aryan ITM2017003<br></font> </font>"+
                "            <font color='yellow'>  <br> </font>"+
                "               <font color='yellow'> <font size='5'>  Ritesh Yadav IRM2017001<br> </font></font>"+
                "            <font color='yellow'>   <br> </font>"+
                "               <font color='white'> <font size='5'>  Bineet Kumar ISM2017008<br></font> </font>"+
                "</html>"
                ,JLabel.CENTER);


        Font f1=new Font("Arial",Font.BOLD,14);
        //
        t.setFont(f1);
        pic1.add(t);
        //
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

    ImageIcon i = new ImageIcon(getClass().getResource("i.png"));
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
        pic2.setBounds(width*8/24,0,600,400);

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