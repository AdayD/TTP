package Picture;

import java.io.*;

public class MakePicture {

    /*  TO DO
     *  Read Files
     *  Encode to picture
     */
    private File fileToRead;

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

    /**
     * Reads files that can be viewed as a text file
     * source code, txt, md, json, ...
     * @throws FileNotFoundException
     */
    public void readTextFile() throws FileNotFoundException {
        fd.fileSetter(this.fileToRead);
        fd.readText();
    }

    /**
     * Reads bytes of a File
     * @throws IOException
     */
    public void readBinFile() throws IOException {
        fd.fileSetter(this.fileToRead);
        fd.readBytes();
        System.out.println(fd.readBytes().length);
    }

}
