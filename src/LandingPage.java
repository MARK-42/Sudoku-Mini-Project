import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.JarFile;


public class LandingPage extends JFrame {

    private JButton start;
    private JComboBox diff;
    private JLabel pic1,pic2, difficulty, title;
    private ImageIcon img1,img2,img3;
    private static String[] levels = {"Easy", "Medium", "Hard"};

    public LandingPage() {
        super("Sudoku");
        start = new JButton("Go");
        img1 = new ImageIcon(getClass().getResource("sudoku1.jpeg"));
        pic1 = new JLabel(img1);

        img3 = new ImageIcon(getClass().getResource("title.jpeg"));
        pic2 = new JLabel(img3);
        pic2.setBounds(0,0,100,100);

        img2 = new ImageIcon(getClass().getResource("image_background.jpg"));
        setContentPane(new JLabel(img2));

        difficulty = new JLabel("Difficulty:");
        diff = new JComboBox(levels);
        title = new JLabel("");
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();



//        ((JComboBox) difficulty).addItemListener(
//                new ItemListener() {
//                    public void levelchange(ItemEvent event){
//                        if(event.getStateChange()==ItemEvent.SELECTED)
//                    }
//                }
//
//                }
//        );

        setVisible(true);
        //setSize(600, 600);
        setBounds(0,0,d.width,d.height);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 2;
        c.gridy = 0;
        add(title, c);


        c.weightx = 0;
        c.weighty = 2;
        c.gridx = 0;
        c.gridy = 1;
        add(pic1, c);

        c.weightx = 0;
        c.weighty = 2;
        c.gridx = 0;
        c.gridy = 0;
        add(pic2, c);

        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 1;
        c.gridy = 4;
        add(difficulty, c);

        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 2;
        c.gridy = 4;
        add(diff, c);

        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 3;
        c.gridy = 4;
        add(start, c);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
                Date date1 = new Date();
                System.out.println(t.format(date1));
                String str1 = t.format(date1);
                String choice = diff.getSelectedItem().toString();
                setVisible(false);
                mainFrame frame=new mainFrame(choice,str1);
            }
        });
    }
}
