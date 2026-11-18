import Picture.MakePicture;
import Picture.PixelData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Ttp {

    void main() {

        Scanner sc = new Scanner(System.in);
        URL path = Ttp.class.getResource("test.txt");
        File test = new File(path.getFile());
        PixelData px = new PixelData(test);

        try {
            px.readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        for(byte b : MakePicture.makeHeader(1920,1080)) {
//            System.out.println("HEXBYTE:");
//            System.out.printf("0x%02X", b);
//            System.out.println();
//            System.out.println("Int");
//            System.out.println(b);
//        }
    }
}
