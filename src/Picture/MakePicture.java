package Picture;

import java.io.*;

public class MakePicture {
    /*  TO DO
     *  Read Files
     *  Split File
     *  Encode to picture
     */

    /*
     *  HEIGHT_TOTAL AND WIDTH_TOTAL SHOULD BE ASSIGNED FROM THE READING OF A FILE BUT WITH "STANDARDS"
     *  LESS THAN 1280 X 720 BUT MORE THAN 800 X 600 USE 1280 X 720 AND SO ON
     */
    public int HEIGHT_TOTAL;
    public int WIDTH_TOTAL;
    PixelData pd = new PixelData();

    public MakePicture(int HEIGHT_TOTAL, int WIDTH_TOTAL) {
        this.HEIGHT_TOTAL = HEIGHT_TOTAL;
        this.WIDTH_TOTAL = WIDTH_TOTAL;
    }

    /**
     * Makes the file uses PixelData class
     * MakeHeader gets the hardcoded header
     * -- pending
     * @throws IOException
     */
    public void makeFile() throws IOException {
        File picture = new File("test.bmp");

        // https://stackoverflow.com/questions/10061029/how-to-make-bmp-image-from-pixel-byte-array-in-java

        ByteArrayOutputStream picData = new ByteArrayOutputStream();

        byte[] header = pd.makeHeader(this.HEIGHT_TOTAL,this.WIDTH_TOTAL); // CREATES A HEADER WITH A SET RES
        picData.write(header); // ADDS THE HEADER TO THE OutputStream

        byte[] info = pd.makeTestPicture(this.HEIGHT_TOTAL,this.WIDTH_TOTAL);
        picData.write(info);

        try(FileOutputStream outputStream = new FileOutputStream(picture)){
            outputStream.write(picData.toByteArray());
        }

        picData.close();
    }

    public void readTextFile() throws FileNotFoundException {
        pd.readText();
    }

    public void readBinFile() throws IOException {
        pd.readBytes();
    }

}
