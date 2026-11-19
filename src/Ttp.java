import Picture.MakePicture;

import java.io.IOException;

public class Ttp {

    void main() {
        MakePicture mp = new MakePicture(1080,1920);

        try {
            mp.makeFile();
            mp.readBinFile();
            mp.readTextFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
