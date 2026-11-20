package Picture;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class FileData {
    File fileToRead;

    /**
     * Needed!
     * FileData uses the default constructor
     * When used the File needs to be set
     * @param f File to read
     */
    public void fileSetter (File f) {
        this.fileToRead = f;
    }

    /**
     * For plain text files
     * @return List of Strings with the file content
     * @throws FileNotFoundException
     */
    public List<String> readText() throws FileNotFoundException {
        List<String> fileC;

        try {
            fileC = Files.readAllLines(this.fileToRead.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileC;

    }

    /**
     * For bytes
     * @return Byte array with file content
     * @throws IOException
     */
    public byte[] readBytes() throws IOException {
        // https://howtodoinjava.com/java/io/read-file-content-into-byte-array/
        byte[] content;

        try (InputStream in = new FileInputStream(this.fileToRead)) {
            content = in.readAllBytes();
        }

        return content;
    }
}
