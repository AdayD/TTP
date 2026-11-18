import Picture.MakePicture;

import java.io.IOException;

public class Ttp {

    void main() {

//        URL path = Ttp.class.getResource("test.txt");
//        File test = new File(path.getFile());
        MakePicture mp = new MakePicture(1080,1920);

        try {
            mp.makeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
