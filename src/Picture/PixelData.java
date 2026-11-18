package Picture;

import java.io.*;

public class PixelData extends MakePicture {
    private String path;
    private File file;

    public PixelData(File f) {
        this.file = f;
    }

    public void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.file)); // ???? From stackoverflow

        // https://stackoverflow.com/questions/1480398/java-reading-a-file-from-current-directory

        System.out.println(reader.readAllLines());
    }

    public byte[] makeTestPicture() throws IOException {
        ByteArrayOutputStream picInfo = new ByteArrayOutputStream();

        for ( int height = 0; height < HEIGHT_TOTAL; height++) {
            ByteArrayOutputStream row = new ByteArrayOutputStream();

            for ( int width = 0; width < WIDTH_TOTAL; width++) {
                row.write(254);
                row.write(254);
                row.write(254);
            }
            picInfo.write(row.toByteArray());
        }

        return picInfo.toByteArray();
    }
}
