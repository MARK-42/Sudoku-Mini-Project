import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.JarFile;

import static java.awt.Font.BOLD;


public class LandingPage extends JFrame {
    //private ImageIcon back_image;

    public LandingPage() {

        super("Sudoku");

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,d.width,d.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane p= new pane();
        add(p);
//        back_image = new ImageIcon(getClass().getResource("image_background.jpg"));
//        setContentPane(new JLabel(back_image));
        setVisible(true);
//        ((JComboBox) difficulty).addItemListener(
//                new ItemListener() {
//                    public void levelchange(ItemEvent event){
//                        if(event.getStateChange()==ItemEvent.SELECTED)
//                    }
//                }
//
//                }
//        );


        //setSize(600, 600);

        //setLayout(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();
//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 2;
//        c.gridy = 0;
//        add(title, c);


//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 2;
//        c.gridy = 1;
//        add(pic1, c);

//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 2;
//        c.gridy = 0;
//        add(pic2, c);

//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 1;
//        c.gridy = 4;
//        add(difficulty, c);
//
//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 2;
//        c.gridy = 4;
//        add(diff, c);
//
//        c.weightx = 6;
//        c.weighty = 6;
//        c.gridx = 3;
//        c.gridy = 4;
//        add(start, c);
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
    //private ImageIcon back_image= new ImageIcon(getClass().getResource("image_background.jpg"));
//    Image background =Toolkit.getDefaultToolkit().createImage("image_background.jpg");
//    drawImage(background,0,0,null);
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //Image background =Toolkit.getDefaultToolkit().createImage("image_background.jpg");
        //g.drawImage(background,0,0,this);
        //setBackground(Color.blue);
        //setContentPane(new JLabel(back_image));

//        img1 = new ImageIcon(getClass().getResource("body_pic.png"));
//        img3 = new ImageIcon(getClass().getResource("Title_pic.png"));
//        drawImage(background,0,0,null);

        int width=getWidth();
        int height=getHeight();
//        difficulty.setFont(new Font ("Garamond", BOLD,10));
//        difficulty.setForeground(Color.BLACK);
//        remove(difficulty);
//        add(difficulty);
//        difficulty.setBounds(width/2,height*4/5,600,40);
//        difficulty.setFont(new Font("Arial", BOLD ,30));

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


//        remove(diff);
//        add(diff);
//        int width1=getWidth();
//        int height1=getHeight();
//        diff.setBounds(width1/2,height1/2,60,50);
//        //difficulty.setFont(Font.getFont(Ar));

    }
    pane(){
//        start.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
//                Date date1 = new Date();
//                System.out.println(t.format(date1));
//                String str1 = t.format(date1);
//                String choice = diff.getSelectedItem().toString();
//                setVisible(false);
//                mainFrame frame=new mainFrame(choice,str1);
//            }
//        });

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
    }

}