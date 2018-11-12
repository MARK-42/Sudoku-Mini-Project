import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPage l= new LandingPage();

            }
        });

    }

}
