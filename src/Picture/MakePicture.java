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

    public MakePicture(File fileToRead) {
        this.fileToRead = fileToRead;

        try {
            setPicSize(this.fileToRead.length());
            readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setPicSize(long size) {
        this.WIDTH_TOTAL = (int) Math.ceil(Math.sqrt(size));
        this.HEIGHT_TOTAL = (int) Math.ceil((double) size / this.WIDTH_TOTAL);
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

        try {
            List<String> plainText = fd.readText();

            if (plainText == null) {
                byte[] byteData = fd.readBytes();
                if (byteData != null) {
                    System.out.println("[BYTES] " + byteData.length);
                    this.info = byteData;
                }
            } else {
                System.out.println(plainText);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
