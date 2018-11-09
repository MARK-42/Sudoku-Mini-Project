import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class key
{
    JTextField grid [][];
    key(JTextField grid [][]) {
        this.grid = grid;
        for (int i = 0; i < 9; i++) {
            final int i_curr = i;
            for (int j = 0; j < 9; j++) {
                final int j_curr = j;
                grid[i][j].addKeyListener(new KeyListener() {


                    public void keyTyped(KeyEvent e) {
                        String s = grid[i_curr][j_curr].getText();
                        int t = Integer.parseInt(s);
                        if (t != 1 && t != 3 && t != 4 && t != 5 && t != 6 && t != 7 && t != 8 && t != 9 && t != 2) {
                            grid[i_curr][j_curr].setBackground(Color.RED);
                        }


                        for (int w = 0; w < 9; w++) {
                            for (int y = 0; y < 9; y++) {
                                if (w == i_curr || y == j_curr) {
                                    //grid[w][y].setBackground(Color.CYAN);
                                    if (s.compareTo(grid[w][y].getText()) == 0) {
                                        grid[i_curr][j_curr].setBackground(Color.RED);
                                        break;
                                    }
                                }
                            }
                        }
                        int c, v;
                        c = i_curr / 3;
                        v = j_curr / 3;
                        for (int w = c * 3; w < (c + 1) * 3; w++) {
                            for (int y = v * 3; y < (v + 1) * 3; y++) {
                                if (s.compareTo(grid[w][y].getText()) == 0) {
                                    grid[i_curr][j_curr].setBackground(Color.RED);
                                    break;
                                }
                            }
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });

            }

        }

    }

}
