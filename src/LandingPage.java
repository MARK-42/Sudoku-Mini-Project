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
    private JLabel pic, difficulty, title;
    private ImageIcon img1;
    private static String[] levels = {"Easy", "Medium", "Hard"};

    public LandingPage() {
        super("Sudoku");
        start = new JButton("Go");
        img1 = new ImageIcon(getClass().getResource("sudoku1.jpeg"));
        pic = new JLabel(img1);
        difficulty = new JLabel("Difficulty:");
        diff = new JComboBox(levels);
        title = new JLabel("SUDOKU");

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
        setBounds(400,100,600,600);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 2;
        c.gridy = 0;
        add(title, c);


        c.weightx = 4;
        c.weighty = 4;
        c.gridx = 2;
        c.gridy = 2;
        add(pic, c);

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
