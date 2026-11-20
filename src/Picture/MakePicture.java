package Picture;

import java.io.*;
import java.util.List;

public class MakePicture {

    /*  TO DO
     *  Read Files
     *  Encode to picture
     */
    private File fileToRead;
    private byte[] info;

    /* TO DO
     * Set H_T and W_T with file content
     */
    public int HEIGHT_TOTAL;
    public int WIDTH_TOTAL;
    PixelData pd = new PixelData();
    FileData fd = new FileData();

    public MakePicture(int HEIGHT_TOTAL, int WIDTH_TOTAL,File fileToRead) {
        this.HEIGHT_TOTAL = HEIGHT_TOTAL;
        this.WIDTH_TOTAL = WIDTH_TOTAL;
        this.fileToRead = fileToRead;
    }

    public MakePicture(File fileToRead) {
        this.fileToRead = fileToRead;
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

        byte[] header = PixelData.makeHeader(this.HEIGHT_TOTAL,this.WIDTH_TOTAL); // CREATES A HEADER WITH A SET RES
        picData.write(header); // ADDS THE HEADER TO THE OutputStream

        byte[] infoPic = pd.makeTestPicture(this.HEIGHT_TOTAL,this.WIDTH_TOTAL,info);
        picData.write(infoPic);

        //byte[] info = pd.makeTestPicture(this.HEIGHT_TOTAL,this.WIDTH_TOTAL);
        //picData.write(info);
        try(FileOutputStream outputStream = new FileOutputStream(picture)){
            outputStream.write(picData.toByteArray());
        }

        picData.close();
    }

    /**
     * Reads a file, both plain text and binary files
     * Uses FileData
     * Tries to read the file as it is plain text
     * If it's a binary file it will get an error and try to read the bytes instead
     */
    public void readFile() throws IOException {
        fd.fileSetter(this.fileToRead);
        int size = 0;

        try {
            List<String> plainText = fd.readText();

            if (plainText == null) {
                byte[] byteData = fd.readBytes();
                if (byteData != null) {
                    System.out.println(byteData.length);
                    size = byteData.length;
                    this.info = byteData;
                }
            } else {
                System.out.println(plainText);
                size = plainText.size();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.WIDTH_TOTAL = 1280;
        this.HEIGHT_TOTAL = 720;
        makeFile();
    }
}
