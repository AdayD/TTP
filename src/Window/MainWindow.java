package Window;

import Picture.MakePicture;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {
    public MainWindow() {

        int c = JOptionPane.showConfirmDialog(null, "Enter file",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        switch (c) {
            case JOptionPane.YES_OPTION -> {
                JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));

                int usrInput = fc.showOpenDialog(null);

                if (usrInput == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    MakePicture mp = new MakePicture(720,1280,f);
                    try {
                        mp.makeFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            case JOptionPane.NO_OPTION -> System.exit(0);
        }
    }
}
