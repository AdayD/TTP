import Picture.MakePicture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Ttp {

    /*
     * The size for the picture should be assigned by reading the file to insert into the picture
     * Need to mark the end of the file (or maybe end of file == end of picture)
     */
    void main() {
        MakePicture mp = new MakePicture(1080,1920,new File("testFile.exe"));
        try {
            //mp.makeFile();
            mp.readBinFile();

            //mp.readTextFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
